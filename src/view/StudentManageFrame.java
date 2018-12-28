package view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Util.StringUtil;
import dao.ClassDao;
import dao.StudentDao;
import model.Classes;
import model.Student;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentManageFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField StudentSearchTextField;
	private JTable studentListTable;
	private JTextField nameEditTextfield;
	private JTextField numTextField;
	private JTextField nationTextField;
	private JTextField birthTextField;
	private JTextField addressTextField;
	private JTextField IDTextField;
	private JTextField PhoneTextField;
	@SuppressWarnings("rawtypes")
	private JComboBox studentSearchComboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox studentEditComboBox;
	private List<Classes>classList;
	private ButtonGroup buttongroup;
	private JRadioButton maleRadioButton;
	private JRadioButton femaleButton;
	private JButton submitButton;
	private JButton deleteButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManageFrame frame = new StudentManageFrame();
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
	public StudentManageFrame() {
		setTitle("\u5B66\u751F\u4FE1\u606F\u4FEE\u6539");
		setBounds(100, 100, 817, 478);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u751F\u7BA1\u7406.png"));
		StudentSearchTextField = new JTextField();
		StudentSearchTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u73ED\u7EA7\uFF1A");
		label_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\src\\image\\\u73ED\u7EA7\u7BA1\u7406.png"));
		
		studentSearchComboBox = new JComboBox();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		
		nameEditTextfield = new JTextField();
		nameEditTextfield.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5B66 \u7C4D \u53F7\uFF1A");
		
		numTextField = new JTextField();
		numTextField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u73ED\u7EA7\uFF1A");
		
		JLabel lblNewLabel = new JLabel("\u6027\u522B\uFF1A");
		
		nationTextField = new JTextField();
		nationTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u6C11\u65CF\uFF1A");
		
		JLabel label_6 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		
		birthTextField = new JTextField();
		birthTextField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		
		JLabel label_8 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		IDTextField = new JTextField();
		IDTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		PhoneTextField = new JTextField();
		PhoneTextField.setColumns(10);
		
		JButton StudentSearchButton = new JButton("\u67E5\u8BE2");
		StudentSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchStudent(ae);
			}
		});
		StudentSearchButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u641C\u7D22.png"));
		
	 submitButton = new JButton("\u786E\u8BA4\u66F4\u6539");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u786E\u8BA4.png"));
		
		studentEditComboBox = new JComboBox();
		
		deleteButton = new JButton("\u5220\u9664\u5B66\u751F");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteStudent();
			}
		});
		deleteButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5220\u9664.png"));
		
		 maleRadioButton = new JRadioButton("\u7537");
		
		 femaleButton = new JRadioButton("\u5973");
		 buttongroup = new ButtonGroup();
		buttongroup.add(maleRadioButton);
		buttongroup.add(femaleButton );
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(StudentSearchTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentSearchComboBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(StudentSearchButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(submitButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(deleteButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 746, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_3)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(numTextField))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(nameEditTextfield, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(maleRadioButton)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(femaleButton))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_5)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(nationTextField)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_4)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(studentEditComboBox, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_6)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(birthTextField)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_7)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_8)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(IDTextField)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(PhoneTextField, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1))))))
					.addGap(74))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(StudentSearchTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(studentSearchComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(StudentSearchButton)
						.addComponent(submitButton)
						.addComponent(deleteButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(nameEditTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(nationTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(label_7)
						.addComponent(addressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(studentEditComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(numTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(label_6)
						.addComponent(birthTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(IDTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PhoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(maleRadioButton)
						.addComponent(femaleButton))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent ae) {
              selectedTableRow(ae);
			}
		});
		scrollPane.setViewportView(studentListTable);
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u5B66\u7C4D\u53F7", "\u5B66\u751F\u59D3\u540D", "\u73ED\u7EA7", "\u6027\u522B", "\u6C11\u65CF", "\u51FA\u751F\u5E74\u6708", "\u5BB6\u5EAD\u4F4F\u5740", "\u8EAB\u4EFD\u8BC1\u53F7", "\u8054\u7CFB\u65B9\u5F0F"
			}
		));
		getContentPane().setLayout(groupLayout);
		setClassInfo();
		setTable(new Student());
		setAuthority();
	}
	
	protected void submitEditAct(ActionEvent ae) {
		int row = studentListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String studentName = nameEditTextfield.getText().toString();
		String studentNum = numTextField.getText().toString();
		String studentNation = nationTextField.getText().toString();
		String studentAddress = addressTextField.getText().toString();
		String studentBirth = birthTextField.getText().toString();
		String studentID = IDTextField.getText().toString();
		String studentPhone = PhoneTextField.getText().toString();
		
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "请填写学生姓名！");
			return;
		}
		
		Student student = new Student();
		student.setName(studentName);
		student.setNation(studentNation);
		student.setAddress(studentAddress);
		student.setBirth(studentBirth);
		student.setPhone(studentPhone);
		student.setNum(studentNum);
		student.setID(studentID);
		student.setPassword("123456");
		Classes sc = (Classes)studentEditComboBox.getSelectedItem();
		student.setClassNum(sc.getNum());          //设置班级号
		if(maleRadioButton.isSelected())student.setSex(maleRadioButton.getText().toString());
		if(femaleButton.isSelected())student.setSex(femaleButton.getText().toString());//设置性别
		
		StudentDao studentDao = new StudentDao();
		if(studentDao.update(student)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		studentDao.closeDao();
		setTable(new Student());
	}

	protected void searchStudent(ActionEvent ae) {
		Student student = new Student();
		student.setName(StudentSearchTextField.getText().toString().trim());
		Classes classes = (Classes)studentSearchComboBox.getSelectedItem();
		student.setClassNum(classes.getNum());
		setTable(student);
	}
	@SuppressWarnings({ })
	protected void deleteStudent() {
		int row = studentListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		StudentDao studentDao = new StudentDao();
		if(studentDao.delete(studentListTable.getValueAt(row, 0).toString())){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		studentDao.closeDao();
		setTable(new Student());	
	}

	@SuppressWarnings("unchecked")
	public void setTable(Student student) {                       //将查询到的结果返回表格
		if("学生".equals(MainFrame1.usertype.getName())){
			Student s = (Student)MainFrame1.userObject;
			student.setName(s.getName());
		}
		DefaultTableModel dft =(DefaultTableModel) studentListTable.getModel();
		dft.setRowCount(0);
		StudentDao  studentDao= new StudentDao();
		List<Student> studentList = studentDao.getStudentList(student);
		for (Student stu :studentList) {
			@SuppressWarnings("rawtypes")
			Vector v = new Vector();
			v.add(stu.getNum().trim());
			v.add(stu.getName().trim());
			v.add(getClassNameById(stu.getClassNum()).trim());		
			v.add(stu.getSex().trim());
			v.add(stu.getNation().trim());
			v.add(stu.getBirth().trim());
			v.add(stu.getAddress().trim());
			v.add(stu.getID().trim());
			v.add(stu.getPhone().trim());
			
			dft.addRow(v);
		}
		studentDao.closeDao();
	}
	private String getClassNameById(String id){
		for (Classes sc : classList) {
			if(sc.getNum().equals(id))
				return sc.getClassName();
		}
		return "";
	}
	protected void selectedTableRow(MouseEvent me) {
		DefaultTableModel dft =(DefaultTableModel) studentListTable.getModel();
		numTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 0).toString().trim());
		nameEditTextfield.setText((String) dft.getValueAt(studentListTable.getSelectedRow(), 1).toString().trim());
		String className = dft.getValueAt(studentListTable.getSelectedRow(), 2).toString();
		for(int i=0;i<studentEditComboBox.getItemCount();i++){
			Classes sc = (Classes)studentEditComboBox.getItemAt(i);
			if(className.equals(sc.getClassName().trim())){
				studentEditComboBox.setSelectedIndex(i);
			}
		}
		String sex = dft.getValueAt(studentListTable.getSelectedRow(), 3).toString();
		buttongroup.clearSelection();
		if(sex.equals(maleRadioButton.getText()))maleRadioButton.setSelected(true);
		if(sex.equals(femaleButton.getText()))femaleButton.setSelected(true);
		nationTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 4).toString().trim());  
		birthTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 5).toString().trim());  
		addressTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 6).toString().trim());  
		IDTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 7).toString().trim());  
		PhoneTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 8).toString().trim());      //将鼠标点选的信息显示在文本框里
	}
	@SuppressWarnings("unchecked")
	private void setClassInfo(){
		ClassDao classDao = new ClassDao();
		classList = classDao.getClasslist(new Classes());	
		for (Classes sc : classList) {
			studentSearchComboBox.addItem(sc);
			studentEditComboBox.addItem(sc);
		}
		classDao.closeDao();
	}
 void setAuthority(){
		if("学生".equals(MainFrame1.usertype.getName())){
			Student s = (Student)MainFrame1.userObject;
			StudentSearchTextField.setText(s.getName());
			StudentSearchTextField.setEnabled(false);
			deleteButton.setEnabled(false);
			submitButton.setEnabled(false);
//			studentListTable.setEnabled(false);
			for(int i=0;i<studentSearchComboBox.getItemCount();i++){
				Classes cl = (Classes) studentSearchComboBox.getItemAt(i);
				if(cl.getNum() == s.getClassNum()){
					studentSearchComboBox.setSelectedIndex(i);
					break;
				}
			}
			studentSearchComboBox.setEnabled(false);
			for(int i=0;i<studentEditComboBox.getItemCount();i++){
				Classes sc = (Classes) studentEditComboBox.getItemAt(i);
				if(sc.getNum() == s.getClassNum()){
					studentEditComboBox.setSelectedIndex(i);
					break;
				}
			}
			studentEditComboBox.setEnabled(false);
		}
	}
}
