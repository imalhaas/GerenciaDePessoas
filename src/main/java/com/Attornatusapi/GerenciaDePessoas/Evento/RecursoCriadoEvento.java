package com.Attornatusapi.GerenciaDePessoas.Evento;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;

public class RecursoCriadoEvento extends ApplicationEvent {

    private static final long SerialVersionUID = 1L;

    private HttpServletResponse response;
    private Long codigo;

    public RecursoCriadoEvento(Object source, HttpServletResponse response, Long codigo) {
        super(source);
        this.codigo = codigo;
        this.response = response;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Long getCodigo() {
        return codigo;
    }
}