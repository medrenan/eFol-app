package br.org.fatec.efol.impl.service;

import br.org.fatec.efol.impl.repository.LoginRepository;
import br.org.fatec.efol.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository repo;

    public User login(String username, String password) {
        User user = repo.findByUsernameAndPassword(username, password);
        return user;
    }

}