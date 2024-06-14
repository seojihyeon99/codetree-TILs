import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

/**
 * 문제 조건에서 
 * 1<= 원소의 개수 n <100,000이고, 1<= 원소의 값 <= 100,000
 * 라고 했으므로 O(N^2)의 알고리즘은 불가능하다.
 * 
 * 따라서 O(k*N) 혹은 O(N^2) 알고리즘을 사용해야한다.
 */
public class Main {
	static int n;
	
    public static void main(String[] args) throws IOException {    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	
    	n = Integer.parseInt(br.readLine()); // 원소의 개수
    	
    	int[] arr = new int[n];

    	// 원소 입력 받기
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i=0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	// 병합 정렬 시작
    	mergeSort(arr, 0, n-1);
    	
    	// 출력
    	for(int i=0; i<n; i++) {
    		sb.append(arr[i] + " ");
    	}
    	System.out.println(sb);
    }
    
    // l~r에 대해서 병합 정렬 하는 함수
    static void mergeSort(int[] arr, int l, int r) {
    	if(l < r) {
    		int m = (l+r)/2;
    		mergeSort(arr, l, m); 	// 왼쪽 부분에 대해서 다시 병합 정렬
    		mergeSort(arr, m+1, r);	// 오른쪽 부분에 대해서 다시 병합 정렬
    		merge(arr, l, m, r); 	// 왼쪽 정렬된 부분 + 오른쪽 정렬된 부분을 합침   		
    	}
    }
    
    static void merge(int[] arr, int l, int m, int r) {
    	int i = l;
    	int j = m+1;
    	int k = l;
    	List<Integer> list = new LinkedList<>();
    	
    	while(i<=m && j<=r) {
    		if(arr[i] <= arr[j]) {
    			list.add(arr[i++]);		
    		} else {
    			list.add(arr[j++]);
    		}
    	}
    	
    	while(i<=m) {
    		list.add(arr[i++]);
    	}
    	
    	while(j<=r) {
    		list.add(arr[j++]);
    	}
    	
    	// 정렬된 부분을 원 배열로 복사
    	ListIterator<Integer> it = list.listIterator();
    	while(it.hasNext()) {
    		arr[k++] = it.next();
    	}
    }
}