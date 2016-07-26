package frame;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class StuManageView extends JInternalFrame{
	CardLayout cd ;
	JPanel stu_panel;
	public StuManageView() {
		setFrameIcon(new ImageIcon("images\\userName.png"));
		setTitle("学生信息管理");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		stu_panel = new JPanel();
		cd = new CardLayout();
		stu_panel.setBounds(0, 0, 780, 338);
		getContentPane().add(stu_panel);
		stu_panel.setLayout(cd);
	
		AddStuView addStu = new AddStuView();
		DelStuView delStu = new DelStuView();
		UpdateStuView updStu = new UpdateStuView();
		SearchStuView serchStu = new SearchStuView();
		stu_panel.add(addStu,"addStu");
		stu_panel.add(delStu,"delStu");
		stu_panel.add(updStu,"updStu");
		stu_panel.add(serchStu,"serchStu");
		
		JPanel panel_button = new JPanel();
		panel_button.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_button.setBounds(0, 348, 780, 90);
		getContentPane().add(panel_button);
		panel_button.setLayout(null);
		
		JButton addStuButton = new JButton("添加学生信息");
		addStuButton.setIcon(new ImageIcon("images\\add.png"));
		addStuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(stu_panel,"addStu");	
			}
		});
		addStuButton.setFont(new Font("宋体", Font.PLAIN, 14));
		addStuButton.setBounds(59, 28, 155, 37);
		panel_button.add(addStuButton);
		
		JButton button = new JButton("删除学生信息");
		button.setIcon(new ImageIcon("images\\delete.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(stu_panel, "delStu");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(246, 28, 137, 37);
		panel_button.add(button);
		
		JButton button_1 = new JButton("更改信息");
		button_1.setIcon(new ImageIcon("images\\reset.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(stu_panel, "updStu");
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.setBounds(418, 28, 146, 37);
		panel_button.add(button_1);
		
		JButton button_2 = new JButton("查询学生信息");
		button_2.setIcon(new ImageIcon("images\\search.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(stu_panel, "serchStu");
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 14));
		button_2.setBounds(597, 28, 137, 37);
		panel_button.add(button_2);
		setSize(827,467);
		setVisible(true);
	}
	

	
 }

	

