package org.example;

public class Cliente {
    private String nome;
    private String contato;

    public Cliente(String nome, String contato){
        this.nome=nome;
        this.contato=contato;
    }

    public String getContato() {
        return contato;
    }

    public String getNome() {
        return nome;
    }


}
