import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static int uniqueWolfs(List<Integer> arr) {
        int result, maxValue = 0;
        int[] counter = new int[5];

        if (arr.size() < 5 || arr.size() > 2 * Math.pow(10, 5)) {
            System.out.println("\n5'ten Büyük veya 2 * 10^5'ten Küçük Değer Girmelisiniz!");
            result = -1;
            return result;
        }

        for (int i = 0; i < arr.size(); i++) {
            switch (arr.get(i)) {
                case 1:
                    counter[0]++;
                    break;
                case 2:
                    counter[1]++;
                    break;
                case 3:
                    counter[2]++;
                    break;
                case 4:
                    counter[3]++;
                    break;
                case 5:
                    counter[4]++;
                    break;
            }
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > maxValue)
                maxValue = i + 1;
        }

        result = maxValue;

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Output.txt"));
        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("")).map(Integer::parseInt).collect(toList());
        int result = Result.uniqueWolfs(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}