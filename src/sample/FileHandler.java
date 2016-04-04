package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by RudiAndre on 30.03.2016.
 */
public class FileHandler {



    File file;


    //Constructor
    public FileHandler(){
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
                new FileChooser.ExtensionFilter("Game of Life Files ", "*"));
        file = fileChooser.showOpenDialog(null);
        readGameBoardFromFile(file);
    }

    public void readGameBoardFromFile(File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
       while((line = br.readLine()) != null){
           System.out.println(br.readLine());
        }
    }






    /**
     * Reading file from web
     * @param url
     * @throws IOException
     * @throws PatternFormatException
     */


   /* public void readGameBoardFromURL(String url) throws IOException,
            PatternFormatException {
            URL destination = new URL(url);
            URLConnection conn = destination.openConnection();
            readGameBoard(new InputStreamReader(conn.getInputStream()));
    }*/

}
