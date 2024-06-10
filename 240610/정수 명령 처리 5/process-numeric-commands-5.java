import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine()); // 연산 개수
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            switch(op) {
            case "push_back":
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
                break;
            case "pop_back":
                stack.pop();
                break;
            case "size":
                sb.append(stack.size() + "\n");
                break;
            case "get":
                num = Integer.parseInt(st.nextToken()) - 1;
                sb.append(stack.get(num) + "\n");
                break;
            }
        }

        System.out.println(sb);

    }
}