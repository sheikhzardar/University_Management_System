package operations;

import java.awt.Choice;
import java.awt.Font;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import dataBaseConnection.Connect;
import net.proteanit.sql.DbUtils;

public class ViewStudentLeave implements ActionListener 
{

	private JFrame frame;
	private JLabel lblheading;
	private JLabel label;
	private Choice choice;
	private JTable table;
	private JScrollPane sp;
	private JButton btnSearch;
	private JButton btnPrint;
	private JButton btnApplyLeave;
	private JButton btnCancel;
	private JButton btnRefresh;
	
	public ViewStudentLeave() 
	{
		frame = new JFrame("Student's Leave Details");
		frame.setBounds(300, 80, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		lblheading = new JLabel("Student's Leave Details");
		lblheading.setFont(new Font("Serif", Font.BOLD, 20));
		lblheading.setBounds(380, 27, 220, 27);
		frame.getContentPane().add(lblheading);
		
		label = new JLabel("Search By Roll No");
		label.setFont(new Font("Serif", Font.BOLD, 15));
		label.setBounds(24, 86, 138, 15);
		frame.getContentPane().add(label);
		
		choice = new Choice();
		choice.setBackground(SystemColor.info);
		choice.setForeground(SystemColor.activeCaptionText);
		choice.setBounds(184, 83, 167, 18);
		frame.getContentPane().add(choice);
		
		Connection con=null;
		try
		{
			con = new Connect().connect();
			String statement = "SELECT * FROM students";
			PreparedStatement pstmt = con.prepareStatement(statement);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				choice.add(rs.getString("roll_no"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		}
		
		table = new JTable();
		try 
		{
			con=new Connect().connect();
			String statement="SELECT * FROM leaves_student";
			PreparedStatement pstmt=con.prepareStatement(statement);
			ResultSet rs=pstmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
				try 
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
		}
		
		sp=new JScrollPane(table);
		sp.setBounds(10,125,970,400);
		frame.getContentPane().add(sp);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setBounds(377, 85, 85, 21);
		btnSearch.addActionListener(this);
		frame.getContentPane().add(btnSearch);
		
		btnPrint = new JButton("Print Details");
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.setBounds(257, 550, 105, 27);
		btnPrint.addActionListener(this);
		frame.getContentPane().add(btnPrint);
		
		btnApplyLeave = new JButton("Apply Leave");
		btnApplyLeave.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnApplyLeave.setBounds(440, 550, 105, 27);
		btnApplyLeave.addActionListener(this);
		frame.getContentPane().add(btnApplyLeave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.setBounds(611, 550, 105, 27);
		btnCancel.addActionListener(this);
		frame.getContentPane().add(btnCancel);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRefresh.setBounds(503, 85, 85, 21);
		btnRefresh.addActionListener(this);
		frame.getContentPane().add(btnRefresh);
		
		
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnSearch)
		{
			Connection con=null;
			try 
			{
				String roll=choice.getSelectedItem();
				con=new Connect().connect();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM leaves_student where roll_no = '"+roll+"'");
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
		if(ae.getSource()==btnRefresh)
		{
			frame.setVisible(false);
			new ViewStudentLeave();
		}
		if(ae.getSource()==btnPrint)
		{
			try
			{
				table.print();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(ae.getSource()==btnApplyLeave)
		{
			new LeaveStudent();
		}
		if(ae.getSource()==btnCancel)
		{
			frame.setVisible(false);
		}
	}
}
