package com.bwf.onlineweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 创建这个基类，把�?有的定义都放在这�?
 * @author admin
 *
 */
public class BaseDao {

	/**
	 * 原来是private私有的，子类不能继承父类的私有量
	 * 故换成受保护的protected，只有子类能放问
	 */
	protected Connection conn;
	protected String sql;
	protected PreparedStatement pcmd;
	//结果�?
	protected ResultSet rs;
}
