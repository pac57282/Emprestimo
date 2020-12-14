/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.dao;

import br.com.emprestimo.entidade.Bibliotecario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @brief Nome da Classe: BibliotecarioDaoImpl
 * @package Nome do Pacote: br.com.emprestimo.dao
 * @project Nome do Projeto: Emprestimo
 * @author Autor: Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date Data: 14/12/2020
 */
public class BibliotecarioDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "INSERT INTO bibliotecario(cdBibliotecario, Login, Senha, Nome, Logradouro, Cidade, Estado, CEP) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, bibliotecario.getCdBibliotecario());
            preparando.setString(2, bibliotecario.getLogin());
            preparando.setString(3, bibliotecario.getSenha());
            preparando.setString(4, bibliotecario.getNome());
            preparando.setString(5, bibliotecario.getLogradouro());
            preparando.setString(6, bibliotecario.getCidade());
            preparando.setString(7, bibliotecario.getEstado());
            preparando.setString(8, bibliotecario.getCEP());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            bibliotecario.setCdBibliotecario(resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar Bibliotecario " + e.getMessage());
        }
    }

    public void alterar(Bibliotecario bibliotecario) throws SQLException {
        String sql = "UPDATE bibliotecario SET Login = ?, Senha = ?, Nome = ?, Logradouro = ?, Cidade = ?, Estado = ?, CEP = ? WHERE cdBibliotecario = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, bibliotecario.getLogin());
            preparando.setString(2, bibliotecario.getSenha());
            preparando.setString(3, bibliotecario.getNome());
            preparando.setString(4, bibliotecario.getLogradouro());
            preparando.setString(5, bibliotecario.getCidade());
            preparando.setString(6, bibliotecario.getEstado());
            preparando.setString(7, bibliotecario.getCEP());
            preparando.setInt(8, bibliotecario.getCdBibliotecario());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Bibliotecario " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM bibliotecario WHERE cdBibliotecario = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
