package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import dbuilt.DBHelper;
import entity.Cadmini;

public class CadminiDao {
	//新增
	public void addCadmini(String cano,String pwd,String caname,String cno) {
		String sql = "insert into Cadmini values (?,?,?,?)";
		DBHelper.executeUpdate(sql,cano,pwd,caname,cno);
	}
	//查询全部学院管理员
	public ArrayList<Cadmini> getAllCadminis (){
		ArrayList<Cadmini> list = new ArrayList<Cadmini>();
		String sql = "select * from Cadmini ";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		Cadmini admini = new Cadmini();
        		admini.setCAno(rs.getString(1));
        		admini.setPwd(rs.getString(2));
        		admini.setCaname(rs.getString(3));
        		admini.setCno(rs.getInt(4));
				list.add(admini);
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return list;
	} 
	//查询单个学院管理员，CAno
	public Cadmini getCadmini(String cano) {
		Cadmini admini = new Cadmini();
		String sql = "select * from Cadmini where CAno=\'"+cano+"\'";
		ResultSet rs = DBHelper.executeQuery(sql);
        try{
        	while (rs.next()) {
        		admini.setCAno(rs.getString(1));
        		admini.setPwd(rs.getString(2));
        		admini.setCaname(rs.getString(3));
        		admini.setCno(rs.getInt(4));
        	}
        } catch (Exception ex) {
			ex.printStackTrace();
		}
		DBHelper.closeConnection();
		return admini;
	}
	//更改信息
		public void update(String cano,String pwd,String caname,String cno) {
			String sql = "update cadmini set pwd=?,CAname=?,Cno=? where CAno=?";
			DBHelper.executeUpdate(sql,pwd,caname,cno,cano);
		}
	//更改密码
	public void updatePWD(String cano,String pwd) {
		String sql = "update cadmini set pwd=? where CAno=?";
		DBHelper.executeUpdate(sql,pwd,cano);
	}
	//删除
	public void delete(String cano) {
		String sql = "delete from cadmini where CAno=?";
		DBHelper. executeUpdate(sql,cano);
	}
}
