package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;
import entity.Administrator;
import entity.Cadmini;

public class AdministratorDao {
	//查询单个学院管理员，Ano
		public Administrator getAdministrator(String ano) {
			Administrator admini = new Administrator();
			String sql = "select * from Administrator where Ano=\'"+ano+"\'";
			ResultSet rs = DBHelper.executeQuery(sql);
	        try{
	        	while (rs.next()) {
	        		admini.setAno(rs.getString(1));
	        		admini.setPwd(rs.getString(2));	
	        	}
	        } catch (Exception ex) {
				ex.printStackTrace();
			}
			DBHelper.closeConnection();
			return admini;
		}
}
