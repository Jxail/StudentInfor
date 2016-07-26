package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class MainFrameView extends JFrame {

	private JPanel contentPane;
	final JDesktopPane desktopPane = new JDesktopPane();
	/**
	 * Create the frame.
	 */
	public MainFrameView() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 822, 32);
		contentPane.add(menuBar);
		
		JMenu menuGroup = new JMenu("分组管理");
		JMenu menuStu = new JMenu("学生管理");
//------------------menuItemGroup-----------------------------------		
		menuGroup.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuBar.add(menuGroup);
		menuBar.add(menuStu);
		JMenuItem menuItemGroup = new JMenuItem("分组信息管理");
		menuItemGroup.setIcon(new ImageIcon("images/studentManage.png"));
		menuItemGroup.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		menuItemGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GroupManageView gmv = new GroupManageView();
				gmv.setVisible(true);
				desktopPane.add(gmv);

			}
		});
		  menuGroup.add(menuItemGroup);
//------------------menuItemStu--------------------------	
		
		menuStu.setFont(new Font("微软雅黑", Font.PLAIN, 14));	
		JMenuItem menuItemStu = new JMenuItem("学生信息管理");
		menuItemStu.setIcon(new ImageIcon("images/userName.png"));
		menuItemStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StuManageView smv = new StuManageView();
				smv.setVisible(true);
				desktopPane.add(smv);
			}
		});
		menuStu.add(menuItemStu);
//----------------desktopPane---------------------------------------------	
		desktopPane.setBounds(0, 30, 822, 449);
		contentPane.add(desktopPane);
	}
}
