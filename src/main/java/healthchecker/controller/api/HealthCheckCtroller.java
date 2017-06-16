package healthchecker.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 1004w455 on 2017. 6. 16..
 */
@RestController
public class HealthCheckCtroller {

    @GetMapping("/healthcheck")
    public String healthcheck(String url) {
        return getStatus(url);
    }

    private String getStatus(String url) {
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect(); // 연결만되면 서버 살아있는걸로 판단해도 될듯.
            return "Green";
//            int code = connection.getResponseCode();
//            if (code == 200) {
//                result = "Green";
//            }
        } catch (Exception e) {
            return "Red";
        }
    }

}
