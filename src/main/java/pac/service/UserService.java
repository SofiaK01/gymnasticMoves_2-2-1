package pac.service;

import pac.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    void add(User user);

    List<User> listUsers();

    User getUserByCarInfo(String model, int series);
}
