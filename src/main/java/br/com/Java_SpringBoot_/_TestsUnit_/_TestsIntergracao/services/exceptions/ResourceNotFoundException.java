package br.com.Java_SpringBoot_._TestsUnit_._TestsIntergracao.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
