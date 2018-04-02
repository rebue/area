package rebue.area;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
@ServletComponentScan("rebue")
public class AreaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AreaApplication.class, args);
    }

}
