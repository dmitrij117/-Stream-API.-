import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> intListResult = new ArrayList<>();
        for (int value : intList) {
            if (value > 0 && value % 2 == 0) intListResult.add(value);
        }
        sorting(intListResult, 0, intListResult.size() -1);
        for (int value : intListResult) {
            System.out.println(value);
        }

    }
    public static void sorting(List<Integer> intList, int low, int tall) {
        int middle = low + (tall - low) /2;
        int base = intList.get(middle);
        int i = low, j = tall;
        while (i <= j) {
            while (intList.get(i) < base) {
                i++;
            }
            while (intList.get(j) > base) {
                j--;
            }

            if (i <= j) {
                int boof = intList.get(i);
                intList.set(i, intList.get(j));
                intList.set(j, boof);
                i++;
                j--;
            }
        }
        if (low < j) sorting(intList, low, j);
        if (tall > i) sorting(intList, i, tall);


    }
}
