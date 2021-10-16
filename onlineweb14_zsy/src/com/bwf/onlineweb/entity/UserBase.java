package com.bwf.onlineweb.entity;

import com.bwf.onlineweb.enums.Gender;

public class UserBase {
    //初始化基本信息；
	private int id;
	private String account;
	private String name;
	private Gender gender;
	private String pwd;
//	右击source选择getter and setter�?
//	然后select all，自动生成标准类
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		//返回当前对象的姓名（可以换成其他的，�?后控�?
//		在Test.java控制台上的输�?
		return this.name;
	}
	
	
	
}
