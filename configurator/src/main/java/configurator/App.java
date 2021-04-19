package configurator;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class App extends Application {
	@Override
    public void start(Stage stage) { 
	    Parent root;
		try {
			// load the fxml object for the main screen
			root = FXMLLoader.load(getClass().getClassLoader().getResource("test.fxml"));
	        Scene scene = new Scene(root, 640, 480);
		    
	        stage.setTitle("PCIMG Configurator");
	        stage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	       
	            
        stage.show();        
    }

    public static void main(String[] args) {
        launch();
    }
}
	