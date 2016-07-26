package frame;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import business.businessImpl.GroupManageImpl;
import table.LqGroup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateGroupView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public UpdateGroupView() {
		setBorder(new TitledBorder(null, "\u66F4\u65B0\u5206\u7EC4\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("将更新的分组编号�?");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 52, 130, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(164, 49, 346, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(41, 112, 54, -20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("更改分组组名为：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(31, 90, 118, 15);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 87, 346, 21);
		add(textField_1);
		
		JLabel lblNewLabel_3 = new JLabel("更改的分组简介：");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(31, 127, 112, 15);
		add(lblNewLabel_3);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(164, 138, 346, 127);
		add(textArea);
		
		JButton btnNewButton = new JButton("确定更改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gID = Integer.parseInt(textField.getText());
				String gName = textField_1.getText();
				String gDesc = textArea.getText();
				LqGroup lqgroup = new LqGroup(gID,gName,gDesc);  //将获取的值封装给LqGroup这个�?
				boolean ub = new GroupManageImpl().updGroupImpl(lqgroup);
				if(ub==true){
					JOptionPane.showMessageDialog(null, "恭喜你，更改�?"+gID+"组的信息成功�?");
				}
				else{
					JOptionPane.showMessageDialog(null, "sorry，更改第"+gID+"组的信息失败�?");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(227, 301, 93, 37);
		add(btnNewButton);
		
		JButton button = new JButton("取消更改");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(362, 301, 93, 37);
		add(button);
	}
}
