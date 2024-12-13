module org.gerenciamentolivros {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;




    // Configurações do Hibernat, Postgres e Lombok
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires jakarta.persistence;



    opens org.gerenciamentolivros to javafx.fxml;
    opens org.gerenciamentolivros.model.entity to org.hibernate.orm.core;
    exports org.gerenciamentolivros;
    exports org.gerenciamentolivros.controller;
    opens org.gerenciamentolivros.controller to javafx.fxml;
    exports org.gerenciamentolivros.model.entity;
}