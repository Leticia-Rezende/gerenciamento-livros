package org.gerenciamentolivros.utils;

import java.nio.file.Paths;

public class PathFXML {
    public static String pathBase() {
        return Paths.get("src/main/java/org/gerenciamento-livros/view").toAbsolutePath().toString();
    }
}
