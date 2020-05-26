package springhw.beans;
import java.io.*;
import springhw.beans.adds.*;

public class Parser {
    private String filename;
    public Parser(String filename) {
        this.filename = filename;
    }

    public Characters[] parse(){
        try
        {
            FileReader reader = new FileReader(this.filename);
            BufferedReader breader = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            int i = 0;
            String line = breader.readLine();
            while (line != null){
                sb.append(line + ' ');
                line = breader.readLine();
                i = i + 1;
            }
            Characters[] mass = new Characters[i];
            String data = sb.toString();
            String[] md = data.split(" ");
            for (int j = 0; j < i; j++) {
                if(md[1 + j * 4].equals("tank")){
                    Characters chars = new Tank(md[3 + j * 4]);
                    mass[j] = chars;
                } else {
                    if (md[1 + j * 4].equals("melee")) {
                        Characters chars = new Melee(md[3 + j * 4]);
                        mass[j] = chars;
                    } else {
                        if (md[1 + j * 4].equals("range")) {
                            Characters chars = new Range(md[3 + j * 4]);
                            mass[j] = chars;
                        } else {
                            mass[j] = null;
                        }
                    }
                }
            }

            return mass;

        }catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            return null;
        } catch (IOException e) {
            System.out.println("IOException");
            return null;
        }
    }
}
