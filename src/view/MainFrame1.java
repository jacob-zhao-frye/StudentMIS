package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.UserType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MainFrame1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane DESKTOP_PANE;
	public static UserType usertype;
	public static Object userObject;
	private JMenu facultyManageMenu;
	private JMenuItem teacherAddMenuItem;
	private JMenuItem teacherManageMenuItem;
	private JMenuItem classAddMenuItem;
	private JMenuItem classManageMenuItem;
	private JMenuItem studentManageMenuItem;
	private JMenuItem studentAddMenuItem;
	private JMenu studentManageMenu;
	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// EventQueue.invokeLater(new Runnable() {
	// public void run() {
	// try {
	// MainFrame1 frame = new MainFrame1();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	
	public MainFrame1(UserType usertype, Object UserObject) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.usertype = usertype;
		this.userObject = UserObject;
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		mnNewMenu.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u7CFB\u7EDF\u8BBE\u7F6E.png"));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u4FEE\u6539\u5BC6\u7801.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u9000\u51FA.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(MainFrame1.this, "确认退出") == JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		studentManageMenu = new JMenu("\u5B66\u751F\u4FE1\u606F");
		studentManageMenu.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u751F\u7BA1\u7406.png"));
		menuBar.add(studentManageMenu);

		studentAddMenuItem = new JMenuItem("\u5B66\u751F\u4FE1\u606F\u6DFB\u52A0");
		studentAddMenuItem.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6DFB\u52A0.png"));
		studentAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
			}
		});
		studentManageMenu.add(studentAddMenuItem);

		studentManageMenuItem = new JMenuItem("\u5B66\u751F\u4FE1\u606F\u4FEE\u6539");
		studentManageMenuItem.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u751F\u7BA1\u7406.png"));
		studentManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentManage(ae);
			}
		});
		studentManageMenu.add(studentManageMenuItem);

		facultyManageMenu = new JMenu("\u9662\u7CFB\u7BA1\u7406");
		facultyManageMenu.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u5B66\u9662 (1).png"));
		menuBar.add(facultyManageMenu);

		classAddMenuItem = new JMenuItem("\u73ED\u7EA7\u6DFB\u52A0");
		classAddMenuItem.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6DFB\u52A0.png"));
		classAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				classaddFrame(ae);
			}
		});
		facultyManageMenu.add(classAddMenuItem);

		classManageMenuItem = new JMenuItem("\u73ED\u7EA7\u4FE1\u606F\u4FEE\u6539");
		classManageMenuItem.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u73ED\u7EA7\u7BA1\u7406.png"));
		classManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassManageFrame classManageFrame = new ClassManageFrame();
				classManageFrame.setVisible(true);
				DESKTOP_PANE.add(classManageFrame);
			}
		});
		facultyManageMenu.add(classManageMenuItem);

		teacherAddMenuItem = new JMenuItem("\u6559\u5E08\u6DFB\u52A0");
		teacherAddMenuItem.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u6DFB\u52A0.png"));
		teacherAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				teacherAddAct(ae);
			}
		});
		facultyManageMenu.add(teacherAddMenuItem);

		teacherManageMenuItem = new JMenuItem("\u6559\u5E08\u4FE1\u606F\u4FEE\u6539");
		teacherManageMenuItem.setIcon(new ImageIcon("D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\res\\\u8001\u5E08.png"));
		teacherManageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				teacherManageAct(ae);
			}
		});
		facultyManageMenu.add(teacherManageMenuItem);
		// URL picURL = MainFrame1.class.getResource("/src/image/毛玻璃.jpg");
//		 String picPath
//		 ="D:\\User\\Document\\eclipse-workspace\\StudnetMIS\\src\\image\\毛玻璃.jpg";//
		// 将getFile改为getPath亦可
		// String picPathone = MainFrame1.class.getResource("backImg.jpg")
		// .getPath();
//		 final Image image = ImageIO.read(new File(picPath));
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		DESKTOP_PANE = new JDesktopPane();
		getContentPane().add(DESKTOP_PANE);
		DESKTOP_PANE.setOpaque(true);
		setAuthority();
	}

	protected void teacherManageAct(ActionEvent ae) {
		TeacherManageFrame teacherManageFrame = new TeacherManageFrame();
		teacherManageFrame.setVisible(true);
		DESKTOP_PANE.add(teacherManageFrame);
	}

	protected void teacherAddAct(ActionEvent ae) {
		TeacherAddFrame teacherAddFrame = new TeacherAddFrame();
		teacherAddFrame.setVisible(true);
		DESKTOP_PANE.add(teacherAddFrame);
	}

	protected void studentManage(ActionEvent ae) {
		StudentManageFrame studentManageFrame = new StudentManageFrame();
		studentManageFrame.setVisible(true);
		DESKTOP_PANE.add(studentManageFrame);
	}

	protected void studentAddAct(ActionEvent ae) {
		StudentAddFrame studentAddFrame = new StudentAddFrame();
		studentAddFrame.setVisible(true);
		DESKTOP_PANE.add(studentAddFrame);

	}

	protected void classaddFrame(ActionEvent ae) { // 打开班级添加窗口
		ClassAddFrame classAddFrame = new ClassAddFrame();
		classAddFrame.setVisible(true);
		DESKTOP_PANE.add(classAddFrame); // 添加DESKTOP_PANE需要继承JInternalpane，添加close ableset ，Iconifiable(true);
	}

	protected void editPassword(ActionEvent ae) {
		EditPasswordFrm editpassword = new EditPasswordFrm();
		editpassword.setVisible(true);
		DESKTOP_PANE.add(editpassword);
		contentPane.repaint();
	}

	void setAuthority() {
		if ("学生".equals(usertype.getName())) {
			studentAddMenuItem.setEnabled(false);
			facultyManageMenu.setEnabled(false);
		}
		if ("教师".equals(usertype.getName())) {
			teacherAddMenuItem.setEnabled(false);
			classAddMenuItem.setEnabled(false);
			classManageMenuItem.setEnabled(false);
		}
	}
}
