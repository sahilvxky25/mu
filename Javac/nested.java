import java.util.*;

public class FlattenList {
    public static List<Integer> flatten(List<Object> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (Object obj : nestedList) {
            if (obj instanceof Integer) {
                result.add((Integer) obj);
            } else if (obj instanceof List) {
                result.addAll(flatten((List<Object>) obj)); // Recursive case
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Object> nestedList = Arrays.asList(1, Arrays.asList(2, 3), 4, Arrays.asList(5, Arrays.asList(6, 7)));
        System.out.println(flatten(nestedList)); // Output: [1, 2, 3, 4, 5, 6, 7]
    }
}
