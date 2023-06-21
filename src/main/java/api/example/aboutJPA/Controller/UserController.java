package api.example.aboutJPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.example.aboutJPA.Model.User;
import api.example.aboutJPA.Service.UserService;
import api.example.aboutJPA.Service.UserServiceHibernate;

@RestController
public class UserController {

    @Autowired 
    UserService userService;

    @Autowired
    UserServiceHibernate userServiceHibernate;

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public User getUserByID(@PathVariable int id){
        return userService.getUserByID(id);
    }

    @PostMapping("/users")
    public String CreateUser(@RequestBody User user){
        return userService.CreateUser(user);
    }

    @PutMapping("/users")
    public String UpdateUser(@RequestBody User user){
        return userService.UpdateUser(user);
    }

    @DeleteMapping("/users")
    public String DeleteAllUser(){
        return userService.DeleteAllUser();
    }

    @DeleteMapping("/users/{id}")
    public String DeleteUserByID(@PathVariable int id){
        return userService.DeleteUserByID(id);
    }

    // Hibernate
    @GetMapping("/usersH")
    public List<User> getAllUserH(){
        return userServiceHibernate.getAllUser();
    }

    @GetMapping("/usersH/{userID}")
    public User getAllUserH(@PathVariable int userID){
        return userServiceHibernate.getUserbyID(userID);
    }

    @PostMapping("/usersH")
    public String CreateUserH(@RequestBody User user){
        return userServiceHibernate.CreateUser(user);
    }

    @PutMapping("/usersH")
    public String UpdateUserH(@RequestBody User user){
        return userServiceHibernate.UpdateUser(user);
    }

    @DeleteMapping("usersH/{userID}")
    public String DeleteUserByIDH(@PathVariable int userID){
        return userServiceHibernate.DeleteUserByID(userID);
    }
}
