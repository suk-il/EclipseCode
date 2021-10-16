package com.bwf.onlineweb.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 注释编辑�?
 * @author admin
 *
 */
public class DBHelp {
    //为了防止外界实例化对�?
	private  DBHelp() {
		
	}
	//初始化这三个数据，外界不能访问修改
	private static String driveName;
	private static String url;
	private static String user;
	private static String password;
	//然后通过配置文件读取对应的信
	//采用静态方法，只要类被加载执行一次就可以
	static {
		
		try {
			//读取配置文件
			Properties pro=new Properties();
			pro.load(DBHelp.class.getResourceAsStream("db.config.properties"));
			
			//从配置文件中获取�?=”前面名字对应的�?
			driveName = pro.getProperty("driveName");
			url=pro.getProperty("url");
			user=pro.getProperty("user");
			password=pro.getProperty("password");
			
			Class.forName(driveName);
			
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		}catch (IOException e) {			
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 得到数据库连�?
	 * @return
	 */
	public static Connection getConn() {
		//连接 定义�?下，获取连接信息后最后返回连接�??
		Connection conn=null;
		//调用时如果走的�?�，就返回conn
		try {
			conn = DriverManager.getConnection(url,user,password);
			return conn;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	 //如果代码错误走不通try，那么就让它返回null
		return null;
	}
	
	
	/**
	 * 关闭数据库连�?
	 * @param conn
	 */
	//不需要返回�??
	public static void closeConn(Connection conn) {
		//如果连接不为空，那就尝试关闭
		if(conn!=null) {
			try {
				//如果没有关闭，那就使其关�?
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				//关闭后，让连接清�?
				conn=null;
			}
		}
	}
}
