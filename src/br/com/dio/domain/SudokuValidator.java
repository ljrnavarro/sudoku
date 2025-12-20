package br.com.dio.domain;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {

    private SudokuValidator() {
        // impede instanciação
    }

    public static boolean isValid(SudokuBoard board) {

        // valida linhas
        for (int row = 0; row < 9; row++) {
            Set<Integer> seen = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                Integer value = board.getValue(row, col);
                if (value != null && !seen.add(value)) {
                    return false;
                }
            }
        }

        // valida colunas
        for (int col = 0; col < 9; col++) {
            Set<Integer> seen = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                Integer value = board.getValue(row, col);
                if (value != null && !seen.add(value)) {
                    return false;
                }
            }
        }

        // valida setores 3x3
        for (int boxRow = 0; boxRow < 3; boxRow++) {
            for (int boxCol = 0; boxCol < 3; boxCol++) {

                Set<Integer> seen = new HashSet<>();

                for (int row = boxRow * 3; row < boxRow * 3 + 3; row++) {
                    for (int col = boxCol * 3; col < boxCol * 3 + 3; col++) {

                        Integer value = board.getValue(row, col);
                        if (value != null && !seen.add(value)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
