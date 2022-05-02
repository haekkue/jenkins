/*
�ڿ� ����(����)_CWE-99
*/

public class CTest 
{

	public void BAD01() throws IOException 
	{
		int def = 1000;
 		ServerSocket serverSocket;
		Properties props = new Properties();
		String fileName = "file_list";
		FileInputStream in = new FileInputStream(fileName);
		props.load(in);

		String service = props.getProperty("Service No");
		int port = Integer.parseInt(service);

		if(port != 0)
  			serverSocket = new ServerSocket(port + 3000);  // �ܺο��� �Է¹��� ������ ������ �����Ѵ�.
 		else
			serverSocket = new ServerSocket(def + 3000);
	}

	public static void BAD02(String args[])
	{
		SocketClinet c;
		String ip = args[0];
		int port = 7777;

		try
		{
			c = new SocketClient(ip, port);
			c.startSocket();
		}
		catch (IOException e)
		{
			System.out.println("���� ������ �����߽��ϴ�.");
		}
	}


	public void GOOD01() throws IOException
	{
  		ServerSocket serverSocket;
  		Properties props = new Properties();
  		String fileName = "file_list";
  		FileInputStream in = new FileInputStream(fileName);
  		String service = "";

  		if (in != null && in.available() > 0) {
    			props.load(in);
    			service = props.getProperty("Service No");
  		}

  		if ("".equals(service)) service = "8080";

  		int port = Integer.parseInt(service);

  		switch (port) {  // Ư�� ��Ʈ�� �����ϵ��� ��.
    		case 1:
      			port = 3001; break;
    		case 2:
      			port = 3002; break;
    		case 3:
      			port = 3003; break;
    		default:
      			port = 3000;
  		}

  		serverSocket = new ServerSocket(port);
	}

	public static void GOOD02(String args[])
	{
		SocketClient c;
		String ip = args[0];
		int port = 7777;

		try
		{
			if ("127.0.0.1".equals(ip))
			{
				c = new SocketClient(ip, port);
				c.startSocket();
			}
		}
		...
	}

}
