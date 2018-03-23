package results;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Rectangle;


public class Result extends JPanel {

	private int noOfCol;
	private int noOfRows;
	private String[] colHead;
	private String[][] Data;
	public Result(int noOfCol,String[] colHead,int noOfRows,String[][] Data) {
		
		this.noOfCol=noOfCol;
		this.noOfRows=noOfRows;
		this.colHead=colHead;
		this.Data=Data;
		setLayout(null);
		
		if(noOfRows>0)
		{
			ScrollPane jsp=new ScrollPane();
			jsp.add(makeResult());
			jsp.setBounds(0, 0, 951, 420);
			add(jsp);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No data found.");
		}
	}
	private Panel makeResult()
	{
		Panel p=new Panel();
		p.setBounds(new Rectangle(0, 0, 200+150*noOfCol,100+32*noOfRows));
		
		p.setBackground(new Color(255, 215, 0));
		p.setLayout(null);
		
		int distanceBetweenTwoRows=10;
		int distanceBetweenTwoColoumns=10;
		int distanceBetweenColoumnHeadAndData=30;
		int dataStartFrom=80;
		
		JLabel lblSrno = new JLabel("S.No");
		lblSrno.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
		lblSrno.setBackground(SystemColor.activeCaption);
		lblSrno.setBounds(10, 11, 51, 25);
		p.add(lblSrno);
		
		JLabel[] lblColHead = new JLabel[noOfCol+1];
		for(int i=0;i<noOfCol;i++)
		{
			lblColHead[i] = new JLabel(colHead[i]);
			lblColHead[i].setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
			lblColHead[i].setBackground(SystemColor.RED);
			lblColHead[i].setHorizontalAlignment(JLabel.CENTER);
			lblColHead[i].setBounds(dataStartFrom+150*i+distanceBetweenTwoColoumns*i, 11, 150, 25);
			p.add(lblColHead[i]);
		}
		
		JLabel[][] DATA=new JLabel[Data.length][noOfCol];
		JLabel[] Srn=new JLabel[noOfRows];
		for(int i=0;i<noOfRows;i++)
		{
			Srn[i]=new JLabel(""+(i+1)+".  ");
			Srn[i].setHorizontalAlignment(JLabel.CENTER);
			Srn[i].setBounds(10,25+distanceBetweenColoumnHeadAndData+i*25+i*distanceBetweenTwoRows, 51, 25);
			p.add(Srn[i]);
			for(int j=0;j<noOfCol;j++)
			{
				DATA[i][j]=new JLabel(Data[i][j]);
				DATA[i][j].setHorizontalAlignment(JLabel.CENTER);
				DATA[i][j].setBounds(distanceBetweenTwoColoumns*j+dataStartFrom+j*150, 25+distanceBetweenTwoRows*i+distanceBetweenColoumnHeadAndData+i*25, 150, 25);
				p.add(DATA[i][j]);
			}
		}
		return p;
	}
}
