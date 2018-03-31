
/**
 *
 * @author ehn19
 */
class Player {

    private Die[] dice;
    private Board board;
    private Piece piece;

    Player(Die[] dice, Piece p, Board b) {
        this.dice = dice;
        this.board = b;
        this.piece = p;
    }

    void takeTurn() {
        int fvTotal = rollDice();
        Square s = piece.getLocation();
        Square s2 = board.getSquare(s, fvTotal);
        piece.setLocation(s2);
    }

    public int rollDice() {
        int fvTotal = 0;
        for (Die die : dice) {
            die.roll();
            fvTotal += die.getFaceValue();
        }
        return fvTotal;
    }

}
