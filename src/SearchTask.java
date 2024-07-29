import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SearchTask implements Callable<List<Integer>> {
    private final String filePath;
    private final String wordToSearch;

    public SearchTask(String filePath, String wordToSearch) {
        this.filePath = filePath;
        this.wordToSearch = wordToSearch;
    }

    @Override
    public List<Integer> call() throws IOException {
        List<Integer> lineNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lineNumber = 1;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(wordToSearch)) {
                    lineNumbers.add(lineNumber);
                }
                lineNumber++;
            }
        }
        return lineNumbers;
    }
}
