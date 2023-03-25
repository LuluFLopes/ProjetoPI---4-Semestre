package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public void cadastrar(Produto produto) {
       produtoRepository.save(produto);
    }

    @Transactional
    public void alterar(Produto produto) {
        produtoRepository.save(produto);
    }

    public Page<Produto> listar(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

}
