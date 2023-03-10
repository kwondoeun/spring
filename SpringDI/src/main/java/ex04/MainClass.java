package ex04;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		//Car, Airplane 빈을 생성하고, 의존성 주입
		//각 객체 안에 있는 배터리를 자바클래스에서 출력.
		//인터페이스는 모형일 뿐이다.

		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("application-context.xml");

		Car car = ctx.getBean(Car.class);
		car.getBattery().energy();

		Airplane airplane = ctx.getBean("airplane" , Airplane.class);
		//System.out.println(airplane.getBattery()); //ex04.Battery2@50b5ac82

		airplane.getBattery().energy();


	}
}
