package operations;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import dataBaseConnection.Connect;

public class Student_Result implements ActionListener 
{

	private JFrame frame;
	private JLabel lblHeading;
	private JButton btnBack;
	private JButton btnClose;
	
	public Student_Result()
	{
		JOptionPane.showMessageDialog(null, "Please Enter the Roll Number");
	}
	public Student_Result(String roll_number, String name, String sem) 
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(500, 100, 455, 571);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblHeading = new JLabel("Student's Result");
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblHeading.setBounds(176,10,152,43);
		frame.getContentPane().add(lblHeading);
		
		JLabel lblName = new JLabel("Student's Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblName.setBounds(35, 62, 95, 25);
		frame.getContentPane().add(lblName);
		
		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRollNumber.setBounds(35, 97, 81, 25);
		frame.getContentPane().add(lblRollNumber);
		
		JLabel lblName_1 = new JLabel(name);
		lblName_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblName_1.setBounds(138, 62, 95, 25);
		frame.getContentPane().add(lblName_1);
		
		JLabel lblRollNumber_1 = new JLabel(roll_number);
		lblRollNumber_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblRollNumber_1.setBounds(138, 97, 95, 25);
		frame.getContentPane().add(lblRollNumber_1);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSemester.setBounds(35, 132, 63, 25);
		frame.getContentPane().add(lblSemester);
		
		JLabel lblSemester_1 = new JLabel("Semester "+sem);
		lblSemester_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblSemester_1.setBounds(138, 132, 95, 25);
		frame.getContentPane().add(lblSemester_1);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSubject.setBounds(24, 175, 144, 25);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarks.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblMarks.setBounds(222, 175, 144, 25);
		frame.getContentPane().add(lblMarks);
		
		JLabel lblSubject_1 = new JLabel();
		lblSubject_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblSubject_1.setBounds(24, 210, 144, 25);
		frame.getContentPane().add(lblSubject_1);
		
		JLabel lblMarks_1 = new JLabel();
		lblMarks_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarks_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblMarks_1.setBounds(222, 210, 144, 25);
		frame.getContentPane().add(lblMarks_1);
		
		JLabel lblSubject_2 = new JLabel();
		lblSubject_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblSubject_2.setBounds(24, 245, 144, 25);
		frame.getContentPane().add(lblSubject_2);
		
		JLabel lblMarks_2 = new JLabel();
		lblMarks_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarks_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblMarks_2.setBounds(222, 245, 144, 25);
		frame.getContentPane().add(lblMarks_2);
		
		JLabel lblSubject_3 = new JLabel();
		lblSubject_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblSubject_3.setBounds(24, 280, 144, 25);
		frame.getContentPane().add(lblSubject_3);
		
		JLabel lblMarks_3 = new JLabel();
		lblMarks_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarks_3.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblMarks_3.setBounds(222, 280, 144, 25);
		frame.getContentPane().add(lblMarks_3);
		
		JLabel lblSubject_4 = new JLabel();
		lblSubject_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblSubject_4.setBounds(24, 315, 144, 25);
		frame.getContentPane().add(lblSubject_4);
		
		JLabel lblSubject_5 = new JLabel();
		lblSubject_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblSubject_5.setBounds(24, 350, 144, 25);
		frame.getContentPane().add(lblSubject_5);
		
		JLabel lblMarks_4 = new JLabel();
		lblMarks_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarks_4.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblMarks_4.setBounds(222, 315, 144, 25);
		frame.getContentPane().add(lblMarks_4);
		
		JLabel lblMarks_5 = new JLabel();
		lblMarks_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarks_5.setFont(new Font("Segoe UI Variable", Font.BOLD, 12));
		lblMarks_5.setBounds(222, 350, 144, 25);
		frame.getContentPane().add(lblMarks_5);
		
		Connection con = null;
		
		try
		{
			con = new Connect().connect();
			PreparedStatement ps =con.prepareStatement("SELECT * FROM marks WHERE roll_no = '"+roll_number+"' AND semester = 'Semester "+sem+"'");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				lblSubject_1.setText(rs.getString("subject1"));
				lblSubject_2.setText(rs.getString("subject2"));
				lblSubject_3.setText(rs.getString("subject3"));
				lblSubject_4.setText(rs.getString("subject4"));
				lblSubject_5.setText(rs.getString("subject5"));
				
				lblMarks_1.setText(rs.getString("marks1"));
				lblMarks_2.setText(rs.getString("marks2"));
				lblMarks_3.setText(rs.getString("marks3"));
				lblMarks_4.setText(rs.getString("marks4"));
				lblMarks_5.setText(rs.getString("marks5"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(0, 128, 192));
		btnBack.setFont(new Font("Serif", Font.BOLD, 12));
		btnBack.setBounds(83, 472, 95, 25);
		btnBack.setFocusable(false);
		btnBack.addActionListener(this);
		frame.getContentPane().add(btnBack);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(new Color(255, 255, 255));
		btnClose.setBackground(new Color(0, 128, 192));
		btnClose.setFont(new Font("Serif", Font.BOLD, 12));
		btnClose.setBounds(258, 472, 95, 25);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);
		frame.getContentPane().add(btnClose);
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnBack)
		{
			frame.setVisible(false);
			new Result();
		}
		if(ae.getSource()==btnClose)
		{
			frame.setVisible(false);
		}
	}
}
