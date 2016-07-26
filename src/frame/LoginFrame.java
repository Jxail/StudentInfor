package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.businessImpl.LoginManageImpl;
import jdbcDao.Login_Operation;
import table.Admin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {
    
	private JPanel contentPane;
	private JTextField textField;
	static Connection conn = null;
	static PreparedStatement pres = null;
    String aName = null; 
    String aPwd = null;
    Login_Operation login;
    private JPasswordField passwordField;
//-------------------------------判断登陆条件----------------------------------	
    public void login(){
		aName = textField.getText();   //获取用户输入的用户名和密�?
	    aPwd = passwordField.getText(); 
		Admin admin = new Admin(aName,aPwd);  //调用Admin的构造方�?,封装用户名和密码
		boolean b = new LoginManageImpl().checkUser(admin);  //调用业务类中的checkuser方法判断用户输入的是否正�?
		if(b){JOptionPane.showMessageDialog(null, "恭喜你，登陆成功");
		 new MainFrameView();  //如果验证成功则跳转到主界�?
		}
		else JOptionPane.showMessageDialog(null, "对不起，你的用户名或密码错误，登陆失败！");
	}
  
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}		
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/student.png"));
		setTitle("欢迎来到学生信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 100, 380, 295);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(7, 7, 7, 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u64A4\u9500");
		btnNewButton.setIcon(new ImageIcon("images/reset.png"));
		btnNewButton.setFont(new Font("����", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton.setBounds(221, 188, 99, 36);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setIcon(new ImageIcon("images/login.png"));
		button.setFont(new Font("����", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
				  login();  
			}
		});
		button.setBounds(68, 188, 104, 36);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setBounds(177, 68, 143, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("用户姓名�?");
		lblNewLabel.setIcon(new ImageIcon("images/userName.png"));
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setBounds(64, 68, 93, 29);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("用户密码�?");
		label.setIcon(new ImageIcon("images/password.png"));
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(64, 125, 93, 29);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(177, 121, 143, 29);
		contentPane.add(passwordField);
	}
	
	
}
