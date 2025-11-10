import java.util.*;
import java.util.function.*;

/**
 * Класс с универсальным методом для обработки коллекций.
 */
public class CollectionProcessor {

    public static <T, P> P processCollection(
            List<T> source,
            Supplier<P> collectionSupplier,
            BiConsumer<P, T> accumulator) {

        P result = collectionSupplier.get();

        for (T item : source) {
            accumulator.accept(result, item);
        }

        return result;
    }
}
