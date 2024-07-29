import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        // step 1:
        // get the different keywords from the query : later implementation
        // having hard coded keywords for now
        String word1 = "Hello";
        String word2 = "World";
        List<String> query_words = new ArrayList<>();
        query_words.add(word1);
        query_words.add(word2);


        // step 2:
        // send the query to query module
        QueryManager queryManager = new QueryManager();
        queryManager.runQuery(word1);

        // step 3:
        // query module will redirect keywords to searchManager

        // step 4:
        // search manager query the files
    }
}