package org.picmg.test.integrationTest.generated;
/**
	This is a generated integration test using the testMaker application
*/
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import org.junit.Test;
import static org.junit.Assert.*;
import org.picmg.test.integrationTest.RobotThread;
import org.picmg.test.integrationTest.RobotUtils;
import java.io.IOException;
public class TextBoxTest extends Application
{
	public void robotCalls()
	{
		test();
	}
	@Override
	public void start(Stage stage)
	{
		Parent root;
		try 
		{
			root = FXMLLoader.load(getClass().getClassLoader().getResource("topTabScene.fxml"));
			Scene scene = new Scene(root, 1024, 768);
			stage.setTitle("PICMG Configurator");
			stage.setScene(scene);
			stage.show();
			robotCalls();
		
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	public void test()
	{
		RobotThread.build(200, ()->RobotUtils.click("#effectersTab")).run();
		RobotThread.build(200, ()->RobotUtils.click("#stepCheckbox")).run();
		RobotThread.build(800, ()->RobotUtils.check("#stepCheckbox","true")).run();
		RobotThread.build(200, ()->RobotUtils.click("#stepCheckbox")).run();
		RobotThread.build(800, ()->RobotUtils.check("#stepCheckbox","false")).run();
		RobotThread.build(200, ()->RobotUtils.click("#descriptionTextArea")).run();
		RobotThread.build(200, ()->RobotUtils.type("Test")).run();
		RobotThread.build(800, ()->RobotUtils.check("#descriptionTextArea","Test")).run();
	}
}