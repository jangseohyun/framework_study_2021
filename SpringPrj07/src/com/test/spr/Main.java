/*==============================================
	Main.java
	- main() 메소드를 포함하는 테스트 클래스
==============================================*/

package com.test.spr;

import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		// 주 업무 실행을 할 수 있는 객체 준비
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		//Calculator cal = new CalculatorImpl();
		Calculator cal = context.getBean("proxy",Calculator.class);
	
		int add = cal.add(10, 20);
		System.out.println(add);

		int sub = cal.sub(10, 20);
		System.out.println(sub);

		int multi = cal.multi(10, 20);
		System.out.println(multi);

		int div = cal.div(10, 20);
		System.out.println(div);
	}
}

/*
[실행 결과]
6월 14, 2021 2:05:13 오후 org.springframework.context.support.AbstractApplicationContext prepareRefresh
정보: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@378fd1ac: startup date [Mon Jun 14 14:05:13 KST 2021]; root of context hierarchy
6월 14, 2021 2:05:13 오후 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
정보: Loading XML bean definitions from class path resource [config.xml]
6월 14, 2021 2:05:14 오후 org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
정보: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@63e31ee: defining beans [cal,aspect,proxy]; root of factory hierarchy
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 시작-------------------------
10 + 20 = 30
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 종료-------------------------
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 경과시간 : 2/1000초
30
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 시작-------------------------
10 - 20 = -10
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 종료-------------------------
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 경과시간 : 2/1000초
-10
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 시작-------------------------
10 * 20 = 200
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 종료-------------------------
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 경과시간 : 1/1000초
200
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 시작-------------------------
10 / 20 = 0
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 종료-------------------------
6월 14, 2021 2:05:14 오후 com.test.spr.CalculatorAspect invoke
정보: 경과시간 : 2/1000초
0
*/
