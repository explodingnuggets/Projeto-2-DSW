package br.dsw.exception;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

public class T2ExceptionHandlerFactory extends ExceptionHandlerFactory {

    private ExceptionHandlerFactory exceptionHandlerFactory;

    public T2ExceptionHandlerFactory() {
    }

    public T2ExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
        this.exceptionHandlerFactory = exceptionHandlerFactory;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        return new T2ExceptionHandler(exceptionHandlerFactory.getExceptionHandler());
    }
}