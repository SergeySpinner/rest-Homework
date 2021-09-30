package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ApplicationStarter {
    @Autowired
    public void setData(UserRepository temp){
        data = temp;
    }

    private static UserRepository data;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class);
        List<User> userList = data.findAll();
        userList.forEach(temp -> System.out.println(temp));
    }
}
