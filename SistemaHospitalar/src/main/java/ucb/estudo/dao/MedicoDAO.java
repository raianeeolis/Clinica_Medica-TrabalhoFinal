/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.dao;

import ucb.estudo.model.Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
     public void inserir(Medico medico) throws SQLException {
        String sql = "INSERT INTO medico (id_medico, nome, cpf, data_nasc, especialidade, disponibilidade) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, medico.getIdMedico());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getCpf());
            ps.setDate(4, Date.valueOf(medico.getDataNascimento()));
            ps.setString(5, medico.getEspecializacao());
            ps.setString(6, medico.getDisponibilidade());

            ps.executeUpdate();
        }
    }

    public List<Medico> listar() throws SQLException {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico";

        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Medico m = new Medico();
                m.setIdMedico(rs.getInt("id_medico"));
                m.setNome(rs.getString("nome"));
                m.setCpf(rs.getString("cpf"));
                m.setDataNascimento(rs.getDate("data_nasc").toLocalDate());
                m.setEspecializacao(rs.getString("especialidade"));
                m.setDisponibilidade(rs.getString("disponibilidade"));
                lista.add(m);
            }
        }
        return lista;
    }

    public void atualizar(Medico medico) throws SQLException {
        String sql = "UPDATE medico SET nome=?, cpf=?, data_nasc=?, especialidade=?, disponibilidade=? WHERE id_medico=?";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCpf());
            ps.setDate(3, Date.valueOf(medico.getDataNascimento()));
            ps.setString(4, medico.getEspecializacao());
            ps.setString(5, medico.getDisponibilidade());
            ps.setInt(6, medico.getIdMedico());

            ps.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM medico WHERE id_medico=?";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
