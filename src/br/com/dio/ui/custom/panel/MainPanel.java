package br.com.dio.ui.custom.panel;

import br.com.dio.domain.SudokuGame;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private final SudokuGame game;
    private final SudokuSector[][] sectors = new SudokuSector[3][3];

    public MainPanel(SudokuGame game) {
        this.game = game;
        initPanel();
    }

    private void initPanel() {
        // Layout 3x3 (cada célula é um setor 3x3)
        setLayout(new GridLayout(3, 3));

        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        for (int sectorRow = 0; sectorRow < 3; sectorRow++) {
            for (int sectorCol = 0; sectorCol < 3; sectorCol++) {

                SudokuSector sector = new SudokuSector(
                        game,
                        sectorRow,
                        sectorCol
                );

                sector.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                sectors[sectorRow][sectorCol] = sector;
                add(sector);
            }
        }
    }

    /**
     * Atualiza todo o tabuleiro visual a partir do estado do jogo.
     * Usado principalmente no Reset.
     */
    public void refresh() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                sectors[row][col].refresh();
            }
        }
        repaint();
        revalidate();
    }
}
