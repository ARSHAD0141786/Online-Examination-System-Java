package startTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import database.Connect;
import user.UserPanel;
import main.MainFrame;
import java.awt.SystemColor;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowResult extends JPanel {

	/**
	 * Create the panel.
	 */
	private String Username;
	private String query;
	public ShowResult(String[] r,String username) {
		Username=username;
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(208, 109, 575, 401);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblCourseName = new JLabel("Course name : ");
		lblCourseName.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblCourseName.setBounds(39, 11, 202, 31);
		panel.add(lblCourseName);
		
		JLabel lblCourseName_1 = new JLabel("Time taken : ");
		lblCourseName_1.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblCourseName_1.setBounds(39, 53, 202, 31);
		panel.add(lblCourseName_1);
		
		JLabel lblTotalQuestions = new JLabel("Total questions : ");
		lblTotalQuestions.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblTotalQuestions.setBounds(39, 95, 202, 31);
		panel.add(lblTotalQuestions);
		
		JLabel lblAttemptedQuestions = new JLabel("Attempted questions : ");
		lblAttemptedQuestions.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblAttemptedQuestions.setBounds(39, 137, 202, 31);
		panel.add(lblAttemptedQuestions);
		
		JLabel lblCorrectQuestions = new JLabel("Correct questions : ");
		lblCorrectQuestions.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblCorrectQuestions.setBounds(39, 179, 202, 31);
		panel.add(lblCorrectQuestions);
		
		JLabel lblWrongQuestions = new JLabel("Wrong questions : ");
		lblWrongQuestions.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblWrongQuestions.setBounds(39, 221, 202, 31);
		panel.add(lblWrongQuestions);
		
		JLabel lblScore = new JLabel("Marks obtained : ");
		lblScore.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblScore.setBounds(39, 263, 202, 31);
		panel.add(lblScore);
		
		JLabel lblTotalMarks = new JLabel("Total marks : ");
		lblTotalMarks.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblTotalMarks.setBounds(39, 305, 202, 31);
		panel.add(lblTotalMarks);
		
		JLabel lblPercentage = new JLabel("Percentage : ");
		lblPercentage.setFont(new Font("Shruti", Font.PLAIN, 18));
		lblPercentage.setBounds(39, 347, 202, 31);
		panel.add(lblPercentage);
		
		JLabel r0 = new JLabel(r[0]);
		r0.setHorizontalTextPosition(SwingConstants.CENTER);
		r0.setHorizontalAlignment(SwingConstants.CENTER);
		r0.setFont(new Font("Raavi", Font.BOLD, 20));
		r0.setBounds(296, 11, 180, 31);
		panel.add(r0);
		
		JLabel r1 = new JLabel(r[1]);
		r1.setForeground(Color.BLACK);
		r1.setHorizontalTextPosition(SwingConstants.CENTER);
		r1.setHorizontalAlignment(SwingConstants.CENTER);
		r1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r1.setBounds(296, 55, 180, 31);
		panel.add(r1);
		
		JLabel r2 = new JLabel(r[2]);
		r2.setForeground(Color.BLACK);
		r2.setHorizontalTextPosition(SwingConstants.CENTER);
		r2.setHorizontalAlignment(SwingConstants.CENTER);
		r2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r2.setBounds(296, 95, 180, 31);
		panel.add(r2);
		
		JLabel r3 = new JLabel(r[3]);
		r3.setForeground(Color.BLACK);
		r3.setHorizontalTextPosition(SwingConstants.CENTER);
		r3.setHorizontalAlignment(SwingConstants.CENTER);
		r3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r3.setBounds(296, 137, 180, 31);
		panel.add(r3);
		
		JLabel r4 = new JLabel(r[4]);
		r4.setForeground(Color.BLACK);
		r4.setHorizontalTextPosition(SwingConstants.CENTER);
		r4.setHorizontalAlignment(SwingConstants.CENTER);
		r4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r4.setBounds(296, 179, 180, 31);
		panel.add(r4);
		
		JLabel r5 = new JLabel(r[5]);
		r5.setForeground(Color.BLACK);
		r5.setHorizontalTextPosition(SwingConstants.CENTER);
		r5.setHorizontalAlignment(SwingConstants.CENTER);
		r5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r5.setBounds(296, 221, 180, 31);
		panel.add(r5);
		
		JLabel r6 = new JLabel(r[6]);
		r6.setForeground(Color.BLACK);
		r6.setHorizontalTextPosition(SwingConstants.CENTER);
		r6.setHorizontalAlignment(SwingConstants.CENTER);
		r6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r6.setBounds(296, 263, 180, 31);
		panel.add(r6);
		
		JLabel r7 = new JLabel(r[7]);
		r7.setForeground(Color.BLACK);
		r7.setHorizontalTextPosition(SwingConstants.CENTER);
		r7.setHorizontalAlignment(SwingConstants.CENTER);
		r7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		r7.setBounds(296, 305, 180, 31);
		panel.add(r7);
		
		JLabel label_8 = new JLabel(r[8]+" %");
		label_8.setForeground(Color.BLACK);
		label_8.setHorizontalTextPosition(SwingConstants.CENTER);
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_8.setBounds(296, 347, 180, 31);
		panel.add(label_8);
		
		query="INSERT INTO result (username,course_name,time_taken,total_questions,wrong_question,"
				+ "attempted_question,obtained_marks,total_marks,percentage,test_date) VALUES('"
				+ Username+"','"+r[0]+"','"+r[1]+"',"+r[2]+","+r[5]+","+r[3]+","+r[6]+","+r[7]+","+r[8]+",current_timestamp)";
		
		JButton save = new JButton("SAVE");
		save.setFocusable(false);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connect c=new Connect("root","");
				try{
					Statement st=c.con.createStatement();
					System.out.println("sdsd");
					st.execute(query);
					JOptionPane.showMessageDialog(null, "Thank You.\nYour result is saved successfully.");
					MainFrame.AddPanel(new UserPanel(Username));
				}
				catch(SQLException e)
				{
					System.out.println("Error in saving result : "+e);
				}
			}
		});
		save.setForeground(new Color(0, 255, 0));
		save.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		save.setBounds(862, 511, 120, 36);
		add(save);
		
		JButton Discard = new JButton("DISCARD");
		Discard.setFocusable(false);
		Discard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.AddPanel(new UserPanel(Username));
			}
		});
		Discard.setForeground(new Color(255, 0, 0));
		Discard.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		Discard.setBounds(10, 511, 152, 36);
		add(Discard);
		
		JLabel lblOnlineExamination = new JLabel("RESULT");
		lblOnlineExamination.setForeground(new Color(240, 255, 240));
		lblOnlineExamination.setBackground(Color.GREEN);
		lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnlineExamination.setFont(new Font("Lucida Handwriting", Font.BOLD, 41));
		lblOnlineExamination.setBounds(361, 43, 270, 72);
		add(lblOnlineExamination);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC22.PNG"));
		lblNewLabel.setBorder(new LineBorder(new Color(255, 0, 0), 4));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 0, 990, 558);
		add(lblNewLabel);
	}
}
