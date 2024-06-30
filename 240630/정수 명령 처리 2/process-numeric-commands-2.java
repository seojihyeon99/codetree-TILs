import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new LinkedList<>();
		int n = Integer.parseInt(br.readLine()); // 명령어의 개수
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken(); // 명령어
			
			switch(op) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				break;
			case "pop":
				sb.append(queue.poll() + "\n");
				break;
			case "size":
				sb.append(queue.size() + "\n");
				break;
			case "empty":
				sb.append((queue.isEmpty()? 1 : 0) + "\n");
				break;
			case "front":
				sb.append(queue.peek() + "\n");
				break;
			}
		}
		
		System.out.println(sb);
	}
}