package api.example.aboutJPA.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import api.example.aboutJPA.Model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class UserServiceHibernate {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUser(){
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }
    
    public User getUserbyID(int userID){
        
        return entityManager.find(User.class, userID);
    }
    @Transactional
    public String CreateUser(User user){
        System.out.println("Create User");
        entityManager.persist(user);
        return "Create User With Hibernate";
    }
    @Transactional
    public String UpdateUser(User user){
        if(getUserbyID(user.getUserID()) != null){
            entityManager.merge(user);
            return "Update User With Hibernate";
        }
        return "Hibernate Not Found";
    }
    @Transactional
    public String DeleteUserByID(int ID){
        User user = getUserbyID(ID);
        if(user != null){
            entityManager.remove(user);
            return "Remove User With Hibernate";
        }
        return "Hibernate Not Found";
    }
    

}
