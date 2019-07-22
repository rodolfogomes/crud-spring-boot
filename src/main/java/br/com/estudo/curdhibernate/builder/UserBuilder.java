package br.com.estudo.curdhibernate.builder;

public class UserBuilder  extends  UserAbstractBuilder{
    @Override
    public void buildNome() {
        user.setNome("Rodolfo");
    }
}
