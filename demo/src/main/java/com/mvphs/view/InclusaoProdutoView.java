package com.mvphs.view;

import javax.swing.*;
import java.awt.*;

public class InclusaoProdutoView extends JFrame {
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblPrecoCusto;
    private JTextField txtPrecoCusto;
    private JLabel lblPercentualLucro;
    private JTextField txtPercentualLucro;
    private JLabel lblPrecoVenda;
    private JTextField txtPrecoVenda;
    private JButton btnIncluir;
    private JButton btnCancelar;

    public InclusaoProdutoView() {
        setTitle("Inclusão de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        lblNome = new JLabel("Nome:");
        txtNome = new JTextField();

        lblPrecoCusto = new JLabel("Preço de Custo:");
        txtPrecoCusto = new JTextField();

        lblPercentualLucro = new JLabel("Percentual de Lucro:");
        txtPercentualLucro = new JTextField();

        lblPrecoVenda = new JLabel("Preço de Venda:");
        txtPrecoVenda = new JTextField();
        txtPrecoVenda.setEditable(false);

        btnIncluir = new JButton("Incluir");
        btnCancelar = new JButton("Cancelar");

        add(lblNome);
        add(txtNome);
        add(lblPrecoCusto);
        add(txtPrecoCusto);
        add(lblPercentualLucro);
        add(txtPercentualLucro);
        add(lblPrecoVenda);
        add(txtPrecoVenda);
        add(btnIncluir);
        add(btnCancelar);

        setLocationRelativeTo(null);
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtPrecoCusto() {
        return txtPrecoCusto;
    }

    public JTextField getTxtPercentualLucro() {
        return txtPercentualLucro;
    }

    public JTextField getTxtPrecoVenda() {
        return txtPrecoVenda;
    }

    public JButton getBtnIncluir() {
        return btnIncluir;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}