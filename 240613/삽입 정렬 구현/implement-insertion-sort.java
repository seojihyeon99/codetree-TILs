import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 원소의 개수
        
        // 원소 입력 받기
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 삽입 정렬
        for(int i=1; i<n; i++) {
        	int idx = i-1; // 들어갈 위치의 바로 앞
        	int key = arr[i];
        	
        	while(idx>=0 && arr[idx] > key) {
        		arr[idx+1] = arr[idx];
        		idx--;
        	}
        	
        	arr[idx+1] = key;
        }
        
        
        // 출력
        for(int i=0; i<n; i++) {
        	System.out.print(arr[i] + " ");
        }
    }
}