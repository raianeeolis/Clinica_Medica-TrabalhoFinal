/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.dao;

import ucb.estudo.model.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    public void inserir(Paciente paciente) throws SQLException {
        String sql = "INSERT INTO paciente (id_paciente, nome, cpf, data_nasc, convenio, prioridade) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, paciente.getIdPaciente());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getCpf());
            ps.setDate(4, Date.valueOf(paciente.getDataNascimento()));
            ps.setString(5, paciente.getConvenio());
            ps.setString(6, paciente.getPrioridade());

            ps.executeUpdate();
        }
}
    public List<Paciente> listar() throws SQLException {
        List<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Paciente p = new Paciente();
                p.setIdPaciente(rs.getInt("id_paciente"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setDataNascimento(rs.getDate("data_nasc").toLocalDate());
                p.setConvenio(rs.getString("convenio"));
                p.setPrioridade(rs.getString("prioridade"));
                lista.add(p);
            }
        }
        return lista;
    }

    public void atualizar(Paciente paciente) throws SQLException {
        String sql = "UPDATE paciente SET nome=?, cpf=?, data_nasc=?, convenio=?, prioridade=? WHERE id_paciente=?";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());
            ps.setDate(3, Date.valueOf(paciente.getDataNascimento()));
            ps.setString(4, paciente.getConvenio());
            ps.setString(5, paciente.getPrioridade());
            ps.setInt(6, paciente.getIdPaciente());

            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM paciente WHERE id_paciente=?";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
