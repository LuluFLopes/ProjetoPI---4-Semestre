package br.com.senacsp.ProjetoPI.dto;

import br.com.senacsp.ProjetoPI.model.Usuario;

public class UsuarioDTO {
    private String nome;
    private String cpf;
    private String usuario;
    private String senha;

    public UsuarioDTO(String nome, String cpf, String usuario, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario conversor(UsuarioDTO dto) {
        Usuario usuario = new Usuario(
                dto.getNome(),
                dto.getCpf(),
                dto.getUsuario(),
                dto.getSenha()
        );
        return usuario;
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

