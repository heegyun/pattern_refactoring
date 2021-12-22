/*
 * �� �ڵ�� "�ڹ� ���������ϰ� �����丵(������ ��, �Ѻ� �̵��, 2003)"�� ���Ե� ���Դϴ�.
 * �� ������� �뵵��� ������� ���, ����, ������ �� �ֽ��ϴ�.
 * ��, �ҽ��ڵ带 ������ �� �� �ڸ�Ʈ�� �״�� �����Ǿ�� �մϴ�.
 * http://www.pairprogrammer.com/book/DesignPatternAndRefactoring
 */
 
package refactoring.examples.state.one;

import java.io.*;

/* Replace Type Code with State/Strategy */
public class StateDemoBefore {
	public static void main(String[] args) throws IOException {
		if ( args.length != 1) {
			System.out.println("���� : java StateDemoBefore [Happy|Angry|Cold]");
			System.exit(0);
		}
		
		MyRobot roboto = new MyRobot();
		
		if ( args[0].equals("Happy") )
			roboto.setState(0);
		else if ( args[0].equals("Angry") )
			roboto.setState(1);
		else if ( args[0].equals("Cold"))
			roboto.setState(2);
		
		roboto.talk();	
	}
}
	
class MyRobot {
	private int currentState; // 0 : Happy, 1: Angry, 2: Cold 

	public MyRobot() {
		currentState = 0;
	}
	
	public void setState(int currentState) {
		this.currentState = currentState;
	}	

	public void talk() {
		if (currentState == 0) { 
			System.out.println("����. ����~ ����~ ");
		} else if (currentState == 1) {
			System.out.println("����. �Ⱦ�~ �Ⱦ�~ ");
		} else if (currentState == 2) {
			System.out.println("����. �䷷~ �䷷~ ");
		}
		
	}
}

