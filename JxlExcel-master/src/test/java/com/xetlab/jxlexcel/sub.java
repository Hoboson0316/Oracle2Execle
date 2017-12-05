package com.xetlab.jxlexcel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sub {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		conn = Dbutil.getConnection();
		PreparedStatement pre = null;
		ResultSet result = null;
		String sql = "select ff.address,ff.address_1,ff.dzzhuuid\r\n" + 
				"  from SJYY.SJ_DZZH_Test01 ff where ff.status='2'";
		
		
		System.out.println("sql===" + sql);
		pre = conn.prepareStatement(sql);// 实例化预编译语句
		result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
		while (result.next()) {
			String ADDRESS = result.getString("ADDRESS");
			String ADDRESS_1 = result.getString("ADDRESS_1");
			String DZZHUUID = result.getString("DZZHUUID");
			String dizhi01;
			String dizhi02;
			if(ADDRESS.getBytes().length>84) {
				 dizhi01=getAddress(ADDRESS);
			}else {
				 dizhi01=ADDRESS;
			}
			if(ADDRESS_1.getBytes().length>84) {
				 dizhi02=getAddress(ADDRESS_1);
			}else {
				 dizhi02=ADDRESS_1;
			}
			//System.out.println("处理前01======"+ADDRESS);
			System.out.println("处理后01======"+dizhi01);
			
			//System.out.println("处理前02======"+ADDRESS_1);
			System.out.println("处理后02======"+dizhi02);
			String updatSql="update  SJYY.SJ_DZZH_Test01 ff set ff.address='"+dizhi01+"', ff.address_1='"+dizhi02+"' where ff.dzzhuuid='"+DZZHUUID+"'";
			pre = conn.prepareStatement(updatSql);// 实例化预编译语句
			pre.executeUpdate(updatSql);// 执行查询，注意括号中不需要再加参数
		}
		

		

	}
	
public static String getAddress(String  add) {

	String dz1 = null;
	for (int i = 0; i < add.length(); i++) {
		int s = add.substring(0, i).getBytes().length;
		if (s > 84) {
			dz1= add.substring(0, i - 1);
			return dz1;
		}
	}
	return dz1;
}
	


}
