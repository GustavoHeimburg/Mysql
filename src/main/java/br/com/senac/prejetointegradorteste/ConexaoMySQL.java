package br.com.senac.prejetointegradorteste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoMySQL {
    public static String status = "Não conectou...";

    public static Connection getConexaoMySQL() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String mydatabase = "senac_projeto";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?serverTimezone=America/Brasília";
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar a conexão");
            }

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conexao = ConexaoMySQL.getConexaoMySQL();
        if (conexao == null) {
            System.out.println("Não foi possível estabelecer uma conexão com o banco de dados.");
            return;
        }

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conexao.createStatement();
            String sql = "SELECT materia, formula FROM materia_formula";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String materia = rs.getString("materia");
                String formula = rs.getString("formula");
                System.out.println("Materia: " + materia + ", Formula: " + formula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

