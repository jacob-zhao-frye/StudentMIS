package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Util.StringUtil;
import dao.ClassDao;
import dao.StudentDao;
import model.Classes;
import model.Student;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

@SuppressWarnings("unused")
public class StudentAddFrame extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private JTextField studentNumTextField;
	private JTextField studentNameTextField;
	private JTextField studentNationTextField;
	private JTextField studentBirthTextField;
	private JTextField studentAddressTextField;
	private JTextField studentIDTextField;
	private JTextField studentPhoneTextField;
	private JButton resetValueButton;
	private JButton submitInsertButton;
	private JPasswordField studentPasswordField;
	private JRadioButton studentSexMaleRadioButton;
	private JRadioButton studentSexFemaleRadioButton;
	private ButtonGroup sexButtonGroup;
	@SuppressWarnings("rawtypes")
	private JComboBox studentClassComboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentAddFrame frame = new StudentAddFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public StudentAddFrame() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u4FEE\u6539");
		setBounds(100, 100, 395, 425);
		getContentPane().setLayout(new GridLayout(6,2));
		setClosable(true);
		setIconifiable(true);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel label = new JLabel("\u5B66\u751F\u7F16\u53F7\uFF1A");
		label.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u751F\u7BA1\u7406.png"));
		panel.add(label);
		
		studentNumTextField = new JTextField();
		panel.add(studentNumTextField);
		studentNumTextField.setColumns(20);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		
		JLabel label_1 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u751F\u7BA1\u7406.png"));
		panel_2.add(label_1);
		
		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(20);
		panel_2.add(studentNameTextField);
		
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u6027\u522B\uFF1A");
		label_2.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6027\u522B.png"));
		
		 studentSexMaleRadioButton = new JRadioButton("\u7537");
		
		 studentSexFemaleRadioButton = new JRadioButton("\u5973");
			sexButtonGroup = new ButtonGroup();
			sexButtonGroup.add(studentSexMaleRadioButton);
			sexButtonGroup.add(studentSexFemaleRadioButton);
			
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(studentSexMaleRadioButton)
							.addGap(18)
							.addComponent(studentSexFemaleRadioButton))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(55)
							.addComponent(label_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(54))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentSexFemaleRadioButton)
						.addComponent(studentSexMaleRadioButton))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4);
		
		JLabel label_3 = new JLabel("\u6C11    \u65CF\uFF1A");
		label_3.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6C11\u65CF.png"));
		panel_4.add(label_3);
		
		studentNationTextField = new JTextField();
		studentNationTextField.setColumns(20);
		panel_4.add(studentNationTextField);
		
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);
		
		JLabel label_4 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_4.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u51FA\u751F\u65E5\u671F.png"));
		panel_5.add(label_4);
		
		studentBirthTextField = new JTextField();
		studentBirthTextField.setColumns(20);
		panel_5.add(studentBirthTextField);
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6);
		
		JLabel lblNewLabel = new JLabel("\u5730    \u5740\uFF1A");
		lblNewLabel.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5730\u5740.png"));
		panel_6.add(lblNewLabel);
		
		studentAddressTextField = new JTextField();
		studentAddressTextField.setColumns(20);
		panel_6.add(studentAddressTextField);
		
		JPanel panel_7 = new JPanel();
		getContentPane().add(panel_7);
		
		JLabel lblNewLabel_1 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u8EAB\u4EFD\u8BC1 .png"));
		panel_7.add(lblNewLabel_1);
		
		studentIDTextField = new JTextField();
		studentIDTextField.setColumns(20);
		panel_7.add(studentIDTextField);
		
		JPanel panel_8 = new JPanel();
		getContentPane().add(panel_8);
		
		JLabel lblNewLabel_2 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u7535\u8BDD\u53F7.png"));
		panel_8.add(lblNewLabel_2);
		
		studentPhoneTextField = new JTextField();
		studentPhoneTextField.setColumns(20);
		panel_8.add(studentPhoneTextField);
		
		JPanel panel_9 = new JPanel();
		getContentPane().add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\u6240\u5728\u73ED\u7EA7\uFF1A");
		lblNewLabel_3.setBounds(52, 10, 80, 16);
		lblNewLabel_3.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5E74\u7EA7.png"));
		panel_9.add(lblNewLabel_3);
		
		 studentClassComboBox = new JComboBox();
		studentClassComboBox.setBounds(29, 34, 134, 21);
		panel_9.add(studentClassComboBox);
		
		JPanel panel_10 = new JPanel();
		getContentPane().add(panel_10);
		
		JLabel label_5 = new JLabel("\u767B\u9646\u5BC6\u7801\uFF1A");
		label_5.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\password.png"));
		panel_10.add(label_5);
		
		studentPasswordField = new JPasswordField();
		studentPasswordField.setColumns(20);
		panel_10.add(studentPasswordField);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		submitInsertButton = new JButton("\u63D2\u5165");
		submitInsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				StudentAddAct(ae);
			}
		});
		submitInsertButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u786E\u8BA4.png"));
		panel_1.add(submitInsertButton);
		
		JPanel panel_11 = new JPanel();
		getContentPane().add(panel_11);
		
		resetValueButton = new JButton("\u91CD\u7F6E");
		panel_11.add(resetValueButton);
		resetValueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetValueButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u91CD\u7F6E.png"));
		setClassInfo();
	}

	protected void StudentAddAct(ActionEvent ae) {
		String studentNum = studentNumTextField.getText().toString().trim();
		String studentName = studentNameTextField.getText().toString().trim();
		String studentNation = studentNationTextField.getText().toString().trim();
		String studentSex = null;
		String studentBirth = studentBirthTextField.getText().toString().trim();
		String studentAddress = studentAddressTextField.getText().toString().trim();
		String studentID = studentIDTextField.getText().toString().trim();
		String studentPhone = studentPhoneTextField.getText().toString().trim();		
		String studentPassword = studentPasswordField.getPassword().toString().trim();
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "请填写学生姓名!");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "请填写密码!");
			return;
		}
		
		Classes sc = (Classes)studentClassComboBox.getSelectedItem();
//		String sex = studentSexMaleRadioButton.isSelected() ? studentSexMaleRadioButton.getText() : (studentSexFemaleRadioButton.isSelected() ? studentSexFemaleRadioButton.getText());
		if(studentSexMaleRadioButton.isSelected()) {
			studentSex = "男";
					}else if(studentSexFemaleRadioButton.isSelected()) {
						studentSex = "女";
					}else {
						JOptionPane.showMessageDialog(this, "请选择性别");//判断性别
					}
		Student stu = new Student();                        //先将各数据传到STU里，之后调用StudentDao将数据传入数据库中
		stu.setNum(studentNum);
		stu.setName(studentName);
		stu.setSex(studentSex);
		stu.setNation(studentNation);
		stu.setBirth(studentBirth);
		stu.setAddress(studentAddress);
		stu.setID(studentID);
		stu.setPhone(studentPhone);
		stu.setClassNum(sc.getNum());
		stu.setPassword(studentPassword);
		StudentDao studentDao = new StudentDao();	
		if(studentDao.addStudent(stu)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		 studentNumTextField.setText("");
		 studentNameTextField.setText("");
		 sexButtonGroup.clearSelection();
		 studentNationTextField.setText("");
		 studentBirthTextField.setText("");
		 studentAddressTextField.setText("");
		 studentIDTextField.setText("");
		 studentPhoneTextField.setText("");
			studentClassComboBox.setSelectedIndex(0);
	}
	@SuppressWarnings("unchecked")
	private void setClassInfo(){
		ClassDao classDao = new ClassDao();
		List<Classes> classList = classDao.getClasslist(new Classes());	
		for (Classes sc : classList) {
			studentClassComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
}
