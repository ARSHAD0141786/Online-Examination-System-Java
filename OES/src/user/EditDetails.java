package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.MainFrame;
import database.Connect;


public class EditDetails{

	public String USERNAME;
	public String PASSWORD;
	public String FIRST;
	public String MIDDLE;
	public String LAST;
	public String EMAIL;
	public String MOBILE;
	public String COLLEGE;
	public String ADDRESS;
	public String Gender;
	public int Date;
	public int Month;
	public int Year;
	public String RegDate;
	public String RegNo;
	
	
	private void databaseWork(String u_name)
	{
		Connect c=new Connect("root","");
		try{
			Statement stmt=c.con.createStatement();
			String query="select *from userdetails where username='"+u_name+"'";
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			USERNAME=rs.getString("Username");
			PASSWORD=rs.getString("Password");
			FIRST=rs.getString("FirstName");
			MIDDLE=rs.getString("MiddleName");
			LAST=rs.getString("LastName");
			EMAIL=rs.getString("E-mail");
			MOBILE=rs.getString("Mobile");
			COLLEGE=rs.getString("College");
			ADDRESS=rs.getString("Address");
			Gender=rs.getString("Gender");
			java.util.Date d=rs.getDate("DOB");
			Date=d.getDate();
			Month=d.getMonth()+1;
			Year=d.getYear()+1900;
			RegNo=rs.getString("RegNo");
			RegDate=rs.getString("RegDate");
			System.out.println(Date+"---"+Month+"---"+Year);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	
	public EditDetails(String username) {
		databaseWork(username);
		MainFrame.AddPanel(new RegistrationForm(this));
	}
}
