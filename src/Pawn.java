public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean isMoveSectorEmpty = false;
        if ((color.equals("White"))) {
            if ((line == 1 && toLine == 3 && column == toColumn) &&
                    chessBoard.board[line + 1][column] == null && chessBoard.board[line + 2][column] == null) {
                isMoveSectorEmpty = true;
            } else if ((toLine - line) == 1 && column == toColumn && chessBoard.board[line + 1][column] == null) {
                isMoveSectorEmpty = true;
            }
        } else if ((color.equals("Black"))) {
            if ((line == 6 && toLine == 4 && column == toColumn) &&
                    chessBoard.board[line - 1][column] == null && chessBoard.board[line - 2][column] == null) {
                isMoveSectorEmpty = true;
            } else if ((toLine - line) == -1 && column == toColumn && chessBoard.board[line - 1][column] == null) {
                isMoveSectorEmpty = true;
            }
        } else {
            isMoveSectorEmpty = false;
        }

        boolean isRightPosition;
        if (color.equals("White") && ((line == 1 && toLine == 3 && column == toColumn) || ((toLine - line) == 1 && column == toColumn))) {
            isRightPosition = true;
        } else if (color.equals("Black") && ((line == 6 && toLine == 4 && column == toColumn) || ((toLine - line) == -1 && column == toColumn))) {
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
        } else{
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}