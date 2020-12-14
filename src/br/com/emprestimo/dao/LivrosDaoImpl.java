/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.dao;

import br.com.emprestimo.entidade.Livros;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @brief Nome da Classe: LivrosDaoImpl
 * @package Nome do Pacote: br.com.emprestimo.dao
 * @project Nome do Projeto: Emprestimo
 * @author Autor: Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date Data: 14/12/2020
 */
public class LivrosDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Livros livros) throws SQLException {
        String sql = "INSERT INTO livros(cdLivro, Titulo, Resumo, dtPublicacao, Edicao, nmEditora, Cidade, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, livros.getCdLivro());
            preparando.setString(2, livros.getTitulo());
            preparando.setString(3, livros.getResumo());
            preparando.setDate(4, livros.getDtPublicacao());
            preparando.setString(5, livros.getEdicao());
            preparando.setString(6, livros.getNmEditora());
            preparando.setString(7, livros.getCidade());
            preparando.setString(8, livros.getEstado());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            livros.setCdLivro(resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar Livros " + e.getMessage());
        }
    }

    public void alterar(Livros livros) throws SQLException {
        String sql = "UPDATE livros SET Titulo = ?, Resumo = ?, dtPublicacao = ?, Edicao = ?, nmEditora = ?, Cidade = ?, Estado = ? WHERE cdLivro = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, livros.getTitulo());
            preparando.setString(2, livros.getResumo());
            preparando.setDate(3, livros.getDtPublicacao());
            preparando.setString(4, livros.getEdicao());
            preparando.setString(5, livros.getNmEditora());
            preparando.setString(6, livros.getCidade());
            preparando.setString(7, livros.getEstado());
            preparando.setInt(8, livros.getCdLivro());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Livros " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM livros WHERE cdLivro = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
