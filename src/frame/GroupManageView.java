package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GroupManageView extends JInternalFrame{
	
	CardLayout cd ;
	JPanel panel_group;
	public GroupManageView() {
		setFrameIcon(new ImageIcon("images\\groupManage.png"));
		setTitle("学生分组信息管理");
		setIconifiable(true);
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		getContentPane().setLayout(null);
	    panel_group = new JPanel();
	    cd = new CardLayout();
		panel_group.setBounds(0, 0, 780, 338);
		getContentPane().add(panel_group);
		panel_group.setLayout(cd);
		
		AddGroupView addGroup = new AddGroupView();
		DelGroupView delGroup = new DelGroupView();
		UpdateGroupView updGroup = new UpdateGroupView();
		SearchGroupView serchGroup = new SearchGroupView();
		panel_group.add(addGroup,"addGroup");
		panel_group.add(delGroup,"delGroup");
		panel_group.add(updGroup,"updGroup");
		panel_group.add(serchGroup,"serchGroup");
		
		JPanel panel_button = new JPanel();
		panel_button.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_button.setBounds(0, 348, 780, 90);
		getContentPane().add(panel_button);
		panel_button.setLayout(null);
		
		JButton addGroup_Button = new JButton("添加分组信息");
		addGroup_Button.setIcon(new ImageIcon("images\\add.png"));
		addGroup_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_group,"addGroup");
			}
		});
		addGroup_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		addGroup_Button.setBounds(59, 26, 140, 34);
		panel_button.add(addGroup_Button);
		
		JButton delGroup_button = new JButton("删除分组信息");
		delGroup_button.setIcon(new ImageIcon("images\\delete.png"));
		delGroup_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cd.show(panel_group,"delGroup");
			}
		});
		delGroup_button.setFont(new Font("宋体", Font.PLAIN, 14));
		delGroup_button.setBounds(235, 26, 143, 34);
		panel_button.add(delGroup_button);
		
		JButton updGroup_button = new JButton("更新分组信息");
		updGroup_button.setIcon(new ImageIcon("images\\reset.png"));
		updGroup_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_group,"updGroup");
			}
		});
		updGroup_button.setFont(new Font("宋体", Font.PLAIN, 14));
		updGroup_button.setBounds(411, 26, 136, 34);
		panel_button.add(updGroup_button);
		
		JButton SearchGroup_button = new JButton("查询分组信息");
		SearchGroup_button.setIcon(new ImageIcon("images\\search.png"));
		SearchGroup_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cd.show(panel_group,"serchGroup");
			}
		});
		SearchGroup_button.setFont(new Font("宋体", Font.PLAIN, 14));
		SearchGroup_button.setBounds(576, 26, 140, 34);
		panel_button.add(SearchGroup_button);
	
		setSize(823,467);
		setVisible(true);
		
	}
}
