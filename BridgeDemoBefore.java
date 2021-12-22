/*
 * 이 코드는 "자바 디자인패턴과 리팩토링(박지훈 저, 한빛 미디어, 2003)"에 포함된 것입니다.
 * 비 상업적인 용도라면 마음대로 사용, 변경, 배포할 수 있습니다.
 * 단, 소스코드를 배포할 때 이 코멘트는 그대로 유지되어야 합니다.
 * http://www.pairprogrammer.com/book/DesignPatternAndRefactoring
 */
 
package refactoring.examples.bridge.one;

/* Tease Apart Inheritance */
public class BridgeDemoBefore {
	public static void main(String[] args) {
		Stack[] stacks = { new EvenNumberStackArray(15), new OddNumberStackArray(15)};		
	
		for (int i = 0; i < stacks.length; i++)
			pushNumber(stacks[i], 1, 50);
				
		for (int j = 0;  j < stacks.length; j++) {
			printStack(stacks[j]);			
		}		
	}
	
	/* start부터 end까지 stack에 숫자를 입력한다. */
	public static void pushNumber(Stack stack, int start, int end) {
		for (int i = start; i <= end; i++)
			stack.push(i);
	}
	
	/* 스택의 값들을 pop해서 출력한다.*/
	public static void printStack(Stack stack) {
		while (!stack.isEmpty())
			System.out.print(stack.pop() + "  ");
		System.out.println();
	}
		
}

/* Stack 구현 클래스의 인터페이스 */
abstract class Stack {
	abstract void push(int i);
	abstract int pop();
	abstract int top();
	abstract boolean isEmpty();
	abstract boolean isFull();
}

/* 배열로 구현된 스택 구현 클래스 */
class StackArray extends Stack {
	private int[] items;
	private int total;
	
	public StackArray() {
		items = new int[10]; // 디폴트 
		total = -1;		
	}
		
	public StackArray(int num) {
		if ( num > 0 )
			items = new int[num];
		else
			items = new int[10]; // 디폴트 
			
		total = -1;
	}
	
	public void push(int i) {
		if (!isFull())
			items[++total] = i;
	}
	
	public boolean isEmpty() {
		return total == -1;
	}
	
	public boolean isFull() {
		return total == items.length - 1;
	}
	
	public int top() {
		if (isEmpty())
			return -1;
		return items[total];
	}
	
	public int pop() {
		if (isEmpty())
			return -1;
			
		return items[total--];
	}
	
}

/* 짝수값만 들어가는 스택 */
class EvenNumberStackArray extends StackArray {
	
	public EvenNumberStackArray(int num) {
		super(num);
	}
	
	public void push(int in) {
		if ( in%2 != 0 ) 
			return;
		
		super.push(in);		
	}	
}

/* 홀수값만 들어가는 스택 */
class OddNumberStackArray extends StackArray {
	public OddNumberStackArray(int num) {
		super(num);
	}
	
	public void push(int in) {
		if ( in%2 == 0 ) 
			return;
		
		super.push(in);		
	}		
}

