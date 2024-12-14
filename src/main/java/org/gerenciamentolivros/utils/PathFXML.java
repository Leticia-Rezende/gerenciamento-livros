package org.gerenciamentolivros.utils;

import java.nio.file.Paths;

public class PathFXML {
    public static String pathBase() {
        return Paths.get("C:\\Users\\Unifan\\Desktop\\aquiiiii\\gerenciamento-livros\\src\\main\\java\\org\\gerenciamentolivros\\view").toAbsolutePath().toString();
    }
}
