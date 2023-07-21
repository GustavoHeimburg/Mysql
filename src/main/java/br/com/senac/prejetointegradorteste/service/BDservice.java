package br.com.senac.prejetointegradorteste.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class  BDservice{
    public static String status = "Não conectou...";

    public static Connection getConexaoMySQL() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost";
            String mydatabase = "senac_projeto";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
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
}
