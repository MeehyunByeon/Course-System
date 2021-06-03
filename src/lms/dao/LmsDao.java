package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lms.vo.Enroll;
import lms.vo.Professor;
import lms.vo.Student;
import lms.vo.SSubject;

public class LmsDao {
	private static LmsDao dao = new LmsDao();
	private LmsDao() {}
	public static LmsDao getInstance() {
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		}catch(Exception e) {
			System.out.print("MDAO:connect"+e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				conn.close();
			}catch(Exception e) 
			{
				System.out.print("Pstmt close error"+e);
			}
		}
		
		if(conn != null)
		{
			try {
				conn.close();
			}catch(Exception e) 
			{
				System.out.print("Conn close error"+e);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			}catch(Exception e) {
				System.out.print("rs close error"+e);
			}
		}
	}
	
	public boolean loginP(String id, String pwd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				result = true;
			}
			else
				result = false;
			
		}catch (Exception e) 
		{
			System.out.print("Login Error: "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	public boolean loginS(String id, String pwd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				result = true;
			}
			else
				result = false;
			
		}catch (Exception e) 
		{
			System.out.print("Login Error: "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	public void enroll(SSubject subject)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?,?);");
			pstmt.setString(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.setString(3, subject.getCount()+"");
			pstmt.setString(4, subject.getProf());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("MDAO:enroll"+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	public Enroll search(String subject) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Enroll enroll = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from enroll where student = ?;");
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				enroll = new Enroll();
				enroll.setSubject(rs.getString(1));
				enroll.setStudent(rs.getString(2));
			}
		}catch(Exception e) {
			System.out.print("MSearch error"+e);
		}finally
		{
			close(conn, pstmt, rs);
		}
		return enroll;
	}
}




