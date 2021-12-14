/*
 * 이 코드는 "자바 디자인패턴과 리팩토링(박지훈 저, 한빛 미디어, 2003)"에 포함된 것입니다.
 * 비 상업적인 용도라면 마음대로 사용, 변경, 배포할 수 있습니다.
 * 단, 소스코드를 배포할 때 이 코멘트는 그대로 유지되어야 합니다.
 * http://www.pairprogrammer.com/book/DesignPatternAndRefactoring
 */
 
package refactoring.examples.printer.one;

/* Extract SuperClass */
public class PrinterExample {

	public static void main(String[] args) {

		InkjetPrinter iPrinter = new InkjetPrinter("101");
		DotPrinter dPrinter = new DotPrinter("102");
		LaserPrinter lPrinter = new LaserPrinter("103");
		PDFWriter pWriter = new PDFWriter("Test.pdf");

		iPrinter.print("환영합니다. 프린터를 테스트중입니다.");
		dPrinter.print("환영합니다. 프린터를 테스트중입니다.");
		lPrinter.print("환영합니다. 프린터를 테스트중입니다.");
		pWriter.print("환영합니다. 프린터를 테스트중입니다.");		
	}
}

class InkjetPrinter {
	private double inkCapacity; // 잉크의 용량 
	private double inkReductionRate; // 한번 프린트할 때마다 줄어드는 잉크의 비율 
	
	private String ID;
	
	public InkjetPrinter(String ID) {
		this.ID = ID;
		inkCapacity = 100;
		inkReductionRate = 0.5; 
	}
	
	public String getID() {
		return ID;
	}

	public void print(Object msg) {
		if ( isPrintable() ) {
			System.out.println("*잉크젯 방식으로 프린트를 시작합니다.*");
			System.out.println(msg.toString());
			System.out.println("*잉크젯 방식으로 프린트를 종료합니다.*");	
			
			inkCapacity -= inkReductionRate;			
		} else 
			alert();				
	}
	
	public void alert() {
		System.out.println("잉크가 부족합니다. 빨간 램프를 깜박깜박~ ");
	}
	
	public boolean isPrintable() { // 한장을 찍을 분량이 남아있으면,
		return (inkCapacity - inkReductionRate) >= 0;		
	}
	
	public void testPrinting() {
		print("아아~ 프린트 테스트. 프린트 테스트");												 
	}	
}

class DotPrinter {
	private String ID;

	public DotPrinter(String ID) {
		this.ID = ID;
	}
	
	public String getID() {
		return ID;
	}

	public void print(Object msg) {
		if ( isPrintable() ) {
			System.out.println("*도트 방식으로 프린트를 시작합니다.*");
			System.out.println(msg.toString());
			System.out.println("*도트 방식으로 프린트를 종료합니다.*");						
		} 				
	}
	
	public boolean isPrintable() { 
		return true;		
	}
	
	public void testPrinting() {
		print("아아~ 프린트 테스트. 프린트 테스트");												 
	}	
}

class LaserPrinter {
	private double tonerCapacity; // 토너의 용량
	private double tonerReductionRate; // 한번 프린트할 때마다 줄어드는 토너의 비율 
	
	private String ID;

	public LaserPrinter(String ID) {
		this.ID = ID;
		tonerCapacity = 100;
		tonerReductionRate = 0.2;
	}
	
	public String getID() {
		return ID;
	}
	
	public void print(Object msg) {
		if ( isPrintable() ) {
			System.out.println("*레이저 방식으로 프린트를 시작합니다.*");
			System.out.println(msg.toString());
			System.out.println("*레이저 방식으로 프린트를 종료합니다.*");	
			
			tonerCapacity -= tonerReductionRate;			
		} else 
			alert();				
	}
	
	public void alert() {
		System.out.println("토너가 부족합니다. 노란 램프를 깜박깜박~ ");
	}
	
	public boolean isPrintable() { // 한장을 찍을 분량이 남아있으면,
		return (tonerCapacity - tonerReductionRate) >= 0;		
	}
	
	public void testPrinting() {
		print("아아~ 프린트 테스트. 프린트 테스트");												 
	}		
}


class PDFWriter  {
	private String fileName; // PDF 문서 파일 이름

    public PDFWriter(String fileName) {
        this.fileName = fileName;
    }
    
   	public void setFileName(String fileName) {
   		this.fileName = fileName;
   	}

    public void print(Object document) {
        System.out.println("*문서내용을 " + fileName + " 파일에 PDF 포맷으로 출력하기 시작합니다.*");
        System.out.println(document);
        System.out.println("*문서내용을 PDF 포맷으로 출력을 완료했습니다.");
    }    	
}

