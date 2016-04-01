package sample;

import javafx.stage.FileChooser;

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
     * @param file
     * @throws IOException
     */
    public void readGameBoardFromDisk(File file) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Game of Life Files", "*.rle"));
        File selectedFile = fileChooser.showOpenDialog(null);





        /*if(selectedFile != null) {
            display(selectedFile);
        }*/

        //fileChooser(new FileReader(file));

      /*  FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(mainStage);
        if (selectedFile != null) {
            mainStage.display(selectedFile);
        }*/
    }


    public void setStage() {
        this.stage = stage;
    }

    /**
     * Reading file from web
     * @param url
     * @throws IOException
     * @throws PatternFormatException
     */

    /*
    public void readGameBoardFromURL(String url) throws IOException,
            PatternFormatException {
            URL destination = new URL(url);
            URLConnection conn = destination.openConnection();
            readGameBoard(new InputStreamReader(conn.getInputStream()));
    }*/

}
