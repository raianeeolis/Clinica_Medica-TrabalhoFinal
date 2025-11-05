/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.model;

import java.time.LocalDate;

public class Medico extends Pessoa{
    private int idMedico;
    private String especializacao;
    private String disponibilidade;

    public Medico() {
        super();
    }
    
    public Medico(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
    }
    
    public Medico(String nome, String cpf, LocalDate dataNascimento, String especializacao, String disponibilidade) {
        this(nome, cpf, dataNascimento);
        this.especializacao = especializacao;
        this.disponibilidade = disponibilidade;
    }
    
    public Medico(int idMedico, String nome, String cpf, LocalDate dataNascimento, String especializacao, String disponibilidade) {
        this(nome, cpf, dataNascimento, especializacao, disponibilidade);
        this.idMedico = idMedico;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
