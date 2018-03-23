package startTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import database.Connect;

public class QuestionPanel extends JPanel implements ActionListener{

	/**
	 * This panel is smaller than the Main BeginTest Panel
	 */

	private Connect c=new Connect("root","");
	private String CourseName;
	private ResultSet rs;
	private int q_number=1;
	private JPanel panel = new JPanel();
	private JRadioButton o_1; 
	private JRadioButton o_2;
	private JRadioButton o_3 ;
	private JRadioButton o_4 ;
	
	//if bug occurs then make String non static .
	static String[][] qInfo;
	static int q_attempted;
	/**
	 * qInfo reference variable contains the whole information of each question in the course
	 * four coloumns : 
	 * 1 : question number
	 * 2 : selected option
	 * 3 : correct option
	 * 4 : 0 if question is viewed and not attempted
	 *     1 if question is viewed and attempted
	 *     -1 if question is not viewed
	 *  
	 * **/
	
	
	private void databaseWork()
	{
		try{
			Statement s=c.con.createStatement();
			String query="select count(q_id) from questions where course_name='"+CourseName+"'";
			rs=s.executeQuery(query);
			rs.next();
			int totalQuestions=rs.getInt(1);
			qInfo=new String[totalQuestions][4];
			for(int i=0;i<totalQuestions;i++)
				for(int j=0;j<4;j++)
					qInfo[i][j]="-1";
			query="select *from questions where course_name='"+CourseName+"'";
			rs=s.executeQuery(query);
		}
		catch(SQLException e)
		{
			System.out.println("Error in SQL : "+e);
		}
	}
	
	public QuestionPanel(String courseName) {
		CourseName=courseName;
		databaseWork();
		
		setLayout(null);
		setBackground(Color.PINK);
		ResultManagement();
	}

	JLabel questionAttempted;
	JLabel questionRemaining;
	JButton Next;
	JButton Previous;
	private void ResultManagement()
	{
			setVisible(true);
			
			questionAttempted=new JLabel();
			questionAttempted.setBounds(10, 350, 144, 35);
			questionAttempted.setVisible(true);
			questionRemaining=new JLabel();
			questionRemaining.setBounds(10, 380, 144, 35);
			questionRemaining.setVisible(true);
			add(questionAttempted);
			add(questionRemaining);
			
			try {
				if(rs.next())
				{
					makeQuestionVisible(rs.getString("q_id"));
					
					Previous = new JButton("LAST");
					Previous.setForeground(Color.RED);
					Previous.setFont(new Font("SimSun", Font.BOLD, 18));
					Previous.setBounds(10, 310, 144, 35);
					Previous.setFocusable(false);
					add(Previous);
					Previous.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							try {
								if(!rs.previous())
								{
									rs.afterLast();
									q_number=qInfo.length+1;
									rs.previous();
								}
								q_number--;
								makeQuestionVisible(rs.getString("q_id"));
								if(q_number==1)
									Previous.setText("LAST");
								else
									Previous.setText("PREVIOUS");
								if(q_number==qInfo.length)
									Next.setText("FIRST");
								else
									Next.setText("NEXT");
								
							} catch (SQLException e) {
								e.printStackTrace();
							}
							
						}
					});
					
					Next = new JButton("NEXT");
					Next.setForeground(Color.GREEN);
					Next.setFont(new Font("SimSun", Font.BOLD, 18));
					Next.setBounds(550, 310, 102, 35);
					Next.setFocusable(false);
					add(Next);
					Next.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent arg0) {
							try {
								if(!rs.next())
								{
//									JOptionPane.showMessageDialog(null, "This is the last question.");
									q_number=0;
									rs.beforeFirst();
									rs.next();
//									Next.setText("FIRST");
								}
								q_number++;
								makeQuestionVisible(rs.getString("q_id"));
								if(q_number==1)
									Previous.setText("LAST");
								else
									Previous.setText("PREVIOUS");
								if(q_number==qInfo.length)
									Next.setText("FIRST");
								else
									Next.setText("NEXT");
				
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					});
					repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No questions available.");
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
	}
	
	private void makeQuestionVisible(String q_id)
	{
		//add questions
		
		//add four options
		
		//add next and previos button
		
		if(qInfo[q_number-1][3].equals("-1"))
		{
			qInfo[q_number-1][0]=""+q_number+"";
			try{
				qInfo[q_number-1][2]=rs.getString("correct_option");
			}
			catch(SQLException e)
			{
				System.out.println(e);
			}
			qInfo[q_number-1][3]="0";
		}
		
		questionAttempted.setText("Question attempted : "+q_attempted);
		questionRemaining.setText("Question remaining : "+(qInfo.length-q_attempted));
		add(panel);
		
		panel.setBackground(Color.PINK);
		panel.setBounds(10,10,650,300);
		panel.setLayout(null);
		
		panel.removeAll();
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65,20, 450, 120);
		panel.add(scrollPane);
		
		JLabel lblQXx = new JLabel("Q."+q_number);
		lblQXx.setFont(new Font("SimSun", Font.BOLD, 18));
		lblQXx.setBounds(10, 12, 49, 35);
		panel.add(lblQXx);
				
		JTextArea question_statement = new JTextArea();
		
		try {
			question_statement.setText(rs.getString("q_statement"));
		} catch (SQLException e) {
			System.out.println(e);
		}
		question_statement.setFont(new Font("Gisha", Font.BOLD, 18));
		question_statement.setBackground(Color.PINK);
		question_statement.setEditable(false);
		panel.add(question_statement);
		
		scrollPane.setViewportView(question_statement);
		
		
		o_1 = new JRadioButton();
		try {
			o_1.setText(rs.getString("option_1"));
		} catch (SQLException e) {
			System.out.println(e);
		}
		o_1.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		o_1.setBounds(57, 169, 462, 23);
		panel.add(o_1);
		o_1.addActionListener(this);
		
		o_2 = new JRadioButton();
		try {
			o_2.setText(rs.getString("option_2"));
		} catch (SQLException e) {
			System.out.println(e);
		}
		o_2.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		o_2.setBounds(57, 195, 462, 23);
		panel.add(o_2);
		o_2.addActionListener(this);
					
		o_3 = new JRadioButton();
		try {
			o_3.setText(rs.getString("option_3"));
		} catch (SQLException e) {
			System.out.println(e);
		}
		o_3.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		o_3.setBounds(57, 221, 462, 23);
		panel.add(o_3);
		o_3.addActionListener(this);
		
		o_4 = new JRadioButton();
		try {
			o_4.setText(rs.getString("option_4"));
		} catch (SQLException e) {
			System.out.println(e);
		}
		o_4.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		o_4.setBounds(57, 247, 462, 23);
		panel.add(o_4);
		o_4.addActionListener(this);
		
		switch(qInfo[q_number-1][1].charAt(0))
		{
			case '1':o_1.setSelected(true);break;
			case '2':o_2.setSelected(true);break;
			case '3':o_3.setSelected(true);break;
			case '4':o_4.setSelected(true);break;
		}
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(o_1);
		bg.add(o_2);
		bg.add(o_3);
		bg.add(o_4);
		
		
		panel.repaint();
		panel.revalidate();
		}
	public void actionPerformed(ActionEvent ae) {
		if((qInfo[q_number-1][3].equals("0")))
			q_attempted++;
		questionAttempted.setText("Question attempted : "+q_attempted);
		questionRemaining.setText("Question remaining : "+(qInfo.length-q_attempted));
		if(ae.getSource()==o_1)
		{
			qInfo[q_number-1][1]="1";
		}
		if(ae.getSource()==o_2)
		{
			qInfo[q_number-1][1]="2";
		}
		if(ae.getSource()==o_3)
		{
			qInfo[q_number-1][1]="3";
		}
		if(ae.getSource()==o_4)
		{
			qInfo[q_number-1][1]="4";
		}
		qInfo[q_number-1][3]="1";
	}
}