package database;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import user.RegistrationForm;

public class FormData {

	private static Connect c=new Connect("root","");
	public static boolean saveData(RegistrationForm rf)
	{
		try{
		String query1="INSERT INTO userdetails "
				+ "(username,password,firstname,middlename,lastname,gender,`E-mail`,Mobile,DOB,Address,College,RegDate) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,current_timestamp)";
		String date=""+rf.Year+"-"+rf.Month+"-"+rf.Date+"";
		
		PreparedStatement ps=(PreparedStatement)c.con.prepareStatement(query1);
		ps.setString(1, rf.USERNAME.getText());
		ps.setString(2, rf.PASSWORD.getText());
		ps.setString(3, rf.FIRST.getText());
		ps.setString(4, rf.MIDDLE.getText());
		ps.setString(5, rf.LAST.getText());
		ps.setString(6, ""+rf.Gender+"");
		ps.setString(7, rf.EMAIL.getText());
		ps.setString(8, rf.MOBILE.getText());
		ps.setString(9, date);
		ps.setString(10, rf.ADDRESS.getText());
		ps.setString(11, rf.COLLEGE.getText());
		
		int rowid=ps.executeUpdate();
		
		if(rowid>0)
		{
			System.out.println("Done");
		}
		System.out.println("done");
		return true;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Message : "+e.getMessage());
			return false;
		}
	}
	
	
	
	public static boolean updateData(RegistrationForm rf)
	{
		try{
			String query1="UPDATE userdetails SET "
				+ " username=?,password=?,firstname=?,middlename=?,lastname=?,gender=?,`E-mail`=?,Mobile=?,DOB=?,Address=?,College=? where(username=?) ";
			String date=""+rf.Year+"-"+rf.Month+"-"+rf.Date+"";
			
			PreparedStatement ps=(PreparedStatement)c.con.prepareStatement(query1);
			
			ps.setString(1, rf.USERNAME.getText());
			ps.setString(2, rf.PASSWORD.getText());
			ps.setString(3, rf.FIRST.getText());
			ps.setString(4, rf.MIDDLE.getText());
			ps.setString(5, rf.LAST.getText());
			ps.setString(6, ""+rf.Gender+"");
			ps.setString(7, rf.EMAIL.getText());
			ps.setString(8, rf.MOBILE.getText());
			ps.setString(9, date);
			ps.setString(10, rf.ADDRESS.getText());
			ps.setString(11, rf.COLLEGE.getText());
			ps.setString(12, rf.USERNAME.getText());
			
			int rowid=ps.executeUpdate();
			
			if(rowid>0)
			{
				JOptionPane.showMessageDialog(null, "Details updated successfully.\nPlease login with your new details.");
			}
			return true;
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null, "Message : "+e.getMessage());
			return false;
		}
	}
}
