package myUtil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnJdbc {
	/*private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "Jdbc:oracle:" + "thin:@119.29.236.232:1521:orcl";
	private final static String USER= "Scott"; // 用户�?
	private final static String PWD = "123456"; // 用户密码
	*/
	private static Properties prop = new Properties();
	private static Connection conn= null;   // 创建�?个数据库连接
	
    static{ 
    	try {
//    		Class.forName(DRIVER);
    		FileInputStream file = new FileInputStream("jdbc.prop");
    		prop.load(file);  
            file.close();
			Class.forName(prop.getProperty("DRIVER"));//Driver就相当于�?个人�?
		} catch (Exception e) {
			// TODO 自动生成�? catch �?
			e.printStackTrace();
		}// 加载Oracle驱动,放在静�?�块中加载快
	}	
	  
    public static Connection getConnJdbc() {
		 
		try {	
			
//			conn = DriverManager.getConnection(URL,USER,PWD);
			conn = DriverManager.getConnection(
					prop.getProperty("URL"),  //通过键�?�实现索�?
					prop.getProperty("USER"),
					prop.getProperty("PWD") // 获取连接
			    );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}

