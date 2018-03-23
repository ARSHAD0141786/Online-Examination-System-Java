package startTest;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Clock extends JPanel {

	/**
	 * Create the panel.
	 */
	static int HH;
	static int MM;
	static int SS;
	static int time=0;
	Thread t;
	Clock(int H,int M,int S)
	{
		HH=H;
		MM=M;
		SS=S;
		setLayout(null);
		Run r=new Run();
		add(r);
		r.setBounds(0, 0, 300, 200);
		r.setBackground(Color.blue);
		t=new Thread(r);
		t.start();
	}
}
class Run extends JPanel implements Runnable
{
	public void run() {
		while(Clock.HH!=00 || Clock.MM!=00 || Clock.SS!=00)
		{
			makeGUI(Clock.HH+" : "+Clock.MM+" : "+Clock.SS);
			
			if(Clock.SS==00)
			{
				if(Clock.MM==00)
				{
					Clock.HH--;
					Clock.MM=59;
				}
				else
				{
					Clock.MM--;
					Clock.SS=59;
				}
			}
			else
			{
				Clock.SS--;
			}
		}
		JOptionPane.showMessageDialog(null, "TIME UP");
		BeginTest.endTest();
	}
	public void makeGUI(String txt) {
		setLayout(null);
		setBackground(new Color(255, 222, 173));
		JLabel lblXxxxxx = new JLabel(txt);
		lblXxxxxx.setBackground(new Color(148, 0, 211));
		lblXxxxxx.setForeground(new Color(148, 0, 211));
		lblXxxxxx.setHorizontalAlignment(SwingConstants.LEFT);
		lblXxxxxx.setFont(new Font("Times Roman", Font.BOLD, 60));
		lblXxxxxx.setBounds(20, 0, 266, 123);
		add(lblXxxxxx);
		repaint();
		revalidate();
		try {
			Thread.sleep(1000);
			Clock.time++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		remove(lblXxxxxx);
		repaint();
		revalidate();
	}
}