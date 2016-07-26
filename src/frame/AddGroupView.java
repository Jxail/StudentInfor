package frame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import business.businessImpl.GroupManageImpl;
import myUtil.StringUtil;
import table.LqGroup;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddGroupView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable addGroupTable;

	/**
	 * Create the panel.
	 */
	public AddGroupView() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "添加分组信息", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(20, 73, 54, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("添加分组:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(103, 48, 86, 22);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(215, 49, 266, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("添加分组名字:");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(103, 101, 98, 20);
		add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(215, 101, 266, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("添加分组简介：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(105, 146, 124, 22);
		add(lblNewLabel_4);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(176, 178, 307, 84);
		add(textArea);
		
		JButton addGroupButton = new JButton("确定添加");
		addGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				String gID = textField.getText();
				String gName = textField_1.getText();
				String gDesc = textArea.getText();
			
				if(StringUtil.isEmpty(gID)){ 
					JOptionPane.showMessageDialog(null, "小组编号不能为空！！");
					return;
				}
				if(StringUtil.isEmpty(gName)){
					JOptionPane.showMessageDialog(null, "小组名称不能为空！！");
					return;	
				}
				LqGroup lqgroup = new LqGroup(Integer.parseInt(gID),gName,gDesc);
				boolean ab = new GroupManageImpl().addGroupImpl(lqgroup);
				if(ab){
					JOptionPane.showMessageDialog(null, "恭喜你，添加第"+gID+"组成功！");	
					textField.setText("");
					textField_1.setText("");
					textArea.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "sorry，添加第"+gID+"组失败！");
				}
			}
		});	
		addGroupButton.setFont(new Font("宋体", Font.PLAIN, 14));
		addGroupButton.setBounds(188, 284, 93, 40);
		add(addGroupButton);
		
		JButton resetbutton = new JButton("取消添加");
		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
			}
		});
		resetbutton.setFont(new Font("宋体", Font.PLAIN, 14));
		resetbutton.setBounds(388, 284, 93, 40);
		add(resetbutton);
	
	}
}
