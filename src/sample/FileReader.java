package sample;

import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

/**
 * Created by RudiAndre on 30.03.2016.
 */
public class FileReader {

    //Constructor
    public FileReader(){
    }


    //Stage testStage = new Stage();
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
}
