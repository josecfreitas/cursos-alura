package br.com.gbd.alura.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    Autor(es): José Carlos de Freitas
    Data: 05/03/2017 às 10:22:57
    Arquivo: HomeController
*/

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        System.out.println("Exibindo a HOME");
        
        return "index";
    }
}
