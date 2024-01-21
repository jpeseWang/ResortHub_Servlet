package Repositories.Common;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Config.DbConnection;
import Utils.ConvertUtils;

public abstract class RepositoryBase<TEntity> {

    protected abstract String getTableName();

    protected abstract TEntity createEntityFromResultSet(ResultSet rs) throws SQLException;

    protected List<TEntity> getAll() {
        String query = String.format("SELECT * FROM %s;", getTableName());
        return executeQuery(query, new ArrayList<>());
    }

    protected TEntity getById(Object id) {
        String query = String.format("SELECT TOP 1 * FROM %s WHERE Id = ?;", getTableName());
        List<Object> params = new ArrayList<>();
        params.add(id);

        List<TEntity> entities = executeQuery(query, params);

        return entities.size() != 0 ? entities.get(0) : null;
    }

    protected void deleteById(String id) {
        String query = String.format("DELETE FROM %s WHERE Id = ?;", getTableName());
        List<Object> params = new ArrayList<>();
        params.add(id);

        executeNonQuery(query, params);
    }

    protected void executeNonQuery(String query, List<Object> params) {
        System.out.println("[Query]: " + query);
        if (!params.isEmpty()) {
            System.out.println("[Params]: " + params.toString());
        }

        Connection conn = null;

        try {
            conn = DbConnection.get();

            if (conn == null) {
                throw new NullPointerException("Database connection has not been set up successfully.");
            }

            PreparedStatement ps = conn.prepareStatement(query);

            setParamsForQuery(ps, params);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error executing query: " + ex.getMessage());
        } finally {
            if (conn != null)
                DbConnection.close(conn);
        }
    }

    protected List<TEntity> executeQuery(String query, List<Object> params) {
        System.out.println("[Query]: " + query);
        if (!params.isEmpty()) {
            System.out.println("[Params]: " + params.toString());
        }

        List<TEntity> entities = new ArrayList<>();

        Connection conn = null;

        try {
            conn = DbConnection.get();

            if (conn == null) {
                throw new NullPointerException("Database connection has not been set up successfully.");
            }

            PreparedStatement ps = conn.prepareStatement(query);

            setParamsForQuery(ps, params);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TEntity entity = createEntityFromResultSet(rs);
                entities.add(entity);
            }

        } catch (SQLException ex) {
            System.err.println("Error executing query: " + ex.getMessage());
        } finally {
            if (conn != null)
                DbConnection.close(conn);
        }

        return entities;
    }

    private void setParamsForQuery(PreparedStatement ps, List<Object> params) throws SQLException {
        for (int i = 0; i < params.size(); i++) {
            Object param = params.get(i);
            if (param instanceof String) {
                ps.setString(i + 1, (String) param);
            } else if (param instanceof Integer) {
                ps.setInt(i + 1, (Integer) param);
            } else if (param instanceof Date) {
                ps.setDate(i + 1, new java.sql.Date(((Date) param).getTime()));
            } else if (param instanceof BigDecimal) {
                ps.setBigDecimal(i + 1, (BigDecimal) param);
            } else if (param instanceof Float) {
                ps.setFloat(i + 1, (Float) param);
            } // Add more cases for other data types as needed
        }
    }

}
