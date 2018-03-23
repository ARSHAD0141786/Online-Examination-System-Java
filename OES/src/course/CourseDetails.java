package course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.Connect;

public class CourseDetails {

	static Connect c=new Connect("root","");
	public String[] Courses;
	public String[] HiddenCourses;
	public ResultSet rs;
	
	public CourseDetails() {
		try{
			Statement st=c.con.createStatement();
			String query="select count(course_name) from course_details";
			rs=st.executeQuery(query);
			rs.next();
			Courses=new String[rs.getInt(1)];
			query="select *from course_details";
			rs=st.executeQuery(query);
			int i=0;
			while(rs.next())
				Courses[i++]=rs.getString("course_name");
			query="select count(course_name) from course_details where hide=1";
			rs=st.executeQuery(query);
			rs.next();
			HiddenCourses=new String[rs.getInt(1)];
			query="select *from course_details where hide=1";
			rs=st.executeQuery(query);
			i=0;
			while(rs.next())
				HiddenCourses[i++]=rs.getString("course_name");
			
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
	public CourseDetails(String Course_name) {
		try{
			Statement st=c.con.createStatement();
			String query="select *from course_details where course_name='"+Course_name+"'";
			rs=st.executeQuery(query);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}
}
