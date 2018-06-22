package pl.kabeonet.springbootsecuritydemo.bean.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kabeonet.springbootsecuritydemo.entity.Car;
import pl.kabeonet.springbootsecuritydemo.entity.Role;
import pl.kabeonet.springbootsecuritydemo.entity.User;
import pl.kabeonet.springbootsecuritydemo.repository.CarRepository;
import pl.kabeonet.springbootsecuritydemo.service.RoleService;
import pl.kabeonet.springbootsecuritydemo.service.UserService;

import java.util.List;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CarRepository CarRepository;
    private UserService userService;
    private RoleService roleService;

    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setCarRepository(CarRepository CarRepository) {
        this.CarRepository = CarRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadCars();
        loadUsers();
        loadRoles();
        assignUsersToUserRole();
        assignUsersToAdminRole();
    }

    private void loadCars() {
        Car audi = new Car();
        audi.setCarNumber(1);
        audi.setModel("Audi A3");
        audi.setMileage(12000);
        audi.setDescription("Samochód powypadkowy");
        CarRepository.save(audi);

        log.info("Saved Audi - id: " + audi.getId());

        Car peugeot = new Car();
        peugeot.setCarNumber(2);
        peugeot.setModel("Peugeot 800");
        peugeot.setMileage(13000);
        peugeot.setDescription("Samochód nowy");
        CarRepository.save(peugeot);

        log.info("Saved Peugeot - id:" + peugeot.getId());
    }

    private void loadUsers() {
        User user1 = new User();
        user1.setUserName("user");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUserName("admin");
        user2.setPassword("admin");
        userService.saveOrUpdate(user2);

    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role" + adminRole.getRole());
    }
    private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (user.getUserName().equals("user")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUserName().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }
}