package sample;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by RudiAndre on 30.03.2016.
 */
public class FileReader {



    //Constructor
    public FileReader(){
    }


    //Stage testStage = new Stage();

    /**
     * Reading file from disk
     * @author Rudi
     * @throws IOException
     */
    public void readGameBoardFromDisk() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life Files ", "*.rle"));
        fileChooser.showOpenDialog(null);
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
