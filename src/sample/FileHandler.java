/**
 * File Handler  class is responsible for the input and
 * output of files to read patterns in RLE format via disc
 * and web.
 *
 * @author Rudi André Dahle
 * @author Ginelle Ignacio
 * @author Olav Smevoll
 */

package sample;

import javafx.event.ActionEvent;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import WebFile.WebFileController;

public class FileHandler {

    //Data field
    File file;

    Board gameBoard = Board.getBoard();
    Alerts error = new Alerts();

    //Constructor
    //public FileHandler(Board gameboard) {this.gameBoard = gameboard;}


    /**
     * Reading game board
     *
     * @param r Returns the game board
     * @throws IOException
     * @author Ginelle
     */
    public void readGameBoard(Reader r) throws IOException {
    }


    /**
     * Reading file from disk
     *
     * @throws IOException
     * @author Rudi André Dahle
     */
    public void chooseFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")+"/rle"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life WebFile ", "*.rle"));
        file = fileChooser.showOpenDialog(null);
        if (file != null) {
            readGameBoardFromFile(file);
        }
    }


    /**
     * @param file Returns the file
     * @throws IOException
     * @author Olav Smevoll
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
        fromRleToSimplified(rleCode);
        System.out.println(rleCode);
    }


    /**
     *
     * @param rle
     * @author Olav Smevoll
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
        rleToArray(finalRle);
    }


    /**
     * @param rle
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



/**
 * Reading file from web
 *
 * @author Ginelle Ignacio
 * @param url Returns the web address
 * @throws IOException
 * @throws PatternFormatException
 */


