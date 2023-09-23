package operations;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataBaseConnection.Connect;
import net.proteanit.sql.DbUtils; 

public class FeeDetails implements ActionListener
{
	private JFrame frame;
	private JLabel lblHeading;
	private JLabel lblCourse;
	private JLabel lblBranch;
	private JComboBox cb_c;
	private JComboBox cb_b;
	private JButton btnSearch;
	private JButton btnCancel;
	private JScrollPane sp;
	
	private JTable table;
	private JButton btnPrint;
	public FeeDetails() 
	{
		frame = new JFrame("Fee Details");
		frame.setBounds(100, 100, 730, 461);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblHeading = new JLabel("Fee Details");
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHeading.setBounds(32, 21, 116, 30);
		frame.getContentPane().add(lblHeading);
		
		lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCourse.setBounds(35, 78, 63, 21);
		frame.getContentPane().add(lblCourse);
		
		lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblBranch.setBounds(225, 78, 63, 21);
		frame.getContentPane().add(lblBranch);
		
		String courses[]= {"B.Tech","BCA","M.Tech","MCA"};
		cb_c = new JComboBox(courses);
		cb_c.setForeground(new Color(255, 255, 255));
		cb_c.setBackground(new Color(51, 102, 102));
		cb_c.setFocusable(false);
		cb_c.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		cb_c.setBounds(95,78,88,21);
		frame.getContentPane().add(cb_c);
		
		String branch[]= {"Computer Science","Mechanical","Civil","Electrical","Petroleum"};		
		cb_b = new JComboBox(branch);
		cb_b.setForeground(Color.WHITE);
		cb_b.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		cb_b.setFocusable(false);
		cb_b.setBackground(new Color(51, 102, 102));
		cb_b.setBounds(285, 79, 144, 21);
		frame.getContentPane().add(cb_b);
		
		btnSearch = new JButton("Search");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(0, 128, 192));
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSearch.setBounds(476, 79, 85, 21);
		btnSearch.setFocusable(false);
		btnSearch.addActionListener(this);
		frame.getContentPane().add(btnSearch);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(0, 128, 192));
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancel.setBounds(585, 79, 85, 21);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		frame.getContentPane().add(btnCancel);
		
		btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnPrint.setFocusable(false);
		btnPrint.setBackground(new Color(0, 128, 192));
		btnPrint.setBounds(558, 379, 85, 21);
		btnPrint.addActionListener(this);
		frame.getContentPane().add(btnPrint);
		
		table = new JTable();
		Connection con=null;
		try
		{
			con = new Connect().connect();
			PreparedStatement pstmt = con.prepareStatement("select * from fee");
			ResultSet rs = pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		sp= new JScrollPane(table);
		sp.setBounds(32,134,638,228);
		frame.getContentPane().add(sp);
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnSearch)
		{
			Connection con=null;
			String c=cb_c.getSelectedItem().toString();
			String b=cb_b.getSelectedItem().toString();
			try
			{
				con = new Connect().connect();
				PreparedStatement pstmt = con.prepareStatement("select * from fee where course = '"+c+"' AND branch = '"+b+"'");
				ResultSet rs = pstmt.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con!=null)
				{
					try 
					{
						con.close();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		if(ae.getSource()==btnPrint)
		{
			try 
			{
				table.print();
			} 
			catch (PrinterException e) 
			{		
				e.printStackTrace();
			}
		}
		
		if(ae.getSource()==btnCancel)
		{
			frame.setVisible(false);
		}
	}
}
