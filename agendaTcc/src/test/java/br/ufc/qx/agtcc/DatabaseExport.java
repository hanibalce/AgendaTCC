package br.ufc.qx.agtcc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.search.TablesDependencyHelper;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

public class DatabaseExport {

	public static void main(String[] args) throws Exception {

		// Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost/saad?useSSL=false", "root", "root");
		IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

		// IDataSet fullDataSet = connection.createDataSet();
		// FlatXmlDataSet.write(fullDataSet, new
		// FileOutputStream("src/test/resources/full.xml"));

		String[] depTableNames = TablesDependencyHelper.getAllDependentTables(connection, "permissao");
		IDataSet depDataSet = connection.createDataSet(depTableNames);
		FlatXmlDataSet.write(depDataSet, new FileOutputStream("src/test/resources/full.xml"));

	}
}
