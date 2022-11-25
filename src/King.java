public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean isMoveSectorEmpty;
        if (chessBoard.board[toLine][toColumn] == null) {
            isMoveSectorEmpty = true;
        } else {
            isMoveSectorEmpty = false;
        }

        boolean isRightPosition;
        if ((Math.abs(toLine - line) == 1 && toColumn == column) || (Math.abs(toColumn - column) == 1 && toLine == line) ||
                (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 1)) {
            isRightPosition = true;
        } else {
            isRightPosition = false;
        }

        boolean isStayOnBoard;
        if ((toLine <= 7) && (toLine >= 0) && (toColumn <= 7) && (toColumn >= 0)) {
            isStayOnBoard = true;
        } else {
            isStayOnBoard = false;
        }

        if ((isMoveSectorEmpty && isRightPosition && isStayOnBoard) ||
                (isMoveSectorEmpty && isRightPosition && isStayOnBoard && chessBoard.board[line][column].getColor().equals(this.color) &&
                        !chessBoard.board[toLine][toColumn].getColor().equals(this.color)))
        {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (chessBoard.board[i][j] != null) {
                    if (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i , j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}