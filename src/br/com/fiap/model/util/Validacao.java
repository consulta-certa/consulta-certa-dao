package br.com.fiap.model.util;

import javax.swing.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Validacao {
    public static boolean validarInteger (String entrada) {
        try {
            Integer.parseInt(entrada);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas números inteiros.");
            return false;
        }
    }

    public static boolean validarDouble (String entrada) {
        try {
            Double.parseDouble(entrada);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas números reais.");
            return false;
        }
    }

    public static boolean validarString (String entrada) {
        if (entrada != null && entrada.matches("^[\\p{L}\\s]+$")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas letras.");
            return false;
        }
    }

    public static boolean validarData(String entrada) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm").withResolverStyle(ResolverStyle.STRICT);
        try {
            LocalDateTime data = LocalDateTime.parse(entrada, formatter);
            if (data.isBefore(LocalDateTime.now())) {
                JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida a partir de hoje.");
                return false;
            }

            return true;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas no formato exato 'DD/MM/AAAA HH:MM'.");
            return false;
        }
    }

    public static boolean validarEmail(String entrada) {
        if (entrada != null && entrada.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir um email.");
            return false;
        }
    }
}
