package launch;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        //Musique d'ambiance.
        URL urlMusique = getClass().getResource("/sounds/MusiqueProjetJava.mp3");
        Media mediaMusique = new Media(urlMusique.toString());
        MediaPlayer mediaPlayerMusique = new MediaPlayer(mediaMusique);
        mediaPlayerMusique.play();
        mediaPlayerMusique.setAutoPlay(true);
    

        

        Parent root = FXMLLoader.load(getClass().getResource("/view/Fenetre.fxml"));
        
        root.setStyle("-fx-background-image: url('images/BackgroundImage.jpg')");  
        
        Scene scene = new Scene(root);
        
       scene.getStylesheets().add(getClass().getResource("/css/Style.css").toExternalForm());
        
    
        

        primaryStage.setScene(scene);
        primaryStage.setTitle("Inventaire");
        primaryStage.show();
    }
    
}
