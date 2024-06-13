import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
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

        // 해당 자리가 0~9인 숫자 저장
    	Queue<Integer>[] queue = new Queue[10];
    	for(int i=0; i<10; i++) {
    		queue[i] = new ArrayDeque<>();
    	}
    	
    	// 기수 정렬
        for(int i=1; i<=6; i++) { // i는 현재 자릿수(뒤에서부터)
        	// 해당 보는 자리의 값에(0~9) 따라서 0번~9번 Queue에 넣음
        	for(int j=0; j<n; j++) {
        		int digit = arr[j]%(int)Math.pow(10, i);
        		if(i != 1) digit = digit/(int)Math.pow(10, i-1);
        		
        		queue[digit].offer(arr[j]);
        	}
        	
        	//0번~9번 큐를 순회하며, 각각의 원소를 꺼내어 새로운 배열에 넣어줌
        	int[] newArr = new int[n];
        	int idx = 0;
        	for(int j=0; j<10; j++) {
        		int size = queue[j].size();
        		for(int k=0; k<size; k++) {
        			newArr[idx++] = queue[j].poll();
        		}
        	}
        	
        	arr = newArr; // 새로운 배열(newArr)을 다시 시작배열(arr)로
        }
        
        // 출력
        for(int i=0; i<n; i++) {
        	System.out.print(arr[i] + " ");
        }
    }
}