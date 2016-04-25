package test;

import org.junit.Before;
import org.junit.Test;
import sample.FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * Created by RudiAndre on 21.04.2016.
 */
public class FileHandlerTest {

    FileHandler fileHandler = new FileHandler();
    String rleCode;

    @Before
    public void setUp() throws Exception {
        File file = new File(System.getProperty("user.dir")+"/rle/glider.rle");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        rleCode = "";

        while ((line = br.readLine()) != null) {
            if ((line.matches("[b, o, $, !, 0-9]*"))) {
                rleCode = rleCode.concat(line + "\n");
            }
        }
    }


    @Test
    public void testFromRleToSimplified() throws Exception {
        assertEquals("bob$bbo$ooo", fileHandler.fromRleToSimplified(rleCode));
    }
}