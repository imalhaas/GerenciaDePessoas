package com.Attornatusapi.GerenciaDePessoas.Evento.Listener;

import com.Attornatusapi.GerenciaDePessoas.Evento.RecursoCriadoEvento;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvento> {

    @Override
    public void onApplicationEvent(RecursoCriadoEvento recursoCriadoEvento) {

        HttpServletResponse response = recursoCriadoEvento.getResponse();
        Long codigo = recursoCriadoEvento.getCodigo();

        adicionarHeaderLocation(response, codigo);
    }

    private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("location", uri.toASCIIString());
    }
}
