/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.dsw.exception;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;

public class T2ExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    //Obtém uma instância do FacesContext
    final FacesContext facesContext = FacesContext.getCurrentInstance();

    //Obtém um mapa do FacesContext
    final Map requestMap = facesContext.getExternalContext().getRequestMap();

    //Obtém o estado atual da navegação entre páginas do JSF
    final NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();

    //Declara o construtor que recebe uma exceptio do tipo ExceptionHandler como parâmetro
    T2ExceptionHandler(ExceptionHandler exception) {
        this.wrapped = exception;
    }

    //Sobrescreve o método ExceptionHandler que retorna a "pilha" de exceções
    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {

        final Iterator iterator = getUnhandledExceptionQueuedEvents().iterator();
        while (iterator.hasNext()) {
            ExceptionQueuedEvent event = (ExceptionQueuedEvent) iterator.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

            Throwable exception = context.getException();

            try {
                requestMap.put("exceptionMessage", exception.getMessage());
                String error = exception.getMessage();
                try {
                    String[] errors = exception.getMessage().split(":", 3);
                    error = errors[errors.length];
                } catch (Exception e) {
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", exception.getMessage().split(":", 3)[2]));
                facesContext.renderResponse();
            } finally {
                iterator.remove();
            }
        }
        getWrapped().handle();
    }
}
