package br.com.senacsp.ProjetoPI.model;

import br.com.senacsp.ProjetoPI.enumeracoes.pedidos.StatusPedido;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataCompra;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Double frete;
    private String transportadora;
    private String formaDePagamento;
    @OneToOne
    private EnderecoEntrega enderecoEntrega;
    @OneToOne
    private EnderecoFaturamento enderecoFaturamento;
    @ManyToOne
    private Cliente cliente;
    @ManyToMany
    private List<Produto> produtos;

    public Pedido(Double valorTotal, StatusPedido statusPedido, Double frete, String transportadora, String formaDePagamento, EnderecoEntrega enderecoEntrega, EnderecoFaturamento enderecoFaturamento, Cliente cliente, List<Produto> produtos) {
        this.dataCompra = LocalDateTime.now();
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.frete = frete;
        this.transportadora = transportadora;
        this.formaDePagamento = formaDePagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Pedido(Long id, Double valorTotal, StatusPedido statusPedido, Double frete, String transportadora, String formaDePagamento, EnderecoEntrega enderecoEntrega, EnderecoFaturamento enderecoFaturamento, Cliente cliente, List<Produto> produtos) {
        this.id = id;
        this.dataCompra = LocalDateTime.now();
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        this.frete = frete;
        this.transportadora = transportadora;
        this.formaDePagamento = formaDePagamento;
        this.enderecoEntrega = enderecoEntrega;
        this.enderecoFaturamento = enderecoFaturamento;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }

    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String transportadora) {
        this.transportadora = transportadora;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public EnderecoEntrega getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(EnderecoEntrega enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public EnderecoFaturamento getEnderecoFaturamento() {
        return enderecoFaturamento;
    }

    public void setEnderecoFaturamento(EnderecoFaturamento enderecoFaturamento) {
        this.enderecoFaturamento = enderecoFaturamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
