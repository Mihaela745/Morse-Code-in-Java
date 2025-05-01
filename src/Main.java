import FileHandler.FileToFile;
import MorseHandler.MorseTranslator;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Selectati textul ce trebuie transtalat");
            int userSelection=fileChooser.showOpenDialog(null);
            if (userSelection==JFileChooser.APPROVE_OPTION)
            {
                File selectedFile=fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                File newFile=FileToFile.FileToFileTranslation(selectedFile.getPath());
                int openFile=JOptionPane.showConfirmDialog(
                        null,
                        "Traducerea salvata la :\n"+
                                newFile.getAbsolutePath()+"\n\nDoriti sa o deschideti?","Deschideti fisierul:",
                                JOptionPane.YES_NO_OPTION);
                if(openFile==JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(newFile);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null,"Imposibil de deschisFisierul.","Eroare",JOptionPane.ERROR_MESSAGE);
                       e.printStackTrace();
                    }
                }
            }


    }
}