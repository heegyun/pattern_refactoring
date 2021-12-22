/*
 * �� �ڵ�� "�ڹ� ���������ϰ� �����丵(������ ��, �Ѻ� �̵��, 2003)"�� ���Ե� ���Դϴ�.
 * �� ������� �뵵��� ������� ���, ����, ������ �� �ֽ��ϴ�.
 * ��, �ҽ��ڵ带 ������ �� �� �ڸ�Ʈ�� �״�� �����Ǿ�� �մϴ�.
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
	
	/* start���� end���� stack�� ���ڸ� �Է��Ѵ�. */
	public static void pushNumber(Stack stack, int start, int end) {
		for (int i = start; i <= end; i++)
			stack.push(i);
	}
	
	/* ������ ������ pop�ؼ� ����Ѵ�.*/
	public static void printStack(Stack stack) {
		while (!stack.isEmpty())
			System.out.print(stack.pop() + "  ");
		System.out.println();
	}
		
}

/* Stack ���� Ŭ������ �������̽� */
abstract class Stack {
	abstract void push(int i);
	abstract int pop();
	abstract int top();
	abstract boolean isEmpty();
	abstract boolean isFull();
}

/* �迭�� ������ ���� ���� Ŭ���� */
class StackArray extends Stack {
	private int[] items;
	private int total;
	
	public StackArray() {
		items = new int[10]; // ����Ʈ 
		total = -1;		
	}
		
	public StackArray(int num) {
		if ( num > 0 )
			items = new int[num];
		else
			items = new int[10]; // ����Ʈ 
			
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

/* ¦������ ���� ���� */
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

/* Ȧ������ ���� ���� */
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

