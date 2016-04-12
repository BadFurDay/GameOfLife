/**
 * File Handler  class is responsible for the input and
 * output of files to read patterns in RLE format via disc
 * and web.
 *
 * @author Rudi André Dahle
 * @author Ginelle Ignacio
 * @author Olav Smevoll
 */

package Main;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.stage.FileChooser;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileHandler {

    //Data field
    File file;

    //Object
    Board gameBoard;

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

    //Stage testStage = new Stage();

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
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life WebFile ", "*.rle"));
        file = fileChooser.showOpenDialog(null);
        readGameBoardFromFile(file);
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
                System.out.print(num);
                matcher.find();
            }
                for(int i = 0; i < num; i++){
                    finalRle += matcher.group();
                }

        }

        rleToArray(finalRle);

    }

    public void rleToArray(String rle){


        gameBoard.clearBoard();
        int yCounter = 5;
        int xCounter = 5;


        for(int i = 0; i < rle.length(); i++){
            if (rle.charAt(i) == '$'){
                yCounter++;
                xCounter = 5;
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
        System.out.println("Pattern from disk");

    }



    /**
     * Reading file from web
     *
     * @author Ginelle Ignacio
     * @param url Returns the web address
     * @throws IOException
     * @throws PatternFormatException
     */

   public void readGameBoardFromURL(String url) throws IOException,
            PatternFormatException {
            URL destination = new URL(url);
            URLConnection conn = destination.openConnection();
            readGameBoard(new InputStreamReader(conn.getInputStream()));
    }

}
