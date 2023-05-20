package br.com.senacsp.ProjetoPI.dto.usuario;

import br.com.senacsp.ProjetoPI.enumeracoes.usuario.Grupo;
import br.com.senacsp.ProjetoPI.enumeracoes.usuario.Status;
import br.com.senacsp.ProjetoPI.model.Usuario;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String usuario;
    private String senha;
    private Status status;
    private Grupo grupo;

    public Usuario conversor(UsuarioDTO dto) {
        Usuario usuario = new Usuario(
                dto.getNome(),
                dto.getCpf(),
                dto.getUsuario(),
                dto.getSenha(),
                Status.ATIVO,
                dto.getGrupo()
        );
        return usuario;
    }

    public Usuario conversorAlterar(UsuarioDTO dto) {
        Usuario usuario = new Usuario(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                dto.getUsuario(),
                dto.getSenha(),
                Status.ATIVO,
                dto.getGrupo()
        );
        return usuario;
    }

    public Usuario conversorStatus(UsuarioDTO dto) {
        Usuario usuario = new Usuario(
                dto.getId(),
                dto.getStatus()
        );
        return usuario;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}

