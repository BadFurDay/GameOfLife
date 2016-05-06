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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileHandler {

    //Data field
    File file;
    private List<List<Boolean>> loadDynamicBoard = new ArrayList<>();
    private boolean error = true;


    //Objects
    Board gameBoard;
    Graphics graphics;
    Alerts alerts = new Alerts();
    DynamicBoard dynamicBoard = DynamicBoard.getInstance();


    /**
     * File Handler's constructor receives no arguments.
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Igncacio
     */
    public FileHandler(){
    }


    /**
     * This File Handler constructor contains parameters.
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @param gc GraphicsContext's variable
     * @param statBoard Board's variable
     */
    public FileHandler(Graphics gc, Board statBoard) {
        this.graphics = gc;
        this.gameBoard = statBoard;
    }


    /**
     * Gets boolean value of error
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @return error Returns the boolean value of error
     */
    public boolean getError(){
        return error;
    }


    /**
     * Method called to read an RLE file stored on the
     * computer's disk. Program will show a dialog box
     * containing RLE files which the user can choose.
     *
     * The only file format that will be available and
     * visible for the user when choosing a file is RLE.
     * This will avoid errors for wrong file formats.
     *
     * @author Rudi André Dahle
     * @author Olav Smevoll
     * @author Ginelle Ignacio
     * @throws IOException if an alerts occurs while opening file
     * @throws PatternFormatExceptions Exceptions related to file handling
     */
    public void chooseFile() throws IOException, PatternFormatExceptions {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")+"/rle"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life File ", "*.rle"));
        file = fileChooser.showOpenDialog(null);

       if (file != null) {
            readGameBoardFromFile(file);
       } else {
           alerts.noFile();
       }
    }


    /**
     * Method called to read the content of file
     * by using File Reader and Buffered Reader.
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @param file Receives a file selected by the user
     *             that the Buffered Reader will read
     * @throws IOException If an alert occurs when reading the file
     * @throws PatternFormatExceptions Exceptions related to file handling
     */
    public void readGameBoardFromFile(File file) throws IOException,
            PatternFormatExceptions {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String rleCode = "";

        //Checks if file content is empty
        if (br.readLine() == null){
            alerts.emptyFile();
        }

        //Checks and reads wrong file content
        if((line = br.readLine()) != null){
            if(!line.matches("[^b, ^o, ^$, ^!, ^0-9]")){
                error = true;
            }
        }

        //Checks and reads correct file content
        while ((line = br.readLine()) != null) {
            if ((line.matches("[b, o, $, !, 0-9]*"))) {
                error = false;
                rleCode = rleCode.concat(line + "\n");
            }
        }
        fromRleToSimplified(rleCode);
    }


    /**
     * Transforms the rle code into a string consisting of o, b and $.
     * 3b from the rle code will turn into bbb etc.
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @param rle Receives a string representation of
     *            a RLE file
     * @return Returns StringBuilders value as toString().
     */
    public String fromRleToSimplified(String rle) {
        StringBuilder finalRle = new StringBuilder();

        Pattern pattern = Pattern.compile("\\d+|[ob]|\\$");
        Matcher matcher = pattern.matcher(rle);

        while (matcher.find()) {
            int num = 1;
            if (matcher.group().matches("\\d+")) {
                num = Integer.parseInt(matcher.group());
                matcher.find();
            }
            for (int i = 0; i < num; i++) {
                finalRle.append(matcher.group());
            }
        }
        finalRle.toString();
        rleToArray(finalRle.toString());
        return finalRle.toString();
    }


    /**
     * Takes the string created in the fromRleToSimplified method
     * and creates the pattern on the board.
     *
     * @author Olav Smevoll
     * @author Rudi André Dahle
     * @author Ginelle Ignacio
     * @param rle Receives a string representation of
     *            a RLE file
     */
    private void rleToArray(String rle) {
        int yCounter = 5;
        int xCounter = 5;

        dynamicBoard.resetDynamicBoard(loadDynamicBoard);

        for (int i = 0; i < rle.length(); i++) {
            if(xCounter == loadDynamicBoard.size() || yCounter == loadDynamicBoard.size()){
                dynamicBoard.addToArrayEastSouth();
                loadDynamicBoard = dynamicBoard.getGameBoard();
                graphics.setCellHeight(dynamicBoard.cellsWide);
                graphics.setCellWidth(dynamicBoard.cellsWide);
            }
            if (rle.charAt(i) == '$') {
                yCounter++;
                xCounter = 5;
            }

            if (rle.charAt(i) == 'b') {
               loadDynamicBoard.get(xCounter).set(yCounter, false);
                xCounter++;
            }
            if (rle.charAt(i) == 'o') {
                loadDynamicBoard.get(xCounter).set(yCounter, true);
                xCounter++;
            }
        }
        dynamicBoard.setGameBoard(loadDynamicBoard);
    }
}