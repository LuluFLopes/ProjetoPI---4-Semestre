package br.com.senacsp.ProjetoPI.model;

import br.com.senacsp.ProjetoPI.grupos.Autorizacao;
import br.com.senacsp.ProjetoPI.grupos.Status;
import jakarta.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    @Column(updatable = false)
    private String usuario;
    private String senha;
    @Enumerated
    private Status status;
    @Enumerated
    private Autorizacao autorizacao;

    public Usuario() {
    }

    public Usuario(Long id, String nome, String cpf, String usuario, String senha, Status status, Autorizacao autorizacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.status = status;
        this.autorizacao = autorizacao;
    }

    public Usuario(String nome, String cpf, String usuario, String senha, Status status, Autorizacao autorizacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.status = status;
        this.autorizacao = autorizacao;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", ativo=" + status +
                ", autorizacao=" + autorizacao +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Status getAtivo() {
        return status;
    }

    public void setAtivo(Status status) {
        this.status = status;
    }

    public Autorizacao getAutorizacao() {
        return autorizacao;
    }

    public void setAutorizacao(Autorizacao autorizacao) {
        this.autorizacao = autorizacao;
    }
}
