package br.com.dio.ui.custom.frame;

import br.com.dio.domain.SudokuGame;
import br.com.dio.ui.custom.panel.MainPanel;
import br.com.dio.ui.custom.button.CheckGameStatusButton;
import br.com.dio.ui.custom.button.FinishGameButton;
import br.com.dio.ui.custom.button.ResetButton;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(SudokuGame game) {

        setTitle("Sudoku");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        MainPanel mainPanel = new MainPanel(game);
        JPanel buttonPanel = new JPanel();

        // Mostra onde o programa está rodando
        String currentDir = System.getProperty("user.dir");

        // Tenta vários caminhos possíveis
        String[] possiblePaths = {
                currentDir + "/src/main/resources/icons/sudoku.png",
                "src/main/resources/icons/sudoku.png"
        };

        boolean iconLoaded = false;

        for (String path : possiblePaths) {
            java.io.File file = new java.io.File(path);
            if (file.exists()) {

                // Carrega o ícone
                ImageIcon originalIcon = new ImageIcon(path);

                // ÍCONE BEM PEQUENO (16x16 pixels)
                Image image = originalIcon.getImage();
                Image resizedImage = image.getScaledInstance(
                        16, // Largura BEM PEQUENA
                        16, // Altura BEM PEQUENA
                        Image.SCALE_SMOOTH
                );

                // Define o ícone redimensionado
                ImageIcon icon = new ImageIcon(path);
                this.setIconImage(icon.getImage());

                iconLoaded = true;
                break;
            }
        }

        if (!iconLoaded) {
            System.out.println("Ícone não encontrado, apenas texto.");
        }

        buttonPanel.add(new CheckGameStatusButton(game));
        buttonPanel.add(new FinishGameButton(game));
        buttonPanel.add(new ResetButton(game, mainPanel));

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
