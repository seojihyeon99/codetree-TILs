import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		
		int n = Integer.parseInt(br.readLine()); // 명령어의 가짓수 
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String op = st.nextToken();
			switch(op) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case "size" :
				sb.append(stack.size() + "\n");
				break;
			case "empty":
				sb.append((stack.isEmpty()? 1 : 0) + "\n");
				break;
			case "top":
				sb.append(stack.peek() + "\n");
				break;
			case "pop":
				sb.append(stack.pop() + "\n");
				break;
			}
		}
		
		System.out.println(sb);
	}
}