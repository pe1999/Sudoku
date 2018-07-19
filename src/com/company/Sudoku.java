package com.company;

public class Sudoku {
    int sudokuBaseSize;
    int sudokuSize;
    int[][] square;

    Sudoku(int[][] sq) {
        sudokuBaseSize = (int)Math.sqrt(sq[0].length);
        sudokuSize = sudokuBaseSize * sudokuBaseSize;
        square = new int[sudokuSize][sudokuSize];
        System.arraycopy(sq, 0, square, 0, sudokuBaseSize * sudokuBaseSize);
    }

    public void solve() {
        solveR(0);
    }

    private void solveR(int n) {
        if(n == sudokuSize * sudokuSize) return;

        int x = n % sudokuSize;
        int y = n / sudokuSize;

        if(isCellFree(x, y)) {

        }
        else
            solveR(n + 1);
    }

    private boolean isCellFree(int x, int y) {
        if(square[y][x] == 0) return true;
        return false;
    }

    public void printSquare() {
        for(int i = 0; i < sudokuSize; i++) {
            for(int j = 0; j < sudokuSize; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }

    boolean isSymbolValidToPlacementOnXY(int symbol, int x, int y){
        // Проверяем, что место свободно
        if(square[y][x] != 0) return false;

        // Проверяем строку, столбец и малый квадрат
        for(int i = 0; i < sudokuSize; i++) {
            if(square[y][i] == symbol || square[i][x] == symbol ||
               square[x - x % sudokuBaseSize + i % sudokuBaseSize][y - y % sudokuBaseSize + i / sudokuBaseSize] == symbol)
                return false;
        }
        return true;
    }
}
