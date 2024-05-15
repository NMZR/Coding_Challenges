package GetMinLength;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolutionGetMinLength {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String seq = bufferedReader.readLine().trim();

        int result = GetMinLength.getMinLength(seq);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
