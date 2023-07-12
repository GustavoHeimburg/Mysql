module com.senac.projetointegradorteste {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens br.com.senac.prejetointegradorteste to javafx.fxml;
    exports br.com.senac.prejetointegradorteste;
}