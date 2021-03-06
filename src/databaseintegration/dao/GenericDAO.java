package databaseintegration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Henrique
 * @param <E> entity type
 * @param <K> primary key type
 */
public abstract class GenericDAO<E, K> {

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        return DriverManager.getConnection(
                "jdbc:derby://localhost:1527/school",
                "school",
                "school"
        );
    }

    protected Statement getStatement() throws ClassNotFoundException, SQLException {

        return getConnection().createStatement();
    }

    protected void closeStatement(Statement st) throws Exception {
        st.getConnection().close();
    }

    public abstract void create(E entity);

    public abstract E read(K key);

    public abstract List<E> readAll();

    public abstract void update(E entity);

    public abstract void delete(K key);
}
