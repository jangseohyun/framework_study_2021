/*==================
	Main.java
	- �������̽�
==================*/

package com.test.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		// [�������� ó���ϰ� �����ϰ� �� ����]
		/*
		// �� RecordImpl1(Record) ��ü ���� ����
		Record rec1 = new RecordImpl1();	//--dependency (���� ��ü)
		
		// �� RecordImpl2(Record) ��ü ���� ����
		Record rec2 = new RecordImpl2();	//--dependency (���� ��ü)
		
		// RecordViewImpl(RecordView) ��ü ���� ����
		//--Record ��ü(���� ��ü-RecordImpl1 or RecordImpl2) �ʿ�
		RecordView view = new RecordViewImpl();
		
		// ���� ��ü ����
		//--���� ��ü ���� ����� ����ϰ� �Ǹ�
		//  ������ ������ ������ �� �ְ� �ǰ�(������ ���)
		//  �� ���� ���� ��Ȳ�� �ٸ� �ʿ� ������ �� �� �� �ְ� �ȴ�.
		view.setRecord(rec1);	//--setter injection
								//  (setter�� ���� ����)
		*/
		
		
		// �� ������ �����ӿ�ũ������
		//    ��ü ���� ���� �� DI(���� ��ü ����)�� ���� ������
		//    ���ʸ� ȯ�� ���� ���Ϸ� ��ü�ȴ�. (�� applicationContext.xml)
		
		// ������ �����ӿ�ũ���� ��applicationContext.xml�� ������ �о
		// ���� �� ������ ��ü�� ���� ������ ���� �Ѵ�.
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// ��getBean()�� �޼ҵ带 �̿��Ͽ� ����ڰ� ���ϴ� ��ü�� ��´�.
		// �޼ҵ� ���ڰ����� id �Ӽ����� �����ϰ� �ȴ�.
		//RecordView view = (RecordViewImpl)context.getBean("view");
		
		// ������ 3.0 ���� �������� ��� ������ �ڵ�
		RecordView view = context.getBean("view", RecordViewImpl.class);
		
		view.input();
		view.output();	
	}
}
