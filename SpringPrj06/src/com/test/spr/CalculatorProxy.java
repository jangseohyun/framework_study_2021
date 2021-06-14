/*=============================================
    CalculatorProxy.java
    - 프록시 클래스
    - 보조 업무 적용 및 주 업무 호출 과정
=============================================*/

package com.test.spr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// ※ Proxy 클래스를 만드는 방법 중 비교적 쉽고 직관적인 방법은
//    InvocationHandler(따라하기 위한 키트) 인터페이스를 구현하는 클래스를 만드는 것이다.

public class CalculatorProxy implements InvocationHandler
{
	private Object target;
	
	// 생성자 정의
	public CalculatorProxy(Object target)
	{
		this.target = target;
	}
	
	// 보조 업무 적용 및 주 업무 호출 과정 추가
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
	    // 예시로 가영이가 정미 따라하도록 하기 위해 Object proxy(성격), Method method(습관) 등을 키트로 받을 수 있게 해주는 부분
	    // 굳이 분해해서 찾아볼 필요 없이 그냥 틀 받아서 따라하면 됨

		// 보조 업무(cross-cutting concern) 설정
		//--시간 측정(Around Advice)
		Log log = LogFactory.getLog(this.getClass());	// 로그 가져와서 로그 기록 수정할 수 있게
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("처리 시간 측정 시작--------------------");
		
		// 주 업무(core concern) 실행 내용
		Object result = method.invoke(target, args);
		//--두 번째 파라미터로 넘겨받은 Method method의 method
		//  Object[] 배열의 args → Object가 가지는 주변 속성들
	    //  객체 반환하게 만듦

		sw.stop();
		log.info("처리 시간 측정 시작--------------------");
		log.info(String.format("경과시간: %s/1000초", sw.getTotalTimeMillis()));
		
		return result;
	}
}
