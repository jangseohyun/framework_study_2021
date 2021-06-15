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
		
		/*
		 * int sub = cal.sub(10, 20); System.out.println(sub);
		 * 
		 * int multi = cal.multi(10, 20); System.out.println(multi);
		 * 
		 * int div = cal.div(10, 20); System.out.println(div);
		 */
		
		// 예외 상황이 발생할 수 있도록 값을 넘기는 처리
		int add2 = cal.add(100, 200);
		System.out.println(add2);
	}
}

/*
[실행 결과-예외 발생 X]
6월 15, 2021 10:20:19 오전 org.springframework.context.support.AbstractApplicationContext prepareRefresh
정보: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@378fd1ac: startup date [Tue Jun 15 10:20:19 KST 2021]; root of context hierarchy
6월 15, 2021 10:20:19 오전 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
정보: Loading XML bean definitions from class path resource [config.xml]
6월 15, 2021 10:20:19 오전 org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
정보: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@63e31ee: defining beans [cal,aspect,before,afterThrowing,proxy]; root of factory hierarchy
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 종료-------------------
	10 + 20 = 30
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 8/1000초
	30
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 종료-------------------
	10 - 20 = -10
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 5/1000초
	-10
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 종료-------------------
	10 * 20 = 200
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 4/1000초
	200
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 실행--------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorBeforeAdvice before
	정보: Before Advice 종료-------------------
	10 / 20 = 0
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 10:20:19 오전 com.test.spr.CalculatorAspect invoke
	정보: 경과시간 : 3/1000초
	0
*/

/*
[실행 결과-예외 발생]
6월 15, 2021 10:23:10 오전 org.springframework.context.support.AbstractApplicationContext prepareRefresh
정보: Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@378fd1ac: startup date [Tue Jun 15 10:23:10 KST 2021]; root of context hierarchy
6월 15, 2021 10:23:11 오전 org.springframework.beans.factory.xml.XmlBeanDefinitionReader loadBeanDefinitions
정보: Loading XML bean definitions from class path resource [config.xml]
6월 15, 2021 10:23:11 오전 org.springframework.beans.factory.support.DefaultListableBeanFactory preInstantiateSingletons
정보: Pre-instantiating singletons in org.springframework.beans.factory.support.DefaultListableBeanFactory@63e31ee: defining beans [cal,aspect,before,afterThrowing,proxy]; root of factory hierarchy
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorBeforeAdvice before
정보: Before Advice 실행--------------------
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorBeforeAdvice before
정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorBeforeAdvice before
정보: Before Advice 종료-------------------
10 + 20 = 30
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 종료-------------------------
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorAspect invoke
정보: 경과시간 : 9/1000초
30
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorAspect invoke
정보: 처리 시간 측정 시작-------------------------
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorBeforeAdvice before
정보: Before Advice 실행--------------------
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorBeforeAdvice before
정보: 주 업무 실행 전에 수행되어야 하는 작업
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorBeforeAdvice before
정보: Before Advice 종료-------------------
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorAfterThrowing afterThrowing
	정보: After Throwing Advice 수행---------------------------
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorAfterThrowing afterThrowing
	정보: 주 업무 실행 과정에서 예외 발생 시 처리되는 사후 업무
6월 15, 2021 10:23:11 오전 com.test.spr.CalculatorAfterThrowing afterThrowing
	정보: ---------------------------After Throwing Advice 수행
Exception in thread "main" java.lang.IllegalArgumentException: 100보다 큰 인자를 전달한 예외 발생
	at com.test.spr.CalculatorImpl.add(CalculatorImpl.java:28)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:309)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:183)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:150)
	at org.springframework.aop.framework.adapter.ThrowsAdviceInterceptor.invoke(ThrowsAdviceInterceptor.java:124)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:50)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at com.test.spr.CalculatorAspect.invoke(CalculatorAspect.java:34)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:172)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:202)
	at com.sun.proxy.$Proxy0.add(Unknown Source)
	at com.test.spr.Main.main(Main.java:35)
*/