import java.util.List;

public class Compression {

    public static <T> T compress(List<T> list, T initial, CompressionFunction<T> algorithm) {
        // Если список null или пуст — возвращаем начальное значение
        if (list == null || list.isEmpty()) {
            return initial;
        }

        T result = initial;
        for (T item : list) {
            result = algorithm.compress(result, item);
        }
        return result;
    }
}
