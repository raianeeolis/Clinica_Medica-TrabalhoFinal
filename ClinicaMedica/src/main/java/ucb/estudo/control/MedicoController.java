/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.control;

import ucb.estudo.dao.MedicoDAO;
import ucb.estudo.model.Medico;
import java.sql.SQLException;
import java.util.List;

public class MedicoController {
    private final MedicoDAO medicoDAO = new MedicoDAO();

    public void adicionarMedico(Medico medico) {
        try {
            medicoDAO.inserir(medico);
            System.out.println("Médico cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar médico: " + e.getMessage());
        }
    }

    public List<Medico> listarMedicos() {
        try {
            return medicoDAO.listar();
        } catch (SQLException e) {
            System.err.println("Erro ao listar médicos: " + e.getMessage());
            return null;
        }
    }

    public void atualizarMedico(Medico medico) {
        try {
            medicoDAO.atualizar(medico);
            System.out.println("Médico atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar médico: " + e.getMessage());
        }
    }

    public void excluirMedico(int idMedico) {
    try {
        medicoDAO.excluir(idMedico);
        System.out.println("Médico excluído com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao excluir médico: " + e.getMessage());
        }
    }
}
