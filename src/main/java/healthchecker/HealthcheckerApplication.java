package healthchecker;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealthcheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcheckerApplication.class, args);
	}

	@GetMapping("/healthcheck")
	public String healthcheck(String url) {
		return getStatus(url);
	}

	private String getStatus(String url) {
		String result = "";
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
			connection.setRequestMethod("GET");
			connection.connect(); // 연결만되면 서버 살아있는걸로 판단해도 될듯.
			int code = connection.getResponseCode();
			if (code == 200) {
				result = "Green";
			}
		} catch (Exception e) {
			result = "->Red<-";
		}
		return result;
	}
}
