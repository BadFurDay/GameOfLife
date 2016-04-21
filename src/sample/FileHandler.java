/**
 * File Handler  class is responsible for the input and
 * output of files to read patterns in RLE format via disc
 * and web.
 *
 * @author Rudi André Dahle
 * @author Olav Smevoll
 * @author Ginelle Ignacio
 */

package sample;

import javafx.stage.FileChooser;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileHandler {

    //Data field
    File file;

    //Constructor
    public FileHandler() {
    }


    //Object
    Board gameBoard = Board.getBoard();


    /**
     * Method called to read an RLE file stored in the
     * computer's disk. Program will show a dialog box
     * containing RLE files which the user can choose.
     *
     * @author Rudi André Dahle
     * @throws IOException if an error occurs while opening file
     */
    public void chooseFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")+"/rle"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life WebFile ", "*.rle"));
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            System.out.println("Fildestinasjon: " + file);
            readGameBoardFromFile(file);
        }
        System.out.println("file: " + file);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        if (file != null) {
            try {
                readGameBoardFromFile(file);
            } catch (IOException io){
                io.printStackTrace();
            }
            str.append("file");
        }
        return toString();
    }

    /**
     * Method called to read the content of file
     * by using File Reader and Buffered Reader.
     *
     * @author Olav Smevoll
     * @param file Receives a file selected by the user
     *             that the Buffered Reader will read
     * @throws IOException

     */
    private void readGameBoardFromFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String rleCode = "";

        while ((line = br.readLine()) != null) {
            if ((line.matches("[b, o, $, !, 0-9]*"))) {
                rleCode = rleCode.concat(line + "\n");
            }
        }
        System.out.println("Lest av rle-kode fra fil: " + rleCode);
        fromRleToSimplified(rleCode);
    }


    /**
     * Method called to read the content of an RLE file
     * or URL by using Pattern and Matcher.
     *
     * @author Olav Smevoll
     * @param rle Receives a string representation of
     *            a RLE file
     */
    public void fromRleToSimplified(String rle) {  //Hjelpemetode, kan settes private. Da må webfilecontroller endres litt. Sette inn i samme klasse?
        String finalRle = "";

        Pattern pattern = Pattern.compile("\\d+|[ob]|\\$");
        Matcher matcher = pattern.matcher(rle);
        while (matcher.find()) {
            int num = 1;
            if (matcher.group().matches("\\d+")) {
                num = Integer.parseInt(matcher.group());
                matcher.find();
            }
            for (int i = 0; i < num; i++) {
                finalRle += matcher.group();
            }
        }
        System.out.println("Tolket koden om til enkelte celler: " + finalRle);
        rleToArray(finalRle);
    }


    /**
     * This method makes it possible for the content of
     * the RLE file to be visible on the game board.
     *
     * @author Olav Smevoll
     * @param rle Receives a string representation of
     *            a RLE file
     */
    private void rleToArray(String rle) {
        gameBoard.clearBoard();
        int yCounter = 5;
        int xCounter = 5;

        for (int i = 0; i < rle.length(); i++) {
            if (rle.charAt(i) == '$') {
                yCounter++;
                xCounter = 5;
            }
            if (rle.charAt(i) == 'b') {
                gameBoard.gameBoard[xCounter][yCounter] = false;
                xCounter++;
            }
            if (rle.charAt(i) == 'o') {
                gameBoard.gameBoard[xCounter][yCounter] = true;
                xCounter++;
            }
        }
    }
}
