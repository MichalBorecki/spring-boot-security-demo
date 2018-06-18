package pl.kabeonet.springbootsecuritydemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kabeonet.springbootsecuritydemo.entity.User;

public class UserRepository extends CrudRepository<User, Long> {
}
