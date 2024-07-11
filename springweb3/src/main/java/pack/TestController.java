package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/*
 * @RestController
 * @Controller + @ResponseBody
 * xml이나 json 반환
 * 
 */

/*
 * @Controller
 * 사용자의 요청을 처리한 후 지정된 뷰(템플릿 엔진 : jsp ...)에 모델 객체를 넘겨주는 역할
 */

/*
@RestController
public class TestController {

	@RequestMapping("test1") // method 구분 X
	public String abc() {
		
		return "요청에 대한 반응 보이기";
	}
	
}
*/

@Controller
public class TestController {

	@RequestMapping("test1") // method 구분 X
	public ModelAndView abc() {
		System.out.println("abc() 처리");
		//return null;
		
		//return new ModelAndView("list", "msg", "안녕? jsp");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");
		
		// request.setAttribute("msg", "안녕? jsp");
		// HttpServletRequest를 사용해 key, value로 jsp를 전송
		mav.addObject("msg", "안녕? jsp");
		return mav;
	}
	
	@RequestMapping(value="test2", method=RequestMethod.GET) // get 요청만 처리
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "성공2");
	}
	
	//@RequestMapping("test3")
	@GetMapping("test3") // get 요청 처리
	//@PostMapping("test3") // post 요청 처리
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "성공3");
	}
	
	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg", "성공4"); // request.setAttribute("msg", "성공4");
		return "list"; // view 파일명 반환
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST) // post 요청만 처리
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "성공5");
	}
	
	@PostMapping("test6")
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "성공6");
	}
	
	@PostMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg", "성공7");
		return "list";
	}
	
	//
	
	@GetMapping("test8")
	@ResponseBody
	public String abc8() {
		String value = "일반 데이터 - String, Map, JSON 등 전달 기능";
		return value; // jsp 파일 호출 X
	}
	
	@GetMapping("test8_1")
	@ResponseBody // 반환값은 JSON타입 (Jackson 라이브러리가 지원)
	public DataDto abc8_1() {
		DataDto dto = new DataDto();
		dto.setCode(10);
		dto.setName("톰");
		return dto;
	}
}


