package br.com.estudo.curdhibernate.builder;

import br.com.estudo.curdhibernate.model.User;

public abstract class UserAbstractBuilder {
    protected User user;

    public UserAbstractBuilder() {
        user =  new User();
    }

    public  abstract  void buildNome();

    public  User getUser(){
        return user;
    }


}
