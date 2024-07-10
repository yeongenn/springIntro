package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl implements JikwonInterface {

	@Override
	public List<Jikwon> selectAll() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("hello"); // DB 연결 정보 넘기기
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction(); 
		
		List<Jikwon> jlist = null;
		
		try {
			//https://stackoverflow.com/questions/10807496/error-cannot-create-typedquery-for-query-with-more-than-one-return
			/*
			jlist = em.createQuery("select j.num, j.name, " +
						"case when j.buserNum = 10 then '총무부' " +
						"else '~~부' end, j.ibsaYear " +
						"from Jikwon j", Jikwon.class)
						.getResultList();
			case when 조건문 되는지 확인하려고 쿼리문 넣었더니
			Cannot create TypedQuery for query with more than one return using requested result type 에러
			쿼리문 조회 결과값을 TypedQuery로 받으려면 select j.num, j.name ... 특정 칼럼명 넣는게 아니라
			select j from Jikwon j <- 이런 식으로 엔티티 전체를 조회해야 한단다
			특정 칼럼명 조회하고 싶으면 반환 타입을 Object[]로 선언하고 값을 받아서 그걸 다시 Entity(혹은 DTO?)에 담으면 된다는데
			그저 어렵네;;;
			*/
		
			
			jlist = em.createQuery("select j from Jikwon j", Jikwon.class)
					.getResultList();
		} catch (Exception e) {
			//tx.rollback();
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}
		
		return jlist;
	}

	@Override
	public List<Object[]> countByBuser() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction tx = em.getTransaction(); 
		
		List<Object[]> olist = null;
		
		try {
			// 물리테이블 칼럼명 buser_num으로 하면 에러
			String jpql = "select j.buserNum, count(j) from Jikwon j group by j.buserNum";
			olist = em.createQuery(jpql, Object[].class).getResultList(); 
		} catch (Exception e) {
			//tx.rollback();
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}
		
		return olist;
	}
	
}
