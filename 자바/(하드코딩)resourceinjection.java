/*
�ڿ� ����(�޼ҵ� �Ķ������ DB ����)_CWE-99

����� ���� �ҽ� 
*/

class CTest
{
	public void BAD1(ServletRequest req, Connection con) throws SQLException 
	{
		String lastName = req.getParameter("lastName");

		String query = "UPDATE userData INTO lastName=? WHERE userid = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, lastName);
		statement.executeUpdate();
	}

	public void BAD2(ServletRequest req, Connection con) throws SQLException 
	{
		String lastName = req.getParameter("lastName");
		String firstName;

		firstName = lastName;

		String query = "UPDATE userData INTO lastName=? WHERE userid = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, firstName);
		statement.executeUpdate();
	}

	public void BAD3(ServletRequest req, ServletResponse res, Connection con) throws SQLException 
	{
		String lastName = req.getParameter("lastName");
		String firstName = req.getParameter("firstName");
		String one = res.getParameter("one");
		String two = res.getParameter("two");
		String three = res.getParameter("three");
		String other, yours;

		other = two; 
		yours = other;

		String query = "UPDATE userData INTO lastName=? WHERE userid = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, lastName);
		statement.setString(2, firstName);
		statement.setString(3, one);
		statement.setString(4, two);
		statement.setString(5, three);
		statement.setString(6, other);
		statement.setString(7, yours);
		statement.executeUpdate();
	}

	public void BAD4(ERDictionary dictionary) 
	{
		String CSVFileName = dictionary.getParameter("CSVFileName");
		if (CSVFileName == null || CSVFileName.length() == 0) {
			return;
		}
		
		String query = "UPDATE userData INTO lastName=? WHERE userid = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, CSVFileName);
		statement.executeUpdate();
	}


	public void GOOD1(ServletRequest req) throws SQLException 
	{
		Connection con;
		String lastName = req.getParameter("lastName");

		// Not ����
		if (lastName !=null)
		{
			lastName = lastName.replaceAll("<","&lt");
		}

		String query = "UPDATE userData INTO lastName=? WHERE userid = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, lastName);
		statement.executeUpdate();
	}

	public void GOOD2(ServletRequest req, Connection con) throws SQLException 
	{
		int userId = Integer.parseInt(req.getParameter("userId"));	// �̰� ����� �ƴ�

		String query = "UPDATE userData INTO lastName=? WHERE userid = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(2, userId);
		statement.executeUpdate();
	}

	public void GOOD3(HttpServletRequest request, HttpServletResponse response) throws Throwable
	{
		ServerSocket serverSocket;
		Properties props = new Properties();
		String fileName = "file_list";
		FileInputStream in = new FileInputStream(fileName);
		String service = "";

		if (in != null && in.available() > 0)
		{
			props.load(in);

			service = props.getProperty("Service No");
		}

		if ("".equals(service)) service = "8080";

		int port = Integer.parseInt(service);

		switch (port)
		{
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
	
	public static void GOOD4(String args[])
	{
		SocketClient c;
		String ip=args[0];
		int port=7777;

		try
		{
			if("127.0.0.1".equals(ip))
			{
				c=new SocketClient(ip, port);
				c.startSocket();
			}
		}
		catch (IOException e)
		{
			System.out.println("���� ������ ����.");
		}
	}

	public void GOOD5(ServletRequest req, Connection con) throws SQLException 
	{
		String lastName = req.getParameter("lastName");

		check(lastName);

		String query = "UPDATE userData INTO lastName=? WHERE userid = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, lastName);
		statement.executeUpdate();
	}

	public String check(String strPa)
	{
		if (strPa !=null)
		{
			strPa = strPa.replaceAll("<","&lt");
		}
		return strPa;
	}

}

