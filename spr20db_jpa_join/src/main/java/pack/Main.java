package pack;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Main {

	public static void main(String[] args) {
		// JOIN
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		
		try {
			// JPQL 사용 ----------------------------
			String jpql = "select j.jikwonNo, j.jikwonName, b.buserName, year(j.jikwonYear) " + 
							"from Jikwon j " +
							"join j.buser b"; // Jikwon Entity 멤버필드에 선언된 buser
			
			// Entity로 받지않고 Object[] 타입으로 받으면 함수 사용 가능
			
			// Hibernate: /* select j.jikwonNo, j.jikwonName, b.buserName, j.jikwonYear from Jikwon j join j.buser b */ 
			// select jikwon0_.jikwon_no as col_0_0_, jikwon0_.jikwon_name as col_1_0_, 
			// 			buser1_.buser_name as col_2_0_, jikwon0_.jikwon_ibsail as col_3_0_ 
			// 			from Jikwon jikwon0_ 
			// 			inner join Buser buser1_ 
			// 			on jikwon0_.buser_num=buser1_.buser_no
			
			TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
			List<Object[]> list = query.getResultList();
			
			for(Object[] o : list) {
				//int year = getYear((Date) o[3]);
				System.out.println(o[0] + " " 
									+ o[1] + " " 
									+ o[2] + " " 
									+ o[3]); // 칼럼명 쓰고 싶으면 클래스 따로 만들어야
			}
			
			// Native SQL 사용 ------------------------
			// RDB에 따라 문법이 살짝 다르다 -> 변경사항이 발생할 경우 귀찮아진다
			String sql = "select " +
							"jikwon_no, jikwon_name, buser_name, year(jikwon_ibsail) " +
							"from jikwon " +
							"join buser " +
							"on buser_num = buser_no";
			Query query2 = em.createNativeQuery(sql);
			List<Object[]> list2 = query2.getResultList();
			
			for(Object[] o : list2) {
				System.out.println(o[0] + " " 
									+ o[1] + " " 
									+ o[2] + " " 
									+ o[3]); 
			}
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		} finally {
			em.close();
			emf.close();
		}

	}
	
	// JPQL 입사년도 추출용
	private static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance(); // singleton
		calendar.setTime(date);
		
		return calendar.get(Calendar.YEAR);
	}

}
