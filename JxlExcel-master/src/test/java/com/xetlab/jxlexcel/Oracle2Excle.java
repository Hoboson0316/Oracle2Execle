package com.xetlab.jxlexcel;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.functors.IfClosure;

import com.xetlab.jxlexcel.conf.ExcelTemplate;
import com.xetlab.jxlexcel.conf.TitleRow;

public class Oracle2Excle implements Runnable {
	
	private String swjgdm;
	private String city;
	private ExcelCall call;
	
	public Oracle2Excle(String city,   ExcelCall call) {
		this.city = city;
		this.call=call;
	}
	public Oracle2Excle(String city, String swjgdm,   ExcelCall call) {
		this.swjgdm = swjgdm;
		this.city = city;
		this.call=call;
	}

	public Oracle2Excle(String city, String swjgdm ) {
		this.swjgdm = swjgdm;
		this.city = city;
	}
	@Override
	public void run() {
		try {
			List<sql2excleVo> lSql2excleVos = getDbLs();
			System.out.println("lSql2excleVos==" + lSql2excleVos.size());
			String[] titles = createTestTitles("标题", 7);
			List<Object[]> datas = createTestDatas(7, lSql2excleVos);
			if (!lSql2excleVos.isEmpty()) {
				File tmp = createTmpFile(this.city + "(" + this.swjgdm + ")" + ".xls");
				JxlExcelWriter jxlExcelWriter = new JxlExcelWriter(tmp);
				ExcelTemplate excelTemplate = new ExcelTemplate();
				excelTemplate.addTitleRow(new TitleRow(titles));
				jxlExcelWriter.setExcelTemplate(excelTemplate);
				jxlExcelWriter.writeArrays(datas);
				}
			this.call.exec();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	


	public  List<sql2excleVo> getDbLs() throws SQLException {
		// TODO Auto-generated method stub
		   Connection conn = null;
           conn = Dbutil.getConnection();
           // 创建预编译语句对象，一般都是用这个而不用Statement
           PreparedStatement pre = null;
           // 创建一个结果集对象
           ResultSet result = null;

        String sql;
 		if(null !=this.swjgdm ) {
 			sql = "select *\r\n" + 
 			 		"  from SJYY.SJ_DZZH_Test01 ff\r\n" + 
 			 		" where ff.precise = '1'\r\n" + 
 			 		"   and ff.zgswj_dm = '"+this.swjgdm+"'\r\n" + 	
 			 		"   and ff.city ='"+this.city+"'";
 		}else {
 			sql = "select *\r\n" + 
 			 		"  from SJYY.SJ_DZZH_Test01 ff\r\n" + 
 			 		" where ff.precise = '1'\r\n" + 
 			 		"   and ff.city ='"+this.city+"'";
 		}
    	
        System.out.println("sql==="+sql);
           pre = conn.prepareStatement(sql);// 实例化预编译语句
           result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
           List<sql2excleVo> lSql2excleVos = new ArrayList<sql2excleVo>();
           while (result.next()) {
        	   String dzzhuuid    =result.getString("DZZHUUID");   
        	   String lng         =result.getString("LNG");        
        	   String lat         =result.getString("LAT");        
        	   String address     =result.getString("ADDRESS");    
        	   String nsrid       =result.getString("NSRMC");      
        	   String czsj        =result.getString("CZSJ");       
        	   String yxbz        =result.getString("YXBZ");       
        	   String status      =result.getString("STATUS");     
        	   String precise     =result.getString("PRECISE");    
        	   String confidence  =result.getString("CONFIDENCE"); 
        	   String lev         =result.getString("LEV");        
        	   String city        =result.getString("CITY");       
        	   String insertdate  =result.getString("INSERTDATE"); 
        	   String address_1   =result.getString("ADDRESS_1");  
        	   String zgswj_dm    =result.getString("ZGSWJ_DM");

               lSql2excleVos.add(new sql2excleVo(dzzhuuid, lng, lat, address, nsrid, czsj, yxbz, status, precise, confidence, lev, city, insertdate, address_1, zgswj_dm));
           }
           System.out.println(lSql2excleVos.size()+"city==="+this.city+"("+this.swjgdm+")");
           return lSql2excleVos;
	}


	// 标题
	private String[] createTestTitles(String titlePrefix, int colSize) {
		String[] titles=new String[] {"dzzhuuid", "lat","lng", "zgswj_dm", "address", "address_1","nsrmc"};
		return titles;
	}

	// 数据
	private List<Object[]> createTestDatas(int colSize, List<sql2excleVo> lSql2excleVos) {
		List<Object[]> datas = new ArrayList<Object[]>();
		for (int i = 0; i < lSql2excleVos.size(); i++) {
			Object[] rowData = new Object[colSize];
			datas.add(rowData);
			for (int j = 0; j < colSize; j++) {
				switch (j) {
				case 0:
					rowData[j] = lSql2excleVos.get(i).getDzzhuuid();
					break;
				case 1:
					rowData[j] = lSql2excleVos.get(i).getLat();
					break;
				case 2:
					rowData[j] = lSql2excleVos.get(i).getLng();
					break;
				case 3:
					rowData[j] = lSql2excleVos.get(i).getZgswj_dm();
					break;
				case 4:
					rowData[j] = lSql2excleVos.get(i).getAddress();
					break;
				case 5:
					rowData[j] = lSql2excleVos.get(i).getAddress_1();
					break;
				case 6:
					rowData[j] = lSql2excleVos.get(i).getNsrid();
					break;
				default:
					break;
				}
			}
		}
		return datas;
	}

	// 创建Execle
	private File createTmpFile(String fileName ) throws IOException {
		File tmp = new File(fileName);
		if (tmp.exists()) {
			tmp.delete();
		}
			tmp.createNewFile();
		return tmp;
	}
}
