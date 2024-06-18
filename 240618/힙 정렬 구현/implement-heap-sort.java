import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine()); // 원소의 개수
		
		// 배열에 원소 입력받기
		int[] arr = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 힙 정렬
		heapSort(arr, n);
		
		// 출력
		for(int i=1; i<=n; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}
	
	static void heapify(int[] arr, int i, int n) {
		int largest = i; // i번째 노드와 자식들 중 가장 큰 원소의 인덱스
		
		// 왼쪽 자식
		if(i*2 <= n && arr[i*2] > arr[largest]) {
			largest = i*2;
		}
		
		// 오른쪽 자식
		if(i*2+1 <= n && arr[i*2+1] > arr[largest]) {
			largest = i*2+1;
		}
		
		// i번째 노드가 자식들과 비교해서 최대가 아니라면 => 자식 중 최댓값과 swap하고 다시 해당 위치에서 heapify
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			
			heapify(arr, largest, n);
		}
	}
	
	static void heapSort(int[] arr, int n) {
		// 처음  max-heap 생성
		for(int i=n/2; i>=1; i--) {
			heapify(arr, i, n);			
		}
		
		// 이후 max-heap의 루트노드를 최댓값으로 설정하고, 다시 heap을 만듦(heapify(1))
		for(int i=n; i>=1; i--) {
			// 최댓값을 고정
			int temp = arr[i];
			arr[i] = arr[1];
			arr[1] = temp;
			// 남은 i-1개의 원소에 대해서 heapify(1)하여 다시 max-heap 생성
			heapify(arr, 1, i-1);
		}
	}
}