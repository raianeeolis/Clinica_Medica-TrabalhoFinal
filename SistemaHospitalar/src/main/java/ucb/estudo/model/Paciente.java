/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.model;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private int idPaciente;
    private String convenio;
    private String prioridade; 

    public Paciente() {
        super(); 
    }
      
    public Paciente(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
    }
    
    public Paciente(String nome, String cpf, LocalDate dataNascimento, String convenio, String prioridade) {
        this(nome, cpf, dataNascimento);
        this.convenio = convenio;
        this.prioridade = prioridade;
    }

    public Paciente(int idPaciente, String nome, String cpf, LocalDate dataNascimento, String convenio, String prioridade) {
        this(nome, cpf, dataNascimento, convenio, prioridade);
        this.idPaciente = idPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }
    
}
