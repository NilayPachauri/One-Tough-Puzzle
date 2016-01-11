import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Puzzle {
    ArrayList<Piece> board;

    public Puzzle() {
        board = new ArrayList<Piece>();
    }

    public Puzzle(ArrayList<Piece> board) {
        this.board = board;
    }

    @SuppressWarnings("finally")
    public static Puzzle readFile(File f) throws IOException {
        //Piece[][] board = new Piece[3][3];
        ArrayList<Piece> board = new ArrayList<Piece>();
        LineNumberReader lnr = new LineNumberReader(new FileReader(f));
        lnr.skip(Long.MAX_VALUE);

        if (lnr.getLineNumber() + 1 != 9) {
            JOptionPane.showMessageDialog(null, "THERE ARE AN INCORRECT NUMBER OF LINES IN YOUR FILE. FILE NOT READ",
                    "ERROR", JOptionPane.WARNING_MESSAGE);
            return new Puzzle(new ArrayList<Piece>());
        } else {
            JOptionPane.showMessageDialog(null, "File read successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        BufferedReader br = new BufferedReader(new FileReader(f));

        String line;
        String[] parsedElements;
        int[] sides = new int[4];
        int count = 0;

        try {
            while ((line = br.readLine()) != null) {
                count++;

                parsedElements = line.split(",");

                for (int i = 0; i < parsedElements.length; ++i) {
                    sides[i] = Integer.parseInt(parsedElements[i]);
                }

                board.add(count-1, new Piece(sides, "Piece " + count));
            }
        } catch (NumberFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            br.close();
            return new Puzzle(board);
        }
    }

    public static File generateFile() throws IOException {
        String fileName = JOptionPane.showInputDialog(null,
                "Please enter the name you wish to give your genereated file", "Name", JOptionPane.INFORMATION_MESSAGE);
        File f = new File(fileName);
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        ArrayList<Integer> protrusions = new ArrayList<>();
        ArrayList<Integer> receptors = new ArrayList<>();

        Random rand = new Random();
        int guess;

        for (int i = 0; i < 18; i++) {
            guess = rand.nextInt(4);

            protrusions.add(guess);
            receptors.add(Integer.parseInt("-" + guess));
        }

        for (int i = 0; i < 36; i++)    {
            if ((i % 4) <= 1)   {
                if ((i != 0) && (i % 4) == 0)   {
                    bw.newLine();
                }
                bw.write(protrusions.remove(rand.nextInt(protrusions.size())).toString() + ",");
            } else if ((i % 4) >= 2)    {
                bw.write(receptors.remove(rand.nextInt(receptors.size())).toString());
                if ((i % 4) != 3)   {
                    bw.write(',');
                }
            }
        }
        
        bw.flush();
        bw.close();
        
        return f;
    }
}
