import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }
    public static void main(String[] args){
        HamletParser parse = new HamletParser();

        String leonChange = parse.changeHamletToLeon();
        saveToFile(leonChange);
        String tariqChange = parse.changeHoratioToTariq();
        saveToFile(tariqChange);
    }



    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }


    public String changeHamletToLeon() {
        Pattern pattern = Pattern.compile("Hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        boolean match = matcher.find();
        String Leon = hamletData;

        if(match) {
            Leon = matcher.replaceAll("Leon");
        }
        return Leon;
    }

    public String changeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        boolean match = matcher.find();
        String Tariq = hamletData;

        if(match) {
            Tariq = matcher.replaceAll("Tariq");
        }
        return Tariq;
    }

    public boolean findHoratio() {
        return false;
    }

    public boolean findHamlet() {
        return false;
    }

    public static void saveToFile(String line) {
        try {
            PrintWriter fileOut = new PrintWriter("src/main/resources/hamletChange.txt");
            fileOut.println(line);
            fileOut.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
