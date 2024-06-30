import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Deque<Integer> dq = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine()); // 명령어의 개수
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch(op) {
			case "push_front":
				int num = Integer.parseInt(st.nextToken());
				dq.offerFirst(num);
				break;
			case "push_back":
				num = Integer.parseInt(st.nextToken());
				dq.offerLast(num);
				break;
			case "pop_front":
				sb.append(dq.pollFirst() + "\n");
				break;
			case "pop_back":
				sb.append(dq.pollLast() + "\n");
				break;
			case "size":
				sb.append(dq.size() + "\n");
				break;
			case "empty":
				sb.append((dq.isEmpty() ? 1 : 0) + "\n");
				break;
			case "front":
				sb.append(dq.peekFirst() + "\n");
				break;
			case "back":
				sb.append(dq.peekLast() + "\n");
				break;
			}
		}
		
		System.out.println(sb);
		
	}
}