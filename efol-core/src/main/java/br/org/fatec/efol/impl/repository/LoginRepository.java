package br.org.fatec.efol.impl.repository;

import br.org.fatec.efol.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends JpaRepository<User, Long>{

    User findByUsernameAndPassword(String username, String password);

}