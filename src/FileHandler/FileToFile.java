package FileHandler;

import java.io.*;
import MorseHandler.MorseTranslator;
public class FileToFile {

    public static void FileToFileTranslation(String sourcePath)
    {
        File source=new File(sourcePath);
        if(!(source.exists()))
        {
            System.out.println("Doesn't exist.");
            return;
        }

        String parentdDirectory=source.getParent();
        String fileName=source.getName();
        String withoutExtension=fileName.split("\\.")[0];

        String newFileName=withoutExtension+"_out"+".txt";

        File newFile= new File(parentdDirectory,newFileName);

        try (
            BufferedReader buffer=new BufferedReader(new FileReader(source));
            BufferedWriter writer=new BufferedWriter(new FileWriter(newFile));
        )
        {
        String line;
        String output;
        while((line= buffer.readLine())!=null)
            {
                output= MorseTranslator.Translator(line);
                writer.write(output);
                writer.newLine();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
