package br.com.dio.ui.custom.button;

import br.com.dio.domain.SudokuGame;
import br.com.dio.domain.SudokuValidator;

import javax.swing.*;
import java.awt.*;

public class FinishGameButton extends JButton {

    private final SudokuGame game;

    public FinishGameButton(SudokuGame game) {
        this.game = game;

        setText("Finalizar jogo");
        setFont(new Font("Arial", Font.BOLD, 12));

        // Mostra onde o programa está rodando
        String currentDir = System.getProperty("user.dir");

        // Tenta vários caminhos possíveis
        String[] possiblePaths = {
                currentDir + "/src/main/resources/icons/finish.png",
                "src/main/resources/icons/finish.png"
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
                this.setIcon(new ImageIcon(resizedImage));

                iconLoaded = true;
                break;
            }
        }

        if (!iconLoaded) {
            System.out.println("Ícone não encontrado, apenas texto.");
        }

        // Tamanho do botão (compacto)
        setPreferredSize(new Dimension(100, 35));
        setMinimumSize(new Dimension(100, 35));
        setMaximumSize(new Dimension(100, 35));

        // Posiciona o texto à direita do ícone
        setHorizontalTextPosition(SwingConstants.RIGHT);

        // Espaçamento entre ícone e texto
        setIconTextGap(5);

        // Remove margens grandes
        setMargin(new Insets(2, 5, 2, 5));

        addActionListener(e -> finishGame());
    }

    private void finishGame() {
        boolean valid = SudokuValidator.isValid(game.getBoard());

        if (valid) {
            JOptionPane.showMessageDialog(
                    this,
                    "Parabéns! Sudoku concluído corretamente 🎉",
                    "Vitória",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "O Sudoku ainda possui erros.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
