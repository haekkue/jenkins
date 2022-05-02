/*
���� : �������Ϳ�����
���� : 1. Inner class ó��
��� :
 * ���� : ��������( ), �����( )
 * ���� : ��������( ), �����( )
*/

class Outer
{
	private String m_strA=null;

	public void bad()
	{
		System.out.println( "Outer strA : " +m_strA.length());	// m_strA(���) �����, m_strA ������� ���� Ȯ��

		// ����Ŭ���� - �޽�� �ȿ��� ���� 
		class InnerLocal
		{
			public String m_strA =null;
			public String m_strB = null;

			public void bad()
			{
				System.out.println("InnerLocal strA :" + m_strA.length());	// m_strA(���) �����, m_strA ������� ���� Ȯ��
				System.out.println("InnerLocal strB :" + m_strB.length());	// m_strB(���) �����, m_strB ������� ���� Ȯ��
			}
		}

		// ����Ŭ���� ����
		InnerLocal il = new InnerLocal();
		il.bad();
		System.out.println("InnerLocal strB :" + il.m_strB.length());		// m_strB(���) �����, m_strB ������� ���� Ȯ��
   }
   
	// ����Ŭ���� - Ŭ���� �ȿ��� ����
	class InnerMember
	{
		public String m_strB=null;

		public void bad()
		{
			System.out.println(" InnerMember m_strA : " + m_strA);			// m_strA(�ܺθ��) �����, m_strA �ܺθ������ ���� Ȯ��
			System.out.println(" InnerMember m_strB : " + m_strB);			// m_strB(���) �����, m_strB ������� ���� Ȯ��
		}
	}
   
	// ��������Ŭ���� 
	static class InnerStatic
	{
		public static String m_strD = null;

		public void bad()
		{
			//System.out.println("InnerStatic m_strA : " + m_strA);        	//static�� static������ �����ϱ� ������ ������ ����.
			System.out.println("InnerStatic m_strD : " + m_strD);			// m_strD(���) �����, m_strD ������� ���� Ȯ��
		}
	}
}

public class Test
{
	public static void main(String[] args)
    {
		//Member Inner class
		Outer.InnerMember im = new Outer(). new InnerMember();
		im.bad();
		   
		//Local Inner class
		Outer out = new Outer();
		out.bad();
		   
		//Static Inner class
		Outer.InnerStatic is = new Outer.InnerStatic();
		is.bad();
		System.out.println("InnerStatic m_strD : " + Outer.InnerStatic.m_strD);	// m_strD(�������) �����, m_strD ����������� ���� Ȯ��
    }
}