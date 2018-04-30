package sam.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {
	@RequestMapping("/kuku")
	public String test() {
		return "Hello Dear";

	}

	@RequestMapping("/test")
	public int check(int a, int b)  {

		return (a + b);
	}

}
