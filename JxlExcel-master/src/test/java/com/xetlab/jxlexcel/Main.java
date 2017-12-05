package com.xetlab.jxlexcel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) {
		    final String[] zgswjgdm=new String[] {"16101020000", "16101030000", "16101040000", "16101110000", "16101120000", "16101130000", "16101140000", "16101150000", "16101160000", "16101220000", "16101240000", "16101250000", "16101260000", "16101810000", "16101820000", "16101830000", "16101840000", "16101850000", "16101860000", "16101870000", "16101900000", "16101970000", "16101980000"}; 
			final String[] city=new String[] {"铜川市", "宝鸡市", "咸阳市", "渭南市", "延安市", "汉中市", "榆林市", "安康市", "商洛市", "西咸市", "杨凌市" };
			ExecutorService pool = Executors.newFixedThreadPool(zgswjgdm.length);  
/*		for (int i = 0; i < zgswjgdm.length; i++) {
			final String aa = zgswjgdm[i];
			pool.execute(new Oracle2Excle("西安市", zgswjgdm[i], new ExcelCall() {
				@Override
				public void exec() {
					System.out.println("我跑完了." + aa);
				}
			}));

		}*/
		
		for (int i = 0; i < city.length; i++) {
			final String aa = city[i];
			pool.execute(new Oracle2Excle(city[i], new ExcelCall() {
				@Override
				public void exec() {
					System.out.println("我跑完了." + aa);
				}
			}));

		}
	}
}
