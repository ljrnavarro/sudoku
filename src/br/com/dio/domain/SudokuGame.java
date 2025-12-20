package br.com.dio.domain;

public class SudokuGame {

    private final SudokuBoard board;
    private final int[][] template;

    public SudokuGame(int[][] template) {
        this.template = template;
        this.board = new SudokuBoard(template);
    }

    public SudokuBoard getBoard() {
        return board;
    }

    public void setValue(int row, int col, Integer value) {
        board.setValue(row, col, value);
    }

    public boolean isValid() {
        return SudokuValidator.isValid(board);
    }

    public boolean isComplete() {
        return board.isComplete();
    }

    /**
     * 🔁 Restaura o jogo para o estado inicial
     */
    public void reset() {
        board.reset(template);
    }
}
