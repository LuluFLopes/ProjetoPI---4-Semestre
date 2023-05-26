package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.dto.cliente.ClienteDTO;
import br.com.senacsp.ProjetoPI.model.Cliente;
import br.com.senacsp.ProjetoPI.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    ClienteService clienteService;

    @Mock
    ClienteRepository clienteRepository;

    @Captor
    ArgumentCaptor<Cliente> clienteCaptor;

    ClienteDTO clienteDTO;

    String usuario;

    String senha;

    Long id;

    @Test
    public void deveConverterObjetoCorretamenteAntesDeSalvar() {
        dadoUmDtoDeClienteASerInserido();
        aoIniciarOProcessoDeSalvarOClienteNoBanco();
        deveFazerAConversaoDeDtoParaClasseModeloParaOMetodoDeSalvar();
    }

    @Test
    public void deveConverterObjetoCorretamenteAntesDeAtualizar() {
        dadoUmDtoDeClienteASerAtualizado();
        aoIniciarOProcessoDeAtualizarOClienteNoBanco();
        deveFazerAConversaoDeDtoParaClasseModeloParaOMetodoDeAlterar();
    }

    @Test
    public void deveDarExceptionAposTentarLogarComUsuarioNaoCadastrado() {
        dadoUmUsuarioEUmaSenha();
        aoTentarFazerOLogin();
        deveLancarExcecaoPorNaoEncontrar();
    }

    @Test
    public void deveDarExceptionAposBuscarClienteNaoCadastrado() {
        dadoUmId();
        aoTentarBuscarOClientePorSeuId();
        deveDarLancarExcecaoPorNaoEncontrarCliente();
    }

    @Test
    public void deveLancarExceptionAoTentarListarENaoEncontrarRegistros() {
        aoTentarBuscarAListaDeClientesCadastrados();
        deveLancarExcecaoPorListaNaoTerElementos();
    }

    private void deveFazerAConversaoDeDtoParaClasseModeloParaOMetodoDeSalvar() {
        Cliente cliente = clienteCaptor.getValue();

        assertEquals("teste", cliente.getNome());
        assertEquals("111.111.111-11", cliente.getCpf());
        assertEquals(new Date("01/01/1994"), cliente.getDataNascimento());
        assertEquals("Masculino", cliente.getGenero());
        assertEquals("teste@teste.com.br", cliente.getUsuario());
        assertEquals("123", cliente.getSenha());
    }

    private void aoIniciarOProcessoDeSalvarOClienteNoBanco() {
        clienteService.salvar(clienteDTO);
        verify(clienteRepository).save(clienteCaptor.capture());
    }

    private void dadoUmDtoDeClienteASerInserido() {
        clienteDTO = new ClienteDTO(
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

    private void deveFazerAConversaoDeDtoParaClasseModeloParaOMetodoDeAlterar() {
        Cliente cliente = clienteCaptor.getValue();

        assertEquals(1L, cliente.getId());
        assertEquals("teste", cliente.getNome());
        assertEquals("111.111.111-11", cliente.getCpf());
        assertEquals(new Date("01/01/1994"), cliente.getDataNascimento());
        assertEquals("Masculino", cliente.getGenero());
        assertEquals("teste@teste.com.br", cliente.getUsuario());
        assertEquals("123", cliente.getSenha());
    }

    private void aoIniciarOProcessoDeAtualizarOClienteNoBanco() {
        clienteService.alterar(clienteDTO);
        verify(clienteRepository).save(clienteCaptor.capture());
    }

    private void dadoUmDtoDeClienteASerAtualizado() {
        clienteDTO = new ClienteDTO(
                1L,
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

    private void deveLancarExcecaoPorNaoEncontrar() {
        assertThrows(NullPointerException.class, () -> clienteService.login(usuario, senha));
    }

    private void deveDarLancarExcecaoPorNaoEncontrarCliente() {
        assertThrows(NullPointerException.class, () -> clienteService.buscarPorId(id));
    }

    private void aoTentarBuscarOClientePorSeuId() {
        when(clienteRepository.findById(id)).thenReturn(null);
    }

    private void dadoUmId() {
        id = 1L;
    }

    private void aoTentarFazerOLogin() {
        when(clienteRepository.login(any(), any())).thenReturn(null);
    }

    private void dadoUmUsuarioEUmaSenha() {
        usuario = "usuario";
        senha = "123";
    }

    private void deveLancarExcecaoPorListaNaoTerElementos() {
        assertThrows(NullPointerException.class, () -> clienteService.listar());
    }

    private void aoTentarBuscarAListaDeClientesCadastrados() {
        when(clienteRepository.findAll()).thenReturn(new ArrayList<>());
    }

}