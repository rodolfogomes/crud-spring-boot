package br.com.estudo.curdhibernate.services;

import br.com.estudo.curdhibernate.model.User;
import br.com.estudo.curdhibernate.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository dao = null;

    public UserService() {
    }

    public UserService(UserRepository userRepository ) {
        this.dao = userRepository;
    }

    public  User save(User user){
        return dao.save(user);
    }

    public List<User> findAll(){
       return dao.findAll();
    }

    public ResponseEntity<User> findById(long id){
        return dao.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> update( long id,  User user){
        return  dao.findById(id)
                .map(record ->{
                    record.setNome(user.getNome());
                    User updated = dao.save(record);
                    return  ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());

    }

    public  ResponseEntity<?> delete ( long id){
        return dao.findById(id)
                .map(record->{
                    dao.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
