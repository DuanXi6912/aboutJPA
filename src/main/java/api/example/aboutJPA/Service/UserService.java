package api.example.aboutJPA.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.example.aboutJPA.Model.User;
import api.example.aboutJPA.Repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserByID(int ID){
        int index = ValidUserByID(ID);
        if(index != -1){
            return userRepository.findAll().get(index);
        }
        return null;
    }

    public String CreateUser(User user){
        userRepository.save(user);
        return "Create User";
    }

    public String UpdateUser(User user){
        int index = ValidUserByID(user.getUserID());
        if(index != -1){
            userRepository.save(user);
            return "Update User";
        }
        return "Not Found";
    }

    public String DeleteUserByID(int ID){
        int index = ValidUserByID(ID);
        if(index != -1){
            userRepository.delete(userRepository.findAll().get(index));
            return "Delele User " + ID;
        }
        return "Not Found";
    }

    public String DeleteAllUser(){
        userRepository.deleteAll();
        return "Delete All User";
    }


    private int ValidUserByID(int ID){
        List<User> users = userRepository.findAll();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUserID() == ID){
                return i;
            }
        }
        return -1;
    }
}
