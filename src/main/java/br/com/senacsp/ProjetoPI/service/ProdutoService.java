package br.com.senacsp.ProjetoPI.service;

import br.com.senacsp.ProjetoPI.model.Produto;
import br.com.senacsp.ProjetoPI.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public boolean cadastrar(Produto produto) {
       return produtoRepository.save(produto) != produto;
    }

    @Transactional
    public boolean alterar(Produto produto) {
        return produtoRepository.save(produto) != produto;
    }

    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

}
