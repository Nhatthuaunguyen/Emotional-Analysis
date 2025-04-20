import java.io.*;

public class LoadData {
    public static void main(String[] args) {
        String inputFile = "D:\\Emotional-Analysis\\DataFile\\emotion.csv";
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            while((line = reader.readLine()) != null) {
                String[] row = line.split (",");

                for(String index:row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}