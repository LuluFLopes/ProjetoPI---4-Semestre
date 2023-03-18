package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.model.Usuario;
import br.com.senacsp.ProjetoPI.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public boolean salvar(Usuario usuario) {
        Usuario retorno = null;
        if (usuarioRepository.validaExistenciaCadastro(usuario.getUsuario()) == null) {
            retorno = usuarioRepository.save(usuario);
        }
        return retorno != null;
    }

    public boolean alterar(Usuario usuario) {
        return usuarioRepository.save(usuario) != usuario;
    }

    public List<Usuario> login(String usuario, String senha) {
        return usuarioRepository.login(usuario, senha);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }


}
