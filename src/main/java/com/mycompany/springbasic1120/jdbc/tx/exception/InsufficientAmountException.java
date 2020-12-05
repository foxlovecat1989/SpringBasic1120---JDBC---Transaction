package com.mycompany.springbasic1120.jdbc.tx.exception;

public class InsufficientAmountException extends Exception {

    public InsufficientAmountException() {
        super("NOT ENOUGH MONEY!!!");
    }
    
}
