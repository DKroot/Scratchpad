using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Configuration;
using System.Data.Common;
using System.Data.Entity;
using System.Data.SqlClient;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using Oracle.ManagedDataAccess.Client;

namespace TestEF
{
	[Table("PUBLICATIONS", Schema = "KOROBSKD_DB")]
	public class Application
	{
		[Key]
		[Column("APPL_ID")]
		public decimal Id { get; set; }

		[Column("PO_NAME")]
		public string Name { get; set; }
	}

	public static class DbConnectionFactory
	{
		public static DbConnection CreateConnection(string connectionStringName = "IreportEntities")
		{
			var connectionString = ConfigurationManager.ConnectionStrings[connectionStringName];
			if (connectionString.ProviderName.Equals("Oracle.ManagedDataAccess.Client", StringComparison.InvariantCultureIgnoreCase))
				return new OracleConnection(connectionString.ConnectionString);
			return new SqlConnection(connectionString.ConnectionString);
		}
	}

	public class MyContext : DbContext
	{
		public MyContext() : base(DbConnectionFactory.CreateConnection(), true) { }

		public DbSet<Application> Applications { get; set; }

		protected override void OnModelCreating(DbModelBuilder modelBuilder)
		{
			Database.SetInitializer<MyContext>(null);
			base.OnModelCreating(modelBuilder);
		}
	}

	class Program
	{
		static void Main(string[] args)
		{
			using (var context = new MyContext())
			{
				var list = context.Applications.Where(a => a.Id == 8690000).ToArray();
			}
		}
	}
}
