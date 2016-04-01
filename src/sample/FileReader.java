package sample;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by RudiAndre on 30.03.2016.
 */
public class FileReader {

    /**
     * Reading file from disk
     * @param file
     * @throws IOException
     */
    public void readGameBoardFromDisk(File file) throws IOException {
        //readGameBoard(new FileReader(file));
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
