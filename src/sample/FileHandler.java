package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by RudiAndre on 30.03.2016.
 */
public class FileHandler {

    //Data field
    File file;


    //Constructor
    public FileHandler(){
    }

    /**
     * Reading game board
     * @author Ginelle
     * @param r
     * @throws IOException
     */
    public void readGameBoard(Reader r) throws IOException{

    }

    //Stage testStage = new Stage();

    /**
     * Reading file from disk
     * @author Rudi
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
     * @author Olav
     * @param file
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

        String[] rleSplit = rleCode.split("\\$");

        ArrayList splittedRle = new ArrayList();


        for(int i = 0; i < rleSplit.length; i++){
            splittedRle.add(rleSplit[i]);
        }

        System.out.println(splittedRle);
    }



    /**
     * Reading file from web
     * @author Ginelle
     * @param url
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
