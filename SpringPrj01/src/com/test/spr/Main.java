/*==================
	Main.java
	- �������̽�
==================*/

package com.test.spr;

public class Main
{
	public static void main(String[] args)
	{
		// [�������� ó���ϰ� �����ϰ� �� ����]
		//--------------------------------------------------------------
		
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
		
		//--------------------------------------------------------------
		
		view.input();
		view.output();	
	}
}
