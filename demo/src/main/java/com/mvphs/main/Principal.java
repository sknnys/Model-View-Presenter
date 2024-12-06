package com.mvphs.main;

import com.mvphs.model.ProdutoCollection;
import com.mvphs.presenter.InclusaoProdutoPresenter;


public class Principal {
    public static void main(String[] args) {
        ProdutoCollection produtos = new ProdutoCollection();
        new InclusaoProdutoPresenter(produtos);
    }
}