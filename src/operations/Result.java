package operations;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import dataBaseConnection.Connect;
import net.proteanit.sql.DbUtils;

public class Result implements ActionListener, MouseListener{

	private JFrame frame;
	private JLabel lblRollNumber;
	private JLabel lblHeading;
	private JLabel lblSearch;
	private JButton btnResult;
	private JTable table;
	private JScrollPane sp;
	private JButton btnRefresh;
	private JButton btnCancel;
	private boolean bol;
	private String name;
	private String roll;

	public Result() 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 915, 520);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		bol=false;
		
		lblHeading = new JLabel("View Students Result");
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblHeading.setBounds(34, 30, 193, 23);
		frame.getContentPane().add(lblHeading);
		
		lblSearch = new JLabel("Search Student from Table");
		lblSearch.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSearch.setBounds(34, 71, 181, 23);
		frame.getContentPane().add(lblSearch);
		
		lblRollNumber = new JLabel();
		//So that Change in Background Color is Affected
		lblRollNumber.setOpaque(true);
		lblRollNumber.setForeground(new Color(255, 255, 255));
		lblRollNumber.setBackground(new Color(64, 128, 128));
		lblRollNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNumber.setText("Roll Number");
		lblRollNumber.setBounds(240, 75, 150, 20);
		frame.getContentPane().add(lblRollNumber);
		
		table = new JTable();
		Connection con=null;
		
		
		try 
		{
			con= new Connect().connect();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM students");
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
		table.addMouseListener(this);
		
		
		sp = new JScrollPane(table);
		sp.setBounds(34,137,830,319);
		frame.getContentPane().add(sp);
		
		btnResult = new JButton("View Result");
		btnResult.setForeground(new Color(255, 255, 255));
		btnResult.setBackground(new Color(0, 128, 192));
		btnResult.setBounds(421, 75, 105, 20);
		btnResult.setFocusable(false);
		btnResult.addActionListener(this);
		frame.getContentPane().add(btnResult);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFocusable(false);
		btnRefresh.setBackground(new Color(0, 128, 192));
		btnRefresh.setBounds(554, 75, 105, 20);
		btnRefresh.addActionListener(this);
		frame.getContentPane().add(btnRefresh);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFocusable(false);
		btnCancel.setBackground(new Color(0, 128, 192));
		btnCancel.setBounds(690, 75, 105, 20);
		btnCancel.addActionListener(this);
		frame.getContentPane().add(btnCancel);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnResult)
		{
			if(!bol)
			{
				JOptionPane.showMessageDialog(null,"Select Student to view Result ","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				String sem=JOptionPane.showInputDialog(null, "Enter the Semester");
				frame.setVisible(false);
				new Student_Result(roll,name,sem);
			}
		}
		if(ae.getSource()==btnRefresh)
		{
			frame.setVisible(false);
			new Result();
		}
		if(ae.getSource()==btnCancel)
		{
			frame.setVisible(false);
		}
	}
	public void mouseClicked(MouseEvent me) 
	{
		int row = table.getSelectedRow();
		name =table.getModel().getValueAt(row,1).toString();
		roll = table.getModel().getValueAt(row, 2).toString();
		lblRollNumber.setText(roll);
		bol=true;
		
	}
	public void mousePressed(MouseEvent e) 
	{
		// Not Required
	}
	public void mouseReleased(MouseEvent e) 
	{
		// Not Required	
	}
	public void mouseEntered(MouseEvent e) 
	{
		// Not Required	
	}
	public void mouseExited(MouseEvent e) 
	{
		// Not Required	
	}

	
}
