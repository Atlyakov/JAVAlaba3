import java.util.*;

public class ListTransformer {

    public static <T, P> List<P> transform(List<T> list, Function<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}
