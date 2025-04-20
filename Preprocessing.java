import java.io.*;
import java.util.*;

public class Preprocessing {

    // English stopwords list
    private static final Set<String> stopwords = new HashSet<>(Arrays.asList(
            "i", "me", "my", "myself", "we", "our", "ours", "ourselves", "you", "your", "yours", "yourself",
            "yourselves", "he", "him", "his", "himself", "she", "her", "hers", "herself", "it", "its", "itself",
            "they", "them", "their", "theirs", "themselves", "what", "which", "who", "whom", "this", "that",
            "these", "those", "am", "is", "are", "was", "were", "be", "been", "being", "have", "has", "had", "having",
            "do", "does", "did", "doing", "a", "an", "the", "and", "but", "if", "or", "because", "as", "until", "while",
            "of", "at", "by", "for", "with", "about", "against", "between", "into", "through", "during", "before",
            "after", "above", "below", "to", "from", "up", "down", "in", "out", "on", "off", "over", "under", "again",
            "further", "then", "once", "here", "there", "when", "where", "why", "how", "all", "any", "both", "each",
            "few", "more", "most", "other", "some", "such", "no", "nor", "not", "only", "own", "same", "so", "than",
            "too", "very", "s", "t", "can", "will", "just", "don", "should", "now"
    ));

    public static String preprocessText(String text) {
        // Remove URLs
        text = text.replaceAll("http\\S+", "");

        // Remove special characters and punctuation
        text = text.replaceAll("[^\\w\\s]", "");

        // Remove extra whitespaces
        text = text.replaceAll("\\s+", " ").trim();

        // Remove numeric values
        text = text.replaceAll("\\d+", "");

        // Convert to lowercase
        text = text.toLowerCase();

        // Remove stopwords
        StringBuilder sb = new StringBuilder();
        for (String word : text.split(" ")) {
            if (!stopwords.contains(word)) {
                sb.append(word).append(" ");
            }
        }
        text = sb.toString().trim();

        // Step 9: Remove non-alphanumeric characters again (just in case)
        text = text.replaceAll("[^a-zA-Z\\s]", "");

        return text;
    }

    public static void main(String[] args) {
        String inputFile = "D:\\Emotional-Analysis\\DataFile\\emotion.csv";
        String outputFile = "D:\\Emotional-Analysis\\DataFile\\emotion_clean.csv";

        try (
                BufferedReader readFile = new BufferedReader(new FileReader(inputFile));
                BufferedWriter storeFile = new BufferedWriter(new FileWriter(outputFile))
        ) {
            String line;
            boolean firstLine = true;
            while ((line = readFile.readLine()) != null) {
                if (firstLine) {
                    storeFile.write("id,text,label\n");
                    firstLine = false;
                    continue;
                }
                String[] parts = line.split(",", 3);
                if (parts.length < 3) continue;

                String id = parts[0].trim();
                String text = parts[1].trim();
                String label = parts[2].trim();

                String cleanedText = preprocessText(text);
                storeFile.write(id + "," + cleanedText + "," + label + "\n");
            }
            System.out.println("complete preprocessing");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


