package istio.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication

public class RoutingV1Application {

	public static void main(String[] args) {
		SpringApplication.run(RoutingV1Application.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "\nindex - version v1\n";
	}

	@GetMapping("/service1")
	public String service1(){
		return "\nservice1 - version v1\n";
	}

	@GetMapping("/service2")
	public String service2(){
		return "service2 - version v1\n";
	}

	@RequestMapping(
			value = "*",
			method = { RequestMethod.GET, RequestMethod.POST /*** ...***/})
	@ResponseBody
	public String catchAll() {
		return "\nCatch all requests - version v1\n";
	}
}
