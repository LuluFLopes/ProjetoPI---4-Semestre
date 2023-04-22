package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.model.Cliente;
import br.com.senacsp.ProjetoPI.model.Usuario;
import br.com.senacsp.ProjetoPI.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){this.clienteRepository = clienteRepository; }

    @Transactional
    public void salvar (Cliente cliente){
        clienteRepository.save(cliente);
    }

    @Transactional
    public void alterar (Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public List<Cliente> login(String usuario, String senha) { return clienteRepository.login(usuario, senha); }

    public Cliente buscarCliente(Long id){
        Optional<Cliente> retornoCliente = clienteRepository.findById(id);
        return retornoCliente.orElseThrow(NullPointerException::new);
    }

}
