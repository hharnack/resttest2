package database;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This class allows connection to the database through a pool through the user
 * of a Singleton patter.
 *
 * @author Levon Rose
 */
public class ConnectionPool {

    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    /**
     * Creates a connection
     */
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("jdbc/dogsdb");
        } catch (NamingException e) {
            System.out.println(e);
        }

    }

    /**
     * Creates a connection pool if an instance of one does not already exists.
     *
     * @return The connection pool
     */
    public static synchronized ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }

    /**
     * Gets the connection.
     *
     * @return returns The connection
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    /**
     * Closes the connection so more users can connect at once.
     *
     * @param c The connection to close.
     */
    public void freeConnection(Connection c) {
        try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
