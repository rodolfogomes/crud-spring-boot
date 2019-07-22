package br.com.estudo.curdhibernate.repository;

import br.com.estudo.curdhibernate.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
