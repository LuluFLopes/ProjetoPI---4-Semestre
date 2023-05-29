package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.dto.cliente.ClienteDTO;
import br.com.senacsp.ProjetoPI.model.Cliente;
import br.com.senacsp.ProjetoPI.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public List<Cliente> listar() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        if (listaClientes.size() > 0) {
            return listaClientes;
        } else {
            throw new NullPointerException("Não encontrado!");
        }
    }

    @Transactional
    public void salvar(ClienteDTO dto) {
        clienteRepository.save(dto.conversor(dto));
    }

    @Transactional
    public void alterar(ClienteDTO dto) {
        clienteRepository.save(dto.conversorParaAlterar(dto));
    }

    public Cliente login(String usuario, String senha) {
        return clienteRepository.login(usuario, senha)
                .orElseThrow(NullPointerException::new);
    }

}
