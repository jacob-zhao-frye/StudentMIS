package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Util.StringUtil;
import dao.TeacherDao;
import model.Teacher;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class TeacherAddFrame extends JInternalFrame {
	private  JTextField TeacherNumTextField;
	private JTextField TeacherNameTextField;
	private JTextField TeacherNationTextField;
	private JTextField TeacherBirthTextField;
	private JTextField TeacherAddressTextField;
	private JTextField TeacherIDTextField;
	private JTextField TeacherPhoneTextField;
	private JRadioButton MaleRadioButton;
    private JRadioButton FemaleRadioButton;
    private JButton ResetValueButton;
    private JButton InsertButton;
    private JPasswordField TeacherPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherAddFrame frame = new TeacherAddFrame();
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
	public TeacherAddFrame() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(6,2, 0, 0));
		setClosable(true);
		setIconifiable(true);
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		JLabel label = new JLabel("\u6559\u5E08\u7F16\u53F7\uFF1B");
		label.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u5217\u8868.png"));
		panel.add(label);
		
		TeacherNumTextField = new JTextField();
		panel.add(TeacherNumTextField);
		TeacherNumTextField.setColumns(15);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u8001\u5E08.png"));
		panel_1.add(label_1);
		
		TeacherNameTextField = new JTextField();
		panel_1.add(TeacherNameTextField);
		TeacherNameTextField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u6027\u522B\uFF1A");
		label_2.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6027\u522B.png"));
		panel_2.add(label_2);
		ButtonGroup buttongroup = new ButtonGroup();
		
		MaleRadioButton = new JRadioButton("\u7537");
		panel_2.add(MaleRadioButton);
		
		FemaleRadioButton = new JRadioButton("\u5973");
		panel_2.add(FemaleRadioButton);
		buttongroup.add(MaleRadioButton);
		buttongroup.add(FemaleRadioButton);
		JPanel panel_3 = new JPanel();
		getContentPane().add(panel_3);
		
		JLabel label_3 = new JLabel("\u6C11    \u65CF\uFF1A");
		label_3.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6C11\u65CF.png"));
		panel_3.add(label_3);
		
		TeacherNationTextField = new JTextField();
		panel_3.add(TeacherNationTextField);
		TeacherNationTextField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4);
		
		JLabel label_4 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		label_4.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u51FA\u751F\u65E5\u671F.png"));
		panel_4.add(label_4);
		
		TeacherBirthTextField = new JTextField();
		panel_4.add(TeacherBirthTextField);
		TeacherBirthTextField.setColumns(15);
		
		JPanel panel_5 = new JPanel();
		getContentPane().add(panel_5);
		
		JLabel label_5 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		label_5.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5730\u5740.png"));
		panel_5.add(label_5);
		
		TeacherAddressTextField = new JTextField();
		panel_5.add(TeacherAddressTextField);
		TeacherAddressTextField.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		getContentPane().add(panel_6);
		
		JLabel label_6 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7:");
		label_6.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u8EAB\u4EFD\u8BC1 .png"));
		panel_6.add(label_6);
		
		TeacherIDTextField = new JTextField();
		panel_6.add(TeacherIDTextField);
		TeacherIDTextField.setColumns(15);
		
		JPanel panel_7 = new JPanel();
		getContentPane().add(panel_7);
		
		JLabel lblNewLabel = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		lblNewLabel.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u7535\u8BDD\u53F7.png"));
		panel_7.add(lblNewLabel);
		
		TeacherPhoneTextField = new JTextField();
		panel_7.add(TeacherPhoneTextField);
		TeacherPhoneTextField.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		getContentPane().add(panel_8);
		
		JLabel label_7 = new JLabel("\u767B\u9646\u5BC6\u7801\uFF1A");
		label_7.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u4FEE\u6539\u5BC6\u7801.png"));
		panel_8.add(label_7);
		
		TeacherPasswordField = new JPasswordField();
		TeacherPasswordField.setColumns(15);
		panel_8.add(TeacherPasswordField);
		
		JPanel panel_9 = new JPanel();
		getContentPane().add(panel_9);
		
		JPanel panel_10 = new JPanel();
		getContentPane().add(panel_10);
		
		InsertButton = new JButton("\u6DFB\u52A0");
		InsertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				teacherAddAct(ae);
			}
		});
		InsertButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6DFB\u52A0.png"));
		panel_10.add(InsertButton);
		
		JPanel panel_11 = new JPanel();
		getContentPane().add(panel_11);
		
		ResetValueButton = new JButton("\u91CD\u7F6E");
		ResetValueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		ResetValueButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u91CD\u7F6E.png"));
		panel_11.add(ResetValueButton);

	}
	protected void teacherAddAct(ActionEvent ae) {
			String TeacherNum = TeacherNumTextField.getText().toString().trim();
			String TeacherName = TeacherNameTextField.getText().toString().trim();
			String TeacherNation = TeacherNationTextField.getText().toString().trim();
			String TeacherSex = null;
			String TeacherBirth = TeacherBirthTextField.getText().toString().trim();
			String TeacherAddress = TeacherAddressTextField.getText().toString().trim();
			String TeacherID = TeacherIDTextField.getText().toString().trim();
			String TeacherPhone = TeacherPhoneTextField.getText().toString().trim();		
			String TeacherPassword = TeacherPasswordField.getPassword().toString().trim();
			if(StringUtil.isEmpty(TeacherName)){
				JOptionPane.showMessageDialog(this, "请填写教师姓名!");
				return;
			}
			if(StringUtil.isEmpty(TeacherPassword)){
				JOptionPane.showMessageDialog(this, "请填写密码!");
				return;
			}
			if(MaleRadioButton.isSelected()) {
				TeacherSex = "男";
						}else if(FemaleRadioButton.isSelected()) {
							TeacherSex = "女";
						}else {
							JOptionPane.showMessageDialog(this, "请选择性别");//判断性别
						}
			Teacher teacher =new Teacher();
			teacher.setNum(TeacherNum);
			teacher.setName(TeacherName);
			teacher.setSex(TeacherSex.trim());
			teacher.setNation(TeacherNation);
			teacher.setBirth(TeacherBirth);
			teacher.setAddress(TeacherAddress);
			teacher.setID(TeacherID);
			teacher.setPhone(TeacherPhone);
			teacher.setPassword(TeacherPassword);
			TeacherDao teacherDao = new TeacherDao();	
			if(teacherDao.addTeacher(teacher)){
				JOptionPane.showMessageDialog(this, "添加成功!");
			}else{
				JOptionPane.showMessageDialog(this, "添加失败!");
			}
			resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		 TeacherNumTextField.setText("");
		 TeacherNameTextField.setText("");
		 MaleRadioButton.setSelected(false);
		 FemaleRadioButton.setSelected(false);
		 TeacherBirthTextField.setText("");
		 TeacherAddressTextField.setText("");
		 TeacherIDTextField.setText("");
		 TeacherPhoneTextField.setText("");
		 TeacherNationTextField.setText("");
	}
}
