/*================================================
	OracleDAO.java
	- DAO 역할
	- MssqlDAO와 설정만 다르게 연결하도록 구성
================================================*/


package com.test.spr;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OracleDAO
{
	public List<MemberDTO> list() throws SQLException, ClassNotFoundException
	{
		List<MemberDTO> result = new ArrayList<MemberDTO>();
		
		// 데이터베이스 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@211.238.142.168:1521:xe","scott","tiger");
		
		// 쿼리문 준비 및 실행(select)
		String sql = "SELECT ID, PW, NAME, TEL, EMAIL FROM TBL_MEMBERLIST ORDER BY ID";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setId(rs.getString("ID"));
			dto.setName(rs.getString("NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setEmail(rs.getString("EMAIL"));
			
			result.add(dto);
		}
		
		rs.close();
		stmt.close();
		
		// 데이터베이스 연결 종료
		if (!conn.isClosed())
			conn.close();
		
		return result;
	}
}
