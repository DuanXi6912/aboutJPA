package api.example.aboutJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import api.example.aboutJPA.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
