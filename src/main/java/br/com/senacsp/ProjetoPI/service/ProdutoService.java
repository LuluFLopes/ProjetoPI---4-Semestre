package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.dto.produto.ProdutoDTO;
import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> listar(Pageable pageable) {
        Page<Produto> listaProdutoPaginada = produtoRepository.listagemDeProdutos(pageable);
        if (!listaProdutoPaginada.isEmpty()) {
            return listaProdutoPaginada;
        } else {
            throw new NullPointerException("Não encontrado!");
        }
    }

    public Page<Produto> listarPorNome(Pageable pageable, String nome) {
        return produtoRepository.listagemRapidaPorNome(pageable, nome);
    }

    @Transactional
    public void cadastrar(ProdutoDTO dto) {
        produtoRepository.save(dto.conversor(dto));
    }

    @Transactional
    public void alterar(ProdutoDTO dto) {
        produtoRepository.save(dto.conversor(dto));
    }

    @Transactional
    public void alterarStatus(ProdutoDTO dto) {
        Produto produto = dto.conversorAlteracaoStatus(dto);
        produtoRepository.alterarStatus(produto.getId(), produto.getStatus());
    }

}
