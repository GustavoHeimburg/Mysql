package br.com.senac.prejetointegradorteste;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {
public void cadastraUsuario(Usuario usuario){
        String sql = "INSERT INTO USUARIO (NOME, DESCRICAO) VALUES (?, ?)";
    PreparedStatement ps = null;
    try {
        ps = ConexaoMySQL.getConexaoMySQL().prepareStatement(sql);
        ps.setString(1, usuario.getnome());
        ps.setString(1,usuario.getDescricao());

        ps.execute();
        ps.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    private String getDescricao() {
    return null;
    }

    private String getnome() {
        return null;
    }
}
