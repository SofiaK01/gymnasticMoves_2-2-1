package pac;

import org.springframework.beans.factory.annotation.Autowired;
import pac.model.Car;
import pac.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pac.service.UserService;
import pac.service.UserServiceImpl;

@SpringBootApplication
@EnableConfigurationProperties

public class AnotherPr221Application {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(AnotherPr221Application.class, args);

    }
    /*public void doEvery (){

    }*/

}
