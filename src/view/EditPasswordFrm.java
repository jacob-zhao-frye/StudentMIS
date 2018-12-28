package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.StringUtil;
import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Student;
import model.Teacher;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class EditPasswordFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField OldPasswordTextfield;
	private JTextField NewPasswordTextfield;
	private JTextField ConfirmPasswordTextfield;
	private JLabel CurrentUserLabel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPassword frame = new EditPassword();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EditPasswordFrm()  {
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 323, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		contentPane.setLayout(new GridLayout(5, 1, 0, 0));
	    
	    JPanel panel = new JPanel();
	    panel.setBorder(null);
	    contentPane.add(panel);
	    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	    
	    JLabel label_3 = new JLabel("\u5F53\u524D\u5E10\u6237\uFF1A");
	    panel.add(label_3);
	    label_3.setFont(new Font("微软雅黑", Font.PLAIN, 12));
	    label_3.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\userType.png"));
	    
	    JPanel panel_1 = new JPanel();
	    contentPane.add(panel_1);
	    panel_1.setLayout(null);
		
	    CurrentUserLabel = new JLabel("sss");
	    CurrentUserLabel.setBounds(18, 5, 109, 17);
	    panel_1.add(CurrentUserLabel);
	    CurrentUserLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		panel_2.add(label);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\password.png"));
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		OldPasswordTextfield = new JTextField();
		panel_3.add(OldPasswordTextfield);
		OldPasswordTextfield.setColumns(20);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		panel_4.add(label_1);
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u4FEE\u6539\u5BC6\u7801.png"));
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		NewPasswordTextfield = new JTextField();
		panel_5.add(NewPasswordTextfield);
		NewPasswordTextfield.setColumns(20);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		panel_6.add(label_2);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_2.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u4FEE\u6539\u5BC6\u7801.png"));
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		ConfirmPasswordTextfield = new JTextField();
		panel_7.add(ConfirmPasswordTextfield);
		ConfirmPasswordTextfield.setColumns(20);
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		JButton button = new JButton("\u786E\u8BA4\u4FEE\u6539");
		panel_8.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEdit(ae);
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		button.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u786E\u8BA4.png"));
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		panel_9.add(button_1);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				retValue(ae);
			}
		});
		button_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u91CD\u7F6E.png"));
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		if("管理员".equals(MainFrame1.usertype.getName())) {
			Admin admin = (Admin)MainFrame1.userObject;
			CurrentUserLabel.setText("【管理员】"+admin.getName().trim() );
		}else if("学生".equals(MainFrame1.usertype.getName())){
			Student student = (Student)MainFrame1.userObject;
			CurrentUserLabel.setText("【学生】" + student.getName().trim());
		}else if("教师".equals(MainFrame1.usertype.getName())){
			Teacher teacher = (Teacher)MainFrame1.userObject;
			CurrentUserLabel.setText("【教师】" + teacher.getName().trim());
		}
	}

	protected void submitEdit(ActionEvent ae) {
		String oldPassword = OldPasswordTextfield.getText().toString();
		String newPassword = NewPasswordTextfield.getText().toString();
		String conformPassword = ConfirmPasswordTextfield.getText().toString();
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "请填写旧密码！");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "请填写新密码！");
			return;
		}
		if(StringUtil.isEmpty(conformPassword)){
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}
		if(!newPassword.equals(conformPassword)){
			JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
			return;
		}
		if("管理员".equals(MainFrame1.usertype.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrame1.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setNum(admin.getNum());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));			
			adminDao.closeDao();
			return;
		}
		if("学生".equals(MainFrame1.usertype.getName())){
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			Student student = (Student)MainFrame1.userObject;
			studentTmp.setName(student.getName());
			studentTmp.setPassword(oldPassword);
			studentTmp.setNum(student.getNum());
			JOptionPane.showMessageDialog(this, studentDao.editPassword(studentTmp, newPassword));
			studentDao.closeDao();
			return;
		}
		if("教师".equals(MainFrame1.usertype.getName())){
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacherTmp = new Teacher();
			Teacher teacher = (Teacher)MainFrame1.userObject;
			teacherTmp.setPassword(oldPassword);
			teacherTmp.setNum(teacher.getNum());
			JOptionPane.showMessageDialog(this, teacherDao.editPassword(teacherTmp, newPassword));
			teacherDao.closeDao();
			return;
		}
	}
	

	protected void retValue(ActionEvent ae) {
		OldPasswordTextfield.setText("");
		NewPasswordTextfield.setText("");
		ConfirmPasswordTextfield.setText("");
	}
}
