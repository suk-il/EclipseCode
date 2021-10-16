package com.bwf.onlineweb.util;

import com.bwf.onlineweb.entity.UserBase;

public class ShareData {
     
	private  ShareData() {
		
	}
	//会话用户，防止被实例化，直接私有
	public static UserBase sessionUserBase=null;
}
