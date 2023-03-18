package br.com.senacsp.ProjetoPI.model;

import br.com.senacsp.ProjetoPI.enumeracoes.produto.Avaliacao;
import br.com.senacsp.ProjetoPI.enumeracoes.produto.Status;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String detalhes;
    private Double preco;
    private Integer quantidade;
    @Enumerated
    private Avaliacao avaliacao;
    @Enumerated
    private Status status;

    public Produto(Long id, String nome, String detalhes, Double preco, Integer quantidade, Avaliacao avaliacao, Status status) {
        this.id = id;
        this.nome = nome;
        this.detalhes = detalhes;
        this.preco = preco;
        this.quantidade = quantidade;
        this.avaliacao = avaliacao;
        this.status = Status.ATIVO;
    }

    public Produto(String nome, String detalhes, Double preco, Integer quantidade, Avaliacao avaliacao, Status status) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.preco = preco;
        this.quantidade = quantidade;
        this.avaliacao = avaliacao;
        this.status = Status.ATIVO;
    }

    @Override
    public String toString() {
        return "Produto [ " +
                "id = " + id +
                ", nome = " + nome +
                ", detalhes = " + detalhes +
                ", preco = " + preco +
                ", quantidade = " + quantidade +
                ", avaliacao = " + avaliacao +
                ", status = " + status +
                " ]";
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Avaliacao getAvaliacao() {return avaliacao;}

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
