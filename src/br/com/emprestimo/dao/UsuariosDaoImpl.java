/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.dao;

import br.com.emprestimo.entidade.Usuarios;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @brief Nome da Classe: UsuariosDaoImpl
 * @package Nome do Pacote: br.com.emprestimo.dao
 * @project Nome do Projeto: Emprestimo
 * @author Autor: Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date Data: 14/12/2020
 */
public class UsuariosDaoImpl implements Serializable {

    protected Connection conexao;
    protected PreparedStatement preparando;
    protected ResultSet resultSet;

    public void salvar(Usuarios usuarios) throws SQLException {
        String sql = "INSERT INTO usuarios(cdUsuario, Nome, Login, Senha, Logradouro, Cidade, Estado, CEP) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparando.setInt(1, usuarios.getCdUsuario());
            preparando.setString(2, usuarios.getNome());
            preparando.setString(3, usuarios.getLogin());
            preparando.setString(4, usuarios.getSenha());
            preparando.setString(5, usuarios.getLogradouro());
            preparando.setString(6, usuarios.getCidade());
            preparando.setString(7, usuarios.getEstado());
            preparando.setString(8, usuarios.getCEP());
            preparando.executeUpdate();
            resultSet = preparando.getGeneratedKeys();
            resultSet.next();
            usuarios.setCdUsuario(resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("Erro ao salvar Usuario " + e.getMessage());
        }
    }

    public void alterar(Usuarios usuarios) throws SQLException {
        String sql = "UPDATE usuarios SET Nome = ?, Login = ?, Senha = ?, Logradouro = ?, Cidade = ?, Estado = ?, CEP = ? WHERE cdUsuario = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement(sql);
            preparando.setString(1, usuarios.getNome());
            preparando.setString(2, usuarios.getLogin());
            preparando.setString(3, usuarios.getSenha());
            preparando.setString(4, usuarios.getLogradouro());
            preparando.setString(5, usuarios.getCidade());
            preparando.setString(6, usuarios.getEstado());
            preparando.setString(7, usuarios.getCEP());
            preparando.setInt(8, usuarios.getCdUsuario());
            preparando.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao alterar Usuario " + e.getMessage());
        }
    }

    public void excluir(Integer id) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparando = conexao.prepareStatement("DELETE FROM usuarios WHERE cdUsuario = ?");
            preparando.setInt(1, id);
            preparando.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir " + e.getMessage());
        } finally {
            FabricaConexao.fecharConexao(conexao, preparando);
        }
    }

}
