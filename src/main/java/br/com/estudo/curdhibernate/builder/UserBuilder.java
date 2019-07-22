package br.com.estudo.curdhibernate.builder;

import br.com.estudo.curdhibernate.DTO.UserDTO;
import br.com.estudo.curdhibernate.model.User;

public class UserBuilder{
    public User buildUser(UserDTO userDTO) {
        User user = new User();
        user.setNome(userDTO.getNome());
        return user;
    }

    public UserDTO buildUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        return userDTO;
    }
}
