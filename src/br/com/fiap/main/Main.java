package br.com.fiap.main;

import br.com.fiap.view.ConsultaView;
import br.com.fiap.view.ContatoView;
import br.com.fiap.view.MenuCRUD;
import br.com.fiap.view.PacienteView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ConsultaView consultaView = new ConsultaView();
        PacienteView pacienteView = new PacienteView();
        ContatoView contatoView = new ContatoView();

//        consultaView.iniciar();
//        pacienteView.iniciar();
        contatoView.iniciar();
    }
}