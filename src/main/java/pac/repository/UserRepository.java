package pac.repository;

import org.springframework.data.jpa.repository.Query;
import pac.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u join u.car c WHERE c.model = :model and c.series = :series")
    User getUserByCarInfo(String model, int series);

}
