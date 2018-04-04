package com.rebue.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rebue.wheel.DbUtils;
import rebue.wheel.StrUtils;
import rebue.wheel.idworker.IdWorker3;

/**  
* 创建时间：2018年4月4日 上午10:00:37  
* 项目名称：arae-web-crawlers  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：AreaImpl.java  
* 类说明：  
*/
public class AreaImpl {

	public static void main(String[] args) throws SQLException {
		IdWorker3 idWorker3 = new IdWorker3();
		Connection msSqlConn = DbUtils.getMsSqlConn();
		String sql = "SELECT * FROM region_table ORDER BY code ASC";
		PreparedStatement statement = msSqlConn.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		long i = 0;
		while (rs.next()) {
			// 区域名称
			String areaName = rs.getString(1);
			// 区域编码
			String code = rs.getString(2);
			if (code.length() == 2) {
				String provinceName = areaName;
				// 自动补0
				String is = StrUtils.padLeft(String.valueOf(i++), 6, '0');
				String provinceSql = "INSERT INTO ARE_AREA(ID, AREA_CODE, AREA_NAME, IS_DIS) VALUES(" + idWorker3.getId() + ", '" + is + "', '" + provinceName + "', 0)";
				PreparedStatement statements = msSqlConn.prepareStatement(provinceSql);
				statements.executeUpdate();
				saveArticle(provinceSql + ";" + "\r\n");
				System.out.println(provinceSql);
				sql = "SELECT * FROM region_table WHERE code LIKE '" + code + "%' ORDER BY code ASC";
				statement = msSqlConn.prepareStatement(sql);
				ResultSet rss = statement.executeQuery();
				long j = 0;
				while (rss.next()) {
					// 城市名称
					String cityName = rss.getString(1);
					// 城市编码
					String cityCode = rss.getString(2);
					if (cityCode.length() == 4) {
						// 自动补0
						String js = StrUtils.padLeft(String.valueOf(j++), 3, '0');
						String ijs = is + js;
						String citySql = "INSERT INTO ARE_AREA(ID, AREA_CODE, AREA_NAME, IS_DIS) VALUES(" + idWorker3.getId() + ", '" + ijs + "', '" + cityName + "', 0)";
						PreparedStatement statementss = msSqlConn.prepareStatement(citySql);
						statementss.executeUpdate();
						saveArticle(citySql + ";" + "\r\n");
						System.err.println(citySql);
						sql = "SELECT * FROM region_table WHERE code LIKE '" + cityCode + "%' ORDER BY code ASC";
						statement = msSqlConn.prepareStatement(sql);
						ResultSet rsss = statement.executeQuery();
						long k = 0;
						while (rsss.next()) {
							// 区县名称
							String countyName = rsss.getString(1);
							// 区县编码
							String countyCode = rsss.getString(2);
							if (countyCode.length() == 6) {
								// 自动补0
								String ks = StrUtils.padLeft(String.valueOf(k++), 3, '0');
								String ijks = ijs + ks;
								String countySql = "INSERT INTO ARE_AREA(ID, AREA_CODE, AREA_NAME, IS_DIS) VALUES(" + idWorker3.getId() + ", '" + ijks + "', '" + countyName + "', 0)";
								PreparedStatement statementsss = msSqlConn.prepareStatement(countySql);
								statementsss.executeUpdate();
								saveArticle(countySql + ";" + "\r\n");
								System.err.println(countySql);
								sql = "SELECT * FROM region_table WHERE code LIKE '" + cityCode + "%' ORDER BY code ASC";
								statement = msSqlConn.prepareStatement(sql);
								ResultSet rssss = statement.executeQuery();
								long l = 0;
								while (rssss.next()) {
									// 街道镇名称
									String streetName = rssss.getString(1);
									// 街道镇编码
									String streetCode = rssss.getString(2);
									if (streetCode.length() > 6) {
										// 自动补0
										String ls = StrUtils.padLeft(String.valueOf(l++), 3, '0');
										String ijkls = ijks + ls;
										String streetSql = "INSERT INTO ARE_AREA(ID, AREA_CODE, AREA_NAME, IS_DIS) VALUES(" + idWorker3.getId() + ", '" + ijkls + "', '" + streetName + "', 0)";
										PreparedStatement statementssss = msSqlConn.prepareStatement(streetSql);
										statementssss.executeUpdate();
										saveArticle(streetSql + ";" + "\r\n");
										System.err.println(streetSql);
									}
								}
							}
						}
					}
				}
			}
			
		}
	}
	
	/**
	 * 保存文章到本地
	 * @param titile
	 * @param content
	 * @param blogName
	 */
	public static void saveArticle(String content) {
		String lujing = "d:\\行政区域信息.sql";// 保存到本地的路径和文件名
		File file = new File(lujing);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.flush();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
  

