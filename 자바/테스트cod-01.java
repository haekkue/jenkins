/*
�������Ϳ�����
  1. �θ� ������� ��� 
  2. �θ�, �ڽ� ��� ���� �̸� �ߺ�
  3. this/base ���
  4. �ٸ� Ŭ���� ��� ���� �̸� �ߺ�
*/

class CSon
{
	String m_strTest = null;

	public void bad()
	{
		System.out.println("Test : " + m_strTest.length());	// m_strTest(���) �����, m_strTest ������� ���� Ȯ��
	}
 }

class CTom
{
	String m_strMyMy = null;
	String m_strTest = null;

	public void bad2(String strTest, String strMyMy)
	{
		String strTemp = null;
		strTest = null;
		strMyMy = null;
		System.out.println("Test : " + strTest.length());   		// strTest(�Ķ����) �����, strTest �Ķ���ͺ��� ���� Ȯ��
		System.out.println("Test : " + strMyMy.length());   		// strMyMy(�Ķ����) �����, strMyMy �Ķ���ͺ��� ���� Ȯ��
	}
}

class CSam extends CTom
{
   String m_strTest = null;

   public void bad3(String[] args)
   {
	   String strTest = null;
	   System.out.println("Test : " + m_strTest.length());			// m_strTest(���) �����, strTest ������� ���� Ȯ��
	   System.out.println("Test : " + m_strMyMy.length());			// m_strMyMy(�θ���) �����, m_strMyMy �θ������� ���� Ȯ��
	   System.out.println("Test : " + this.m_strTest.length());		// m_strTest(this,���) �����, strTest ������� ���� Ȯ��
	   System.out.println("Test : " + super.m_strTest.length());	// m_strTest(�θ���) �����, m_strTest �θ������� ���� Ȯ��
	   System.out.println("Test : " + strTest.length());			// strTest(����) �����, strTest �������� ���� Ȯ��
	}
}

public class Test
{
	public static void main(String[] args)
	{
		System.out.println("Hello World !!");
	}
}
