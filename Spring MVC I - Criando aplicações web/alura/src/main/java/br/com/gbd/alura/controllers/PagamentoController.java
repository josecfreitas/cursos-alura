package br.com.gbd.alura.controllers;

import br.com.gbd.alura.models.DadosPagamento;
import br.com.gbd.alura.models.CarrinhoCompras;
import br.com.gbd.alura.models.TipoPreco;
import java.util.concurrent.Callable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/*
    Autor(es): José Carlos de Freitas
    Data: 23/03/2017 às 15:48:16
    Arquivo: PagamentoController
 */
@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    CarrinhoCompras carrinho;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/finalizar", method = RequestMethod.POST)
    public Callable<ModelAndView> finalizar(RedirectAttributes redirectAttributes) {
        return () -> {
            try {
                String url = "http://book-payment.herokuapp.com/payment";
                String response = restTemplate.postForObject(url, new DadosPagamento(carrinho.getTotal()), String.class);
                System.out.println(carrinho.getTotal());

                redirectAttributes.addFlashAttribute("msg", response);

                return new ModelAndView("redirect:/produtos");
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("msg", "Valor maior que o permitido");
                return new ModelAndView("redirect:/produtos");
            }
        };
    }

    @RequestMapping("/remover")
    public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco) {
        carrinho.remover(produtoId, tipoPreco);
        return new ModelAndView("redirect:/carrinho");
    }
}
