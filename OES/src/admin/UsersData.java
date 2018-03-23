package admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import main.MainFrame;
import database.Connect;
import database.UserData;

public class UsersData extends JPanel {


	private static Connect c=new Connect("root","");
	private JComboBox<String> comboBox;
	private String Username;
	private String[] DATA;
	/**
	 * Create the panel.
	 */
	public UsersData() {
		databaseVerify();
		makeGUI();
	}
	private void databaseVerify()
	{
		try{
			Statement st=c.con.createStatement();
			String query="select count(username) from userdetails";
			java.sql.ResultSet rs=st.executeQuery(query);
			rs.next();
			int i=rs.getInt(1);
			DATA=new String[i];
			i=0;
			query="select username from userdetails";
			rs=st.executeQuery(query);
			while(rs.next())
				DATA[i++]=rs.getString("username");
			for(String s:DATA)
				System.out.println(s);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}

	}
	public void makeGUI() {
		//public Verification(){
			setLayout(null);
			
			JButton btnSearch = new JButton("SEARCH");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Show details of that username
					new UserData(Username,true,"UsersData");
				}
			});
			btnSearch.setForeground(new Color(188, 143, 143));
			btnSearch.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnSearch.setBackground(SystemColor.textInactiveText);
			btnSearch.setBounds(739, 223, 125, 36);
			add(btnSearch);
			
			
			
			JLabel lblUsersForVerification = new JLabel("Available Users");
			lblUsersForVerification.setForeground(new Color(220, 20, 60));
			lblUsersForVerification.setFont(new Font("Sylfaen", Font.BOLD, 18));
			lblUsersForVerification.setBounds(234, 223, 156, 28);
			add(lblUsersForVerification);
			
			comboBox = new JComboBox<String>();
			comboBox.setModel(new DefaultComboBoxModel<String>(DATA));
			comboBox.setFont(new Font("Shruti", Font.BOLD, 16));
			comboBox.setBounds(434, 223, 266, 30);
			add(comboBox);
			Username=DATA[0];
			comboBox.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Username=(String)comboBox.getSelectedItem();				
				}
			});
			
			JButton btnNewButton = new JButton("BACK");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					MainFrame.AddPanel(new MainAdmin());
				}
			});
			btnNewButton.setForeground(new Color(0, 0, 205));
			btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
			btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
			btnNewButton.setBounds(10, 512, 125, 36);
			add(btnNewButton);
			
			JLabel lblOnlineExamination = new JLabel("USERS");
			lblOnlineExamination.setForeground(new Color(139, 0, 0));
			lblOnlineExamination.setBackground(Color.GREEN);
			lblOnlineExamination.setHorizontalAlignment(SwingConstants.CENTER);
			lblOnlineExamination.setFont(new Font("Lucida Handwriting", Font.BOLD, 41));
			lblOnlineExamination.setBounds(307, 28, 378, 82);
			add(lblOnlineExamination);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("..\\images\\PIC34.PNG"));
			lblNewLabel.setBorder(new LineBorder(new Color(135, 206, 235), 4));
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setBounds(0, 0, 990, 558);
			add(lblNewLabel);
		}
}
