package br.ufc.qx.agtcc;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.HibernateException;
import org.hibernate.internal.SessionImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class DBunitTest {

	protected static EntityManagerFactory emf;
	protected static EntityManager em;
	protected static DatabaseConnection connection;
	protected List<String> tabelas = new ArrayList<String>();
	protected List<IDataSet> datasets = new ArrayList<IDataSet>();

	@BeforeClass
	public static void createEntityManagerFactory() throws Exception {
		emf = Persistence.createEntityManagerFactory("saadPU");
		em = emf.createEntityManager();
		connection = new DatabaseConnection(((SessionImpl) (em.getDelegate())).connection());
		DatabaseConfig dBConfig = connection.getConfig();
		dBConfig.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
		dBConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
	}

	@AfterClass
	public static void closeEntityManagerFactory() {
		emf.close();
	}

	public void resetarBancoDeDados(List<String> tabelas, List<IDataSet> datasets) {
		if (!em.getTransaction().isActive()) {
			em.getTransaction().begin();
		}
		for (String tabela : tabelas) {
			try {
				if (connection.getConnection().isClosed()) {
					connection = new DatabaseConnection(((SessionImpl) (em.getDelegate())).connection());
				}
				Statement statement = connection.getConnection().createStatement();
				statement.execute("ALTER TABLE " + tabela + " AUTO_INCREMENT = 1");
			} catch (SQLException | HibernateException | DatabaseUnitException e) {
				e.printStackTrace();
			}
		}
		for (IDataSet dataset : datasets) {
			try {
				DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
			} catch (DatabaseUnitException | SQLException e) {
				e.printStackTrace();
			}
		}
		if (em.getTransaction().isActive()) {
			em.getTransaction().commit();
		}
	}
}
