package com.heroku.demo.database;

import javax.sql.DataSource;

import com.heroku.demo.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcJournalDatabase implements JournalDatabase {

    private static final String QUERY_SELECT_BY_ID = "SELECT id, data FROM journals";

    private DataSource dataSource;
    private Connection connection = null;

    // CONSTRUCTOR ////
    @Autowired
    public JdbcJournalDatabase (DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Journal> selectAll() throws SQLException {
        List<Journal> journals = new ArrayList<>();
        setConnection();
        PreparedStatement statement = connection.prepareStatement(QUERY_SELECT_BY_ID);

        ResultSet rs = statement.executeQuery();
        //_log.info("selectById(): " + rs.getFetchSize() + " records retrieved.");

        while (rs.next()) {
            int id = rs.getInt("id");
            String data = rs.getString("data");

            journals.add(new Journal(id, data));
        }

        return journals;
    }

    private void setConnection() throws SQLException {
        if (this.connection == null || !this.connection.isValid(1000) || this.connection.isClosed()) this.connection = dataSource.getConnection();
    }
}
