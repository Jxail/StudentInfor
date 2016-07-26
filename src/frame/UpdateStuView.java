package frame;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.businessImpl.GroupManageImpl;
import business.businessImpl.StuManageImpl;
import myUtil.StringUtil;
import table.LqGroup;
import table.Student;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateStuView extends JPanel {
	private JPanel updStu_panel;
	private JTextField updIDtextField;
	private JTextField updName_text;
	private JTextField updAge_text;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JComboBox comboBox = new JComboBox();
	private JTable table;
	Student student = new Student();  //初始化
//------填充下拉列表信息-------------------------------------------------------	
	private void fillCombobox(){
		Vector vec = new GroupManageImpl().serchGroupImpl(new LqGroup());  //获取查询分组的结�?
		for(int i=0;i<vec.size();i++){
			Vector v = (Vector)vec.get(i);
			int gID = (int) v.get(0);
			String gName = (String) v.get(1);
			String gDesc = (String) v.get(2);
			LqGroup lqgroup = new LqGroup(gID,gName,gDesc);   //将查询到的信息封�?
			comboBox.addItem(lqgroup);
		}
	}
     public void fillTable(Student student){
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		Vector vec = new StuManageImpl().SerchStuImpl(student);
		dtm.setRowCount(0);
		for(int i=0;i<vec.size();i++){
			dtm.addRow((Vector) vec.get(i));
		}
	 }
	public UpdateStuView(){
		setBorder(new TitledBorder(null, "\u66F4\u65B0\u5B66\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel updStuID_label = new JLabel("学号：");
		updStuID_label.setFont(new Font("宋体", Font.PLAIN, 14));
		updStuID_label.setBounds(37, 58, 62, 15);
		add(updStuID_label);
		
		updIDtextField = new JTextField();
		updIDtextField.setBounds(102, 55, 161, 21);
		add(updIDtextField);
		updIDtextField.setColumns(10);
		
		JLabel updedStuName_Label = new JLabel("姓名：");
		updedStuName_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		updedStuName_Label.setBounds(296, 58, 62, 15);
		add(updedStuName_Label);
		
		updName_text = new JTextField();
		updName_text.setBounds(349, 55, 162, 21);
		add(updName_text);
		updName_text.setColumns(10);
		

		JLabel lblNewLabel = new JLabel("姓别：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(554, 58, 49, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("年龄：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(37, 104, 62, 15);
		add(lblNewLabel_1);
		
		updAge_text = new JTextField();
		updAge_text.setBounds(102, 101, 162, 21);
		add(updAge_text);
		updAge_text.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("所属组：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(296, 104, 131, 15);
		add(lblNewLabel_2);
		
		final JRadioButton boy_button = new JRadioButton("男");
		boy_button.setSelected(true);
		buttonGroup.add(boy_button);
		boy_button.setFont(new Font("宋体", Font.PLAIN, 14));
		boy_button.setBounds(609, 54, 49, 23);
		add(boy_button);
		
		JRadioButton girl_Button = new JRadioButton("女");
		buttonGroup.add(girl_Button);
		girl_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		girl_Button.setBounds(663, 54, 68, 23);
		add(girl_Button);
		
		
		comboBox.setBounds(349, 97, 162, 28);
		add(comboBox);
		JButton updStu_Button = new JButton("确认修改");
		updStu_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String updStuID  = updIDtextField.getText();
				String updedStuName = updName_text.getText();
				String updedStuSex  = boy_button.isSelected()?"男":"女";
				LqGroup selectedGroup =  (LqGroup) comboBox.getSelectedItem();  //获取在�?�中时存放到comboBox中的整条学生记录
				int updedStuGroup= selectedGroup.getgID();  //获取那条记录中的学生分组ID
				int updedStuAge  = Integer.parseInt(updAge_text.getText()); 
				if(StringUtil.isEmpty(updStuID)){
					JOptionPane.showMessageDialog(null, "学生ID不能为空！！");
					return;
				}
				if(!(StringUtil.isNotEmpty(updedStuName))){
					JOptionPane.showMessageDialog(null, "学生姓名不能为空！！");
					return;
				}	
				if(comboBox.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null , "该选项项无效，请选择下列具体分组！");
					return;
				}
				Student student = new Student(Integer.parseInt(updStuID),updedStuName,updedStuSex,updedStuAge,updedStuGroup);
				boolean ub = new StuManageImpl().UpdateStuImpl(student);
				if(ub==true){JOptionPane.showMessageDialog(null, "恭喜你，更改学生"+updStuID+"的信息成功！");
				updIDtextField.setText("");
				boy_button.setSelected(true);
				updAge_text.setText("");
				updName_text.setText("");
				comboBox.setSelectedItem(0);
				}
				else JOptionPane.showMessageDialog(null, "sorry，更改学生"+updStuID+"的信息失败！");
			}
		});
		updStu_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		updStu_Button.setBounds(170, 309, 93, 39);
		add(updStu_Button);
		
		JButton updback_Button = new JButton("撤销修改");
		updback_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updIDtextField.setText("");
				boy_button.setSelected(true);
				updAge_text.setText("");
				updName_text.setText("");
				comboBox.setSelectedItem(0);
			}
		});
		updback_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		updback_Button.setBounds(388, 309, 93, 39);
		add(updback_Button);
		
	   comboBox.addItem(new LqGroup(-1,"请在以下分组选择...",null));
	   
	   JScrollPane scrollPane = new JScrollPane();
	   scrollPane.setBounds(116, 132, 410, 167);
	   add(scrollPane);
	   
	   table = new JTable();
	   table.addMouseListener(new MouseAdapter() {
	   	@Override
	   	public void mousePressed(MouseEvent arg0) {
	   		int row = table.getSelectedRow();  //获取选选中的行
	   		String StuID = table.getValueAt(row, 0)+"";
	   		String stuName = table.getValueAt(row, 1)+"";
	   		String stuAge = table.getValueAt(row, 3)+"";
	   		String stuSex = table.getValueAt(row, 2)+"";
	   		if("男".equals(stuSex)) boy_button.setSelected(true);
	   		else girl_Button.setSelected(true);
	   		String stuGroup = table.getValueAt(row, 4)+"";
	   		
	   		updIDtextField.setText(StuID);
	   		updName_text.setText(stuName);
			updAge_text.setText(stuAge);
		
			//使用setSelectedIndex，找到gname对应的索引值
	        int count = comboBox.getItemCount();
			int index = -1;
			for(int i = 0 ;i < count ; i++)
			{
				LqGroup lqgroup = (LqGroup) comboBox.getItemAt(i);
				String gName = lqgroup.getgName();
				if(gName.equals(stuGroup)) index = i;
			}
			comboBox.setSelectedIndex(index);
	   		
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
	   this.fillCombobox();   //调用fillCombobox方法初始化下拉菜单列�?
	   this.fillTable(student);
}
}