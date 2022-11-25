public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean isMoveSectorEmpty = false;
        if ((line == toLine) && ((toColumn - column) != 0)) {
            for (int i = column + 1; i < toColumn; i++) {
                if ((chessBoard.board[line][i] != null)) {
                    isMoveSectorEmpty = false;
                }
            }
        } else if ((column == toColumn) && ((toLine - line) != 0)) {
            for (int i = line + 1; i < toLine; i++) {
                if (chessBoard.board[i][column] != null) {
                    isMoveSectorEmpty = false;
                }
            }
        } else {
            isMoveSectorEmpty = true;
        }

        boolean isRightPosition;
        if ((line == toLine) && ((toColumn - column) != 0)) {
            isRightPosition = true;
        } else if (column == toColumn && (toLine - line) != 0) {
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
                        !chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
