/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.entidade;

import java.io.Serializable;
import java.sql.Date;

/**
 * @brief   Nome da Classe:   Emprestimo
 * @package Nome do Pacote:   br.com.emprestimo.entidade
 * @project Nome do Projeto:  Emprestimo 
 * @author  Autor:            Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date    Data:             14/12/2020
 */
public class Emprestimo implements Serializable {

    private Integer cdEmprestimo;
    private Integer cdUsuario;
    private Integer cdBibliotecario;
    private Integer cdLivro;
    private Date dtDevolucao;
    private Date dtRetirada;

    public Emprestimo() {
    }

    public Emprestimo(Integer cdEmprestimo, Integer cdUsuario, Integer cdBibliotecario, Integer cdLivro, Date dtDevolucao, Date dtRetirada) {
        this.cdEmprestimo = cdEmprestimo;
        this.cdUsuario = cdUsuario;
        this.cdBibliotecario = cdBibliotecario;
        this.cdLivro = cdLivro;
        this.dtDevolucao = dtDevolucao;
        this.dtRetirada = dtRetirada;
    }

    public Integer getCdEmprestimo() {
        return cdEmprestimo;
    }

    public void setCdEmprestimo(Integer cdEmprestimo) {
        this.cdEmprestimo = cdEmprestimo;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public Integer getCdBibliotecario() {
        return cdBibliotecario;
    }

    public void setCdBibliotecario(Integer cdBibliotecario) {
        this.cdBibliotecario = cdBibliotecario;
    }

    public Integer getCdLivro() {
        return cdLivro;
    }

    public void setCdLivro(Integer cdLivro) {
        this.cdLivro = cdLivro;
    }

    public Date getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public Date getDtRetirada() {
        return dtRetirada;
    }

    public void setDtRetirada(Date dtRetirada) {
        this.dtRetirada = dtRetirada;
    }

}
