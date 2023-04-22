package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.model.Usuario;
import br.com.senacsp.ProjetoPI.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void alterar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void habilitarOuDesabilitar(Usuario usuario) {
        usuarioRepository.habilitarOuDesabilitar(usuario.getStatus(), usuario.getId());
    }

    public Usuario login(String usuario, String senha) {
        Usuario usuarioEncontrado = usuarioRepository.login(usuario, senha);
        if (usuarioEncontrado == null) {
            throw new NullPointerException("Não encontrado!");
        }
        return usuarioEncontrado;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> listarTodosComFiltro(Usuario usuario) {
        return usuarioRepository.listarComFiltro(usuario.getUsuario());
    }
}
