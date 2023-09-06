package com.example.AulaSecurity.service;

import com.example.AulaSecurity.model.ProdutoModel;
import com.example.AulaSecurity.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;


    public List<ProdutoModel> mostrarProdutos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }
}
