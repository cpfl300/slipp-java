package pieces;

import static pieces.Piece.Color.*;
import static pieces.Piece.Type.*;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testCreate() {
		verifyCreation(Piece.createWhitePawn(), Piece.createBlackPawn(), PAWN);
		verifyCreation(Piece.createWhiteRook(), Piece.createBlackRook(), ROOK);
		verifyCreation(Piece.createWhiteKnight(), Piece.createBlackKnight(), KNIGHT);
		verifyCreation(Piece.createWhiteBishop(), Piece.createBlackBishop(), BISHOP);
		verifyCreation(Piece.createWhiteQueen(), Piece.createBlackQueen(), QUEEN);
		verifyCreation(Piece.createWhiteKing(), Piece.createBlackKing(), KING);
		Piece piece = Piece.noPiece();
		assertEquals(NOCOLOR, piece.getColor());
		assertEquals(EMPTY.getSymbol(), piece.getSymbol());
	}
	
	private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type) {
		assertEquals(WHITE, whitePiece.getColor());
		assertEquals(type.getSymbol(), whitePiece.getSymbol());
		assertEquals(BLACK, blackPiece.getColor());
		assertEquals(Character.toUpperCase(type.getSymbol()), blackPiece.getSymbol());
	}
	
	public void testCountWhitePieces() throws Exception {
		Piece.resetCountPieces();
		Piece.createWhitePawn(); 
		assertEquals(1, Piece.countWhitePieces());
	}
	
	public void testCountBlackPieces() throws Exception {
		Piece.resetCountPieces();
		Piece.createBlackPawn(); 
		assertEquals(1, Piece.countBlackPieces());
	}
	
    public void testIsWhite() throws Exception {
        Piece whitePawn = Piece.createWhitePawn();
        assertTrue(whitePawn.isWhite());
    }
    
    public void testIsBlack() throws Exception {
        Piece blackPawn = Piece.createBlackPawn();
        assertTrue(blackPawn.isBlack());
    }
    
    public void testCalculateExceptPawn() throws Exception {
    	Piece whitePawn = Piece.createWhitePawn().changeX(1).changeY(2);
    	Piece whiteQueen = Piece.createWhiteQueen().changeX(1).changeY(3);
    	assertEquals(9.0, whiteQueen.calculate(whitePawn));
    	assertEquals(5.0, Piece.createWhiteRook().calculate(whitePawn));
    	assertEquals(3.0, Piece.createWhiteBishop().calculate(whitePawn));
    	assertEquals(2.5, Piece.createWhiteKnight().calculate(whitePawn));
	}
    
    public void testCalculatePawnWhenDifferentType() throws Exception {
    	Piece whitePawn = Piece.createWhitePawn().changeX(1).changeY(2);
    	Piece whiteQueen = Piece.createWhiteQueen().changeX(1).changeY(3);
    	assertEquals(0.5, whitePawn.calculate(whiteQueen));
	}
    
    public void testCalculatePawnWhenSameXY() throws Exception {
    	Piece origin = Piece.createBlackPawn().changeX(1).changeY(2);
    	Piece target = Piece.createBlackPawn().changeX(1).changeY(2);
    	assertEquals(PAWN.getDefaultPoint(), origin.calculate(target));
	}
    
    public void testCalculatePawnWhenSameY() throws Exception {
    	Piece origin = Piece.createBlackPawn().changeX(1).changeY(2);
    	Piece target = Piece.createBlackPawn().changeX(3).changeY(2);
    	assertEquals(PAWN.getDefaultPoint(), origin.calculate(target));
	}
    
    public void testCalculatePawnWhenSameX() throws Exception {
    	Piece origin = Piece.createBlackPawn().changeX(1).changeY(2);
    	Piece target = Piece.createBlackPawn().changeX(1).changeY(4);
    	assertEquals(1.0, origin.calculate(target));
	}
    
    public void testCalculatePawnWhenDifferentXY() throws Exception {
    	Piece origin = Piece.createBlackPawn().changeX(1).changeY(2);
    	Piece target = Piece.createBlackPawn().changeX(3).changeY(4);
    	assertEquals(PAWN.getDefaultPoint(), origin.calculate(target));
	}
    
    public void testChangeX() throws Exception {
		Piece pawn = Piece.createWhitePawn();
		int x = 3;
		
		pawn.changeX(x);
		assertEquals(x, pawn.getX());
	}
    
    public void testChangeY() throws Exception {
		Piece pawn = Piece.createWhitePawn();
		int y = 3;
		
		pawn.changeY(y);
		assertEquals(y, pawn.getY());
	}
}
