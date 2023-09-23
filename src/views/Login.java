package views;
import dataBaseConnection.Login_Credentials;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Login implements ActionListener
{
	private JFrame frame;
	private JTextField textField;
	private JTextField passwordField;
	JButton btnClear;
	JButton btnLogin;

	Login() 
	{
		frame = new JFrame("Login");
		frame.setBounds(450, 250, 402, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("User Name");
		lblUsername.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblUsername.setBounds(28, 40, 72, 23);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblPassword.setBounds(28, 86, 72, 23);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(110, 44, 166, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(110, 88, 166, 19);
		frame.getContentPane().add(passwordField);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(172, 138, 85, 21);
		frame.getContentPane().add(btnClear);
		btnClear.addActionListener(this);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(38, 138, 85, 21);
		btnLogin.addActionListener(this);
		
		frame.getContentPane().add(btnLogin);
		frame.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btnClear)
		{
			textField.setText("");
			passwordField.setText("");
		}
		if(e.getSource()==btnLogin)
		{
			String userid = textField.getText();
			String password = passwordField.getText();
			try
			{
				boolean log =new Login_Credentials().check(userid,password);
				if(log)
				{
					frame.setVisible(false);
					new MainScreen();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username or Password");
					textField.setText("");
					passwordField.setText("");
				}
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String args[])
	{
		new Login();
	}

	
}
