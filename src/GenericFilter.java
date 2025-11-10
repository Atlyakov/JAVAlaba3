import java.util.*;

public class GenericFilter {
    public static <T> List<T> filter(List<T> list, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (filter.test(element)) {
                result.add(element);
            }
        }
        return result;
    }
}

