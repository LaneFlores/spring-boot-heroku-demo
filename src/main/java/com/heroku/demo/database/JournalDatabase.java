package com.heroku.demo.database;

import com.heroku.demo.model.Journal;

import java.sql.SQLException;
import java.util.List;

public interface JournalDatabase {
    // SELECT
    public List<Journal> selectAll() throws SQLException;

    // UPSERT

    // DELETE
}