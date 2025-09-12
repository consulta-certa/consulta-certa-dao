package br.com.fiap.main;

import br.com.fiap.view.ConsultaView;
import br.com.fiap.view.MenuCRUD;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ConsultaView consultaView = new ConsultaView();

        consultaView.iniciar();
    }
}