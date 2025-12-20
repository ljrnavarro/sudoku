package br.com.dio;

import br.com.dio.ui.custom.screen.MainScreen;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainScreen::new);
    }
}
