/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.control;

import ucb.estudo.dao.PacienteDAO;
import ucb.estudo.model.Paciente;
import java.sql.SQLException;
import java.util.List;

public class PacienteController {
    private final PacienteDAO pacienteDAO = new PacienteDAO();

    public void adicionarPaciente(Paciente paciente) {
        try {
            pacienteDAO.inserir(paciente);
            System.out.println("Paciente cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar paciente: " + e.getMessage());
        }
    }

    public List<Paciente> listarPacientes() {
        try {
            return pacienteDAO.listar();
        } catch (SQLException e) {
            System.err.println("Erro ao listar pacientes: " + e.getMessage());
            return null;
        }
    }

    public void atualizarPaciente(Paciente paciente) {
        try {
            pacienteDAO.atualizar(paciente);
            System.out.println("Paciente atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    public void excluirPaciente(int idPaciente) {
    try {
        pacienteDAO.excluir(idPaciente);
        System.out.println("Paciente excluído com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao excluir paciente: " + e.getMessage());
        }
    }
}
