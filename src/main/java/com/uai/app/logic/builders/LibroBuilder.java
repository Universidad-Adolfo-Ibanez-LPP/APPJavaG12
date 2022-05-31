package com.uai.app.logic.builders;

import com.uai.app.dominio.Libro;
import com.uai.app.logic.DataManager;

import java.util.HashSet;

public class LibroBuilder {

    private String titulo;
    private String autor;
    private int estante_numero;
    private String estante_seccion;
    private int piso;
    private String edificio;
    private String sede;

    public LibroBuilder() {
    }


    public LibroBuilder withTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }
    public LibroBuilder withAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LibroBuilder withEstante_numero(int estante_numero) {
        this.estante_numero = estante_numero;
        return this;
    }
    public LibroBuilder withEstante_seccion(String estante_seccion) {
        this.estante_seccion = estante_seccion;
        return this;
    }
    public LibroBuilder withPiso(int piso) {
        this.piso = piso;
        return this;
    }
    public LibroBuilder withEdificio(String edificio) {
        this.edificio = edificio;
        return this;
    }

    public LibroBuilder withSede(String sede) {
        this.sede = sede;
        return this;
    }
    //Return the finally consrcuted User object
    public Libro build(String au,int num,String sec,String tit,int p,String ed, String se) {
        Libro book =  new Libro();
        book.setAutor(au);
        book.setEstante_numero(num);
        book.setEstante_seccion(sec);
        book.setTitulo(tit);
        book.setPiso(p);
        book.setEdificio(ed);
        book.setSede(se);
        validateBookObject(book);
        return book;
    }
    public Libro edit(String au,int num,String sec,String tit,int p,String ed, String se){
        HashSet<Libro> data = DataManager.getInstance().getData();
        data.remove(p);
        LibroBuilder lib = new LibroBuilder();
        Libro book = (lib.build(au,num,sec,tit,p,ed,se));
        return book;
    }

    private void validateBookObject(Libro user) {
        //Do some basic validations to check
        //if user object does not break any assumption of system
    }
}
