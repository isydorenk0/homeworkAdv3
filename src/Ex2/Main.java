package Ex2;

import java.io.*;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("exercise2.txt");
        fileWrite(file);
        fileRead(file);
    }

    private static void fileRead(File file) throws Exception {
        if (!file.exists()) throw new Exception("File doesn't exist");
        try (FileReader fw = new FileReader(file);
             BufferedReader br = new BufferedReader(fw)) {
            String fileLine;
            while ((fileLine = br.readLine()) != null) {
                System.out.println(fileLine);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static void fileWrite(File file) throws Exception {
        validateFile(file);
        try (FileWriter fw = new FileWriter(file);
             PrintWriter pw = new PrintWriter(fw)) {
            Date date = new Date();
            pw.write("New text\n");
            pw.write(date.toString());
            pw.flush();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void validateFile(File file) throws Exception {
        if (file.exists()) {
            boolean deleted = file.delete();
            if (!deleted) throw new Exception("File cannot be deleted");
        }
        boolean created = file.createNewFile();
        if (!created) throw new Exception("File cannot be created");
    }
}
