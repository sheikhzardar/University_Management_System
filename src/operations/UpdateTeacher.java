package operations;

import java.awt.Choice;
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
import javax.swing.JTextField;

import dataBaseConnection.Connect;
import java.awt.Color;

public class UpdateTeacher implements ActionListener 
{

	private JFrame frame;
	private JLabel headLabel;
	private JLabel searchlbl;
	private Choice choice;
	private JButton btnSearch;
	private JButton btnRefresh;
	
	private JLabel lblname;

	private JLabel lblId;
	private JLabel lblAddress;
	private JLabel lblEmailId;
	private JLabel lblClassXii;
	private JLabel lblCourse;
	private JLabel lblFathersName;
	private JLabel lblDateOfBirth;
	private JLabel lblPhoneNo;
	private JLabel lblClassX;
	private JLabel lblAadharNo;
	private JLabel lblQualification;
	private JLabel lblName;
	private JLabel lblId_1;
	private JLabel lblClassXII;
	private JLabel lblFName;
	private JLabel lblDOB;
	private JLabel lblClassX_1;
	private JLabel lblAadhar;
	private JTextField textAddress;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textQualification;
	private JComboBox cbCourse;
	private JButton btnUpdate;
	private JButton btnCancel;
	
	public UpdateTeacher() 
	{
		frame = new JFrame("Update Teacher's Details");
		frame.getContentPane().setBackground(new Color(245, 245, 220));
		frame.getContentPane().setLayout(null);
		frame.setBounds(400, 100, 789, 170);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		headLabel = new JLabel("Update Teacher's Details");
		headLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		headLabel.setBounds(261, 20, 231, 41);
		frame.getContentPane().add(headLabel);
		
		searchlbl = new JLabel("Search By ID: ");
		searchlbl.setFont(new Font("Serif", Font.BOLD, 17));
		searchlbl.setBounds(35, 83, 135, 15);
		frame.getContentPane().add(searchlbl);
		
		choice = new Choice();
		choice.setBounds(202, 83, 167, 18);
		frame.getContentPane().add(choice);
		
		Connection con=null;
		try
		{
			con = new Connect().connect();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM teachers");
			ResultSet rs = pstmt.executeQuery();
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
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setBounds(400, 80, 85, 21);
		btnSearch.addActionListener(this);
		frame.getContentPane().add(btnSearch);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRefresh.setBounds(525, 80, 85, 21);
		btnRefresh.addActionListener(this);
		frame.getContentPane().add(btnRefresh);
		
		
		lblname = new JLabel("Name");
		lblname.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblname.setBounds(35, 140, 65, 28);
		frame.getContentPane().add(lblname);
		
		
		lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblId.setBounds(35, 200, 65, 28);
		frame.getContentPane().add(lblId);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAddress.setBounds(35, 260, 65, 28);
		frame.getContentPane().add(lblAddress);
		
		
		lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmailId.setBounds(35, 320, 65, 28);
		frame.getContentPane().add(lblEmailId);
		
		lblClassXii = new JLabel("Class XII (%)");
		lblClassXii.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblClassXii.setBounds(35, 380, 106, 28);
		frame.getContentPane().add(lblClassXii);
		
		lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblCourse.setBounds(35, 440, 65, 28);
		frame.getContentPane().add(lblCourse);
		
		lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblFathersName.setBounds(410, 140, 113, 28);
		frame.getContentPane().add(lblFathersName);
		
		lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDateOfBirth.setBounds(410, 200, 113, 28);
		frame.getContentPane().add(lblDateOfBirth);
		
		lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPhoneNo.setBounds(410, 260, 113, 28);
		frame.getContentPane().add(lblPhoneNo);
		
		lblClassX = new JLabel("Class X (%)");
		lblClassX.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblClassX.setBounds(410, 320, 113, 28);
		frame.getContentPane().add(lblClassX);
		
		lblAadharNo = new JLabel("Aadhar No.");
		lblAadharNo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAadharNo.setBounds(410, 380, 113, 28);
		frame.getContentPane().add(lblAadharNo);
		
		lblQualification = new JLabel("Qualification");
		lblQualification.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblQualification.setBounds(410, 440, 113, 28);
		frame.getContentPane().add(lblQualification);
		
		lblName = new JLabel("");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblName.setBounds(175, 140, 142, 28);
		frame.getContentPane().add(lblName);
		
		lblId_1 = new JLabel("");
		lblId_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblId_1.setBounds(175, 200, 142, 28);
		frame.getContentPane().add(lblId_1);
		
		lblClassXII = new JLabel("");
		lblClassXII.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblClassXII.setBounds(175, 380, 142, 28);
		frame.getContentPane().add(lblClassXII);
		
		lblFName = new JLabel("");
		lblFName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblFName.setBounds(562, 140, 142, 28);
		frame.getContentPane().add(lblFName);
		
		lblDOB = new JLabel("");
		lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDOB.setBounds(562, 200, 142, 28);
		frame.getContentPane().add(lblDOB);
		
		lblClassX_1 = new JLabel("");
		lblClassX_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblClassX_1.setBounds(562, 320, 142, 28);
		frame.getContentPane().add(lblClassX_1);
		
		lblAadhar = new JLabel("");
		lblAadhar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAadhar.setBounds(562, 380, 142, 28);
		frame.getContentPane().add(lblAadhar);
		
		textAddress = new JTextField();
		textAddress.setBounds(175, 265, 157, 21);
		frame.getContentPane().add(textAddress);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBounds(562, 265, 157, 21);
		frame.getContentPane().add(textPhone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(175, 322, 157, 21);
		frame.getContentPane().add(textEmail);
		
		textQualification = new JTextField();
		textQualification.setBounds(562, 447, 138, 19);
		frame.getContentPane().add(textQualification);
		
		String courses[]= {"B.Tech","BCA","M.Tech","MCA"};
		cbCourse = new JComboBox(courses);
		cbCourse.setBounds(175, 447, 138, 19);
		frame.getContentPane().add(cbCourse);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setBounds(86, 507, 100, 28);
		btnUpdate.addActionListener(this);
		frame.getContentPane().add(btnUpdate);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancel.setBounds(492, 507, 100, 28);
		btnCancel.addActionListener(this);
		frame.getContentPane().add(btnCancel);
		
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnSearch)
		{
			frame.setBounds(400, 100, 789, 620);
			Connection con =null;
			try
			{
				con = new Connect().connect();
				String id=choice.getSelectedItem();
				String statement="SELECT * FROM teachers where id = '"+id+"'";
				PreparedStatement pstmt = con.prepareStatement(statement);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					lblName.setText(rs.getString("teacher_name"));
					lblId_1.setText(rs.getString("id"));
					lblDOB.setText(rs.getString("Date_Of_Birth"));
					lblClassXII.setText(rs.getString("Class_XII_Marks"));
					lblFName.setText(rs.getString("fathers_name"));
					lblClassX_1.setText(rs.getString("Class_X_Marks"));
					lblAadhar.setText(rs.getString("Aadhar_no"));
					textAddress.setText(rs.getString("Address"));
					textPhone.setText(rs.getString("Phone_no"));
					textEmail.setText(rs.getString("Email"));
					textQualification.setText(rs.getString("Qualification"));;
					cbCourse.setSelectedItem(rs.getString("Course"));;
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
		
		if(ae.getSource()==btnRefresh)
		{
			frame.setVisible(false);
			new UpdateStudent();
		}
		
		if(ae.getSource()==btnUpdate)
		{
	
				String id = lblId_1.getText();
				String add = textAddress.getText();
				String phone = textPhone.getText();
				String email = textEmail.getText();
				String course = String.valueOf(cbCourse.getSelectedItem());
				String qualification = textQualification.getText();
				Connection con = null;
				try
				{
					con = new Connect().connect();
					String statement="UPDATE teachers set address = '"+add+"', Phone_no = '"+phone+"', Qualification = '"+qualification+"', course = '"+course+"', email = '"+email+"' WHERE id = '"+id+"'";
					PreparedStatement ps = con.prepareStatement(statement);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Teacher's Record Updated!!!");
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
				frame.setVisible(false);
			
		}
		
		if(ae.getSource()==btnCancel)
		{
			frame.setVisible(false);
		}
	}
}
