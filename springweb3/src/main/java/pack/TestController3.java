package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController3 {
	
	@RequestMapping("/java/korea")
	public String ghi(Model model) {
		model.addAttribute("msg", "/java/korea 요청 성공~");
		return "list";
	}
	
	@GetMapping(value={"/java/good", "/java/nice", "/java/ok"}) // 배열
	public String ghi2(Model model) {
		model.addAttribute("msg", "여러개의 요청이 하나의 메서드와 맵핑");
		return "list";
	}
	
}
