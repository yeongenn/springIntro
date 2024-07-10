package pack.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

@Repository
public class DataImpl implements DataInterface {

	
	@Override
	public List<MemDto> selectDataAll() {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("hello"); // DB 연결 정보 넘기기
				// createEntityManagerFactory(String persistenceUnitName)
				// persistenceUnitName : persistence.xml에서 <persistence-unit name="hello"> name으로 선언
		
		EntityManager em = emf.createEntityManager(); // entity의 생명주기를 관리, CRUD를 수행
		EntityTransaction tx = em.getTransaction(); // transaction 관리하는 인터페이스
		
		
		List<MemDto> list = null;
		
		try {
			// 데이터 추가
			// insert, update, delete 작업은 transaction 처리 하기
//			tx.begin(); 
//			MemDto dto1 = new MemDto();
//			dto1.setNumber(4);
//			dto1.setName("고길동");
//			dto1.setAddr("서초구 방배동");
//			em.persist(dto1); // insert
//			// Hibernate : /* insert pack.model.MemDto */ 
//			// 실제 수행되는 쿼리문 : insert into mem (addr, name, num) values (?, ?, ?)
//			tx.commit();

			
			// 자료 수정
//			tx.begin();
//			MemDto dto2 = em.find(MemDto.class, 4);
//			dto2.setName("신길동");
//			// Hibernate: /* update pack.model.MemDto */ 
//			// 실제 쿼리문 : update mem set addr=?, name=? where num=?
//			tx.commit();
			
			// 자료 삭제
//			tx.begin();
//			MemDto dto3 = em.find(MemDto.class, 4);
//			em.remove(dto3);
//			tx.commit();
//			// Hibernate: /* delete pack.model.MemDto */ 
//			// delete from mem where num=?
						
			
			System.out.println("부분 자료 읽기(단일 entity : find() 사용) ---");
			// find(Class<T> entityClass, Object primaryKey);
			MemDto memDto = em.find(MemDto.class, 1); // 
			System.out.println(memDto.getNumber() + " "
					+ memDto.getName() + " "
					+ memDto.getAddr());
			
			System.out.println("전체 자료 읽기 (JPQL 사용) ---");
			
			/*
		list = findAll(em, MemDto.class); // 메서드 만들어서 가져와도 되고
		for(MemDto m : list) {
			System.out.println(m.getNumber() + " "
								+ m.getName() + " "
								+ m.getAddr());
		}
			 */
			
			list = em.createQuery("select m from MemDto m", MemDto.class)
					.getResultList(); // 이렇게 바로 적어줘도 된다
			
			/*
		select m from MemDto m <- RDBMS에 상관없이 공통적
		위 쿼리문을 Hibernate가 DB dialect를 확인하고 DB에 맞게 쿼리문을 변환 ->
		select memdto0_.num as num1_0_, memdto0_.addr as addr2_0_, memdto0_.name as name3_0_ from mem memdto0_
			 */
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}
	
		
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cls){
		// JPQL
		// 'e'는 테이블 별칭
		// 반환타입이 명확한 경우 TypeQuery
		// TypedQuery<MemDto> tquery = em.createQuery("[sql문]", [반환타입(클래스명).class]);
		// 그렇지 않으면 Query
		// Query<MemDto> query = em.createQuery("[sql문]");
		return em.createQuery("select m from " + 
								cls.getSimpleName() + 
								" m", cls).getResultList();
		

		
	}
}
