package ALIPE.SpringJPAdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ALIPE.SpringJPAdata.model.User;
import ALIPE.SpringJPAdata.repository.UserRepository;

@Component
public class StartApp implements CommandLineRunner{
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("Geraldo");
        user.setUsername("geraldão");
        user.setPassword("geraldogostoso123");

        repository.save(user);

        for(User u : repository.findAll()){
            System.out.println(u);
        }
    }
    
}
