import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.IOException;

public class convertCSVToArff {
    public static void main(String[] args) {
        try {
            // Load CSV
            CSVLoader loader = new CSVLoader();
            loader.setSource(new File("D:\\Emotional-Analysis\\DataFile\\emotion_clean.csv"));
            Instances data = loader.getDataSet();

            // Save ARFF
            ArffSaver saver = new ArffSaver();
            saver.setInstances(data);
            saver.setFile(new File("D:\\Emotional-Analysis\\DataFile\\emotion_clean.arff"));
            saver.writeBatch();

            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred during file processing: " + e.getMessage());
        }
    }
}

