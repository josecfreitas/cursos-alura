package br.com.gbd.alura.conf;

import java.util.Locale;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/*
    Autor(es): José Carlos de Freitas
    Data: 28/03/2017 às 12:01:56
    Arquivo: JsonViewResolver
 */
class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String arg0, Locale arg1) throws Exception {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setPrettyPrint(true);
        return jsonView;
    }

}
