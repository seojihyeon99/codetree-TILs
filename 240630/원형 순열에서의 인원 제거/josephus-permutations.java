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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 사람의 수
		int k = Integer.parseInt(st.nextToken()); // 제거되는 순서
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i=0; i<k-1; i++) {
				queue.offer(queue.poll());
			}
			
			sb.append(queue.poll() + " ");
		}
		
		System.out.println(sb);
	}
}