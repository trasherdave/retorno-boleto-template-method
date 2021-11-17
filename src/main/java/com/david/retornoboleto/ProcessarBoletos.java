package com.david.retornoboleto;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessarBoletos {

    private final Function<String[], Boleto> processarLinhaArquivo;

    public ProcessarBoletos(Function<String[], Boleto> processarLinhaArquivo) {
        this.processarLinhaArquivo = processarLinhaArquivo;
    }

    public List<Boleto> processar(String nomeArquivo) {

        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(nomeArquivo));

            String line;
            List<Boleto> boletos = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] vetor = line.split(";");
                Boleto boleto = processarLinhaArquivo.apply(vetor);
                boletos.add(boleto);
                System.out.println(boleto);

            }

            return boletos;

        } catch (IOException ex) {
            Logger.getLogger(ProcessarBoletos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }

        return null;
    }

}
