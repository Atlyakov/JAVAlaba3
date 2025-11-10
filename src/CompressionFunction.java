@FunctionalInterface
public interface CompressionFunction<T> {
    T compress(T a, T b);
}
