package br.com.senacsp.ProjetoPI.controller;

import br.com.senacsp.ProjetoPI.dto.cliente.ClienteDTO;
import br.com.senacsp.ProjetoPI.model.Cliente;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ClienteIT {

    @Autowired
    ClienteController clienteController;

    @Test
    @Order(1)
    public void cadastrarCliente() {
        clienteController.cadastrar(criaDtoCadastrar());
        
        Cliente cliente = clienteController.buscarPorId(2).getBody();
        assert cliente != null;
        assertEquals(2L, cliente.getId());
        assertEquals("teste", cliente.getNome());
        assertEquals("111.111.111-11", cliente.getCpf());
        assertEquals(new Date("01/01/1994"), cliente.getDataNascimento());
        assertEquals("Masculino", cliente.getGenero());
        assertEquals("teste@teste.com.br", cliente.getUsuario());
        assertEquals("123", cliente.getSenha());
    }

    @Test
    @Order(2)
    public void alteraCliente() {
        clienteController.alterar(criaDtoAlterar());
        Cliente cliente = clienteController.buscarPorId(2).getBody();
        assert cliente != null;
        assertEquals("nomeAlterado", cliente.getNome());
    }

    @Test
    @Order(3)
    public void listar() {
        List<Cliente> lista = clienteController.listar().getBody();
        assert lista != null;
        assertEquals(2, lista.size());
    }

    private ClienteDTO criaDtoAlterar() {
        return new ClienteDTO(
                2L,
                "nomeAlterado",
                "111.111.111-11",
                new Date("01/01/1994"),
                "Masculino",
                "teste@teste.com.br",
                "123",
                null,
                null
        );
    }

    private ClienteDTO criaDtoCadastrar() {
        return new ClienteDTO(
                "teste",
                "111.111.111-11",
                new Date("01/01/1994"),
                "Masculino",
                "teste@teste.com.br",
                "123",
                null,
                null
        );
    }

}