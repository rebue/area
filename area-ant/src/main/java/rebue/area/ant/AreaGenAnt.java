package rebue.area.ant;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import rebue.wheel.DbUtils;
/**
 * 生成antdesign地区级联数据
 * @author jjl
 *
 */
public class AreaGenAnt {
	public static void main(String[] args) {
		try {
			Connection mySqlConn = (Connection) DbUtils.getMySqlConn();
			String sql = "SELECT * FROM area.ARE_AREA where length(AREA_CODE)<=6";
			PreparedStatement statement = (PreparedStatement) mySqlConn.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
//			String str = "";
			while (rs.next()) {
				String str = "";
				str += "{";
				String areaName = rs.getString("AREA_NAME");
				str += "value:'" + areaName + "',label:'" + areaName + "',";
				String areaCode = rs.getString("AREA_CODE");
				String sql1 = "SELECT * FROM area.ARE_AREA WHERE AREA_CODE LIKE '" + areaCode
						+ "%' AND length(AREA_CODE)=9";
				PreparedStatement statement1 = (PreparedStatement) mySqlConn.prepareStatement(sql1);
				ResultSet rs1 = statement1.executeQuery();
				str += "children:[";
				while (rs1.next()) {
					str += "{";
					String areaName1 = rs1.getString("AREA_NAME");
					str += "value:'" + areaName1 + "',label:'" + areaName1 + "',";
					String areaCode1 = rs1.getString("AREA_CODE");
					String sql2 = "SELECT * FROM area.ARE_AREA WHERE AREA_CODE LIKE '" + areaCode1
							+ "%' AND length(AREA_CODE)=12";
					PreparedStatement statement2 = (PreparedStatement) mySqlConn.prepareStatement(sql2);
					ResultSet rs2 = statement2.executeQuery();
					str += "children:[";
					while(rs2.next()) {
						str += "{";
						String areaName2 = rs2.getString("AREA_NAME");
						str += "value:'" + areaName2 + "',label:'" + areaName2 + "'},";
					}
					str +="]},";
				}
				str +="]},";
				System.out.println(str.toString());
			}
			
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (mySqlConn != null) {
				try {
					mySqlConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
