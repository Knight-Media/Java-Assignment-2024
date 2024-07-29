import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueryManager {
    private final HashMap<String, Future> query_results = null;

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public String runQuery(String word){
        Callable<Map<String, Integer>> task = () -> {
            HashMap<String, Integer> stringMap = new HashMap<String, Integer>();
            return stringMap;
        };
        Future<Map<String, Integer>> future = executorService.submit(task);
        query_results.put(word, future);

        // can return Id or something later
        return word;
    }

}
