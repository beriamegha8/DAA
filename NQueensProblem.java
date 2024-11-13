import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private int n;
    private List<List<String>> solutions;

    public NQueens(int n) {
        this.n = n;
        solutions = new ArrayList<>();
    }

    public List<List<String>> solveNQueens() {
        // Initialize an empty board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Use '.' to indicate an empty space
            }
        }
        
        // Start placing queens from the first row
        placeQueen(board, 0);
        return solutions;
    }

    private void placeQueen(char[][] board, int row) {
        // If all queens are placed, add the solution to the list
        if (row == n) {
            solutions.add(constructSolution(board));
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                // Place the queen
                board[row][col] = 'Q';
                // Recurse to place queens in the next row
                placeQueen(board, row + 1);
                // Backtrack: Remove the queen from the current position
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        // Check column for another queen
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check left diagonal for another queen
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check right diagonal for another queen
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }

    public static void main(String[] args) {
        int n = 4; // Change this value for different board sizes
        NQueens nQueens = new NQueens(n);
        List<List<String>> solutions = nQueens.solveNQueens();
        
        // Display all solutions
        System.out.println("All solutions for " + n + "-Queens:");
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
