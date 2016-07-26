package frame;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.businessImpl.GroupManageImpl;
import business.businessImpl.StuManageImpl;
import table.LqGroup;
import table.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DelStuView extends JPanel {
	/*private JTextField delStuID_textField;*/
	public JPanel delStu_panel;
	private JTextField del_textField;
	private JTable table;
//----------------------填充表格-------------------------
	public void fillTable(){
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();  //获取表模�?
		Vector vec =new StuManageImpl().SerchStuImpl(new Student()); //获取组查询到的所有�??
		dtm.setRowCount(0);  //每次调用前清空前面查询的结果
		for(int i=0;i<vec.size();i++){
			dtm.addRow((Vector) vec.get(i)); //将遍历得到的查询结果添加到模型中
		}
	}
	public DelStuView(){
		setBorder(new TitledBorder(null, "\u5220\u9664\u5B66\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel delStuID_lebel = new JLabel("请输入您要删除学生的ID�?");
		delStuID_lebel.setFont(new Font("宋体", Font.PLAIN, 14));
		delStuID_lebel.setBounds(37, 48, 168, 15);
		add(delStuID_lebel);
		
		del_textField = new JTextField();
		del_textField.setBounds(206, 45, 261, 21);
		add(del_textField);
		del_textField.setColumns(10);
		
		JButton del_Button = new JButton("确定删除");
		del_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String delText =del_textField.getText();
				Student student = new Student();
				student.setStuName(delText);
				boolean db = new StuManageImpl().DelStuImpl(student);
				if(db==true){JOptionPane.showMessageDialog(null, "恭喜你，删除学生"+delText+"成功！");
				fillTable();  //当删除成功后更新表格信息
				}
				else JOptionPane.showMessageDialog(null, "sorry,你要删除的学生"+delText+"不存在！");
			}
		});
		del_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		del_Button.setBounds(155, 268, 93, 36);
		add(del_Button);
		
		JButton delBack_Button = new JButton("撤销删除");
		delBack_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				del_textField.setText("");
			}		
		});
		delBack_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		delBack_Button.setBounds(315, 268, 93, 36);
		add(delBack_Button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 92, 357, 166);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
//-------------------设置鼠标监听事件，当鼠标暗中�?条记录时的操�?-----------------		
			public void mousePressed(MouseEvent arg0) {
				int row = table.getSelectedRow();  //获取你�?�中的行
				del_textField.setText(table.getValueAt(row, 1)+"");    //把�?�中的行分组记录的名字添加到删除文本框中
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u6240\u5C5E\u7EC4"
			}
		));
		scrollPane.setViewportView(table);
		 this.fillTable();
	}
	   
}