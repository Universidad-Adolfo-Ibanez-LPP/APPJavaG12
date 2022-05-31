package com.uai.app.dominio;

import com.opencsv.bean.CsvBindByName;

public class Libro implements Comparable<Libro>{

    public Libro() {
    }

    @CsvBindByName(column = "titulo")
    private String titulo;

    @CsvBindByName(column = "autor")
    private String autor;

    @CsvBindByName(column = "estante_numero")
    private int estante_numero;

    @CsvBindByName(column = "estante_seccion")
    private String estante_seccion;

    @CsvBindByName(column = "piso")
    private int piso;

    @CsvBindByName(column = "edificio")
    private String edificio;

    @CsvBindByName(column = "sede")
    private String sede;

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getEstante_numero() {
        return estante_numero;
    }

    public String getEstante_seccion() {
        return estante_seccion;
    }

    public int getPiso() {
        return piso;
    }

    public String getEdificio() {
        return edificio;
    }

    public String getSede() {
        return sede;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public void setEstante_numero(int estante_numero) {
        this.estante_numero = estante_numero;
    }

    public void setEstante_seccion(String estante_seccion) {
        this.estante_seccion = estante_seccion;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                "estante_numero='" + estante_numero + '\''+
                "estante_seccion='" + estante_seccion + '\''+
                "piso='" + piso + '\''+
                "edificio='" + edificio + '\''+
                "sede='" + sede + '\''+
                '}';
    }

    public String[] getDataToCsv(){
        // el string.valueOf me convierte el int a string
        return new String[]{
                getTitulo().trim(),
                getAutor().trim(),
                String.valueOf(getEstante_numero()).trim(),
                getEstante_seccion().trim(),
                String.valueOf(getPiso()).trim(),
                getEdificio().trim(),
                getSede().trim()};
    }
    @Override
    public int compareTo(Libro o) {
        return this.titulo.compareTo(o.getTitulo())*-1;
    }
}
