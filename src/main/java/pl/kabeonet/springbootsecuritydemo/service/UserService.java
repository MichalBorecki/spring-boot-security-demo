package pl.kabeonet.springbootsecuritydemo.service;

import pl.kabeonet.springbootsecuritydemo.entity.User;

public interface UserService extends CRUDService<User> {

    User findByUsername(String username);

}