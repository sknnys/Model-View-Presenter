package com.mvphs.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoCollection {
    private List<Produto> produtos;

    public ProdutoCollection() {
        produtos = new ArrayList<>();
    }

    public void incluir(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("Informe um produto válido");
        }
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Optional<Produto> findProdutoByNome(String nome) {
        return produtos.stream()
                .filter(produto -> produto.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }
}
