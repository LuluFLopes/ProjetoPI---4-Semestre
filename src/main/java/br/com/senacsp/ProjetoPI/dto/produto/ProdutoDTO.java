package br.com.senacsp.ProjetoPI.dto.produto;

import br.com.senacsp.ProjetoPI.enumeracoes.produto.Avaliacao;
import br.com.senacsp.ProjetoPI.enumeracoes.produto.Status;
import br.com.senacsp.ProjetoPI.model.Produto;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String detalhes;
    private Double preco;
    private Integer quantidade;
    private Avaliacao avaliacao;
    private Status status;
    private List<String> urlImg;

    public ProdutoDTO(Long id, String nome, String detalhes,
                      Double preco, Integer quantidade, Avaliacao avaliacao,
                      Status status, List<String> urlImg) {
        this.id = id;
        this.nome = nome;
        this.detalhes = detalhes;
        this.preco = preco;
        this.quantidade = quantidade;
        this.avaliacao = avaliacao;
        this.status = status;
        this.urlImg = urlImg;
    }

    public ProdutoDTO(String nome, String detalhes, Double preco,
                      Integer quantidade, Avaliacao avaliacao, Status status,
                      List<String> urlImg) {
        this.nome = nome;
        this.detalhes = detalhes;
        this.preco = preco;
        this.quantidade = quantidade;
        this.avaliacao = avaliacao;
        this.status = status;
        this.urlImg = urlImg;
    }

    public Produto conversor(ProdutoDTO dto) {
        return new Produto(
                dto.getId(),
                dto.getNome(),
                dto.getDetalhes(),
                dto.getPreco(),
                dto.getQuantidade(),
                dto.getAvaliacao(),
                dto.getStatus(),
                dto.getUrlImg()
        );
    }

    public Produto conversorAlteracaoStatus(ProdutoDTO dto) {
        return new Produto(
                dto.getId(),
                dto.getStatus()
        );
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

    public List<String> getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(List<String> urlImg) {
        this.urlImg = urlImg;
    }
}
