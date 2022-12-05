package dao;

import model.AlunoAcademia;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSetEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoAcademiaDao {

    public List<AlunoAcademia> listarAluno() {

        List<AlunoAcademia> alunos = new ArrayList<AlunoAcademia>();

        try {

            Connection con = new ConnectionFactory().getConnection();

            String queryString = "";

            PreparedStatement smt = con.prepareStatement(queryString);

            ResultSet rs = smt.executeQuery();

            while (rs.next()) {

                AlunoAcademia aluno = new AlunoAcademia();

                aluno.setNome(rs.getString("Nome"));
                aluno.setPeso(rs.getFloat("Peso"));
                aluno.setAltura(rs.getFloat("Altura"));
                aluno.setObjetivo(rs.getString("Objetivo"));
                aluno.setIdade(rs.getInt("Idade"));

                alunos.add(aluno);
            }

            rs.close();
            smt.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return alunos;
    }

    public boolean incluirAluno(AlunoAcademia aluno) {

        boolean rowInserted = false;

        try {
            Connection con = new ConnectionFactory().getConnection();

            String queryString = "insert into alunoAcademia (Nome, Idade, Peso, Altura, Objetivo) values ('"
                    + aluno.getNome() + "', " + aluno.getIdade() + ", " + aluno.getPeso() + ", " + aluno.getAltura()
                    + ", '"
                    + aluno.getObjetivo() + "')";

            PreparedStatement smt = con.prepareStatement(queryString);

            smt.execute();

            con.close();

            rowInserted = true;

        } catch (SQLException e) {
            rowInserted = false;
            throw new RuntimeException(e);
        }

        return rowInserted;
    }

}
