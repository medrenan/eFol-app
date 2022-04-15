package br.org.fatec.efol.impl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.org.fatec.efol.model.users.User;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends JpaRepository<User, Long>{

    User findByUsernameAndPassword(String username, String password);

}