public class Horse extends ChessPiece {

    public Horse(String color) {
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
        if ((Math.abs(toLine - line) == 2 && Math.abs(toColumn - column) == 1) || (Math.abs(toLine - line) == 1 && Math.abs(toColumn - column) == 2)) {
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
                (isRightPosition && isStayOnBoard && chessBoard.board[line][column].getColor().equals(this.color) &&
                        !chessBoard.board[toLine][toColumn].getColor().equals(this.color))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}