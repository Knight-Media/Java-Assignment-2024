import java.util.List;

public class QueryResolver {
    private List<String> query_words;

    public QueryResolver(List<String> query_words) {
        this.query_words = query_words;
    }

    public List<String> resolve() {
        return java.util.Collections.emptyList();
    }
}
