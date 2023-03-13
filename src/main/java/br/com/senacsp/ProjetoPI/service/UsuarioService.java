package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.dao.UsuarioDao;
import br.com.senacsp.ProjetoPI.dto.LoginDTO;
import br.com.senacsp.ProjetoPI.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    public UsuarioDao usuarioDao;

    @Transactional
    public boolean cadastrar(Usuario usuario) {
        return usuarioDao.salvar(usuario);
    }

    @Transactional
    public List<Usuario> login() {
        return usuarioDao.login();
    }

    @Transactional
    public boolean alterar(Usuario usuario) {
        return usuarioDao.alterar(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioDao.listarTodos();
    }
}
