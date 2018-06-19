package pl.kabeonet.springbootsecuritydemo.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kabeonet.springbootsecuritydemo.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
