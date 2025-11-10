import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckErrors check = new CheckErrors();

        System.out.print("Выберите задание из 3 типа (1-4): ");
        int choice = check.CheckNumber();

        switch (choice) {
            case 1:
                System.out.println(
                        "1. Отфильтровать строки длиной < 3: “qwerty”, “asdfg”, “zx”\n" +
                                "2. Отфильтровать положительные числа: 1, -3, 7\n" +
                                "3. Оставить массивы без положительных элементов: {1,2,3}, {-1,-2,-3}, {0,-1,5}, {-5,0,-10}\n"
                );
                // 1. Строки → длины строк
                List<String> strings1 = Arrays.asList("qwerty", "asdfg", "zx");
                List<Integer> lengths = ListTransformer.transform(strings1, s -> s.length());
                System.out.println("Длины строк: " + lengths); // [6, 5, 2]

                // 2. Числа: отрицательные → положительные
                List<Integer> numbers1 = Arrays.asList(1, -3, 7);
                List<Integer> absoluteValues = ListTransformer.transform(numbers1, n -> Math.abs(n));
                System.out.println("Модули чисел: " + absoluteValues); // [1, 3, 7]

                // 3. Массивы → максимумы
                List<int[]> arrays1 = Arrays.asList(
                        new int[]{1, 2, 3},
                        new int[]{-1, -2, -3},
                        new int[]{0, -1, 5},
                        new int[]{-5, 0, -10}
                );

                List<Integer> maxValues = ListTransformer.transform(arrays1, arr -> {
                    if (arr.length == 0) {
                        throw new IllegalArgumentException("Массив пуст");
                    }
                    int max = arr[0];
                    for (int num : arr) {
                        if (num > max) {
                            max = num;
                        }
                    }
                    return max;
                });

                System.out.println("Максимальные значения в массивах: " + maxValues); // [3, -1, 5, 0]
                break;

            case 2:
                System.out.println(
                        "1.  1. Преобразование строк в их длины: “qwerty”, “asdfg”, “zx”\n" +
                                "2. Преобразование чисел: отрицательные → положительные, положительные → без изменений: 1, -3, 7\n" +
                                "3. Из массивов чисел — максимальные значения каждого массива: {1,2,3}, {-1,-2,-3}, {0,-1,5}, {-5,0,-10}\n"
                );

                // 1. Фильтрация строк: длина ≥ 3
                List<String> strings2 = Arrays.asList("qwerty", "asdfg", "zx");
                List<String> filteredStrings = GenericFilter.filter(strings2, s -> s.length() >= 3);
                System.out.println("Строки длиной ≥ 3: " + filteredStrings);

                // 2. Фильтрация чисел: только положительные
                List<Integer> numbers2 = Arrays.asList(1, -3, 7);
                List<Integer> positiveNumbers = GenericFilter.filter(numbers2, n -> n > 0);
                System.out.println("Положительные числа: " + positiveNumbers);


                // 3. Фильтрация массивов: нет положительных элементов
                List<int[]> arrays2 = new ArrayList<>(Arrays.asList(
                        new int[]{1, 2, 3},
                        new int[]{-1, -2, -3},
                        new int[]{0, -1, 5},
                        new int[]{-5, 0, -10}
                ));

                List<int[]> nonPositiveArrays = GenericFilter.filter(arrays2, arr -> {
                    for (int num : arr) {
                        if (num > 0) {
                            return false;
                        }
                    }
                    return true;
                });

                System.out.println("Массивы без положительных элементов:");
                for (int[] arr : nonPositiveArrays) {
                    System.out.println(Arrays.toString(arr));
                }
                break;
            case 3:
                System.out.println(
                        "1.Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, и сформируйте одну\n" +
                                "большую строку, которая состоит из всех строк исходного списка.\n" +
                                "2. Передайте в метод список со значениями: 1,-3,7, и верните сумму всех значений исходного\n" +
                                "списка.\n" +
                                "3. Имеется список, состоящий из списков целых чисел, получите общеe количество\n" +
                                "элементов во всех списках.\n"
                );
                // Задача 1: объединить строки "qwerty", "asdfg", "zx"
                List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                String concatenated = Compression.compress(strings, "",  // начальное значение — пустая строка
                        (a, b) -> a + b  // операция: конкатенация
                );
                System.out.println("1. Объединённая строка: " + concatenated);

                // Задача 2: сумма чисел 1, -3, 7
                List<Integer> numbers = Arrays.asList(1, -3, 7);
                Integer sum = Compression.compress(
                        numbers,
                        0,  // начальное значение — ноль
                        (a, b) -> a + b  // операция: сложение
                );
                System.out.println("2. Сумма чисел: " + sum);

                // Задача 3: общее количество элементов в списках списков
                List<List<Integer>> listsOfNumbers = Arrays.asList(
                        Arrays.asList(1, 2, 3),      // 3 элемента
                        Arrays.asList(4, 5),         // 2 элемента
                        Arrays.asList(6, 7, 8, 9) // 4 элемента
                );

                // Решение в ОДНО ДЕЙСТВИЕ через Stream API
                int totalCount = listsOfNumbers.stream().mapToInt(List::size).sum();  // преобразуем каждый подсписок в его длину (int), суммируем все длины

                System.out.println("3. Общее количество элементов: " + totalCount);
                break;
            case 4:
                System.out.println(
                        "1. Передайте в метод список со значениями: 1,-3,7, и верните их разбитыми на два\n" +
                                "подсписка, в одном из которых будут только положительные числа, а в другом только\n" +
                                "отрицательные\n" +
                                "2. Передайте в метод список со значениями: “qwerty”, “asdfg”, “zx”, “qw” и верните их\n" +
                                "разбитыми на подсписки таким образом, чтобы в любом подсписке были строки только\n" +
                                "одинаковой длины\n" +
                                "3. Передайте в метод список со значениями: “qwerty”, “asdfg”, “qwerty”, “qw” и верните набор\n" +
                                "такого вида, который не может содержать одинаковые объекты\n"
                );
                // Задача 1: Разделение на положительные и отрицательные числа
                System.out.println("Задача 1: Положительные и отрицательные числа");
                List<Integer> numbers9 = List.of(1, -3, 7);

                List<List<Integer>> result1 = CollectionProcessor.processCollection(
                        numbers9,
                        () -> Arrays.asList(new ArrayList<>(), new ArrayList<>()),
                        (lists, num) -> {
                            if (num > 0) {
                                lists.get(0).add(num);  // положительные — в первый подсписок
                            } else {
                                lists.get(1).add(num);  // отрицательные — во второй
                            }
                        }
                );

                System.out.println("Положительные: " + result1.get(0));
                System.out.println("Отрицательные: " + result1.get(1));
                System.out.println();

                // Задача 2: Группировка строк по длине
                System.out.println("Задача 2: Группировка по длине строк");
                List<String> strings9 = List.of("qwerty", "asdfg", "zx", "qw");

                Map<Integer, List<String>> result2 = CollectionProcessor.processCollection(
                        strings9,
                        HashMap::new,
                        (map, str) -> {
                            map.computeIfAbsent(str.length(), k -> new ArrayList<>())
                                    .add(str);
                        }
                );

                List<List<String>> grouped = new ArrayList<>(result2.values());
                System.out.println("Группы по длине: " + grouped);
                System.out.println();

                // Задача 3: Удаление дубликатов (уникальные строки)
                System.out.println("Задача 3: Уникальные строки");
                List<String> strings3 = List.of("qwerty", "asdfg", "qwerty", "qw");

                Set<String> result3 = CollectionProcessor.processCollection(
                        strings3,
                        HashSet::new,
                        Set::add
                );

                System.out.println("Уникальные строки: " + result3);
                break;

            default:
                System.out.println("Ошибка: выберите задание с 1 по 5!");
        }
    }
}
