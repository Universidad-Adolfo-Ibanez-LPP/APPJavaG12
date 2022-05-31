package com.uai.app.dominio.enums;

public enum Tittles {

    TITULO("titulo"),AUTOR("autor"),ESTANTE_NUMERO("estante_numero"),
    ESTANTE_SECCION("estante_seccion"),PISO("piso"),EDIFICIO("edificio"),SEDE("sede");

    private String val;

    public String getVal() {
        return val;
    }

    Tittles(String val) {
        this.val = val;
    }

}
