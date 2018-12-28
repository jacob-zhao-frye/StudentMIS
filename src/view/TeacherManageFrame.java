package view;

import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Util.StringUtil;
import dao.TeacherDao;
import model.Teacher;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class TeacherManageFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable TeacherListTable;
	private JTextField nameTextField;
	private JTextField numEditTextField;
	private JTextField nameEditTextField;
	private JTextField nationEditTextField;
	private JTextField BirthEditTextField;
	private JTextField AddressEditTextField;
	private JTextField IDEditTextField;
	private JTextField phoneEditTextField;
	private JButton searhButton;
	private JButton updateButon;
	private JButton deleteButton;
	private JRadioButton MaleRadioButton;
	private JRadioButton FemaleRadioButton;
	private ButtonGroup buttongroup;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherManageFrame frame = new TeacherManageFrame();
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
	public TeacherManageFrame() {
		setBounds(100, 100, 752, 474);
		setClosable(true);
		setIconifiable(true);
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u7F16\u53F7\uFF1A");
		
		numEditTextField = new JTextField();
		numEditTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		
		nameEditTextField = new JTextField();
		nameEditTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6027\u522B\uFF1A");
		buttongroup = new ButtonGroup();
		MaleRadioButton = new JRadioButton("\u7537");		
		FemaleRadioButton = new JRadioButton("\u5973");
		buttongroup.add(MaleRadioButton);
		buttongroup.add(FemaleRadioButton);
		JLabel label_4 = new JLabel("\u6C11\u65CF\uFF1A");
		
		nationEditTextField = new JTextField();
		nationEditTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u51FA\u751F\u5E74\u6708\uFF1A");
		
		BirthEditTextField = new JTextField();
		BirthEditTextField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		
		AddressEditTextField = new JTextField();
		AddressEditTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		
		JLabel label_7 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		
		IDEditTextField = new JTextField();
		IDEditTextField.setColumns(10);
		
		phoneEditTextField = new JTextField();
		phoneEditTextField.setColumns(10);
		
		searhButton = new JButton("\u67E5\u8BE2");
		searhButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchTeacher(ae);
			}
		});
		searhButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u641C\u7D22.png"));
		
		updateButon = new JButton("\u786E\u8BA4\u4FEE\u6539");
		updateButon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditAct(ae);
			}
		});
		updateButon.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u786E\u8BA4.png"));
		
		deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteTeacher(ae);
			}
		});
		deleteButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5220\u9664.png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searhButton)
							.addGap(18)
							.addComponent(updateButon)
							.addGap(18)
							.addComponent(deleteButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addGap(2)
									.addComponent(numEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(MaleRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(FemaleRadioButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(1)
									.addComponent(nameEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_4)
									.addGap(2)
									.addComponent(nationEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(AddressEditTextField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(phoneEditTextField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BirthEditTextField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(IDEditTextField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searhButton)
						.addComponent(updateButon)
						.addComponent(deleteButton))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(numEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_3)
								.addComponent(MaleRadioButton)
								.addComponent(label_1)
								.addComponent(FemaleRadioButton))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(8)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(nameEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_2)
										.addComponent(label_4)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(nationEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_6)
										.addComponent(AddressEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(phoneEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label_7)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_5)
								.addComponent(BirthEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(IDEditTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		TeacherListTable = new JTable();
		TeacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		TeacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u6559\u5E08\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u6C11\u65CF", "\u51FA\u751F\u5E74\u6708", "\u5BB6\u5EAD\u4F4F\u5740", "\u8EAB\u4EFD\u8BC1\u53F7", "\u8054\u7CFB\u65B9\u5F0F", "\u767B\u5F55\u5BC6\u7801"
			}
		));
		scrollPane.setViewportView(TeacherListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Teacher());
		setAuthority();
	}

	protected void searchTeacher(ActionEvent ae) {
		Teacher teacher = new Teacher();
		teacher.setName(nameTextField.getText().toString().trim());
		setTable(teacher);
	}
	protected void deleteTeacher(ActionEvent ae) {
			int row = TeacherListTable.getSelectedRow();
			if(row == -1){
				JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
				return;
			}
			if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
				return;
			}
			TeacherDao teacherDao = new TeacherDao();
			if(teacherDao.delete(TeacherListTable.getValueAt(row, 0).toString())){
				JOptionPane.showMessageDialog(this, "删除成功！");
			}else{
				JOptionPane.showMessageDialog(this, "删除失败！");
			}
			teacherDao.closeDao();
			setTable(new Teacher());
		}
	protected void submitEditAct(ActionEvent ae) {
		int row = TeacherListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String teacherName = nameEditTextField.getText().toString();
		String teacherNum = numEditTextField.getText().toString();
		String teacherNation = nationEditTextField.getText().toString();
		String teacherAddress = AddressEditTextField.getText().toString();
		String teacherBirth = BirthEditTextField.getText().toString();
		String teacherID = IDEditTextField.getText().toString();
		String teacherPhone = phoneEditTextField.getText().toString();
		
		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(this, "请填写教师姓名！");
			return;
		}
		
		Teacher teacher = new Teacher();
		teacher.setName(teacherName);
		teacher.setNation(teacherNation);
		teacher.setAddress(teacherAddress);
		teacher.setBirth(teacherBirth);
		teacher.setPhone(teacherPhone);
		teacher.setNum(teacherNum);
		teacher.setID(teacherID);
		teacher.setPassword("123456");
		if(MaleRadioButton.isSelected()) teacher.setSex(MaleRadioButton.getText().toString());
		if(FemaleRadioButton.isSelected()) teacher.setSex(FemaleRadioButton.getText().toString());//设置性别
		
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.update(teacher)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());

	}
	
	
	protected void selectedTableRow(MouseEvent me) {
		DefaultTableModel dft =(DefaultTableModel) TeacherListTable.getModel();
		numEditTextField.setText(dft.getValueAt(TeacherListTable.getSelectedRow(), 0).toString().trim());
		nameEditTextField.setText((String) dft.getValueAt(TeacherListTable.getSelectedRow(), 1).toString().trim());
		String sex = dft.getValueAt(TeacherListTable.getSelectedRow(), 2).toString();
		buttongroup.clearSelection();
		if(sex.equals(MaleRadioButton.getText()))MaleRadioButton.setSelected(true);
		if(sex.equals(FemaleRadioButton.getText()))FemaleRadioButton.setSelected(true);
		nationEditTextField.setText(dft.getValueAt(TeacherListTable.getSelectedRow(), 3).toString().trim());  
		BirthEditTextField.setText(dft.getValueAt(TeacherListTable.getSelectedRow(), 4).toString().trim());  
		AddressEditTextField.setText(dft.getValueAt(TeacherListTable.getSelectedRow(), 5).toString().trim());  
		IDEditTextField.setText(dft.getValueAt(TeacherListTable.getSelectedRow(), 6).toString().trim());  
		phoneEditTextField.setText(dft.getValueAt(TeacherListTable.getSelectedRow(), 7).toString().trim());  
    //将鼠标点选的信息显示在文本框里
	}


	@SuppressWarnings("unchecked")
	public void setTable(Teacher teacher) {                       //将查询到的结果返回表格
		if("教师".equals(MainFrame1.usertype.getName())){
			Teacher tLogined = (Teacher) MainFrame1.userObject;
			teacher.setName(tLogined.getName());
			nameTextField.setText(teacher.getName());
		}
		DefaultTableModel dft =(DefaultTableModel) TeacherListTable.getModel();
		dft.setRowCount(0);
		TeacherDao  teacherDao= new TeacherDao();
		List<Teacher> teacherList = teacherDao.getTeacherList(teacher);
		for (Teacher tea :teacherList) {
			@SuppressWarnings("rawtypes")
			Vector v = new Vector();
			v.add(tea.getNum().trim());
			v.add(tea.getName().trim());
			v.add(tea.getSex().trim());
			v.add(tea.getNation().trim());
			v.add(tea.getBirth().trim());
			v.add(tea.getAddress().trim());
			v.add(tea.getID().trim());
			v.add(tea.getPhone().trim());
			v.add(tea.getPassword());
			dft.addRow(v);
		}
		teacherDao.closeDao();
	}
	 void setAuthority(){
		if("教师".equals(MainFrame1.usertype.getName())){
//			System.out.println(MainFrame1.usertype.getName());
			deleteButton.setEnabled(false);
			nameTextField.setEditable(false);
			updateButon.setEnabled(false);
		}
	}
//	protected void deleteTeacher() {
//		int row = TeacherListTable.getSelectedRow();
//		if(row == -1){
//			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
//			return;
//		}
//		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
//			return;
//		}
//		TeacherDao teacherDao = new TeacherDao();
//		if(teacherDao.delete(TeacherListTable.getValueAt(row, 0).toString())){
//			JOptionPane.showMessageDialog(this, "删除成功！");
//		}else{
//			JOptionPane.showMessageDialog(this, "删除失败！");
//		}
//		teacherDao.closeDao();
//		setTable(new Teacher());
//		
//	}
}
