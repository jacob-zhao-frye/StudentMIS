package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.FrameBorderStyle;

import Util.StringUtil;
import dao.AdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import model.Admin;
import model.Student;
import model.Teacher;
import model.UserType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Login1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	@SuppressWarnings("rawtypes")
	private JComboBox usertypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				 try
				    {
					 @SuppressWarnings("unused")
					FrameBorderStyle frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike; 
				        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
				    }
				    catch(Exception e)
				    {				        
				    }
				try {
					Login1 frame = new Login1();
					UIManager.put("TabbedPane.contentOpaque", false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
		}
	);}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Login1() {
		setResizable(false);
		setTitle("\u767B\u9646\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 404, 74);
		contentPane.add(panel);
		
				JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7BA1\u7406\u7CFB\u7EDF\u767B\u5F55");
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 21));
				lblNewLabel.setBackground(Color.WHITE);
				lblNewLabel
						.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u751F.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 84, 404, 38);
		contentPane.add(panel_1);
		
				JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
				panel_1.add(label);
				label.setFont(new Font("微软雅黑", Font.PLAIN, 12));
				label.setIcon(
						new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u7528\u6237\u540D.png"));
				
						usernameTextField = new JTextField();
						panel_1.add(usernameTextField);
						usernameTextField.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(5, 125, 404, 38);
		contentPane.add(panel_2);
		
				JLabel label_1 = new JLabel("\u5BC6   \u7801\uFF1A");
				panel_2.add(label_1);
				label_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
				label_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\password.png"));
				
						passwordTextField = new JTextField();
						panel_2.add(passwordTextField);
						passwordTextField.setColumns(20);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(5, 162, 404, 38);
		contentPane.add(panel_3);
		
				JLabel label_2 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
				panel_3.add(label_2);
				label_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
				label_2.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u7528\u6237\u5217\u8868.png"));
				
						usertypeComboBox = new JComboBox();
						panel_3.add(usertypeComboBox);
						usertypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));
						usertypeComboBox.setModel(new DefaultComboBoxModel(
								new UserType[] { UserType.TEACHER, UserType.STUDENT, UserType.INSTRUCTOR, UserType.ADMIN }));
										
										JPanel panel_4 = new JPanel();
										panel_4.setBounds(5, 210, 404, 38);
										contentPane.add(panel_4);
										
												JButton button = new JButton("\u767B \u5F55");
												panel_4.add(button);
												button.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														try {
															login();
														} catch (IOException e1) {
															e1.printStackTrace();
														}
													}
												});
												button.setFont(new Font("微软雅黑", Font.PLAIN, 12));
												
														JButton button_1 = new JButton("\u91CD\u7F6E");
														panel_4.add(button_1);
														button_1.setFont(new Font("微软雅黑", Font.PLAIN, 12));
														
														JPanel panel_5 = new JPanel();
														panel_5.setBounds(5, 271, 404, 38);
														contentPane.add(panel_5);
						button_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								resetValue(ae);
							}
						});
	}

	protected void login() throws IOException {
		String userName = usernameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectItem = (UserType) usertypeComboBox.getSelectedItem();
		if (StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		Admin admin = null;
		if ("管理员".equals(selectItem.getName())) {                //
			AdminDao adminDao = new AdminDao();//新建一个AdminDao的实例
			Admin adminTmp = new Admin();//新建一个Admin的实例
			adminTmp.setNum(userName);         //从用户名输入框获得管理员用户名
			adminTmp.setPassword(password);//~密码
			admin = adminDao.Login(adminTmp);//调用AdminDao的登录方法
			adminDao.closeDao();
			if(admin==null) {
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectItem.getName()+"】"+admin.getName().trim()+"登录本系统");
			this.dispose();
			new MainFrame1(selectItem,admin).setVisible(true);;
		} else if ("教师".equals(selectItem.getName())) {
			Teacher teacher = null;
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacherTmp = new Teacher();
			teacherTmp.setNum(userName);
			teacherTmp.setPassword(password);
			teacher = teacherDao.login(teacherTmp);
			teacherDao.closeDao();
			if(teacher == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectItem.getName().trim()+"】:"+teacher.getName().trim()+"登录本系统！");
			this.dispose();
			new MainFrame1(selectItem, teacher).setVisible(true);
		} else if ("学生".equals(selectItem.getName())) {
			Student student = null; 
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			studentTmp.setNum(userName);
			studentTmp.setPassword(password);
			student = studentDao.login(studentTmp);
			studentDao.closeDao();
			if(student == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectItem.getName()+"】："+student.getName().trim()+"登录本系统！");
			this.dispose();
			new MainFrame1(selectItem, student).setVisible(true);
		} else if ("辅导员".equals(selectItem.getName())) {
			
		}
	}

	protected void resetValue(ActionEvent ae) {
		usernameTextField.setText("");
		passwordTextField.setText("");
		usertypeComboBox.setSelectedIndex(0);
	}
}
