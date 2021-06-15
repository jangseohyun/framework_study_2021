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
6월 15, 2021 9:33:15 오전 org.springframework.context.support.AbstractApplicationContext prepareRefresh
정보: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@378fd1ac: startup date [Tue Jun 15 09:33:15 KST 2021]; root of context hierarchy
6월 15, 2021 9:33:15 오전 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
정보: Loading XML bean definitions from class path resource [config.xml]
6월 15, 2021 9:33:16 오전 org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
정보: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@63e31ee: defining beans [cal,aspect,before,proxy]; root of factory hierarchy
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행-------------------
	10 + 20 = 30
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 5/1000초
30
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행-------------------
	10 - 20 = -10
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 4/1000초
	-10
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행-------------------
	10 * 20 = 200
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 3/1000초
	200
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행-------------------
	10 / 20 = 0
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 9:33:16 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 4/1000초
	0
*/
