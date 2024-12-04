package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;
    private String feedback;
    private LocalDateTime prazoEntrega;
    private List<String> historicoStatus;

    public Pedido(int id, Cliente cliente, LocalDateTime prazoEntrega) {
        this.id = id;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.RECEBIDO;
        this.prazoEntrega = prazoEntrega;
        this.historicoStatus = new ArrayList<>();
        registrarAlteracaoStatus(StatusPedido.RECEBIDO);
    }

    public void adicionarProduto(Produto produto){
        if(produto.quantidade()<=0){
            throw new IllegalArgumentException("A quantidade de produto deve ser maior que zero");
        }
        produtos.add(produto);
    }

    public void alterarStatus(StatusPedido newStatus){
        this.status = newStatus;
        registrarAlteracaoStatus(newStatus);
    }

    private void registrarAlteracaoStatus(StatusPedido status){
        historicoStatus.add(status.name()+" - "+LocalDateTime.now());

    }

}
