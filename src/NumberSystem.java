import java.util.ArrayList;
import java.util.List;

public class NumberSystem {
    public static List<String> toBinary(List<Integer> numbers) {
        List<String> result = new ArrayList<>();
        for(Integer i : numbers) {
            result.add(convertToBase(i, 2));
        }
        return result;
    }

    public static List<String> toOctal(List<Integer> numbers) {
        List<String> result = new ArrayList<>();
        for(Integer i : numbers) {
            result.add(convertToBase(i, 8));
        }
        return result;
    }

    public static List<String> toHexadecimal(List<Integer> numbers) {
        List<String> result = new ArrayList<>();
        for(Integer i : numbers) {
            result.add(convertToBase(i, 16));
        }
        return result;
    }



    private static String convertToBase(int number, int base) {
        if(number == 0) {
            return "0";
        }

        char[] digits = "0123456789ABCDEF".toCharArray();

        StringBuilder result = new StringBuilder();

        while(number > 0) {
            int remainder = number % base;
            result.append(digits[remainder]);
            number /= base;
        }
        return result.reverse().toString();
    }
}
