package br.com.senacsp.ProjetoPI.dto.produto;

import br.com.senacsp.ProjetoPI.enumeracoes.produto.Avaliacao;
import br.com.senacsp.ProjetoPI.enumeracoes.produto.Status;
import br.com.senacsp.ProjetoPI.model.Produto;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProdutoDTO {

    private String nome;
    private String detalhes;
    private Double preco;
    private Integer quantidade;
    private Avaliacao avaliacao;
    private Status status;

    public ProdutoDTO(String nome, String detalhes, Double preco, Integer quantidade, Avaliacao avaliacao, Status status) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.preco = preco;
        this.quantidade = quantidade;
        this.avaliacao = avaliacao;
        this.status = status;
    }

    public Produto conversor(ProdutoDTO dto) {
        return new Produto(
                dto.getNome(),
                dto.getDetalhes(),
                dto.getPreco(),
                dto.getQuantidade(),
                dto.getAvaliacao(),
                dto.getStatus()
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
