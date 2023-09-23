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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dataBaseConnection.Connect;
import javax.swing.JTextField;


public class UploadMarks implements ActionListener
{
	private JFrame frame;
	private JLabel lblHeading;
	private JLabel lblRoll;
	private Choice choice;
	private	JComboBox combo;
	private JButton btnSubmit;
	private JButton btnCancel;
	private JLabel lblSemester;
	private JLabel lblEnterSubject;
	private JLabel lblEnterMarks;
	private JTextField txtsub1;
	private JTextField txtmarks1;
	private JTextField txtsub2;
	private JTextField txtmarks2;
	private JTextField txtsub3;
	private JTextField txtsub4;
	private JTextField txtsub5;
	private JTextField txtmarks3;
	private JTextField txtmarks4;
	private JTextField txtmarks5;
	
	public UploadMarks() 
	{

		frame = new JFrame("Upload Marks");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(500, 160, 511, 455);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		lblHeading = new JLabel("Upload Student's Marks");
		lblHeading.setFont(new Font("Serif", Font.BOLD, 20));
		lblHeading.setBounds(139, 10, 226, 25);
		frame.getContentPane().add(lblHeading);
		
		lblRoll = new JLabel("Select Roll No.");
		lblRoll.setFont(new Font("Serif", Font.BOLD, 15));
		lblRoll.setBounds(25, 55, 111, 25);
		frame.getContentPane().add(lblRoll);
		
		lblSemester = new JLabel("Select Semester");
		lblSemester.setFont(new Font("Serif", Font.BOLD, 15));
		lblSemester.setBounds(25, 98, 119, 25);
		frame.getContentPane().add(lblSemester);
		
		choice =new Choice();
		choice.setBounds(165, 60, 119, 25);
		choice.setFont(new Font("Times New Roman",Font.BOLD,12));
		frame.getContentPane().add(choice);
		
		String sem[]= {"Semester 1","Semester 2","Semester 3","Semester 4","Semester 5","Semester 6","Semester 7","Semester 8"};
		combo =new JComboBox(sem);
		combo.setBounds(165, 98, 119, 25);
		combo.setBackground(Color.white);
		combo.setFont(new Font("Times New Roman",Font.BOLD,12));
		frame.getContentPane().add(combo);
		
		Connection con= null;
		try
		{
			con = new Connect().connect();
			String statement="select * from students";
			PreparedStatement pstmt=con.prepareStatement(statement);
			ResultSet rs = pstmt.executeQuery();
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
		
		lblEnterSubject = new JLabel("Enter Subject");
		lblEnterSubject.setFont(new Font("Serif", Font.BOLD, 15));
		lblEnterSubject.setBounds(84, 150, 96, 25);
		frame.getContentPane().add(lblEnterSubject);
		
		lblEnterMarks = new JLabel("Enter Marks");
		lblEnterMarks.setFont(new Font("Serif", Font.BOLD, 15));
		lblEnterMarks.setBounds(310, 150, 96, 25);
		frame.getContentPane().add(lblEnterMarks);
		
		txtsub1 = new JTextField();
		txtsub1.setBounds(40, 185, 190, 20);
		frame.getContentPane().add(txtsub1);
		txtsub1.setColumns(10);
		
		txtmarks1 = new JTextField();
		txtmarks1.setColumns(10);
		txtmarks1.setBounds(264, 185, 190, 20);
		frame.getContentPane().add(txtmarks1);
		
		txtsub2 = new JTextField();
		txtsub2.setColumns(10);
		txtsub2.setBounds(40, 215, 190, 20);
		frame.getContentPane().add(txtsub2);
		
		txtmarks2 = new JTextField();
		txtmarks2.setColumns(10);
		txtmarks2.setBounds(264, 215, 190, 20);
		frame.getContentPane().add(txtmarks2);
		
		txtsub3 = new JTextField();
		txtsub3.setColumns(10);
		txtsub3.setBounds(40, 245, 190, 20);
		frame.getContentPane().add(txtsub3);
		
		txtsub4 = new JTextField();
		txtsub4.setColumns(10);
		txtsub4.setBounds(40, 275, 190, 20);
		frame.getContentPane().add(txtsub4);
		
		txtsub5 = new JTextField();
		txtsub5.setColumns(10);
		txtsub5.setBounds(40, 310, 190, 20);
		frame.getContentPane().add(txtsub5);
		
		txtmarks3 = new JTextField();
		txtmarks3.setColumns(10);
		txtmarks3.setBounds(264, 245, 190, 20);
		frame.getContentPane().add(txtmarks3);
		
		txtmarks4 = new JTextField();
		txtmarks4.setColumns(10);
		txtmarks4.setBounds(264, 275, 190, 20);
		frame.getContentPane().add(txtmarks4);
		
		txtmarks5 = new JTextField();
		txtmarks5.setColumns(10);
		txtmarks5.setBounds(264, 310, 190, 20);
		frame.getContentPane().add(txtmarks5);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(0, 128, 192));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSubmit.setBounds(84, 359, 85, 21);
		btnSubmit.addActionListener(this);
		frame.getContentPane().add(btnSubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.setBackground(new Color(0, 128, 192));
		btnCancel.setBounds(321, 359, 85, 21);
		btnCancel.addActionListener(this);
		frame.getContentPane().add(btnCancel);
		
		
		
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnSubmit)
		{
			String roll=choice.getSelectedItem();
			String sem = String.valueOf(combo.getSelectedItem());
			String sub1 = txtsub1.getText().trim();
			String sub2 = txtsub2.getText().trim();
			String sub3 = txtsub3.getText().trim();
			String sub4 = txtsub4.getText().trim();
			String sub5 = txtsub5.getText().trim();
			String marks1 = txtmarks1.getText().trim();
			String marks2 = txtmarks2.getText().trim();
			String marks3 = txtmarks3.getText().trim();
			String marks4 = txtmarks4.getText().trim();
			String marks5 = txtmarks5.getText().trim();
			
			if(sub1.equals("")||sub2.equals("")||sub3.equals("")||sub4.equals("")||sub5.equals(""))
				JOptionPane.showMessageDialog(null, "Enter Name of All Subjects","Warning",JOptionPane.ERROR_MESSAGE);
			else if(marks1.equals("")||marks2.equals("")||marks3.equals("")||marks4.equals("")||marks5.equals(""))
				JOptionPane.showMessageDialog(null, "Enter Marks of All Subjects","Warning",JOptionPane.ERROR_MESSAGE);
			else
			{
				
				Connection con=null;
				try
				{
					String checkSem="";
					String checkRoll="";
					con=new Connect().connect();
					String statement1="SELECT * FROM marks";
					PreparedStatement pstmt1 =con.prepareStatement(statement1);
					ResultSet rs =pstmt1.executeQuery();
					while(rs.next())
					{
						checkRoll = rs.getString("roll_no");
						checkSem = rs.getString("semester");
					}
					if(checkRoll.equals(roll)&&checkSem.equals(sem))
					{
						JOptionPane.showMessageDialog(null,"Students Marks of this Sem already Uploaded","Error",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						String statement="INSERT INTO marks VALUES ('"+roll+"','"+sem+"','"+sub1+"','"+marks1+"','"+sub2+"','"+marks2+"','"+sub3+"','"+marks3+"','"+sub4+"','"+marks4+"','"+sub5+"','"+marks5+"')";
						PreparedStatement pstmt = con.prepareStatement(statement);
						pstmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Marks of Student Inputted", "Marks Updated", JOptionPane.INFORMATION_MESSAGE);
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
			}
		}
		if(ae.getSource()==btnCancel)
		{
			frame.setVisible(false);
		}
	}
}
