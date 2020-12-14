/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.dao;

import br.com.emprestimo.entidade.Autores;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @brief Nome da Classe: AutoresDaoImpl
 * @package Nome do Pacote: br.com.emprestimo.dao
 * @project Nome do Projeto: Emprestimo
 * @author Autor: Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date Data: 14/12/2020
 */
public class AutoresDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Autores autores) throws SQLException {
        String sql = "INSERT INTO autores(cdAutores, nmAutor, cdLivro_FK) VALUES(?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, autores.getCdAutores());
            preparando.setString(2, autores.getNmAutor());
            preparando.setInt(3, autores.getCdLivro_FK());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            autores.setCdAutores(resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar Autores " + e.getMessage());
        }
    }

    public void alterar(Autores autores) throws SQLException {
        String sql = "UPDATE autores SET nmAutor = ?, cdLivro_FK = ? WHERE cdAutores = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, autores.getNmAutor());
            preparando.setInt(2, autores.getCdLivro_FK());
            preparando.setInt(3, autores.getCdAutores());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Autores " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM autores WHERE cdAutores = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
