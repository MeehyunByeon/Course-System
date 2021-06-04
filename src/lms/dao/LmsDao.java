package lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.jar.Attributes.Name;

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
			System.out.print("Professor Login Error: "+e);
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
			System.out.print("Student Login Error: "+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	public void enrollP(SSubject subject)
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
			System.out.print("Professor Enroll Error"+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	public void enrollS(Enroll enroll)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?);");
			pstmt.setString(1, enroll.getSubject());
			pstmt.setString(2, enroll.getStudent());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Student Enroll Error"+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	public SSubject searchS(String find) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SSubject subject = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select subject.id, subject.name, subject.count, prof.name "
					+ "from subject, prof "
					+ "where subject.id = ? and prof.id = subject.prof;");
			pstmt.setString(1, find);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				subject = new SSubject();
				subject.setId(rs.getString(1));
				subject.setName(rs.getString(2));
				subject.setCount(rs.getInt(3));
				subject.setProf(rs.getString(4));
			}
		}catch(Exception e) {
			System.out.print("Student Class Search Error"+e);
		}finally
		{
			close(conn, pstmt, rs);
		}
		return subject;
	}
	
	public void cancleS(Enroll enroll)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from enroll where subject=? AND student=?;");
			pstmt.setString(1, enroll.getSubject());
			pstmt.setString(2, enroll.getStudent());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Student Cancle Error"+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	public void cancleP(SSubject sub) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from subject where id=? AND prof=?;");
			pstmt.setString(1, sub.getId());
			pstmt.setString(2, sub.getProf());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Professor Cancle Error"+e);
		}finally {
			close(conn, pstmt);
		}
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("delete from enroll where subject=?;");
			pstmt.setString(1, sub.getId());
			pstmt.executeUpdate();
		}catch (Exception e) 
		{
			System.out.print("Professor Cancle Error - DB_enroll"+e);
		}finally {
			close(conn, pstmt);
		}
	}
	
	public ArrayList<SSubject> listP(String profId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SSubject sub = null;
		ArrayList<SSubject> listP = new ArrayList<SSubject>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id, name, count from subject where prof=?;");
			pstmt.setString(1, profId);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				sub = new SSubject();
				sub.setId(rs.getString(1));
				sub.setName(rs.getString(2));
				sub.setCount(rs.getInt(3));
				listP.add(sub);
			}
		}catch (Exception e) 
		{
			System.out.print("Professor List Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return listP;
	}
	
	public ArrayList<SSubject> listCP(String profId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SSubject sub = null;
		ArrayList<SSubject> listCP = new ArrayList<SSubject>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select subject.id, subject.name, subject.count, count(*)student "
					+ "from subject, enroll "
					+ "where subject.prof = ? AND enroll.subject = subject.id "
					+ "group by subject.id order by id asc;");
			
			pstmt.setString(1, profId);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				sub = new SSubject();
				sub.setId(rs.getString(1));
				sub.setName(rs.getString(2));
				sub.setCount(rs.getInt(3));
				sub.setNumber(rs.getInt(4));
				listCP.add(sub);
			}
		}catch (Exception e) 
		{
			System.out.print("Professor List Error_CURRENT"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return listCP;
	}
	
	public ArrayList<Enroll> detailP(String subject) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Enroll en = null;
		ArrayList<Enroll> detailP = new ArrayList<Enroll>();

		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select enroll.student, student.name "
					+ "from enroll, student "
					+ "where enroll.subject = ? and enroll.student = student.id;");
			pstmt.setString(1, subject);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				en = new Enroll();
				en.setStudent(rs.getString(1));
				en.setName(rs.getString(2));
				detailP.add(en);
			}
		}catch (Exception e) 
		{
			System.out.print("Professor List Error_DETAIL"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return detailP;
	}
	
	public ArrayList<SSubject> listS(String studId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SSubject sub = null;
		ArrayList<SSubject> listS = new ArrayList<SSubject>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select enroll.subject, subject.name, prof.name "
					+ "from enroll, subject, prof "
					+ "where enroll.student = ? and enroll.subject=subject.id and prof.id = subject.prof "
					+ "group by enroll.subject;");
			pstmt.setString(1, studId);
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				sub = new SSubject();
				sub.setId(rs.getString(1));
				sub.setName(rs.getString(2));
				sub.setProf(rs.getString(3));
				listS.add(sub);
			}
		}catch (Exception e) 
		{
			System.out.print("Student List Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return listS;
	}
	
	public ArrayList<SSubject> showAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SSubject sub = null;
		ArrayList<SSubject> all = new ArrayList<SSubject>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select subject.id, subject.name, subject.count, prof.name "
					+ "from subject, prof where prof.id = subject.prof;");
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				sub = new SSubject();
				sub.setId(rs.getString(1));
				sub.setName(rs.getString(2));
				sub.setCount(rs.getInt(3));
				sub.setProf(rs.getString(4));
				all.add(sub);
			}
		}catch (Exception e) 
		{
			System.out.print("All Class List Error"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return all;
	}
	
	public ArrayList<SSubject> showDetail() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SSubject sub = null;
		ArrayList<SSubject> detail = new ArrayList<SSubject>();
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select subject.id, subject.name, subject.count, prof.name, count(*) "
					+ "from subject, enroll, prof "
					+ "where subject.id = enroll.subject and prof.id = subject.prof "
					+ "group by subject.id;");
			rs = pstmt.executeQuery();
			while (rs.next()) 
			{
				sub = new SSubject();
				sub.setId(rs.getString(1));
				sub.setName(rs.getString(2));
				sub.setCount(rs.getInt(3));
				sub.setProf(rs.getString(4));
				sub.setCurrent(rs.getInt(5));
				detail.add(sub);
			}
		}catch (Exception e) 
		{
			System.out.print("All Class List Error_CURRENT"+e);
		}finally {
			close(conn, pstmt, rs);
		}
		return detail;
	}
	
	
	
}




