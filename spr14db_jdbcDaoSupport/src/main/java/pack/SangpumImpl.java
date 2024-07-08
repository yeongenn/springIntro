package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


// 어노테이션 사용 X 

// JdbcDaoSupport
// 스프링 프레임워크에서 제공하는 추상 클래스
// DB와 상호 작용하는 DAO 개발할 때 편리한 기능을 제공
// 이 클래스는 JdbcTemplate 사용하여 DB 작업을 처리,
// 템플릿 메서드 패턴을 활용하여 일반적인 데이터 엑세스 작업을 구현한다

// JdbcDaoSupport의 멤버 메서드 중 
// getJdbcTemplate() 와 setDataSource()가 있다
// setDataSource() 통해 DB 연결정보 넘겨줘야
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter {

	@Override
	public ArrayList<SangpumDto> selectAll() { // List로 반환, ArrayList 쓸려면 캐스팅 해야한다
		RowMapper rowMapper = new SangpumRowMapper();
		return (ArrayList) getJdbcTemplate().query("select * from sangdata", rowMapper); 
		// JdbcTemplate : JdbcDaoSupport가 가지고 있음, JdbcTemplate 클래스는 쿼리를 가지고 있다
		// 이걸 사용하면 PreparedStatement, ResultSet 안 써도 된다
	}
	
	// 내부 클래스(편의상 내부에서 선언)
	class SangpumRowMapper implements RowMapper{
		
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// (내부적으로 수행된) PreparedStatement에 의해 select의 실행 결과가 mapRow로 전달된다
			// pstmt, rs.next() 쓸 필요 X, 알아서 해준단다
			System.out.println("rowNum : " + rowNum); // 
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
			
			// rowMapper에 의해 dto가 레코드 자료가 소진될 때까지 계속해서 List 컬렉션에 저장된다
			// (내부에서) rs.close()를 만나면 return dto, 이때 타입은 List 타입 (select * ...)
			// 나는 ArrayList 타입으로 처리하고 싶으니까 타입 캐스팅~
		}
	}

}
