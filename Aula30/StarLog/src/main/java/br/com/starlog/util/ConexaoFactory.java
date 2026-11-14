package br.com.starlog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    private static final String URL = "jdbc:sqlite:starlog.db";

    private ConexaoFactory() {
        // Evita instanciação da classe utilitária.
    }

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
