import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine()); // 원소의 개수
        
        // 배열 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int idx = n;
        while(true) {
        	boolean sorted = true;
        	
        	for(int i=0; i<idx-1; i++) {
        		if(arr[i] > arr[i+1]) {
        			int tmp = arr[i];
        			arr[i] = arr[i+1];
        			arr[i+1] = tmp;
        			sorted = false;
        		}
        	}
        	
        	idx--;
        	if(sorted) break;
        }
        
        for(int i=0; i<n; i++) {
        	sb.append(arr[i] + " ");
        }
        
        System.out.println(sb);
    }
}