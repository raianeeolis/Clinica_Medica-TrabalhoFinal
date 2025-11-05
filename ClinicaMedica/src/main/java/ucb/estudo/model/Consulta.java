/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private String idConsulta;
    private String idMedico;
    private String idPaciente;
    private LocalDate dataConsulta;
    private LocalTime horario;

    public Consulta() {}

    public Consulta(String idMedico, String idPaciente) {
        this();
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
    }

    public Consulta(String idMedico, String idPaciente, LocalDate dataConsulta, LocalTime horario) {
        this(idMedico, idPaciente);
        this.dataConsulta = dataConsulta;
        this.horario = horario;
    }

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
       
}
