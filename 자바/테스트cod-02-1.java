/*
�������Ϳ����� - Inner class ó��
*/

class Outer
{
	private int a=10;
	public void disp()
	{
		System.out.println( "Outer a : " +a);
   		//////////// Local Inner Class ////////////
		class InnerLocal
		{
			private int c=30;
			public int d=null;
			public void disp()
			{
				System.out.println("InnerLocal a :" + a);
				System.out.println("InnerLocal c :" + c);
			}
		} //class InnerLocal
		InnerLocal il = new InnerLocal();
		il.disp();
		System.out.println("InnerLocal d :" + il.d.length);
   }
   
	//////////// Member Inner Class ////////////
	class InnerMember
	{
		private int b=20;
		public void disp()
		{
			System.out.println(" InnerMember a : " +a);
			// 	�ܺ�Ŭ������ ����� ����
			System.out.println(" InnerMember b : " +b);
		}
	}// class InnerMember
   
	//////////// Static Inner Class ////////////
	static class InnerStatic
	{
		private static int d = 40;
		public void disp()
		{
			//System.out.println("InnerStatic a : " + a);        //static�� static������ �����ϱ� ������ ������ ����.
			System.out.println("InnerStatic d : " + d);
		}
	} // Static Inner Class
} //class Outer

abstract class InnerAnony
{
	int e = 50;
	public abstract void disp(); //�߻�Ŭ������ ��ü ���� X
} //�߻� �޼��带 �����ϰ� �ִ� �߻� �޼���

public class Test
{
	public static void main(String[] args)
    {
		//Member Inner class
		Outer.InnerMember im = new Outer(). new InnerMember();
		im.disp();
		   
		//Local Inner class
		Outer out = new Outer();
		out.disp();
		   
		//Static Inner class
		Outer.InnerStatic is = new Outer.InnerStatic();
		is.disp();
		   
		// Anonymous Inner Class
		//1.
		InnerAnony ia = new InnerAnony()
		//�߻�޼���� �̿ϼ��̱⶧���� �͸���Ŭ������ ����ؼ� �ϼ���Ų��.
		{
			public void disp()
			{
				System.out.println("InnerAnony e : " + e);
			}
		};
		ia.disp();
		   
		//2
		new InnerAnony()
		{
			public void disp()
			{
				System.out.println( "Inner Anony e : " + e);
			}
		}.disp(); //��ü.�޼����̱� ������ �̷� ������ ���δ�.
    }
}