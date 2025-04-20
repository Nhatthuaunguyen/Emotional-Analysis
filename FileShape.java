import java.io.*;

public class FileShape {

    public static void main(String[] args) {
        String inputFile = "D:\\Emotional-Analysis\\DataFile\\emotion.csv";
        BufferedReader reader = null;
        String line;
        int rowCount = 0;
        int columnCount = 0;

        try {
            reader = new BufferedReader(new FileReader(inputFile));

            // count column
            if ((line = reader.readLine()) != null) {
                String[] header = line.split(",");
                columnCount = header.length;
            }

            // Count rows
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    rowCount++;
                }
            }

            System.out.printf("%nThe Shape Of Data Is: (%d, %d)%n", rowCount, columnCount);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


