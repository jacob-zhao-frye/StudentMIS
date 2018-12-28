package view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.List;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Util.StringUtil;
import dao.ClassDao;
import model.Classes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassManageFrame extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchClassNameTextField;
	private JTable classListTable;
	private JTextField editClassNameTextField;
	private JTextField editYearTextField;
	private JTextField editFacultyName;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClassManageFrame frame = new ClassManageFrame();
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
	public ClassManageFrame() {
		setBounds(100, 100, 733, 431);
		setClosable(true);
		setIconifiable(true);
		JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		lblNewLabel.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u540D\u79F0.png"));
		
		searchClassNameTextField = new JTextField();
		searchClassNameTextField.setColumns(20);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {                                              //查询按钮事件
				Classes cls = new Classes();				
				cls.setClassName(searchClassNameTextField.getText().toString());
				setTable(cls);
			}
		});
		searchButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u641C\u7D22.png"));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel ClassNameLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0\uFF1A");
		ClassNameLabel.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u540D\u79F0.png"));
		
		editClassNameTextField = new JTextField();
		editClassNameTextField.setColumns(10);
		
		JLabel entranceYearLabel = new JLabel("\u6240\u5C5E\u5E74\u7EA7\uFF1A");
		entranceYearLabel.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u8BFE\u7A0B\u5217\u8868.png"));
		
		editYearTextField = new JTextField();
		editYearTextField.setColumns(10);
		
		JLabel FacultyNameLabel = new JLabel("\u6240\u5728\u5B66\u9662\uFF1A");
		FacultyNameLabel.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u7BA1\u7406.png"));
		
		editFacultyName = new JTextField();
		editFacultyName.setColumns(10);
		
		JButton updateConfirm = new JButton("\u786E\u8BA4\u4FEE\u6539");
		updateConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateConfirmAct();
			}
		});
		updateConfirm.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u786E\u8BA4.png"));
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteClassAct(ae);
			}
		});
		deleteButton.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5220\u9664.png"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 566, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(ClassNameLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(entranceYearLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editYearTextField))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(FacultyNameLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(editFacultyName)))
									.addPreferredGap(ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(deleteButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(updateConfirm, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(59)))))
					.addContainerGap(76, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchClassNameTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(31)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(editClassNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(ClassNameLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(entranceYearLabel)
								.addComponent(editYearTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(editFacultyName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(FacultyNameLabel)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(updateConfirm)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(deleteButton)))
					.addGap(30))
		);
		
		classListTable = new JTable();
		classListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedTableRow(me);
			}
		});
		classListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u6240\u5C5E\u5E74\u7EA7", "\u6240\u5728\u5B66\u9662"
			}
		) {		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {                    ///////////////////////////////
					false, false, false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
		});
		scrollPane.setViewportView(classListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Classes());                                              //setTable参数为new一个Classes类
	}
	
	protected void updateConfirmAct() {
		ClassDao classDao = new ClassDao();
		int index = classListTable.getRowCount();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的数据");
			return;
		}
		DefaultTableModel dft =(DefaultTableModel) classListTable.getModel();
		String classNum = (String) dft.getValueAt(classListTable.getSelectedRow(), 0);  
		String className = (String) dft.getValueAt(classListTable.getSelectedRow(), 1);               //String的值
		String entranceYear =  (String) dft.getValueAt(classListTable.getSelectedRow(), 2); 
		String FacultyName =  (String) dft.getValueAt(classListTable.getSelectedRow(), 3); 
		String editClassName = editClassNameTextField.getText().toString().trim();
		String editYear = editYearTextField.getText().toString().trim();
		String editFaculty= editFacultyName.getText().toString().trim();
		if(StringUtil.isEmpty(editClassName)) {
			JOptionPane.showMessageDialog(this, "请填写要修改的名称");
			return;
		}
		if(className.equals(editClassName)&&entranceYear.equals(editYear)&&FacultyName.equals(editFaculty)) {
			JOptionPane.showMessageDialog(this, "你还没有做任何修改");
			return;
		}
		Classes cl = new Classes();
		cl.setClassName(editClassName);
		cl.setEntranceYear(editYear);
		cl.setFacultyNum(editFaculty);
		cl.setNum(classNum.trim());
		if(classDao.update(cl)){
			JOptionPane.showMessageDialog(this, "更新成功!");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败!");
		}
		classDao.closeDao();
		setTable(new Classes());
	}

	protected void deleteClassAct(ActionEvent ae) {
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		int index = classListTable.getRowCount();
		if(index==-1) {
			JOptionPane.showMessageDialog(this, "请选中要删除的数据");
			return;
		}
		DefaultTableModel dft =(DefaultTableModel) classListTable.getModel();
		String classNum = (String) dft.getValueAt(classListTable.getSelectedRow(), 0);
		ClassDao classDao = new ClassDao();
		if(classDao.delete(classNum))
			{
			JOptionPane.showMessageDialog(this, "删除成功");
			}else{
				JOptionPane.showMessageDialog(this, "删除失败");
			}
		setTable(new Classes());
	}

	protected void selectedTableRow(MouseEvent me) {
		DefaultTableModel dft =(DefaultTableModel) classListTable.getModel();
		editClassNameTextField.setText(dft.getValueAt(classListTable.getSelectedRow(), 1).toString().trim());
		editYearTextField.setText((String) dft.getValueAt(classListTable.getSelectedRow(), 2).toString().trim());
		editFacultyName.setText(dft.getValueAt(classListTable.getSelectedRow(), 3).toString().trim());           //将鼠标点选的信息显示在文本框里
	}

	@SuppressWarnings("unchecked")
	public void setTable(Classes classes) {                       //将查询到的结果返回表格
		DefaultTableModel dft =(DefaultTableModel) classListTable.getModel();
		dft.setRowCount(0);
		ClassDao  classDao= new ClassDao();
		List<Classes> classList = classDao.getClasslist(classes);
		for (Classes cl :classList) {
			@SuppressWarnings("rawtypes")
			Vector v = new Vector();
			v.add(cl.getNum().trim());
			v.add(cl.getClassName().trim());
			v.add(cl.getEntranceYear().trim());
			v.add(cl.getFacultyNum().trim());
			dft.addRow(v);
		}
		classDao.closeDao();
	}
}
