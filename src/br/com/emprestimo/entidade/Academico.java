/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.emprestimo.entidade;

import java.io.Serializable;

/**
 * @brief   Nome da Classe:   Academico
 * @package Nome do Pacote:   br.com.emprestimo.entidade
 * @project Nome do Projeto:  Emprestimo 
 * @author  Autor:            Marcelo do Nascimento <marcelo.nascimento@alunos.sc.senac.br>
 * @date    Data:             14/12/2020
 */
public class Academico implements Serializable {

    private Integer cdMatricula;
    private String nmAcademico;
    private Integer CPF;
    private String dsEmail;
    private String dsEndereco;
    private Integer idSexo;
    private Integer idade;

    public Academico() {
    }

    public Academico(Integer cdMatricula, String nmAcademico, Integer CPF, String dsEmail, String dsEndereco, Integer idSexo, Integer idade) {
        this.cdMatricula = cdMatricula;
        this.nmAcademico = nmAcademico;
        this.CPF = CPF;
        this.dsEmail = dsEmail;
        this.dsEndereco = dsEndereco;
        this.idSexo = idSexo;
        this.idade = idade;
    }

    public Integer getCdMatricula() {
        return cdMatricula;
    }

    public void setCdMatricula(Integer cdMatricula) {
        this.cdMatricula = cdMatricula;
    }

    public String getNmAcademico() {
        return nmAcademico;
    }

    public void setNmAcademico(String nmAcademico) {
        this.nmAcademico = nmAcademico;
    }

    public Integer getCPF() {
        return CPF;
    }

    public void setCPF(Integer CPF) {
        this.CPF = CPF;
    }

    public String getDsEmail() {
        return dsEmail;
    }

    public void setDsEmail(String dsEmail) {
        this.dsEmail = dsEmail;
    }

    public String getDsEndereco() {
        return dsEndereco;
    }

    public void setDsEndereco(String dsEndereco) {
        this.dsEndereco = dsEndereco;
    }

    public Integer getIdSexo() {
        return idSexo;
    }

    public void setIdSexo(Integer idSexo) {
        this.idSexo = idSexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}
