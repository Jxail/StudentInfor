/*
 * SearchGroup.java
 *
 * Created on __DATE__, __TIME__
 */

package frame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import business.businessImpl.GroupManageImpl;
import business.businessImpl.StuManageImpl;
import table.LqGroup;
import table.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author  __USER__
 */
public class SearchGroupView extends javax.swing.JPanel {
	private JTextField textField;
	private JTable table;
	/** Creates new form SearchGroup */
	public SearchGroupView() {
		initComponents();
		
	}
//----------------------填充表格的方�?---------------------------------
	public void fillTable(LqGroup lqgroup){
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Vector v = new GroupManageImpl().serchGroupImpl(lqgroup);   //控制空指针异�?
		dtm.setRowCount(0);   //每次显示查询结果之前把之前显示的数据清空
		for(int i=0;i<v.size();i++){
			dtm.addRow((Vector) v.get(i));
		}
	}
	private void initComponents() {

		setBorder(javax.swing.BorderFactory
				.createTitledBorder(javax.swing.BorderFactory
						.createTitledBorder("\u67e5\u8be2\u5206\u7ec4\u4fe1\u606f")));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("查询的小组名称：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(62, 55, 131, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(203, 52, 320, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("开始查询：");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String serchGroupName = textField.getText();
				LqGroup lqgroup = new LqGroup();  //将输入的信息封装到group类中
				lqgroup.setgName(serchGroupName);
				fillTable(lqgroup);  //调用fillTable()方法将查询到的内容填充到表格�?	
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 14));
		btnNewButton.setBounds(180, 298, 93, 34);
		add(btnNewButton);
		
		JButton button = new JButton("取消查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(362, 298, 93, 34);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(96, 122, 427, 166);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = table.getSelectedRow();
				textField.setText(table.getValueAt(row, 1)+"");
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7EC4\u53F7", "\u7EC4\u540D", "\u5C0F\u7EC4\u7B80\u4ECB"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("查询结果显示如下�?");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(63, 97, 130, 15);
		add(lblNewLabel_1);
		
	}
	
}
