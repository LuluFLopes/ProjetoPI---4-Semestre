package br.com.senacsp.ProjetoPI.model;

import br.com.senacsp.ProjetoPI.enumeracoes.pedidos.TipoImagem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private TipoImagem tipoImagem;

    public Imagem(String url, TipoImagem tipoImagem) {
        this.url = url;
        this.tipoImagem = tipoImagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TipoImagem getTipoImagem() {
        return tipoImagem;
    }

    public void setTipoImagem(TipoImagem tipoImagem) {
        this.tipoImagem = tipoImagem;
    }
}
