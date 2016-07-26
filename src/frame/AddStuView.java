package frame;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.businessImpl.GroupManageImpl;
import business.businessImpl.StuManageImpl;
import jdbcDao.jdbcDaoImpl.Group_OperationImpl;
import myUtil.StringUtil;
import table.LqGroup;
import table.Student;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;

public class AddStuView extends JPanel {
	private JPanel addStu_panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JComboBox comboBox = new JComboBox();
//------------------------填充下拉菜单的方�?-------------------------------	
	private void fillComboBox(){

		Vector vec = new GroupManageImpl().serchGroupImpl(new LqGroup());  //获取查询分组的结�?
		for(int i=0;i<vec.size();i++){
			Vector v = (Vector)vec.get(i);  
			int gID = (int) v.get(0);    //获取第一条记�?
			String gName = (String) v.get(1);
			String gDesc = (String) v.get(2);
			LqGroup lqgroup = new LqGroup(gID,gName,gDesc);   //将查询到的信息封�?
			comboBox.addItem(lqgroup);
		}
	}	
	public AddStuView(){
		setBorder(new TitledBorder(null, "\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(null);
		
		JLabel addStuID_Label = new JLabel("学生学号：");
		addStuID_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		addStuID_Label.setBounds(150, 62, 93, 21);
		add(addStuID_Label);
		
		JLabel addStuName_Label = new JLabel("学生姓名：");
		addStuName_Label.setFont(new Font("宋体", Font.PLAIN, 14));
		addStuName_Label.setBounds(150, 93, 93, 30);
		add(addStuName_Label);
		
		textField = new JTextField();
		textField.setBounds(274, 62, 224, 21);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 98, 224, 21);
		add(textField_1);
		textField_1.setColumns(10);
		JLabel lblNewLabel = new JLabel("学生性别：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(150, 135, 93, 31);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("学生年龄：");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(150, 176, 93, 30);
		add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(274, 176, 224, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("学生所属组：");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(150, 219, 93, 15);
		add(lblNewLabel_2);
		
		final JRadioButton boy_Button = new JRadioButton("男");
		buttonGroup.add(boy_Button);  //�?定要记住把男女单选按钮添加到同一个按钮组中去
		boy_Button.setSelected(true);
		boy_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		boy_Button.setBounds(315, 133, 78, 35);
		add(boy_Button);
		
		JRadioButton girl_Button = new JRadioButton("女");
		buttonGroup.add(girl_Button);
		girl_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		girl_Button.setBounds(395, 133, 78, 35);
		add(girl_Button);

		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"请选择以下分组..."}));
		comboBox.setBounds(274, 216, 229, 21);
		add(comboBox);
		
		JButton sureAdd_Button = new JButton("确认添加");
		sureAdd_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	//			fillComboBox(lqgroup);
			    String addStuID = textField.getText();
				String addStuName = textField_1.getText();
				LqGroup selectedGroup = (LqGroup) comboBox.getSelectedItem();  //获取下拉框中的�?�并封装到selectedGroup中去
				int addStuGroup =selectedGroup.getgID();
//				String addstuGroup =selectedGroup.getgName();
				String addStuSex = boy_Button.isSelected()?"男":"女";  //获取单�?�按钮�?�择的�?�项
				int addStuAge = Integer.parseInt(textField_3.getText());
				
				if(StringUtil.isEmpty(addStuID)){
					JOptionPane.showMessageDialog(null, "学生ID不能为空！！");
					return;
				}
				if(!(StringUtil.isNotEmpty(addStuName))){
					JOptionPane.showMessageDialog(null, "学生姓名不能为空！！");
					return;
				}	
				if(comboBox.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null , "该选项无效，请选择下列具体分组！");
					return;
				}
				//将从界面获取的学生ID和学生姓名封装到学生类的对象�?
				Student student = new Student(Integer.parseInt(addStuID),addStuName,addStuSex,addStuAge,addStuGroup);
				boolean b = new StuManageImpl().AddStuImpl(student);  //调用StuManageImpl方法判断是否添加成功
			    if(b==true){
			    	JOptionPane.showMessageDialog(null , "恭喜你，添加学生"+addStuName+"成功！");
			    }
			    else{
			    	JOptionPane.showMessageDialog(null , "sorry，添加学生"+addStuName+"失败!");
			    }
			}
		});
		sureAdd_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		sureAdd_Button.setBounds(202, 262, 93, 39);
		add(sureAdd_Button);
		
		JButton addback_Button = new JButton("撤销添加");
		addback_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_3.setText("");
				boy_Button.setSelected(true);  //默认选中�?
				comboBox.setSelectedIndex(0);	
			}
		});
		addback_Button.setFont(new Font("宋体", Font.PLAIN, 14));
		addback_Button.setBounds(405, 262, 93, 39);
		add(addback_Button);
//-------------调用方法填充下拉菜单-----------------------------		
		comboBox.addItem(new LqGroup(-1,"请选择以下分组...",null));
		this.fillComboBox();
	    
}

}