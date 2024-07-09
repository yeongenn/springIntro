package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import pack.mybatis.SqlMapConfig;

@Repository
public class JikwonImpl implements JikwonInter {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();

	@Override
	public List<JikwonDto> selectJikwonAll() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			
			// Mybatis Annotation version
			SqlMapperInter mapperInter = 
					(SqlMapperInter) session.getMapper(SqlMapperInter.class);
			list = mapperInter.selectDataAll();
			
		} catch (Exception e) {
			System.out.println("selectJikwonAll err : " + e);
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}
	
	@Override
	public List<JikwonDto> countByBuser() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;
		
		try {			
			SqlMapperInter mapperInter = 
					(SqlMapperInter) session.getMapper(SqlMapperInter.class);
			list = mapperInter.countByBuser();
			
		} catch (Exception e) {
			System.out.println("countByBuser err : " + e);
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}
	
	@Override
	public List<JikwonDto> maxPayByBuser() {
		SqlSession session = factory.openSession();
		List<JikwonDto> list = null;
		
		try {
			SqlMapperInter mapperInter = 
					(SqlMapperInter) session.getMapper(SqlMapperInter.class);
			list = mapperInter.maxPayByBuser();
			
		} catch (Exception e) {
			System.out.println("maxPayByBuser err : " + e);
		} finally {
			if(session != null) session.close();
		}
		
		return list;
	}

}
