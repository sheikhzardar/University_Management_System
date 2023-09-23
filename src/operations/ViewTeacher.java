package operations;

import java.awt.Choice;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dataBaseConnection.Connect;

import net.proteanit.sql.DbUtils;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTeacher implements ActionListener
{

	private JFrame frame;
	private JLabel label;
	private Choice choice;
	private JTable table;
	private JScrollPane sp;
	private JLabel lblNewLabel;
	private JButton btnPrint;
	private JButton btnAdd;
	private JButton btnUpdateDetails;
	private JButton btnCancel;
	private JButton btnSearch;
	private JButton btnRefresh;
	
	public ViewTeacher() 
	{
		frame = new JFrame();
		frame.setBounds(300, 80, 1000, 700);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		label = new JLabel("Search By ID");
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
			String statement = "SELECT * FROM teachers";
			PreparedStatement pstmt = con.prepareStatement(statement);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				choice.add(rs.getString("id"));
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
			String statement="SELECT * FROM teachers";
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
		
		lblNewLabel = new JLabel("Teachers Detail");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		lblNewLabel.setBounds(408, 27, 138, 27);
		frame.getContentPane().add(lblNewLabel);
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setBounds(377, 85, 85, 21);
		btnSearch.addActionListener(this);
		frame.getContentPane().add(btnSearch);
		
		btnPrint = new JButton("Print Details");
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.setBounds(113, 550, 105, 27);
		btnPrint.addActionListener(this);
		frame.getContentPane().add(btnPrint);
		
		btnAdd = new JButton("Add Teacher");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAdd.setBounds(326, 550, 105, 27);
		btnAdd.addActionListener(this);
		frame.getContentPane().add(btnAdd);
		
		btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdateDetails.setBounds(538, 550, 113, 27);
		btnUpdateDetails.addActionListener(this);
		frame.getContentPane().add(btnUpdateDetails);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.setBounds(745, 550, 105, 27);
		btnCancel.addActionListener(this);
		frame.getContentPane().add(btnCancel);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRefresh.setBounds(503, 85, 85, 21);
		btnRefresh.addActionListener(this);
		frame.getContentPane().add(btnRefresh);
		
		
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnSearch)
		{
			Connection con=null;
			try 
			{
				String id=choice.getSelectedItem();
				con=new Connect().connect();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM teachers where id = '"+id+"'");
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
			new ViewTeacher();
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
		if(ae.getSource()==btnAdd)
		{
			new AddTeacher();
		}
		if(ae.getSource()==btnUpdateDetails)
		{
			new UpdateTeacher();
			frame.setVisible(false);
		}
		if(ae.getSource()==btnCancel)
		{
			frame.setVisible(false);
		}
		
	}
}
