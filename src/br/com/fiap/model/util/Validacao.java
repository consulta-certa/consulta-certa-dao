package br.com.fiap.model.util;

import javax.swing.*;

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
        JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas letras.");
        return entrada != null && entrada.matches("^[\\p{L}\\s]+$");
    }
}
