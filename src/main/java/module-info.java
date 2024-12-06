module org.gerenciamentolivros {
    requires javafx.controls;
    requires javafx.fxml;

    // Configurações do Hibernat, Postgres e Lombok
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires jakarta.persistence;
    requires static lombok;

    opens org.gerenciamentolivros to javafx.fxml;
    exports org.gerenciamentolivros;
    exports org.gerenciamentolivros.controller;
    opens org.gerenciamentolivros.controller to javafx.fxml;
}