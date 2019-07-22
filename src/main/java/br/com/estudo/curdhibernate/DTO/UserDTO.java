package br.com.estudo.curdhibernate.DTO;

import br.com.estudo.curdhibernate.model.User;

public class UserDTO {
    private String nome;

    public UserDTO(){}

    public UserDTO(String nome) {
        this.nome = nome;
    }

    public User convertToUser(){
        return new User(this.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
