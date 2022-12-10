package view;

import javax.swing.*;

import dao.AlunoAcademiaDao;
import model.AlunoAcademia;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class frmTPAcad implements ActionListener {

    private JFrame jf = new JFrame();

    private JLabel lblNome, lblIdade, lblPeso, lblAltura, lblObjetivo;

    private JTextField txtNome, txtIdade, txtPeso, txtAltura, txtObjetivo;

    private JButton btnMostrarDados, btnIncluir, btnSair, btnLimpar;

    Gson gson = new Gson();
    String aux = "";

    frmTPAcad() {

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(3, 2, 5, 5));

        lblNome = new JLabel("Nome");
        txtNome = new JTextField(20);

        lblIdade = new JLabel("Idade");
        txtIdade = new JTextField(20);

        lblPeso = new JLabel("Peso");
        txtPeso = new JTextField(20);

        lblAltura = new JLabel("Altura");
        txtAltura = new JTextField(20);

        lblObjetivo = new JLabel("Objetivo");
        txtObjetivo = new JTextField(2);

        p1.add(lblNome);
        p1.add(txtNome);

        p1.add(lblIdade);
        p1.add(txtIdade);

        p1.add(lblPeso);
        p1.add(txtPeso);

        p1.add(lblAltura);
        p1.add(txtAltura);

        p1.add(lblObjetivo);
        p1.add(txtObjetivo);

        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));

        btnMostrarDados = new JButton("Mostrar");
        btnIncluir = new JButton("Incluir");
        btnSair = new JButton("Sair");
        btnLimpar = new JButton("Limpar");

        btnMostrarDados.addActionListener(this);
        btnIncluir.addActionListener(this);
        btnSair.addActionListener(this);
        btnLimpar.addActionListener(this);

        p2.add(btnIncluir);
        p2.add(btnMostrarDados);
        p2.add(btnLimpar);
        p2.add(btnSair);

        jf.add(p1, "North");
        jf.add(p2, "South");

        jf.setVisible(true);
        jf.setSize(400, 180);
        jf.setTitle("TRABALHO PRATICO ACADEMIA");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnIncluir) {

            JOptionPane showBox = new JOptionPane();

            AlunoAcademiaDao alunoDao = new AlunoAcademiaDao();
            AlunoAcademia aluno = new AlunoAcademia();

            aluno.setNome(txtNome.getText());
            aluno.setIdade(Integer.parseInt(txtIdade.getText()));
            aluno.setPeso(Float.parseFloat(txtPeso.getText()));
            aluno.setAltura(Float.parseFloat(txtAltura.getText()));
            aluno.setObjetivo(txtObjetivo.getText());

            if (alunoDao.incluirAluno(aluno)) {
                showBox.showMessageDialog(jf, "Aluno incluido com sucesso");
            } else {
                showBox.showMessageDialog(jf, "Aluno não foi incluido");
            }

            aux = gson.toJson(aluno);
        } else if (e.getSource() == btnLimpar) {
            txtNome.setText("");
            txtIdade.setText("");
            txtPeso.setText("");
            txtAltura.setText("");
            txtObjetivo.setText("");
        } else if (e.getSource() == btnSair) {
            System.exit(0);
        } else if (e.getSource() == btnMostrarDados) {
            JOptionPane showBox = new JOptionPane();

            AlunoAcademia aluno = gson.fromJson(aux, AlunoAcademia.class);

            String msg = "Nome: " + aluno.getNome() + " Idade: " + aluno.getIdade() + " Peso: " + aluno.getPeso()
                    + " Altura: " + aluno.getAltura() + " Objetivo: " + aluno.getObjetivo();

            showBox.showMessageDialog(jf, msg);
        }

    }

}
