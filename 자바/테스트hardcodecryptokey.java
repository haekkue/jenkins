/*
Java �ϵ��ڵ�� ��ȣȭ ����
*/

class CTest
{
	private Connection conn;

	public String BAD_encryptString(String usr) 
	{
		String seed = "68af404b513073584c4b6f22b6c63e6b";

		try {
			// ����� ���ǵ� ��ȣȭŰ�� �̿��Ͽ� encrypt�� �����Ѵ�.
			SecretKeySpec skeySpec = new SecretKeySpec(seed.getBytes(), "AES");

			// �ش� ��ȣȭŰ ����� ��ȣȭ �Ǵ� ��ȣȭ ���� ����
		} 
		catch (SQLException e) 
		{ 
			...
		}
		
		return conn;
	}

	public String GOOD_encryptString (String usr) 
	{
		String seed = null;
 
		try {
    			// ��ȣȭ Ű�� �ܺ�ȯ�濡�� ����.
    			seed = getPassword("./password.ini");
    			// ��ȣȭ�� ��ȣȭ Ű�� ��ȣȭ��.
    			seed = decrypt(seed);
    			// ����� ���ǵ� ��ȣȭŰ�� �̿��Ͽ� encrypt�� �����Ѵ�.
    			SecretKeySpec skeySpec = new SecretKeySpec(seed.getBytes(), "AES");

    			// �ش� ��ȣȭŰ ����� ��ȣȭ �Ǵ� ��ȣȭ ���� ����.
			...
  		} 
		catch (SQLException e) {
      			...
  		}
  		
		return con;
	}
}

