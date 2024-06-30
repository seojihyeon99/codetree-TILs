import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		
		String s = br.readLine(); // 괄호 문자열
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			// 여는 괄호('(')
			if(c == '(') {
				stack.push('(');
			}
			// 닫는 괄호(')')
			else {
				if(stack.isEmpty()) {
					System.out.println("No");
					return;
				}
				
				stack.pop();
			}
		}
		
		if(!stack.isEmpty()) System.out.println("No");
		else System.out.println("Yes");
	}
}