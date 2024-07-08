package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {
	public SangpumImpl(DataSource dataSource) {
		setDataSource(dataSource); // setDataSource - JdbcDaoSupport가 가지고 있음
		// 왜 setter로 안하고 생성자로?
		// DataSource가 넘어가야 DB와 연결될테니까 제일 먼저 호출되는 생성자에 주입!
	}
	
	/*
	@Override
	public ArrayList<SangpumDto> selectAll() { 
		RowMapper rowMapper = new SangpumRowMapper();
		return (ArrayList) getJdbcTemplate().query("select * from sangdata", rowMapper); 
	
	}
	*/
	
	@Override
	public ArrayList<SangpumDto> selectAll() {
		String sql = "select * from sangdata";
		ArrayList<SangpumDto> list = (ArrayList) getJdbcTemplate().query(sql, new SangpumRowMapper());
		return list;
	}
	
	// 내부 클래스(편의상 내부에서 선언)
	class SangpumRowMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;

		}
	}

}
