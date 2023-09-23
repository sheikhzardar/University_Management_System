package views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import operations.AddStudent;
import operations.AddTeacher;
import operations.FeeDetails;
import operations.LeaveStudent;
import operations.LeaveTeacher;
import operations.Result;
import operations.UpdateStudent;
import operations.UpdateTeacher;
import operations.UploadMarks;
import operations.ViewStudent;
import operations.ViewStudentLeave;
import operations.ViewTeacher;
import operations.ViewTeacherLeave;

public class MainScreen implements ActionListener
{

	private JFrame frame;
	private JLabel label;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu newInfoMenu;
	private JMenu viewDetailsMenu;
	private JMenu leaveDeatilsMenu;
	private JMenu applyLeaveMenu;
	private JMenu examinationMenu;
	private JMenu exitMenu;
	private JMenu feeDetailsMenu;
	private JMenu updateDetailsMenu;
	
	private JMenuItem newFacultyInformationbtn;
	private JMenuItem newStudentInfobtn;
	
	private JMenuItem viewStudentDetailsbtn;
	private JMenuItem viewTeacherDetailsbtn;
	
	private JMenuItem exitbtn;
	private JMenuItem applyStudentLeavebtn;
	private JMenuItem applyTeacherLeavebtn;
	private JMenuItem studentLeaveDetailsbtn;
	private JMenuItem teacherLeaveDetailsbtn;
	private JMenuItem updateStudentDetailbtn;
	private JMenuItem updateTeacherDetailbtn;
	private JMenuItem updateMarksbtn;
	private JMenuItem viewResultbtn;
	private JMenuItem feebtn;
	
	public MainScreen() 
	{	
		frame = new JFrame();
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		panel=new JPanel();
		label = new JLabel();
		ImageIcon i=new ImageIcon("images/a2.jpg");
		Image i2=i.getImage().getScaledInstance(1500, 800, Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		label.setIcon(i3);
		
		panel.add(label);
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		newInfoMenu = new JMenu("New Information");
		menuBar.add(newInfoMenu);
		
		newStudentInfobtn = new JMenuItem("Add New Student");
		newInfoMenu.add(newStudentInfobtn);
		newStudentInfobtn.addActionListener(this);
		
		newFacultyInformationbtn = new JMenuItem("Add New Faculty");
		newInfoMenu.add(newFacultyInformationbtn);
		newFacultyInformationbtn.addActionListener(this);
		
		viewDetailsMenu = new JMenu("View Details");
		menuBar.add(viewDetailsMenu);
		
		viewStudentDetailsbtn = new JMenuItem("View Student Details");
		viewStudentDetailsbtn.addActionListener(this);
		viewDetailsMenu.add(viewStudentDetailsbtn);
		
		viewTeacherDetailsbtn = new JMenuItem("View Teacher Details");
		viewTeacherDetailsbtn.addActionListener(this);
		viewDetailsMenu.add(viewTeacherDetailsbtn);
		
		leaveDeatilsMenu = new JMenu("Leave Details");
		menuBar.add(leaveDeatilsMenu);
		
		studentLeaveDetailsbtn = new JMenuItem("Student's Leave Details");
		studentLeaveDetailsbtn.addActionListener(this);
		leaveDeatilsMenu.add(studentLeaveDetailsbtn);
		
		teacherLeaveDetailsbtn = new JMenuItem("Teacher's Leave Details");
		teacherLeaveDetailsbtn.addActionListener(this);
		leaveDeatilsMenu.add(teacherLeaveDetailsbtn);
		
		applyLeaveMenu = new JMenu("Apply Leave");
		menuBar.add(applyLeaveMenu);
		
		applyStudentLeavebtn = new JMenuItem("Apply Student's Leave");
		applyStudentLeavebtn.addActionListener(this);
		applyLeaveMenu.add(applyStudentLeavebtn);
		
		applyTeacherLeavebtn = new JMenuItem("Apply Teacher's Leave");
		applyTeacherLeavebtn.addActionListener(this);
		applyLeaveMenu.add(applyTeacherLeavebtn);
		
		examinationMenu = new JMenu("Examination");
		updateMarksbtn = new JMenuItem("Enter Marks Of Student");
		updateMarksbtn.addActionListener(this);
		examinationMenu.add(updateMarksbtn);
		menuBar.add(examinationMenu);
		
		viewResultbtn = new JMenuItem("View Result");
		viewResultbtn.addActionListener(this);
		examinationMenu.add(viewResultbtn);
		
		updateDetailsMenu = new JMenu("Update Details");
		menuBar.add(updateDetailsMenu);
		
		updateStudentDetailbtn = new JMenuItem("Update Student's Detail");
		updateDetailsMenu.add(updateStudentDetailbtn);
		updateStudentDetailbtn.addActionListener(this);
		
		updateTeacherDetailbtn = new JMenuItem("Update Teacher's Detail");
		updateTeacherDetailbtn.addActionListener(this);
		updateDetailsMenu.add(updateTeacherDetailbtn);
		
		feeDetailsMenu = new JMenu("Fee Details");
		feebtn = new JMenuItem("Fee Structure");
		feebtn.addActionListener(this);
		feeDetailsMenu.add(feebtn);
		menuBar.add(feeDetailsMenu);
		
		exitMenu = new JMenu("Exit");
		
		exitbtn = new JMenuItem("Exit");
		exitbtn.addActionListener(this);
		exitMenu.add(exitbtn);
		menuBar.add(exitMenu);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==newStudentInfobtn)
		{
			new AddStudent();
		}
		if(e.getSource()==newFacultyInformationbtn)
		{
			new AddTeacher();
		}
		if(e.getSource()==viewStudentDetailsbtn)
		{
			new ViewStudent();
		}
		if(e.getSource()==viewTeacherDetailsbtn)
		{
			new ViewTeacher();
		}
		if(e.getSource()==applyStudentLeavebtn)
		{
			new LeaveStudent();
		}
		if(e.getSource()==applyTeacherLeavebtn)
		{
			new LeaveTeacher();
		}
		if(e.getSource()==studentLeaveDetailsbtn)
		{
			new ViewStudentLeave();
		}
		if(e.getSource()==teacherLeaveDetailsbtn)
		{
			new ViewTeacherLeave();
		}
		if(e.getSource()==updateStudentDetailbtn)
		{
			new UpdateStudent();
		}
		if(e.getSource()==updateTeacherDetailbtn)
		{
			new UpdateTeacher();
		}
		if(e.getSource()==updateMarksbtn)
		{
			new UploadMarks();
		}
		if(e.getSource()==viewResultbtn)
		{
			new Result();
		}
		if(e.getSource()==feebtn)
		{
			new FeeDetails();
		}
		if(e.getSource()==exitbtn)
		{
			System.exit(0);
		}
	}

}
