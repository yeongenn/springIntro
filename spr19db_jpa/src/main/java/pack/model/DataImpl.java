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

		//
		System.out.println("전체 자료 읽기 ---");
		list = findAll(em, MemDto.class);
		for(MemDto m : list) {
			System.out.println(m.getNumber() + " "
								+ m.getName() + " "
								+ m.getAddr());
		}
		return list;
	}
	
	public<T> List<T> findAll(EntityManager em, Class<T> cls){
		// JPQL
		// 'e'는 테이블 별칭
		return em.createQuery("select e from " + 
								cls.getSimpleName() + 
								" e", cls).getResultList();
	}
}
