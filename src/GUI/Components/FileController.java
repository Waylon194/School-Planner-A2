package GUI.Components;

import Data.Agenda;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class FileController {

    private FileChooser fileChooser = new FileChooser();


    public void saveFile(Stage stage, Agenda agenda){
        System.out.println("Save File");
        File file = fileChooser.showSaveDialog(stage);
        if (file == null) {
            System.out.println("No file selected!");

        }
        else {

            try {

                FileOutputStream fileOut = new FileOutputStream(file.getPath());
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(agenda);
                objectOut.close();
                System.out.println("The Object  was succesfully written to a file");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public void doExit(){
        Platform.exit();
    }
}
