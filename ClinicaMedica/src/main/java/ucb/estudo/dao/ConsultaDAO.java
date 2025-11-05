/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.estudo.dao;

import ucb.estudo.model.Consulta;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
     public void inserir(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consulta (id_consulta, id_medico, id_paciente, data_consulta, horario) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, consulta.getIdConsulta());
            ps.setString(2, consulta.getIdMedico());
            ps.setString(3, consulta.getIdPaciente());
            ps.setDate(4, Date.valueOf(consulta.getDataConsulta()));
            ps.setTime(5, Time.valueOf(consulta.getHorario()));

            ps.executeUpdate();
        }
    }

    public List<Consulta> listar() throws SQLException {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta";

        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Consulta consulta = new Consulta();

                consulta.setIdConsulta(rs.getString("id_consulta"));
                consulta.setIdMedico(rs.getString("id_medico"));
                consulta.setIdPaciente(rs.getString("id_paciente"));

                Date data = rs.getDate("data_consulta");
                if (data != null) {
                    consulta.setDataConsulta(data.toLocalDate());
                }

                Time hora = rs.getTime("horario");
                if (hora != null) {
                    consulta.setHorario(hora.toLocalTime());
                }

                lista.add(consulta);
            }
        }
        return lista;
    }

    public void atualizar(Consulta consulta) throws SQLException {
        String sql = """
                     UPDATE consulta
                     SET id_medico=?, id_paciente=?, data_consulta=?, horario=?
                     WHERE id_consulta=?
                     """;
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, consulta.getIdMedico());
            ps.setString(2, consulta.getIdPaciente());
            ps.setDate(3, Date.valueOf(consulta.getDataConsulta()));
            ps.setTime(4, Time.valueOf(consulta.getHorario()));
            ps.setString(5, consulta.getIdConsulta());

            ps.executeUpdate();
        }
    }

    public void excluir(String idConsulta) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id_consulta=?";
        try (Connection conexao = ConexaoMySQL.getConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, idConsulta);
            ps.executeUpdate();
        }
    }
}
