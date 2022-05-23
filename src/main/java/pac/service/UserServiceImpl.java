package pac.service;

import pac.model.Car;
import pac.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import pac.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
//@PropertySource("classpath:application.properties")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public User getUserByCarInfo(String model, int series) {
        return userRepository.getUserByCarInfo(model, series);
    }

    @PostConstruct
    public void init() {


        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        user1.setCar(new Car("Lamba", 1));
        user2.setCar(new Car("Honda", 2));
        user3.setCar(new Car("Mazda", 3));
        user4.setCar(new Car("Volvo", 4));

        this.add(user1);
        this.add(user2);
        this.add(user3);
        this.add(user4);

        List<User> users = this.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        System.out.println(this.getUserByCarInfo("Volvo", 4));
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

}
