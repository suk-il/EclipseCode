package com.bwf.onlineweb.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bwf.onlineweb.dao.IUserBaseDao;
import com.bwf.onlineweb.entity.UserBase;
import com.bwf.onlineweb.util.DBHelp;
import com.bwf.onlineweb.vo.ApplyedCourse;

public class UserBaseDao extends BaseDao implements IUserBaseDao {

	@Override
	public int save(UserBase userBase) {
		conn = DBHelp.getConn();
		sql = "insert into userbase(account,pwd,name,gender) values(?,?,?,?)";
		try {
			pcmd = conn.prepareStatement(sql);
			pcmd.setString(1, userBase.getAccount());
			pcmd.setString(2, userBase.getPwd());
			pcmd.setString(3, userBase.getName());
			pcmd.setString(4, userBase.getGender().getKey());

			return pcmd.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBHelp.closeConn(conn);
		}
		return 0;
	}

	@Override
	public UserBase findByAccount(String account) {
		conn = DBHelp.getConn();
		sql = "select * from userbase where account=?";
		try {
			pcmd = conn.prepareStatement(sql);
			pcmd.setString(1, account);
			rs = pcmd.executeQuery();

			if (rs.next()) {
				UserBase userBase = new UserBase();
				userBase.setAccount(account);
				userBase.setName(rs.getString("name"));

				return userBase;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			DBHelp.closeConn(conn);
		}

		return null;
	}

	@Override
	public UserBase findBy(String account, String pwd) {
		conn = DBHelp.getConn();
		sql = "select * from userbase where account=? and pwd=?";
		try {
			pcmd = conn.prepareStatement(sql);
			pcmd.setString(1, account);
			pcmd.setString(2, pwd);

			rs = pcmd.executeQuery();
			if (rs.next()) {
				UserBase userBase = new UserBase();
				userBase.setAccount(account);
				userBase.setName(rs.getString("name"));

				return userBase;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeConn(conn);
		}

		return null;
	}

	@Override
	public int saveMyCourse(String account, int courseId) {
		conn = DBHelp.getConn();
		sql = "insert into mycourse(account,cid,applydate) value(?,?,now())";
		try {
			pcmd = conn.prepareStatement(sql);
			pcmd.setString(1, account);
			pcmd.setInt(2, courseId);

			return pcmd.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<ApplyedCourse> findMyApplyed(String account) {

		List<ApplyedCourse> applyedCourseList=new ArrayList<ApplyedCourse>();
		
		conn = DBHelp.getConn();
		sql =  " SELECT a.id,b.name,a.applydate,a.flag ";
		sql += " FROM mycourse a ";
		sql += " LEFT JOIN course b ";
		sql+="ON a.cid=b.id";
		sql += " WHERE a.account=? ";

		try {
			System.out.println(account);
			pcmd = conn.prepareStatement(sql);
			pcmd.setString(1, account);
			rs=pcmd.executeQuery();
			while(rs.next()) {
				ApplyedCourse applyedCourse=new ApplyedCourse();
				applyedCourse.setApplyId(rs.getInt("id"));
				applyedCourse.setCourseName(rs.getString("name"));
				applyedCourse.setApplyDate(rs.getDate("applydate"));
				applyedCourse.setFlag(rs.getString("flag"));
			
				applyedCourseList.add(applyedCourse);
				
			}
			return applyedCourseList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return null;
}

}