package GUI.Components;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Data.Agenda;

import java.io.*;


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

    public Agenda openFile(Stage stage){


        System.out.println("Opening file");
        File file = fileChooser.showOpenDialog(stage);
        if (file == null){
            System.out.println("No file selected");
        }
        else {
            try{
                FileInputStream fileIn = new FileInputStream(file.getPath());
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Agenda agenda = (Agenda) objectIn.readObject();
                return agenda;
            }
            catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }

        return null;
    }

}
