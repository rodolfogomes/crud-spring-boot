package br.com.estudo.curdhibernate.controller;

import br.com.estudo.curdhibernate.model.User;
import br.com.estudo.curdhibernate.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/user"})
public class UserController {
    private  UserRepository dao;

    public UserController(UserRepository dao) {
        this.dao = dao;
    }

    public List<User> findAll(){
        return dao.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<User> findById(@PathVariable long id){
        return dao.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public User create(@RequestBody User user){
        return dao.save(user);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user){
        return  dao.findById(id)
                .map(record ->{
                    record.setNome(user.getNome());
                    User updated = dao.save(record);
                    return  ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping(path = {"/{id}"})
    public  ResponseEntity<?> delete (@PathVariable long id){
        return dao.findById(id)
                .map(record->{
                    dao.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }


}
