import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Game {

	static ArrayList<Win> listOfWins = new ArrayList<>();
	static int iterNum = 0;
	static long initalTime;

	public static void main(String args[]) throws IOException, ParseException {
		File f = Puzzle.generateFile(); // generate the user's file
		Puzzle p = Puzzle.readFile(f); // construct the solved puzzle based on
										// the information
		initalTime = System.nanoTime();
		solve(new Puzzle(), p);
		System.out.println(listOfWins);
		writeFile();
		System.out.println("honhonhon");
	}

	public static Puzzle solve(Puzzle solvedPuzzle, Puzzle remainingPieces) throws ParseException {
		Puzzle possiblySolved = null;
		switch (solvedPuzzle.board.size()) {
		case 0: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 9) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				possiblySolved = solve(solvedPuzzle, remainingPieces);
				
				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));
				
				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
				
			}
			return possiblySolved;
		}
		case 1: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 8) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testLeft(1)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 2: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 7) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testLeft(2)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 3: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 6) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testUp(3)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 4: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 5) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testUp(4) && solvedPuzzle.testLeft(4)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 5: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 4) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testUp(5) && solvedPuzzle.testLeft(5)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 6: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 3) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testUp(6)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 7: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 2) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testUp(7) && solvedPuzzle.testLeft(7)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 8: {
			int pieceCount = 0;
			int orientation = 0;
			while (pieceCount < 1) {
				Piece chosenPiece = remainingPieces.board.remove(pieceCount);
				chosenPiece.setOrientation(orientation);
				solvedPuzzle.board.add(chosenPiece);

				if (solvedPuzzle.testUp(8) && solvedPuzzle.testLeft(8)) {
					possiblySolved = solve(solvedPuzzle, remainingPieces);
				}

				remainingPieces.board.add(pieceCount, solvedPuzzle.board.remove(solvedPuzzle.board.size() - 1));

				orientation = (++orientation) % 4;
				if (orientation == 0) {
					pieceCount++;
				}
				++iterNum;
			}
			return possiblySolved;
		}
		case 9: {

			long duration = System.nanoTime() - initalTime;

			System.out.println(new Win(solvedPuzzle, iterNum, duration));
			listOfWins.add(new Win(solvedPuzzle, iterNum, duration));
			return solvedPuzzle;
		}
		default:
			break;
		}
		return remainingPieces;
	}
	
	public static void writeFile() throws IOException	{
		File f = new File("Solutions.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		for (Win w : listOfWins)	{
			bw.write(w.getPuzzle().toString() + ',');
			bw.write(Integer.toString(iterNum) + ",");
			bw.write(w.duration);
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}
