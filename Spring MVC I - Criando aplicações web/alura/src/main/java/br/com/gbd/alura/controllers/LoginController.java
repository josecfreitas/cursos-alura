package br.com.gbd.alura.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    Autor(es): José Carlos de Freitas
    Data: 30/03/2017 às 18:07:27
    Arquivo: LoginController
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() {
        return "loginForm";
    }
}
