package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.model.GogekImpl.JikwonMapper;

@Repository
public class GogekImpl extends JdbcDaoSupport implements GogekInter {
	@Autowired
	private DataSource dataSource;	

	@PostConstruct
	public void postConstruct() {
		setDataSource(dataSource);
	}

	@Override
	public List<GogekDto> jikwonInCharge(String gogekNum, String gogekName) {
		RowMapper rowMapper = new JikwonMapper();
		
		String sql = "select jikwon_name, jikwon_jik, jikwon_gen "
						+ "from jikwon inner join gogek on gogek_damsano = jikwon_no";
		
		// 
		/*
		if(gogekNum == null && gogekName == null) {
			return null;
		}
		*/
		
		sql += " where gogek_no = " + gogekNum + " and gogek_name = '" + gogekName + "'";
	

		return getJdbcTemplate().query(sql, rowMapper);

	}

	
	class JikwonMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new GogekDto() { // 내부 무명클래스~
				{
					setJikwon_name(rs.getString("jikwon_name"));
					setJikwon_jik(rs.getString("jikwon_jik"));
					setJikwon_gen(rs.getString("jikwon_gen"));
				}
			};
		}
	}
}
