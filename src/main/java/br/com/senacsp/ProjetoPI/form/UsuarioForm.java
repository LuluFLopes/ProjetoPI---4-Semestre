package br.com.senacsp.ProjetoPI.form;

import br.com.senacsp.ProjetoPI.grupos.Status;
import br.com.senacsp.ProjetoPI.grupos.Grupo;
import br.com.senacsp.ProjetoPI.model.Usuario;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioForm {

    private Long id;
    private String nome;
    private String cpf;
    private String usuario;
    private String senha;
    private Status status;
    private Grupo grupo;




    public UsuarioForm(Long id, String nome, String cpf, String usuario, String senha, Status status, Grupo grupo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.usuario = usuario;
        this.senha = senha;
        this.status = status;
        this.grupo = grupo;
    }

    public Usuario conversor(UsuarioForm dto) {
        Usuario usuario = new Usuario(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                dto.getUsuario(),
                dto.getSenha(),
                dto.getAtivo(),
                dto.getAutorizacao()
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

    public Status getAtivo() {
        return status;
    }

    public void setAtivo(Status status) {
        this.status = status;
    }

    public Grupo getAutorizacao() {
        return grupo;
    }

    public void setAutorizacao(Grupo grupo) {
        this.grupo = grupo;
    }
}

