package com.david.retornoboleto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class LeituraRetorno {

    static DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LeituraRetorno() {
    }

    public static Boleto processarLinhaBancoBrasil(String[] vetorLinhaArq) {

        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[2], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArq[3], FORMATO_DATA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetorLinhaArq[4]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[5]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[6]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[7]));
        return boleto;

    }

     public static Boleto processarLinhaBancoBadresco(String[] vetorLinhaArq) {

        Boleto boleto = new Boleto();
        boleto.setId(Integer.parseInt(vetorLinhaArq[0]));
        boleto.setCodBanco(vetorLinhaArq[1]);
        boleto.setAgencia(vetorLinhaArq[2]);
        boleto.setContaBancaria(vetorLinhaArq[3]);
        boleto.setDataVencimento(LocalDate.parse(vetorLinhaArq[4], FORMATO_DATA));
        boleto.setDataPagamento(LocalDate.parse(vetorLinhaArq[5], FORMATO_DATA_HORA).atTime(0, 0, 0));
        boleto.setCpfCliente(vetorLinhaArq[6]);
        boleto.setValor(Double.parseDouble(vetorLinhaArq[7]));
        boleto.setMulta(Double.parseDouble(vetorLinhaArq[8]));
        boleto.setJuros(Double.parseDouble(vetorLinhaArq[9]));
        return boleto;

    }

}
