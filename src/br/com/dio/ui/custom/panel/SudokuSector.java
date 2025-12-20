package br.com.dio.ui.custom.panel;

import br.com.dio.domain.SudokuGame;
import br.com.dio.ui.custom.input.NumberText;

import javax.swing.JPanel;
import java.awt.GridLayout;

public class SudokuSector extends JPanel {

    private final SudokuGame game;
    private final int sectorRow;
    private final int sectorCol;

    private final NumberText[][] fields = new NumberText[3][3];

    public SudokuSector(SudokuGame game, int sectorRow, int sectorCol) {
        this.game = game;
        this.sectorRow = sectorRow;
        this.sectorCol = sectorCol;

        initSector();
        loadValuesFromGame();
    }

    private void initSector() {
        setLayout(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                int globalRow = sectorRow * 3 + row;
                int globalCol = sectorCol * 3 + col;

                NumberText field = new NumberText();

                // Se for célula fixa, bloqueia edição
                Integer value = game.getBoard().getValue(globalRow, globalCol);
                if (value != null) {
                    field.setText(String.valueOf(value));
                    field.setEditable(false);
                }

                // Listener simples para atualizar o domínio
                field.addKeyListener(new java.awt.event.KeyAdapter() {
                    @Override
                    public void keyReleased(java.awt.event.KeyEvent e) {
                        String text = field.getText();

                        if (text == null || text.isEmpty()) {
                            game.setValue(globalRow, globalCol, null);
                        } else {
                            try {
                                game.setValue(globalRow, globalCol, Integer.parseInt(text));
                            } catch (NumberFormatException ignored) {
                            }
                        }
                    }
                });

                fields[row][col] = field;
                add(field);
            }
        }
    }

    /**
     * Atualiza visualmente o setor com base no estado atual do jogo
     */
    public void refresh() {
        loadValuesFromGame();
    }

    private void loadValuesFromGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {

                int globalRow = sectorRow * 3 + row;
                int globalCol = sectorCol * 3 + col;

                Integer value = game.getBoard().getValue(globalRow, globalCol);
                NumberText field = fields[row][col];

                if (value == null) {
                    field.setText("");
                    field.setEditable(true);
                } else {
                    field.setText(String.valueOf(value));
                }
            }
        }
    }
}
