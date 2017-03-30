package br.com.gbd.alura.controllers;

import br.com.gbd.alura.daos.ProdutoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
    Autor(es): José Carlos de Freitas
    Data: 05/03/2017 às 10:22:57
    Arquivo: HomeController
 */
@Controller
public class HomeController {

    @Autowired
    private ProdutoDAO produtoDAO;

    @RequestMapping(value = {"/", "/home"})
    @Cacheable("listaProdutos")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtoDAO.listar());

        return modelAndView;
    }
}
