package operations;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import dataBaseConnection.Connect;
public class AddTeacher implements ActionListener, KeyListener
{

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtXii;
	private JTextField txtFathersName;
	private JTextField txtPhone;
	private JTextField txtX;
	private JTextField txtAadhar;
	private JTextField txtQualification;
	private JButton btnsubmit;
	private JButton btnCancel;
	private JLabel lblid1;
	private JComboBox cbCourse;

	private JDateChooser dc;
	
	Random ran = new Random();

	public AddTeacher() 
	{
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.getContentPane().setLayout(null);
		
		JLabel headLabel = new JLabel("New Teacher Details");
		headLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		headLabel.setBounds(264, 26, 231, 41);
		frame.getContentPane().add(headLabel);
		
		JLabel lblname = new JLabel("Name");
		lblname.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblname.setBounds(40, 95, 65, 28);
		frame.getContentPane().add(lblname);
		
		txtName = new JTextField();
		txtName.setBounds(181, 102, 138, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblid = new JLabel("Employee Id");
		lblid.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblid.setBounds(40, 155, 100, 28);
		frame.getContentPane().add(lblid);
		
		long digit =Math.abs(ran.nextLong()%9000L+10000L);
		lblid1 = new JLabel("1000"+digit);
		lblid1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblid1.setBounds(181, 155, 138, 28);
		frame.getContentPane().add(lblid1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAddress.setBounds(40, 215, 65, 28);
		frame.getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(181, 222, 138, 19);
		frame.getContentPane().add(txtAddress);
		
		JLabel lblEmailId = new JLabel("Email Id");
		lblEmailId.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblEmailId.setBounds(40, 275, 65, 28);
		frame.getContentPane().add(lblEmailId);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(181, 282, 138, 19);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblClassXii = new JLabel("Class XII (%)");
		lblClassXii.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblClassXii.setBounds(40, 335, 106, 28);
		frame.getContentPane().add(lblClassXii);

		txtXii = new JTextField();
		txtXii.setColumns(10);
		txtXii.setBounds(181, 342, 138, 19);
		frame.getContentPane().add(txtXii);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblCourse.setBounds(40, 395, 65, 28);
		frame.getContentPane().add(lblCourse);
		
		String courses[]= {"B.Tech","BCA","M.Tech","MCA"};
		cbCourse = new JComboBox(courses);
		cbCourse.setBounds(181, 402, 138, 19);
		frame.getContentPane().add(cbCourse);	
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblFathersName.setBounds(409, 95, 113, 28);
		frame.getContentPane().add(lblFathersName);
		
		txtFathersName = new JTextField();
		txtFathersName.setColumns(10);
		txtFathersName.setBounds(562, 102, 138, 19);
		frame.getContentPane().add(txtFathersName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDateOfBirth.setBounds(409, 155, 113, 28);
		frame.getContentPane().add(lblDateOfBirth);
		
		dc = new JDateChooser(); 
		dc.setBounds(562, 162, 138, 19);
		frame.getContentPane().add(dc);
		
		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPhoneNo.setBounds(409, 215, 113, 28);
		frame.getContentPane().add(lblPhoneNo);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(562, 222, 138, 19);
		txtPhone.addKeyListener(this);
		frame.getContentPane().add(txtPhone);
		
		JLabel lblX = new JLabel("Class X (%)");
		lblX.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblX.setBounds(409, 275, 113, 28);
		frame.getContentPane().add(lblX);
		
		txtX = new JTextField();
		txtX.setColumns(10);
		txtX.setBounds(562, 282, 138, 19);
		frame.getContentPane().add(txtX);
		
		JLabel lblAadharNo = new JLabel("Aadhar No.");
		lblAadharNo.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAadharNo.setBounds(409, 335, 113, 28);
		frame.getContentPane().add(lblAadharNo);
		
		txtAadhar = new JTextField();
		txtAadhar.setColumns(10);
		txtAadhar.setBounds(562, 342, 138, 19);
		frame.getContentPane().add(txtAadhar);
		
		JLabel lblQualification = new JLabel("Qualtification");
		lblQualification.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblQualification.setBounds(409, 395, 113, 28);
		frame.getContentPane().add(lblQualification);
		
		txtQualification = new JTextField();
		txtQualification.setBounds(562, 402, 138, 19);
		frame.getContentPane().add(txtQualification);
		
		
		btnsubmit = new JButton("Submit");
		btnsubmit.setForeground(new Color(255, 255, 255));
		btnsubmit.setBackground(new Color(0, 128, 192));
		btnsubmit.setFocusable(false);
		btnsubmit.setBounds(206, 473, 113, 41);
		btnsubmit.addActionListener(this);
		frame.getContentPane().add(btnsubmit);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(0, 128, 192));
		btnCancel.setFocusable(false);
		btnCancel.setBounds(425, 473, 113, 41);
		btnCancel.addActionListener(this);
		frame.getContentPane().add(btnCancel);
		
		
		
		frame.setBounds(400, 100, 789, 620);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnsubmit)
		{
			String name=txtName.getText();
			String fathers_name=txtFathersName.getText();
			String address=txtAddress.getText();
			String Roll_no=lblid1.getText();
			String phone_no=txtPhone.getText();
			String dob=((JTextField)dc.getDateEditor().getUiComponent()).getText();
			String email=txtEmail.getText();
			String X=txtX.getText();
			String XII=txtXii.getText();
			String aadhar_no=txtAadhar.getText();
			String course=String.valueOf(cbCourse.getSelectedItem());
			String qualification=txtQualification.getText();
			
			Connection con=null;
			try
			{
				con=new Connect().connect();
				String statement="INSERT INTO teachers VALUES ('"+name+"','"+fathers_name+"','"+Roll_no+"','"+dob+"','"+address+"','"+phone_no+"','"+email+"','"+X+"','"+XII+"','"+aadhar_no+"','"+course+"','"+qualification+"')";
				PreparedStatement ptsmt = con.prepareStatement(statement);
				ptsmt.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Teacher's Data Entered Successfully");
				frame.setVisible(false);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			finally
			{
				if(con!=null)
				{
					try 
					{
						con.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
			}
		}
		if(e.getSource()==btnCancel)
		{
			frame.setVisible(false);
		}
		
	}

	public void keyTyped(KeyEvent e) {
		char c= e.getKeyChar();
		if(!Character.isDigit(c))
		{
			e.consume();
		}
		
	}

	public void keyPressed(KeyEvent e) {
		//No Use Here
	}

	public void keyReleased(KeyEvent e) {
		// No Use Here
	}
}
