package istio.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.net.InetAddress;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@SpringBootApplication

public class RoutingV2Application {

	public static void main(String[] args) {
		SpringApplication.run(RoutingV2Application.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "\nindex - version v2:  "+ RoutingV1Application()+"\n";
	}

	@GetMapping("/service1")
	public String service1(){
		return "\nservice1 - version v2\n";
	}

	@GetMapping("/service2")
	public String service2(){
		return "service2 - version v2\n";
	}

	@RequestMapping(
			value = "*",
			method = { GET, RequestMethod.POST /*** ...***/})
	@ResponseBody
	public String catchAll() {
		return "\nCatch all requests - version v2\n";
	}

	@RequestMapping(value = "/", headers = "release=rc1", method = GET)
	@ResponseBody
	public String headerRoute(HttpServletRequest request) {
		System.out.println("The user agent: " + request.getHeader("user-agent"));
		return "\nRequest routing  based on header \"release=rc1\"\n";
	}
	private static String RoutingV1Application(){
		try {
			InetAddress ip = InetAddress.getLocalHost();
			return ip.toString();

		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
