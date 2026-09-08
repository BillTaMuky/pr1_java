import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String data = readFile("src/raw_data.txt");
        List<Integer> numbers = filter(data);
        System.out.println(NumberSystem.toBinary(numbers));
        System.out.println(NumberSystem.toOctal(numbers));
        System.out.println(NumberSystem.toHexadecimal(numbers));
    }

    private static String readFile(String filename) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                builder.append(currentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String data = builder.toString();
        return data;
    }

    private static List<Integer> filter(String data) {
        System.out.println(data);

        List<Integer> numbers = new ArrayList<>();

        int currentNumber = 0;
        boolean hasDigits = false;

        for(int i = 0; i < data.length(); i++) {
            char c = data.charAt( i);

            if(c >= '0' && c <= '9') {
                int digit = c - '0';
                currentNumber = currentNumber * 10 + digit;
                hasDigits = true;
            }
            else {
                if(hasDigits) {
                    numbers.add(currentNumber);
                    currentNumber = 0;
                    hasDigits = false;
                }
            }

        }

        if (hasDigits) {
            numbers.add(currentNumber);
        }
        System.out.println(numbers);
        return numbers;

    }
}

