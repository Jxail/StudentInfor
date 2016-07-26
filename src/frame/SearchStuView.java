package frame;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import table.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import business.businessImpl.StuManageImpl;
import jdbcDao.jdbcDaoImpl.Stu_OperationImpl;

public class SearchStuView extends JPanel {
	/*private JTextField serchStu_textField;
	private JPanel panel_select;*/
	private JTextField textField;
	private JTable table;
	
//---------------------填充表格的方�?---------------------------------
	public void fillTable(Student student){
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Vector v = new StuManageImpl().SerchStuImpl(student);
		dtm.setRowCount(0);
		for(int i=0;i<v.size();i++){
			dtm.addRow((Vector) v.get(i));
		}
	}
	
	public SearchStuView(){
		setBorder(new TitledBorder(null, "\u67E5\u8BE2\u5B66\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel serchStuID_Label = new JLabel("请输入您要查询的学生姓名：");
		serchStuID_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		serchStuID_Label.setBounds(10, 64, 182, 15);
		add(serchStuID_Label);
		
		textField = new JTextField();
		textField.setBounds(202, 61, 168, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel show_Label = new JLabel("您查询的学生信息如下：");
		show_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		show_Label.setBounds(10, 135, 168, 15);
		add(show_Label);
		
		JButton submit_button = new JButton("查询");
		submit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String serchStuName = textField.getText();
				Student student = new Student();
				student.setStuName(serchStuName);  //封装
				fillTable(student);
				
			}
		});
		submit_button.setFont(new Font("宋体", Font.PLAIN, 14));
		submit_button.setBounds(202, 92, 93, 34);
		add(submit_button);
		
		JButton return_button = new JButton("撤销");
		return_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
			}
		});
		return_button.setFont(new Font("宋体", Font.PLAIN, 14));
		return_button.setBounds(344, 92, 93, 34);
		add(return_button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 160, 485, 179);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u6240\u5C5E\u7EC4"
			}
		));
		scrollPane.setViewportView(table);
	
}
}