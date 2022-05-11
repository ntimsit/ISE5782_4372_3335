package unittests;

import org.junit.Test;
import primitives.Color;
import renderer.ImageWriter;

public class ImageWriterTest {
    /**
     * Test for testing ImageWriter capabilities
     */
    @Test
    public void testViewPlane(){
        ImageWriter imageWriter = new ImageWriter("testViewPlane", 800, 500);
        for (int x = 0; x < 800; x++) {
            for (int y = 0; y < 500; y++) {
                if(y % 50 == 0 || x % 50 == 0)
                    imageWriter.writePixel(x, y, Color.BLACK);
                else
                    imageWriter.writePixel(x, y, new Color(0, 0, 255));
            }
        }
        imageWriter.writeToImage();
    }
}