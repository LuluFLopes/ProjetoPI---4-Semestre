package br.com.senacsp.ProjetoPI.form;

import br.com.senacsp.ProjetoPI.model.Usuario;

public class UsuarioForm {

    private Long id;
    private String nome;
    private String cpf;
    private String usuario;
    private String senha;

    public UsuarioForm(Long id, String nome, String cpf, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario conversor(UsuarioForm dto) {
        Usuario usuario = new Usuario(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                dto.getUsuario(),
                dto.getSenha()
        );
        return usuario;
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
}

