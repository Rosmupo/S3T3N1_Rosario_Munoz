
import com.google.gson.Gson;

import java.io.*;

public class MyFile {

    public static final String DIRECTORY = "/Users/Rosario/Pruebas";
    public static final String FILE_NAME = "database";

    public static boolean checkFile() {

        File file = new File(DIRECTORY + File.separator + FILE_NAME + ".txt");
        boolean exist = file.exists() ? true : false;

        return exist;
    }

    public static void createFile(){
        File file = new File(DIRECTORY + File.separator + FILE_NAME + ".txt");

        try {
            file.createNewFile();
            System.out.println("Se ha creado el archivo");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile (Florist florist) {

        BufferedWriter bufferedWriter;
        FileWriter write;
        Gson gson = new Gson();
        String floristJson = gson.toJson(florist);

        try {

            write = new FileWriter(DIRECTORY + File.separator + FILE_NAME + ".txt");
            bufferedWriter = new BufferedWriter(write);
            bufferedWriter.write(floristJson);
            bufferedWriter.close();
            write.close();
            System.out.println("Datos guardados en el archivo");

        } catch (IOException e) {

            System.out.println("El archivo no existe");
            e.printStackTrace();
        }

    }

    public static Florist readFile() {

        String text = null;
        StringBuilder stringBuilder = null;

        File file = new File(DIRECTORY+ File.separator + FILE_NAME + ".txt");

        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException ex) {

            System.err.println(ex.getMessage());

        }

        if (bufferedReader != null) {

            try {

                bufferedReader.close();

            } catch (IOException ex) {

                System.err.println(ex.getMessage());
            }
        }

        if (fileReader != null) {

            try {

                fileReader.close();

            } catch (IOException ex) {

                System.err.println(ex.getMessage());
            }
        }


        if (stringBuilder != null) {

            text = stringBuilder.toString();
        }

        Florist florist;
        Gson gson = new Gson();
        florist = gson.fromJson(text, Florist.class);

        return florist;

    }

}