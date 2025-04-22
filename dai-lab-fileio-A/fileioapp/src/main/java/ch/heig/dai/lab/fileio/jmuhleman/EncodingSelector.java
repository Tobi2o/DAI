package ch.heig.dai.lab.fileio.jmuhleman;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class EncodingSelector {

     private final Map<String, Charset> charMap = new HashMap<String, Charset>(){ 
    {
        put("utf8", Charset.forName("UTF-8")); 
        put("txt", Charset.forName("US-ASCII")); 
        put("utf16be", Charset.forName("UTF-16BE")); 
        put("utf16le", Charset.forName("UTF-16LE"));
    }};
     
    /**
     * Get the encoding of a file based on its extension.
     * The following extensions are recognized:
     *   - .utf8:    UTF-8
     *   - .txt:     US-ASCII
     *   - .utf16be: UTF-16BE
     *   - .utf16le: UTF-16LE
     * 
     * @param file the file to get the encoding from
     * @return the encoding of the file, or null if the extension is not recognized
     */
    public Charset getEncoding(File file) {

        String extension = "";
        String name = file.getName();

        int i = name.lastIndexOf('.');
        if (i > 0) {
            extension = name.substring(i+1);
        }
    
        if (extension != null){
            return charMap.get(extension);
        }
        return null;
    }
}