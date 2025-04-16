package MorseHandler;

import java.io.FileNotFoundException;
import java.util.Map;

public class MorseTranslator {
    private static final Map<Character,String> morse;

    static {
        try {
            morse = MorseFileReader.readMorseMap("src/MorseHandler/sources/morse.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String Translator(String input)
    {
        if(input==null || input.isEmpty())
           return "";
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<input.length();i++)
        {
            char c=Character.toUpperCase(input.charAt(i));
            if(Character.compare(c,' ')==0)
                builder.append('/');
           else{
               String code=morse.get(c);
                if(code != null && !code.isEmpty())
                   builder.append(code);
               else
                   builder.append(' ');
            }
        }
        return builder.toString().trim();
    }


}
