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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배열 입력받기
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 퀵소트
		quickSort(arr, 0, n-1);
		
		// 출력
		for(int i=0; i<n; i++) {
			sb.append(arr[i] + " ");
		}
		System.out.println(sb);
	}
	
	// left ~ right까지 퀵소트를 이용해서 정렬하는 함수
	static void quickSort(int[] arr, int left, int right) {
		// 원소의 개수가 2개 이상이라면
		if(left < right) {
			int p = partition(arr, left, right);
			
			quickSort(arr, left, p-1);
			quickSort(arr, p+1, right);
		}
	}
	
	// pivot을 기준으로 왼쪽(피봇 미만)과 오른쪽(피봇 이상)으로 나누는 함수
	static int partition(int[] arr, int left, int right) {
		int pivot = arr[right];
		
		int i = left - 1; // pivot 기준 왼쪽(피봇 미만)을 가리키는 포인터
		
		for(int j=left; j<right; j++) {
			if(arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		// pivot과  왼쪽포인터 +1(오른쪽 부분 시작)을 교환
		int temp = arr[i+1];
		arr[i+1] = pivot;
		arr[right] = temp;
		
		return i+1; // pivot의 위치
	}
}