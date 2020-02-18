/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author Armand
 */
import com.github.sarxos.webcam.Webcam;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Camera {
    
    public static void open(){
        Webcam w=Webcam.getDefault();
        w.open();
        try {
            ImageIO.write(w.getImage(), "JPG", new File("photo.png"));
        } catch (IOException ex) {
            Logger.getLogger(Camera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
}
