import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 원소의 개수
        
        // 원소 입력받기
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 선택 정렬
        for(int i=0; i<n-1; i++) {
        	int minIdx = i;
        	
        	for(int j=i+1; j<n; j++) {
        		if(arr[j] < arr[minIdx])
        			minIdx = j;
        	}
        	
        	int tmp = arr[i];
        	arr[i] = arr[minIdx];
        	arr[minIdx] = tmp;
        }
        
        // 출력
        for(int i=0; i<n; i++) {
        	System.out.print(arr[i] + " ");
        }
    }
}