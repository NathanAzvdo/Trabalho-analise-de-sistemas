package org.example;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        estoque.adicionarMaterial("Tecido", 100);
        estoque.adicionarMaterial("Botões", 50);


        Cliente cliente1 = new Cliente("Escola ABC", "contato@escolaabc.com");
        Cliente cliente2 = new Cliente("Empresa XYZ", "rh@empresaxyz.com");


        Pedido pedido1 = new Pedido(1, cliente1, LocalDateTime.now().plusDays(10));
        pedido1.adicionarProduto(new Produto("Camiseta", "M", 50, 25.0, true));
        pedido1.adicionarProduto(new Produto("Short", "G", 30, 20.0, false));

        Pedido pedido2 = new Pedido(2, cliente2, LocalDateTime.now().plusDays(15));
        pedido2.adicionarProduto(new Produto("Calça", "P", 20, 35.0, true));


        pedido1.alterarStatus(StatusPedido.EM_PRODUCAO);
        pedido2.alterarStatus(StatusPedido.ENVIADO);


        pedido2.registrarFeedback("Produtos entregues com ótima qualidade.");


        List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);

        Relatorio relatorio = new RelatorioPedidos(pedidos);
        relatorio.gerarRelatorio();

        estoque.exibirEstoque();
    }
}