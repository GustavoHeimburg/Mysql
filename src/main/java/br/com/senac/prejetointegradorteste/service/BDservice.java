package br.com.senac.prejetointegradorteste.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDservice {
    public static void main(String[] args) throws SQLException {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/senac_projeto", "root", "root");
            Statement stmt = conexao.createStatement();

            String nome = "Giovane";
            String senha = "Pop232";
            String sql = "INSERT INTO usuarios (nome, senha) VALUES ('" + nome + "', '" + senha + "')";
            stmt.executeUpdate(sql);

            ResultSet rsUsuarios = stmt.executeQuery("SELECT * FROM usuarios");
            while (rsUsuarios.next()) {
                System.out.println("nome: " + rsUsuarios.getString("nome"));
                System.out.println("senha: " + rsUsuarios.getString("senha"));
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("O driver de conexao nao foi encontado");
        } catch (SQLException e) {
            System.out.println("Algum erro ao acessar o banco");
            e.printStackTrace();
        } finally {
            if (conexao != null) conexao.close();
        }
    }
}
