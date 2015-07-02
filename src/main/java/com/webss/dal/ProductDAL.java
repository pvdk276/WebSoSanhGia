package com.webss.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProductDAL {

	/**
	 * 
	 * @param productName
	 * @param productStore
	 * @param productStoreUrl
	 * @param productImage
	 * @return
	 * @throws SQLException
	 */
	public int insertProduct(String productName,String productStore,String productStoreUrl, String productImage ) throws SQLException{
		ConnectDB connectdb = new ConnectDB();
		Connection conn = connectdb.openConnect();
		CallableStatement call=conn.prepareCall("{call product_insert(?,?,?,?)}");
		
		call.setString("productName",productName);
		call.setString("productStore", productStore);
		call.setString("productStoreUrl", productStoreUrl);
		call.setString("productImage", productImage);
		
		int result = call.executeUpdate();
		connectdb.closeConnect();
		return result;
	}
}