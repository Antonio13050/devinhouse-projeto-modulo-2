package com.devinhouse.devinpharmacy.exception;

public class QuantidadeInformadaMaiorQueQuantidadeEmEstoqueException extends RuntimeException {

    private String nome;
    private String identificador;

    public QuantidadeInformadaMaiorQueQuantidadeEmEstoqueException() {
    }

    public QuantidadeInformadaMaiorQueQuantidadeEmEstoqueException(String nome, String identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public QuantidadeInformadaMaiorQueQuantidadeEmEstoqueException(String nome, Integer identificador) {
        this(nome, identificador.toString());
    }

    public QuantidadeInformadaMaiorQueQuantidadeEmEstoqueException(String nome, Long identificador) {
        this(nome, identificador.toString());
    }

    public String getMessage() {
        if (nome == null || identificador == null)
            return null;
        return String.format("A '%s' informada é maior que o valor em estoque, estoque atual é '%s'", nome, identificador);
    }
}
