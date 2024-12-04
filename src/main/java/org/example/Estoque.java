package org.example;

import java.util.HashMap;
import java.util.Map;

public class Estoque {

    private Map<String, Integer> materiais;

    public Estoque(){
        this.materiais = new HashMap<>();
    }

    public void adicionarMaterial(String material, int quantidade){
        materiais.put(material, materiais.getOrDefault(material, 0)+ quantidade);
    }

    public boolean verificarDisponibilidade(String material, int quantidade) {
        return materiais.getOrDefault(material, 0) >= quantidade;
    }
    
    public void consumirMaterial(String material, int quantidade) {
        if (verificarDisponibilidade(material, quantidade)) {
            materiais.put(material, materiais.get(material) - quantidade);
        } else {
            throw new IllegalStateException("Material insuficiente no estoque: " + material);
        }
    }

    public void exibirEstoque() {
        System.out.println("\n=== Estoque Atual ===");
        materiais.forEach((material, quantidade) -> System.out.println(material + ": " + quantidade + " unidades"));
    }

}

