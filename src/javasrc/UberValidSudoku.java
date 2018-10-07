package javasrc;

public class UberValidSudoku {
    // index can present multiple systems
    // for each point validate three matrix same time (row#, col#, cube#->translate into row and col#)
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            int row = 0;
            int column = 0;
            int cube = 0;
            for (int j = 0; j < 9;j++){
                if(board[i][j]!='.' && ((row & (1 << board[i][j] - '0')) != 0)) {
                    return false;
                }
                if (board[i][j]!='.') {
                    row |= 1 << board[i][j] - '0';
                }
                if(board[j][i]!='.' && ((column & (1 << board[j][i] - '0')) != 0)) {
                    return false;
                }
                if (board[j][i]!='.') {
                    column |= 1 << board[j][i] - '0';
                }
                int RowIndex = 3*(i/3);
                int ColIndex = 3*(i%3);
                if(board[RowIndex + j/3][ColIndex + j%3]!='.' && ((cube & (1 << board[RowIndex + j/3][ColIndex + j%3] - '0')) != 0)) {
                    return false;
                }
                if (board[RowIndex + j/3][ColIndex + j%3]!='.') {
                    cube |= 1 << board[RowIndex + j/3][ColIndex + j%3] - '0';
                }

            }
        }
        return true;
    }
}
