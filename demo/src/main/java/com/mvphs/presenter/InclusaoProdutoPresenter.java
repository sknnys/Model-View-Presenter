package com.mvphs.presenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mvphs.model.Produto;
import com.mvphs.model.ProdutoCollection;
import com.mvphs.view.InclusaoProdutoView;


public class InclusaoProdutoPresenter {
    private InclusaoProdutoView view;
    private ProdutoCollection produtos;

    public InclusaoProdutoPresenter(ProdutoCollection produtos) {
        this.produtos = produtos;
        this.view = new InclusaoProdutoView();
        configuraView();
        view.setVisible(true);
    }

    private void configuraView() {
        view.getBtnIncluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.getBtnCancelar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        view.getTxtPercentualLucro().addCaretListener(e -> atualizarPrecoVenda());
    }

    private void salvar() throws Exception {
        String nome = view.getTxtNome().getText();
        if (nome == null || nome.isEmpty()) {
            throw new Exception("Nome do produto é obrigatório.");
        }

        double precoCusto = parseDouble(view.getTxtPrecoCusto().getText(), "Preço de custo");
        double percentualLucro = parseDouble(view.getTxtPercentualLucro().getText(), "Percentual de lucro");

        Produto produto = new Produto(nome, precoCusto, percentualLucro);
        produtos.incluir(produto);

        JOptionPane.showMessageDialog(view, "Produto incluído com sucesso!");
        limparCampos();
    }

    private void cancelar() {
        view.dispose();
    }

    private void atualizarPrecoVenda() {
        try {
            double precoCusto = parseDouble(view.getTxtPrecoCusto().getText(), "Preço de custo");
            double percentualLucro = parseDouble(view.getTxtPercentualLucro().getText(), "Percentual de lucro");

            Produto produto = new Produto("", precoCusto, percentualLucro);
            view.getTxtPrecoVenda().setText(String.format("%.2f", produto.calcularPrecoVenda()));
        } catch (Exception e) {
            view.getTxtPrecoVenda().setText("");
        }
    }

    private double parseDouble(String text, String campo) throws Exception {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            throw new Exception("O campo " + campo + " deve conter um número válido.");
        }
    }

    private void limparCampos() {
        view.getTxtNome().setText("");
        view.getTxtPrecoCusto().setText("");
        view.getTxtPercentualLucro().setText("");
        view.getTxtPrecoVenda().setText("");
    }
}