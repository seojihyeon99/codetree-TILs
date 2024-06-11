import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;


/**
 * L은 포인터 좌로 이동, R은 포인터 우로 이동 => 좌우로 포인터 이동 편해야 하므로, Iterator 써서 prev, next 활용해야겠다.
 * D은 노드 제거, P는 노드 추가 => 삭제/삽입이 빈번하게 일어날 수도 있으니.. 동적배열보다는 연결리스트 써야겠다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
    	
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 식빵의 개수
        int m = Integer.parseInt(st.nextToken()); // 암호문의 개수
        
        // 식빵에 적힌 알파벳 입력 받기
        LinkedList<Character> l = new LinkedList<>();
        String s = br.readLine();
        for(int i=0; i<n; i++) {
        	l.add(s.charAt(i));
        }
        
        ListIterator<Character> it = l.listIterator(l.size()); // 가리키는 위치는 처음에 모든 빵의 맨 마지막에 위치
        // 연산 입력 받아, 연산 수행하기
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	char op = st.nextToken().charAt(0);
        	
        	switch(op) {
    		case 'L':
    			if(it.hasPrevious()) it.previous();
    			break;
    		case 'R':
    			if(it.hasNext()) it.next();
    			break;
    		case 'D':
    			if(it.hasNext()) {
    				it.next();
    				it.remove();
    			}
    			break;
    		case 'P':
    			char c = st.nextToken().charAt(0);
    			it.add(c);
    			break;
        	}
        	
        }
        
        for(int i=0; i<l.size(); i++) {
        	sb.append(l.get(i));
        }
        System.out.println(sb);
        
    }
}