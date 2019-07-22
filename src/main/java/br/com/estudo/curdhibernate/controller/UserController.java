package br.com.estudo.curdhibernate.controller;

import br.com.estudo.curdhibernate.DTO.UserDTO;
import br.com.estudo.curdhibernate.builder.UserBuilder;
import br.com.estudo.curdhibernate.model.User;
import br.com.estudo.curdhibernate.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/user"})
public class UserController {
    private UserService service;

    public UserController(UserService dao) {
        this.service = dao;
    }

    public List<User> findAll(){
        return service.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<User> findById(@PathVariable long id){
        return service.findById(id);

    }
    @PostMapping
    public User create(@RequestBody UserDTO userDTO){
        UserBuilder builder = new UserBuilder();
        return service.save(builder.buildUser(userDTO));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable("id") long id, @RequestBody User user){
        return  service.findById(id);
    }

    @DeleteMapping(path = {"/{id}"})
    public  ResponseEntity<?> delete (@PathVariable long id){
        return service.findById(id);
    }


}
