package com.webss.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceDAL {
	public ResultSet getPriceById(int id) throws SQLException{
		ConnectDB connectdb = new ConnectDB();
		Connection conn = connectdb.openConnect();
		CallableStatement call=conn.prepareCall("{call getPriceById(?)}");
		
		call.setInt("id",id);
		
		ResultSet result = call.executeQuery();
		//connectdb.closeConnect();
		return result;
	}
}
