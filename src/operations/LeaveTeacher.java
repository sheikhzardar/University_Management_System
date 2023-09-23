package operations;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JDateChooser;

import dataBaseConnection.Connect;

public class LeaveTeacher implements ActionListener
{

	private JFrame frame;
	private JLabel lblHeading;
	private JLabel lblid;
	private Choice choice;
	private JLabel lblStartDate;
	private JDateChooser dc;
	private JLabel lblNoOfDays;
	private JSpinner spinner;
	private JLabel lblReason;
	private JTextArea textArea;
	private JButton btnApply;
	private JButton btnClear;

	private JScrollPane sp;
	private JLabel lblImage;
	
	public LeaveTeacher()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(400, 100, 720, 522);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblHeading = new JLabel("Apply For Teachers Leave");
		lblHeading.setFont(new Font("Serif", Font.BOLD, 20));
		lblHeading.setBounds(229, 24, 228, 52);
		frame.getContentPane().add(lblHeading);
		
		lblid = new JLabel("Teacher ID");
		lblid.setFont(new Font("Serif", Font.BOLD, 15));
		lblid.setBounds(35, 110, 86, 18);
		frame.getContentPane().add(lblid);
		
		choice = new Choice();
		choice.setBounds(168, 112, 175, 19);
		frame.getContentPane().add(choice);
		Connection con=null;
		try
		{
			con= new Connect().connect();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM teachers");
			ResultSet rs= pstmt.executeQuery();
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
		
		lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Serif", Font.BOLD, 15));
		lblStartDate.setBounds(35, 166, 86, 18);
		frame.getContentPane().add(lblStartDate);
		
		dc = new JDateChooser();
		dc.setBounds(168, 166, 175, 19);
		frame.getContentPane().add(dc);
		
		lblNoOfDays = new JLabel("No. of Days");
		lblNoOfDays.setFont(new Font("Serif", Font.BOLD, 15));
		lblNoOfDays.setBounds(35, 226, 86, 18);
		frame.getContentPane().add(lblNoOfDays);
		
		lblReason = new JLabel("State Reason");
		lblReason.setFont(new Font("Serif", Font.BOLD, 15));
		lblReason.setBounds(35, 291, 86, 18);
		frame.getContentPane().add(lblReason);
		
		SpinnerNumberModel snm= new SpinnerNumberModel(1,1,10,1);
		spinner = new JSpinner(snm);
		spinner.setBounds(168, 228, 41, 20);
		frame.getContentPane().add(spinner);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		sp = new JScrollPane(textArea);
		sp.setBounds(168, 290, 180, 73);
		frame.getContentPane().add(sp);
		
		btnApply = new JButton("Apply");
		btnApply.setFont(new Font("Serif", Font.BOLD, 12));
		btnApply.setBounds(35, 409, 85, 25);
		btnApply.addActionListener(this);
		frame.getContentPane().add(btnApply);
		
		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Serif", Font.BOLD, 12));
		btnClear.setBounds(200, 409, 85, 25);
		btnClear.addActionListener(this);
		frame.getContentPane().add(btnClear);
		
		ImageIcon icon= new ImageIcon("images/tch_leave.jpg");
		lblImage = new JLabel(icon);
		lblImage.setBounds(402, 93, 250, 350);
		frame.getContentPane().add(lblImage);	
		
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnApply)
		{
			Connection con=null;
			String id=choice.getSelectedItem();
			String date = ((JTextField)(dc.getDateEditor().getUiComponent())).getText();
			String days = String.valueOf(spinner.getValue());
			String reason = textArea.getText();
			try
			{
				con=new Connect().connect();
				String statement="INSERT INTO leaves_teacher VALUES ('"+id+"','"+date+"','"+days+"','"+reason+"')";
				PreparedStatement pstmt = con.prepareStatement(statement);
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Leave Applied");
				frame.setVisible(false);
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
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		if(ae.getSource()==btnClear)
		{
			dc.setCalendar(null);
			Integer a=Integer.valueOf(1);
			spinner.setValue(a);
			textArea.setText("");
		}
	}
}