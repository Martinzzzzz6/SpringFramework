package demoSpringIo.demos2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Demos2Application {

	public static void main(String[] args) {
		SpringApplication.run(Demos2Application.class, args);
	}

	@RestController
	public class Controller {
		@GetMapping("/somethingSmart")
		public String printHello() {
			return "Hello World";
		}
	}

}
