package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Exam;
import com.dxc.util.ConnectionManager;

public class ExamJdbcDAO extends JdbcDAO implements DAO<Exam> {
	
	

	public ExamJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Exam e) throws SQLException, ClassNotFoundException {
		boolean res = false;
	//	System.out.println("inside of save method");
		try {
			Connection con = ConnectionManager.getConnection();
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO exam VALUES(?,?)");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getExam_name());
		
		
		if(1== pstmt.executeUpdate()) {
			res = true;
			con.commit();
			con.setAutoCommit(true);
		}
		}
		finally {
			con.close();
		}
		
		return res;
	}

	@Override
	public boolean edit(Exam e) throws SQLException, FileNotFoundException, ParseException, IOException {
		boolean res = false;
		
		try {
			Connection con = ConnectionManager.getConnection();
			
		PreparedStatement pstmt = con.prepareStatement("UPDATE exam SET exam_name=? WHERE id = ?");
		pstmt.setString(1, e.getExam_name());
		pstmt.setInt(2, e.getId());
		
		if(1 == pstmt.executeUpdate()) {
			res = true;
			con.commit();
			con.setAutoCommit(true);
			
			Exam exam = find(e.getId());
			System.out.println(exam);
		}
		
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			con.close();
		}
		return res;
	}

	@Override
	public boolean delete(int id) throws SQLException, FileNotFoundException, ParseException, IOException {
		boolean res = false;
		try {
			Connection con = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM exam WHERE id = ?");
		pstmt.setInt(1, id);
		if(1== pstmt.executeUpdate()) {
			res = true;
			con.commit();
			con.setAutoCommit(true);
			System.out.println(findAll());
			
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return res;
	}

	@Override
	public Exam find(int id) throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		Exam exam = null;
		
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM exam WHERE id = ?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(2);
				
				
				
				exam = new Exam(id, name);
			}
		}
		finally {
			con.close();
		}
		
		return exam;
	}

	@Override
	public List<Exam> findAll() throws SQLException, ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		ArrayList<Exam> exams = new ArrayList<>();
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM exam");
			while(rs.next()) {
				int id = rs.getInt("id");
				String exam_name = rs.getString("exam_name");
				
				
				Exam exam = new Exam(id, exam_name);
				exams.add(exam);
			}
		}
		finally {
			con.close();
		}
		
		
		return exams;
	}
	
	
	

}
