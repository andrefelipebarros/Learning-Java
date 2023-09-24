package ALIPE.SpringJPAdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ALIPE.SpringJPAdata.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
    
}
