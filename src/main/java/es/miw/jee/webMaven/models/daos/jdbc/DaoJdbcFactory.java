package es.miw.jee.webMaven.models.daos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import es.miw.jee.webMaven.models.daos.DaoFactory;
import es.miw.jee.webMaven.models.daos.TemaDao;
import es.miw.jee.webMaven.models.daos.VotoDao;
import es.miw.jee.webMaven.models.entities.Tema;
import es.miw.jee.webMaven.models.entities.Voto;



public class DaoJdbcFactory extends DaoFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/miwjee_jdbc";

    private static final String USER = "root";

    private static final String PASS = "";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS %s";

    private static Connection connection;

    public static Connection getConnection() { 
        try {
            if (connection == null || !connection.isValid(0)) {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error(
                    "Problemas con el driver: " + e.getMessage());
        } catch (SQLException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error(
                    "Problemas con la BD: " + e.getMessage());
        }
        return connection;
    }

    public static void dropAndCreateTables() {
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(String.format(DROP_TABLE, Tema.TABLE));
            statement.executeUpdate(String.format(DROP_TABLE, Voto.TABLE));
            statement.executeUpdate(VotoDaoJdbc.sqlToCreateTable());
        } catch (SQLException e) {
            LogManager.getLogger(DaoJdbcFactory.class).error("Drop tables: " + e.getMessage());
        }
    }

    @Override
    public TemaDao getTemaDao() {
        return new TemaDaoJdbc();
    }

	@Override
	public VotoDao getVotoDao() {		
		return null;
	}

}
