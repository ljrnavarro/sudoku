package br.com.dio.domain;

public class SudokuBoard {

    private final Cell[][] cells = new Cell[9][9];

    public SudokuBoard(int[][] template) {
        initBoard(template);
    }

    /**
     * Inicializa o tabuleiro a partir do template
     */
    private void initBoard(int[][] template) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int value = template[row][col];
                if (value == 0) {
                    cells[row][col] = new Cell(null, false);
                } else {
                    cells[row][col] = new Cell(value, true);
                }
            }
        }
    }

    /**
     * Retorna o valor da célula ou null
     */
    public Integer getValue(int row, int col) {
        return cells[row][col].getValue();
    }

    /**
     * Define valor em uma célula não fixa
     */
    public void setValue(int row, int col, Integer value) {
        Cell cell = cells[row][col];

        if (cell.isFixed()) {
            return; // não permite alteração
        }

        cell.setValue(value);
    }

    /**
     * Verifica se o tabuleiro está completamente preenchido
     */
    public boolean isComplete() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (cells[row][col].getValue() == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Reinicia o tabuleiro para o template original
     */
    public void reset(int[][] template) {
        initBoard(template);
    }

    /**
     * Acesso direto às células (usado pelo Validator)
     */
    public Cell[][] getCells() {
        return cells;
    }
}
