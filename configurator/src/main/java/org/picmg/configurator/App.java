//*******************************************************************
//    App.java
//
//    More information on the PICMG IoT data model can be found within
//    the PICMG family of IoT specifications.  For more information,
//    please visit the PICMG web site (www.picmg.org)
//
//    Copyright (C) 2020,  PICMG
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <https://www.gnu.org/licenses/>.
//
package org.picmg.configurator;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class App extends Application {	
	
	private static Scene scene;

	/**
	 * isInteger()
	 * A helper that returns true if the string parameter represents
	 * a valid base-10 signed integer
	 * @param num - the string to check
	 * @return - true if the string is a valid integer
	 */
	static boolean isInteger(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * isUnsignedInteger()
	 * A helper that returns true if the string parameter represents
	 * a valid base-10 unsigned integer
	 * @param num - the string to check
	 * @return - true if the string is a valid integer
	 */
	static boolean isUnsignedInteger(String num) {
		try {
			Integer.parseInt(num);
			if (num.charAt(0) != '-') return true;
		} catch (NumberFormatException e) {}
		return false;
	}

	/**
	 * isFloat()
	 * A helper that returns true if the string parameter represents
	 * a valid double-precision floating-point number.
	 * @param num - the string to check
	 * @return - true if the string is a valid integer
	 */
	static boolean isFloat(String num) {
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}


	@Override
    public void start(Stage stage) { 
	    Parent root;
	    try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("topTabScene.fxml"));
			Scene scene = new Scene(root, 1024, 768);

			stage.setTitle("PICMG Configurator");
			stage.setScene(scene);
			stage.show();
			//Handling close event
			stage.setOnCloseRequest(event -> {
				close();
			});

		} catch (IOException e) {
	    	System.out.println(e);
		}
	}

	public void close(){
		System.out.println("Closing the PICMG Configurator");
		Platform.exit();
		System.exit(0);
	}

	/**
	 * Launch the app
	 * @param args - the command line arguments for the program
	 */
	public static void main(String[] args) {
		launch();
    }
}