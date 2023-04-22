package br.com.senacsp.ProjetoPI.dto.cliente;

import br.com.senacsp.ProjetoPI.model.Cliente;
import br.com.senacsp.ProjetoPI.model.Endereco;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String genero;
    private String usuario;
    private String senha;
    private List<Endereco> endereco;


    public ClienteDTO(Long id, String nome, String cpf, Date dataNascimento, String genero, String usuario, String senha, List<Endereco> endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.usuario = usuario;
        this.senha = senha;
        this.endereco = endereco;
    }

    public Cliente conversor (ClienteDTO dto){
        return new Cliente(
                dto.getId(),
                dto.getNome(),
                dto.getCpf(),
                dto.getDataNascimento(),
                dto.getGenero(),
                dto.getUsuario(),
                dto.getSenha(),
                dto.getEndereco()
        );
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", genero='" + genero + '\'' +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
