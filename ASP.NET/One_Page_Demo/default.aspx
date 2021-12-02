<%@ Page Language="C#" Debug="true" %>
<%@ Import Namespace="System.Net" %>
<%@ Import Namespace="System.Net.Sockets" %>
<%@ Import Namespace="System.Data.SqlClient" %>

<script runat="server">
	public string GetIPAddress() {
		var ipHostInfo = Dns.GetHostEntry(Dns.GetHostName()); // `Dns.Resolve()` method is deprecated.
		foreach(var address in ipHostInfo.AddressList)
		{
			if (address.AddressFamily == AddressFamily.InterNetwork)
				return address.ToString();
		}

		return string.Empty;
	}

	private SqlConnection DbConnection() {
		return new SqlConnection("Data Source=10.158.236.77;Initial Catalog=master;User ID=sa;Password=cowslip.linguist.MERCY");
	}

	private void Page_Load() {
		var localDateTime = DateTime.Now;

		DateTimeLabel.Text = localDateTime + " UTC";
		HostnameLabel.Text = Dns.GetHostName();
		IpLabel.Text = GetIPAddress();

		using (var conn = DbConnection()) {
			conn.Open();
			SqlServerVersionLabel.Text = conn.ServerVersion;
			/* var command = new SqlCommand("SELECT @@version", conn);	
			using (var dataReader = command.ExecuteReader()) {
				if (dataReader.Read()) {
					SqlServerVersionLabel.Text = dataReader.GetValue(0);
				}
			} */
		}
	}
</script>
<html>
<title>Azure DR Demo</title>

<body>
	<p>The server time now is <b><asp:Label runat="server" id="DateTimeLabel" /></b></p>
	<p>This page is running on the <b><asp:Label runat="server" id="HostnameLabel" /></b> host at <b><asp:Label runat="server" id="IpLabel" /></b></p>
	<p>Connected to a SQL Server at 10.158.236.77 running v<b><asp:Label runat="server" id="SqlServerVersionLabel" /></b></p>
</body>

</html>