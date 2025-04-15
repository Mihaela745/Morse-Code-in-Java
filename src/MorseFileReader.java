import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MorseFileReader {
    public static Map<Character,String> readMorseMap(String filePath) throws FileNotFoundException {
        Map<Character,String> morseMap=new HashMap<>();
        try(BufferedReader buffer=new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line= buffer.readLine())!=null)
            {
                Character sign=line.split(" ")[0].charAt(0);
                String code=line.split(" ")[1];
                morseMap.put(sign,code);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return morseMap;
    }

}
