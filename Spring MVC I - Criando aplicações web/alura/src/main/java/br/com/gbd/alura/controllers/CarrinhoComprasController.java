package br.com.gbd.alura.controllers;

import br.com.gbd.alura.daos.ProdutoDAO;
import br.com.gbd.alura.models.CarrinhoCompras;
import br.com.gbd.alura.models.CarrinhoItem;
import br.com.gbd.alura.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/*
    Autor(es): José Carlos de Freitas
    Data: 13/03/2017 às 11:19:07
    Arquivo: CarrinhoComprasController
*/

@Controller
@RequestMapping("/cart")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {
    
    @Autowired
    private ProdutoDAO produtoDAO;
    
    @Autowired
    private CarrinhoCompras carrinhoCompras;

    @RequestMapping("/add")
    public String add(Integer produtoId, TipoPreco tipo){
        CarrinhoItem item = new CarrinhoItem(produtoDAO.find(produtoId), tipo);
        
        carrinhoCompras.add(item);
        
        return "redirect:/produtos";
    }
    
    @RequestMapping("/itens")
    public ModelAndView itens() {
        ModelAndView modelAndView = new ModelAndView("carrinho/itens");
        
        return modelAndView;
    }
}
