package pl.kabeonet.springbootsecuritydemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kabeonet.springbootsecuritydemo.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
