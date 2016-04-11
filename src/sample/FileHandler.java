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
import java.text.NumberFormat;
import java.util.ArrayList;


public class FileHandler {

    //Data field
    File file;
    Board board = new Board();


    //Constructor
    public FileHandler(){
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
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life Files ", "*.rle"));
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
           if((line.matches("[b,o,$, !, 0-9]*"))){
                rleCode = rleCode.concat(line + "\n");
           }
        }


        String subString = "";
        int j = 0;
        String numberS = "";
        int number = 0;
        String finalRle = "";

            while(j < rleCode.length()){

                subString = subString.concat("" + rleCode.charAt(j));

                if(subString.matches("[0-9]+")){
                    numberS += subString;
                    number = Integer.parseInt(numberS);
                }

                if(rleCode.charAt(j) == 'o'){
                    if(number != 0){
                        for(int i = 0; i < number; i++){
                            finalRle += "o";
                        }
                    }else{
                        finalRle += "o";
                    }

                    subString = "";
                    numberS = "";
                    number = 0;
                }
                if(rleCode.charAt(j) == 'b'){
                    if(number != 0){
                        for(int i = 0; i < number; i++) {
                            finalRle += "b";
                        }
                    }else{
                        finalRle += "b";
                    }
                    subString = "";
                    numberS = "";
                    number = 0;
                }
                if(rleCode.charAt(j) == '$'){
                    finalRle += "$";
                    subString = "";
                    numberS = "";

                }
                j++;
        }
        rleToArray(finalRle);
    }

    public void rleToArray(String rle){


        board.clearBoard();
        int yCounter = 0;
        int xCounter = 0;


        for(int i = 0; i < rle.length(); i++){
            if (rle.charAt(i) == '$'){
                yCounter++;
                xCounter = 0;
            }
            if(rle.charAt(i) == 'b'){
                board.gameBoard[xCounter][yCounter] = false;
                xCounter++;
            }
            if(rle.charAt(i) == 'o'){
                board.gameBoard[xCounter][yCounter] = true;
                xCounter++;
            }
        }
        System.out.println("done");

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
