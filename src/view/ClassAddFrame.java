package view;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Util.*;
import dao.ClassDao;
import model.Classes;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassAddFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ClassNumTextField;
	private JTextField ClassNameTextField;
	private JTextField ClassYearTextField;
	private JTextField ClassFacultyTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClassAddFrame frame = new ClassFrame();
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
	public ClassAddFrame() {
		setTitle("\u73ED\u7EA7\u6DFB\u52A0");
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		contentPane.setLayout(new GridLayout(6,1));
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u7F16\u53F7\uFF1A");
		lblNewLabel.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u7BA1\u7406.png"));
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel.add(lblNewLabel);
		
		ClassNumTextField = new JTextField();
		ClassNumTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel.add(ClassNumTextField);
		ClassNumTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u7BA1\u7406.png"));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_1.add(label);
		
		ClassNameTextField = new JTextField();
		ClassNameTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_1.add(ClassNameTextField);
		ClassNameTextField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel label_1 = new JLabel("\u6240\u5728\u5E74\u7EA7\uFF1A");
		label_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u5217\u8868.png"));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_2.add(label_1);
		
		ClassYearTextField = new JTextField();
		ClassYearTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_2.add(ClassYearTextField);
		ClassYearTextField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JLabel label_2 = new JLabel("\u6240\u5C5E\u5B66\u9662\uFF1A");
		label_2.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u9662 (1).png"));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_3.add(label_2);
		
		ClassFacultyTextField = new JTextField();
		ClassFacultyTextField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		ClassFacultyTextField.setColumns(10);
		panel_3.add(ClassFacultyTextField);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton button = new JButton("\u786E\u8BA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitClass(ae);
			}
			
		});
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_4.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 12));
		panel_4.add(button_1);
	}
	protected void submitClass(ActionEvent ae) {
		// TODO Auto-generated method stub
		String className = ClassNameTextField.getText().toString();
		String classNum = ClassNumTextField.getText().toString();
		String classYear = ClassYearTextField.getText().toString();
		String facultyNum = ClassFacultyTextField.getText().toString();
		if(StringUtil.isEmpty(className)){
			JOptionPane.showMessageDialog(this, "°à¼¶Ãû³Æ²»ÄÜÎª¿Õ£¡");
			return;
		}
		Classes scl = new Classes();
		scl.setClassName(className);
		scl.setNum(classNum);
		scl.setEntranceYear(classYear);
		scl.setFacultyNum(facultyNum);
		ClassDao classDao = new ClassDao();
		if(classDao.addClass(scl)){
			JOptionPane.showMessageDialog(this, "°à¼¶Ìí¼Ó³É¹¦£¡");
		}else{
			JOptionPane.showMessageDialog(this, "°à¼¶Ìí¼ÓÊ§°Ü£¡");
		}
		classDao.closeDao();
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		ClassNameTextField.setText("");
		ClassNumTextField.setText("");
		ClassYearTextField.setText("");
		ClassFacultyTextField.setText("");
}
}
