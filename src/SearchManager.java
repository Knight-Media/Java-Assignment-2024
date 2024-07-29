import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SearchManager {
    private static final String folderPath = "./input";
    private static String[] filePaths = null;
    ExecutorService executor = Executors.newFixedThreadPool(5);
    List<Future<List<Integer>>> futures = new ArrayList<>();
    Map<String, List<Integer>> results = new HashMap<>();

    public Queue<String> queue;

    public SearchManager() {
        queue = new LinkedList<>();
        if(filePaths == null) {
            filePaths = FilePathGenerator.getFilePaths(folderPath);
        }
    }

    public void search(String word) {
        queue.add(word);

    }
    public void searchLinesinFiles(String wordToSearch) throws ExecutionException, InterruptedException {
        for (String filePath : filePaths) {
            futures.add(executor.submit(new SearchTask(filePath, wordToSearch)));
        }
        executor.shutdown();

        for (Future<List<Integer>> future : futures) {
            List<Integer> lineNumbers = future.get();
            if (!lineNumbers.isEmpty()) {
                System.out.println("Found in file: " + future.get().get(0) + ", line numbers: " + lineNumbers);
            }
        }
    }
}
