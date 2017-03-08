package br.com.gbd.alura.validation;

import br.com.gbd.alura.models.Produto;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
    Autor(es): José Carlos de Freitas
    Data: 07/03/2017 às 10:27:32
    Arquivo: ProdutoValidation
 */
public class ProdutoValidation implements Validator {

    public boolean supports(Class<?> clazz) {
        return Produto.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "titulo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Produto produto = (Produto) target;
        
        if(produto.getPaginas() <= 0) {
            errors.rejectValue("paginas", "field.required");
        }
    }

}
