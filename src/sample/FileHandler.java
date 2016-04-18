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

import javafx.stage.FileChooser;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileHandler {

    //Data field
    File file;

    //Object
    Board gameBoard;
    Graphics graphics;

    //Constructor
    public FileHandler(Board gameboard){
        this.gameBoard = gameboard;
    }

    /**
     * Reading game board
     * @author Ginelle
     * @param r Returns the game board
     * @throws IOException
     */
    public void readGameBoard(Reader r) throws IOException{

    }


    /**
     * Reading file from disk
     *
     * @author Rudi André Dahle
     * @throws IOException
     */
    public void chooseFile() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        System.out.println(System.getProperty("user.name"));
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life WebFile ", "*.rle"));
        file = fileChooser.showOpenDialog(null);
        if(file != null) {
            readGameBoardFromFile(file);
        }


    }


    /**
     *
     * @author Olav Smevoll
     * @param file Returns the file
     * @throws IOException
     */
    public void readGameBoardFromFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        String rleCode = "";

        while((line = br.readLine()) != null){
           if((line.matches("[b, o, $, !, 0-9]*"))){
                rleCode = rleCode.concat(line + "\n");
           }
        }

        String finalRle = "";

        Pattern pattern = Pattern.compile("\\d+|[ob]|\\$");
        Matcher matcher = pattern.matcher(rleCode);
        while(matcher.find()){
            int num = 1;
            if(matcher.group().matches("\\d+")){
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
     *
     * @author Olav
     * @param rle
     */
    public void rleToArray(String rle){
        gameBoard.clearBoard();
        int yCounter = 1;
        int xCounter = 1;

        for(int i = 0; i < rle.length(); i++){
            if (rle.charAt(i) == '$'){
                yCounter++;
                xCounter = 1;
            }
            if(rle.charAt(i) == 'b'){
                gameBoard.gameBoard[xCounter][yCounter] = false;
                xCounter++;
            }
            if(rle.charAt(i) == 'o'){
                gameBoard.gameBoard[xCounter][yCounter] = true;
                xCounter++;
            }
        }
       // graphics.draw(gameBoard.getGameBoard());
    }
}
