package Ex4;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import static Ex2.Main.validateFile;

public class Main {
    public static void main(String[] args) throws Exception {
        URL url = new URL( "https://lms.cbs.com.ua/mod/assign/view.php?id=1484");
        StringBuilder stringB = createString(url);
        File file = new File("exercise4.txt");
        fileWrite(file, stringB);
        System.out.println(file.toString() + " was created.");
    }

    private static void fileWrite(File file, StringBuilder stringB) throws Exception{
        validateFile(file);
        try (FileWriter fw = new FileWriter(file);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.write(stringB.toString());
            pw.flush();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static StringBuilder createString(URL url) throws IOException {
        StringBuilder stringB = new StringBuilder();
        InputStream is = null;
        try {
            URLConnection con = url.openConnection();
            is = con.getInputStream();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                stringB.append(line).append("\n");
            }
        }
        return stringB;
    }
}
