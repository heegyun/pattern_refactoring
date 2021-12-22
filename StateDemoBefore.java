/*
 * 이 코드는 "자바 디자인패턴과 리팩토링(박지훈 저, 한빛 미디어, 2003)"에 포함된 것입니다.
 * 비 상업적인 용도라면 마음대로 사용, 변경, 배포할 수 있습니다.
 * 단, 소스코드를 배포할 때 이 코멘트는 그대로 유지되어야 합니다.
 * http://www.pairprogrammer.com/book/DesignPatternAndRefactoring
 */
 
package refactoring.examples.state.one;

import java.io.*;

/* Replace Type Code with State/Strategy */
public class StateDemoBefore {
	public static void main(String[] args) throws IOException {
		if ( args.length != 1) {
			System.out.println("사용법 : java StateDemoBefore [Happy|Angry|Cold]");
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
			System.out.println("아이. 좋아~ 좋아~ ");
		} else if (currentState == 1) {
			System.out.println("아이. 싫어~ 싫어~ ");
		} else if (currentState == 2) {
			System.out.println("아이. 썰렁~ 썰렁~ ");
		}
		
	}
}

