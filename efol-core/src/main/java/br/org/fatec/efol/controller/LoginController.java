package br.org.fatec.efol.controller;


import br.org.fatec.efol.impl.repository.LoginRepository;
import br.org.fatec.efol.impl.service.LoginService;
import br.org.fatec.efol.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private LoginService userService;

    @GetMapping("/login")

    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user ) {

        User oauthUser = userService.login(user.getUsername(), user.getPassword());


        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser))
        {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }

    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";
    }

}