package frame;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import business.businessImpl.GroupManageImpl;
import jdbcDao.jdbcDaoImpl.Group_OperationImpl;
import table.LqGroup;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DelGroupView extends JPanel {
	private JTextField textField;
	private JTable table;
	LqGroup lqgroup = new LqGroup();
	public void fillTable(LqGroup lqgroup){
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Vector vec = new GroupManageImpl().serchGroupImpl(lqgroup);
		dtm.setRowCount(0);   //每次显示查询结果之前把之前显示的数据清空
		for(int i=0;i<vec.size();i++){
			dtm.addRow((Vector) vec.get(i));
		}
	}
	public DelGroupView() {
		setBorder(new TitledBorder(null, "\u5220\u9664\u5206\u7EC4\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("小组名称：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(87, 50, 91, 25);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(180, 52, 238, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton delGroupButton = new JButton("确定删除");
		delGroupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String gName = textField.getText();
				LqGroup lqgroup = new LqGroup(); 
				lqgroup.setgName(gName); //封装到LqGroup类中
				
				boolean db = new GroupManageImpl().delGroupImpl(lqgroup);
				if(db==true){
					JOptionPane.showMessageDialog(null,"恭喜你，删除"+gName+"成功！");
				}
				else{
					JOptionPane.showMessageDialog(null,"sorry，删除"+gName+"失败！");
				}
			}
		});
		delGroupButton.setFont(new Font("宋体", Font.PLAIN, 14));
		delGroupButton.setBounds(161, 292, 93, 40);
		add(delGroupButton);
		
		JButton resetbutton = new JButton("取消删除");
		resetbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		resetbutton.setFont(new Font("宋体", Font.PLAIN, 14));
		resetbutton.setBounds(325, 292, 93, 40);
		add(resetbutton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(97, 85, 371, 207);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			
				int row = table.getSelectedRow();  //得到你�?�中的行
				textField.setText(table.getValueAt(row, 1)+"");   //得到指定行的第二�?,并将其放到文本框�?(下标�?0�?�?)
			}
		});
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"组号", "组名", "小组�?�?"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		this.fillTable(lqgroup);
	}
}
