package com.uai.app.exceptions;

public class LibroNotFoundException extends Exception{
    public LibroNotFoundException() {
        super("El libro no se econtcontró");
    }
}
