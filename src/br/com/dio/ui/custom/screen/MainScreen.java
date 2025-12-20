package br.com.dio.ui.custom.screen;

import br.com.dio.domain.SudokuGame;
import br.com.dio.ui.custom.frame.MainFrame;
import br.com.dio.util.BoardTemplate;

public class MainScreen {

    public MainScreen() {
        SudokuGame game = new SudokuGame(BoardTemplate.TEMPLATE);
        new MainFrame(game);
    }
}
