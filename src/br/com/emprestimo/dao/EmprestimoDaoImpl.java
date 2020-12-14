/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.dao;

import br.com.emprestimo.entidade.Emprestimo;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @brief Nome da Classe: EmprestimoDaoImpl
 * @package Nome do Pacote: br.com.emprestimo.dao
 * @project Nome do Projeto: Emprestimo
 * @author Autor: Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date Data: 14/12/2020
 */
public class EmprestimoDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Emprestimo emprestimo) throws SQLException {
        String sql = "INSERT INTO emprestimo(cdEmprestimo, cdUsuario, cdBibliotecario, cdLivro, dtDevolucao, dtRetirada) VALUES(?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, emprestimo.getCdEmprestimo());
            preparando.setInt(2, emprestimo.getCdUsuario());
            preparando.setInt(3, emprestimo.getCdBibliotecario());
            preparando.setInt(4, emprestimo.getCdLivro());
            preparando.setDate(5, emprestimo.getDtDevolucao());
            preparando.setDate(6, emprestimo.getDtRetirada());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            emprestimo.setCdEmprestimo(resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar Emprestimo " + e.getMessage());
        }
    }

    public void alterar(Emprestimo emprestimo) throws SQLException {
        String sql = "UPDATE emprestimo SET cdUsuario = ?, cdBibliotecario = ?, cdLivro = ?, dtDevolucao = ?, dtRetirada = ? WHERE cdEmprestimo = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setInt(1, emprestimo.getCdUsuario());
            preparando.setInt(2, emprestimo.getCdBibliotecario());
            preparando.setInt(3, emprestimo.getCdLivro());
            preparando.setDate(4, emprestimo.getDtDevolucao());
            preparando.setDate(5, emprestimo.getDtRetirada());
            preparando.setInt(6, emprestimo.getCdEmprestimo());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Emprestimo " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM emprestimo WHERE cdEmprestimo = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
