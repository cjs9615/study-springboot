package abc.def;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ABCController {
	
	public ABCController() {
		System.out.println("ABCController 호출");
	}
}
