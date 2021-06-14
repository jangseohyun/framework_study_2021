/*==============================================
	Main.java
	- main() 메소드를 포함하는 테스트 클래스
==============================================*/

package com.test.spr;

import java.lang.reflect.Proxy;

public class Main
{
	public static void main(String[] args)
	{
		// 주 업무 실행을 할 수 있는 객체 준비
		// 인터페이스 변수 = new 인터페이스구현클래스();
		Calculator cal = new CalculatorImpl();
		// List list = new ArrayList();
		
		// 주 업무 실행에 대한 테스트
		/*
		int add = cal.add(10, 20);
		System.out.println(add);
		
		int sub = cal.sub(10, 20);
		System.out.println(sub);
		
		int multi = cal.multi(10, 20);
		System.out.println(multi);
		
		int div = cal.div(10, 20);
		System.out.println(div);
		*/
		
		// 주 업무 실행에 대한 테스트(AOP 기법 적용 후)
		// Proxy.newProxyInstance(loader-주 업무 실행 클래스에 대한 정보 전달
		//                      , interfaces-주 업무 실행 클래스의 인터페이스에 대한 정보
		//                      , h-보조 업무 실행 클래스에 대한 정보 전달);
		Calculator proxy = (Calculator)Proxy.newProxyInstance(cal.getClass().getClassLoader(), cal.getClass().getInterfaces(), new CalculatorProxy(cal));
		
		int add = proxy.add(10, 20);
		System.out.println(add);

		int sub = proxy.sub(10, 20);
		System.out.println(sub);

		int multi = proxy.multi(10, 20);
		System.out.println(multi);

		int div = proxy.div(10, 20);
		System.out.println(div);
	}
}

/*
[실행 결과]
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
10 + 20 = 30
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 경과시간: 70/1000초
30
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
10 - 20 = -10
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 경과시간: 1/1000초
-10
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
10 * 20 = 200
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 경과시간: 1/1000초
200
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
10 / 20 = 0
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 처리 시간 측정 시작--------------------
6월 14, 2021 11:37:12 오전 com.test.spr.CalculatorProxy invoke
정보: 경과시간: 1/1000초
0
*/
