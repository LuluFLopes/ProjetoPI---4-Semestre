package br.com.senacsp.ProjetoPI.form.pedido;

import br.com.senacsp.ProjetoPI.enumeracoes.pedidos.StatusPedido;
import br.com.senacsp.ProjetoPI.model.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class PedidoForm {

    private Long id;
    private String dataCompra;
    private Double valorTotal;
    private StatusPedido statusPedido;
    private Double frete;
    private String transportadora;
    private String formaDePagamento;
    private EnderecoEntrega enderecoEntrega;
    private EnderecoFaturamento enderecoFaturamento;
    private Cliente cliente;
    private List<Produto> produtos;

    public PedidoForm(Pedido pedido) {
        this.id = pedido.getId();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataCompra = format.format(pedido.getDataCompra());
        this.valorTotal = pedido.getValorTotal();
        this.statusPedido = pedido.getStatusPedido();
        this.frete = pedido.getFrete();
        this.transportadora = pedido.getTransportadora();
        this.formaDePagamento = pedido.getFormaDePagamento();
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.enderecoFaturamento = pedido.getEnderecoFaturamento();
        this.cliente = pedido.getCliente();
        this.produtos = pedido.getProdutos();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
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
