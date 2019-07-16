import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
        int leftSum = 0;
        int rightSum = 0;
        List<List<Integer>> tempArr = new ArrayList<>();
        for (int i=0; i<arr.size();i++) {
            if (arr.get(i).size() == 1) {
                continue;
            }
            tempArr.add(arr.get(i));
        }
        
        System.out.println(tempArr);

        for (int j=0; j<tempArr.size();j++) {
            leftSum = tempArr.get(j).get(j) + leftSum;
            System.out.println(leftSum);
        }

        int i =0;
        for (int k=tempArr.size()-1; k>=0;k--) {          
            rightSum = tempArr.get(i++).get(k) + rightSum;
            System.out.println(rightSum);
        }

        return Math.abs(leftSum-rightSum);

    }

}

public class SolutionDiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
