package com.example.AulaSecurity.controller;

import com.example.AulaSecurity.model.ProdutoModel;
import com.example.AulaSecurity.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', ROLE_ADMIN')")
    public List<ProdutoModel> mostrarProdutos(){
        return produtoService.mostrarProdutos();
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel){
        return produtoService.criarProduto(produtoModel);
    }
}
