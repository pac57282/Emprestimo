/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.entidade;

import java.io.Serializable;

/**
 * @brief   Nome da Classe:   Bibliotecario
 * @package Nome do Pacote:   br.com.emprestimo.entidade
 * @project Nome do Projeto:  Emprestimo 
 * @author  Autor:            Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date    Data:             14/12/2020
 */
public class Bibliotecario implements Serializable {

    private Integer cdBibliotecario;
    private String login;
    private String senha;
    private String nome;
    private String logradouro;
    private String cidade;
    private String estado;
    private String CEP;

    public Bibliotecario() {
    }

    public Bibliotecario(Integer cdBibliotecario, String login, String senha, String nome, String logradouro, String cidade, String estado, String CEP) {
        this.cdBibliotecario = cdBibliotecario;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.CEP = CEP;
    }

    public Integer getCdBibliotecario() {
        return cdBibliotecario;
    }

    public void setCdBibliotecario(Integer cdBibliotecario) {
        this.cdBibliotecario = cdBibliotecario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

}
