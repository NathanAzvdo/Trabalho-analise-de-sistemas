package org.example;

import java.util.List;

public class RelatorioPedidos implements  Relatorio{
    private List<Pedido> pedidos;

    public  RelatorioPedidos(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    @Override
    public void gerarRelatorio(){
        System.out.println("\n======Relatório pedidos:======\n");
        for(Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
            System.out.println("Valor total:"+pedido.calcularValorTotal()+"\n");
            System.out.println("============================================\n");
        }
    }
}
