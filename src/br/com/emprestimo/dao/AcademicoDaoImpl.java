/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.dao;

import br.com.emprestimo.entidade.Academico;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @brief Nome da Classe: AcademicoDaoImpl
 * @package Nome do Pacote: br.com.emprestimo.dao
 * @project Nome do Projeto: Emprestimo
 * @author Autor: Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date Data: 14/12/2020
 */
public class AcademicoDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Academico academico) throws SQLException {
        String sql = "INSERT INTO academico(cdMatricula, nmAcademico, CPF, dsEmail, dsEndereco, idSexo, idade) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, academico.getCdMatricula());
            preparando.setString(2, academico.getNmAcademico());
            preparando.setInt(3, academico.getCPF());
            preparando.setString(4, academico.getDsEmail());
            preparando.setString(5, academico.getDsEndereco());
            preparando.setInt(6, academico.getIdSexo());
            preparando.setInt(7, academico.getIdade());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            academico.setCdMatricula(resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar Academico " + e.getMessage());
        }
    }

    public void alterar(Academico academico) throws SQLException {
        String sql = "UPDATE academico SET nmAcademico = ?, CPF = ?, dsEmail = ?, dsEndereco = ?, idSexo = ?, idade = ? WHERE cdMatricula = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, academico.getNmAcademico());
            preparando.setInt(2, academico.getCPF());
            preparando.setString(3, academico.getDsEmail());
            preparando.setString(4, academico.getDsEndereco());
            preparando.setInt(5, academico.getIdSexo());
            preparando.setInt(6, academico.getIdade());
            preparando.setInt(7, academico.getCdMatricula());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Academico " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM academico WHERE cdMatricula = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
