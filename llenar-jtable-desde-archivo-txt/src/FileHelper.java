import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Brian Vanegas
 */
public class FileHelper {
    BufferedReader br;
    String readLine;
    ArrayList<String> lines = new ArrayList<String>();
    
    public ArrayList FileHelper(String fileName) {
        try{
            br = new BufferedReader(new FileReader(fileName));
            readLine = br.readLine();
            
            while(readLine != null){
                lines.add(readLine);
                readLine = br.readLine();
            }
        } catch(IOException e){
            System.out.println("Hay un problema:" + e);
        }
        return lines;
    }
    
    public boolean ActualizarArchivo(ArrayList personas, String fileName) throws FileNotFoundException, IOException {
        FileOutputStream fout = new FileOutputStream(fileName);
        
        try {
            for(Object persona : personas){
                fout.write(persona.toString().getBytes());
                fout.write('\n');
            }
            return true;
        } catch(FileNotFoundException ex){
            return false;
        }
    }
}