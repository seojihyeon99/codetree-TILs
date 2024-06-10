import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
    	LinkedList<Integer> list = new LinkedList<>();
       
    	int n = Integer.parseInt(br.readLine()); // 명령어의 개수
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	String op = st.nextToken(); // 연산 종류
        	switch(op) {
        	case "push_front":
        		list.addFirst(Integer.parseInt(st.nextToken()));
        		break;
        	case "push_back":
        		list.addLast(Integer.parseInt(st.nextToken()));
        		break;
        	case "pop_front":
        		sb.append(list.pollFirst() + "\n");
        		break;
        	case "pop_back":
        		sb.append(list.pollLast() + "\n");
        		break;
        	case "size":
        		sb.append(list.size() + "\n");
        		break;
        	case "empty":
        		sb.append(list.isEmpty()? 1 : 0 + "\n");
        		break;
        	case "front":
        		sb.append(list.peekFirst() + "\n");
        		break;
        	case "back":
        		sb.append(list.peekLast() + "\n");
        		break;
        	}
        }
       
        System.out.println(sb);
        
    }
}