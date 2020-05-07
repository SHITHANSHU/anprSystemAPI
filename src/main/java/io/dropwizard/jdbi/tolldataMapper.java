package io.dropwizard.jdbi;

import java.sql.ResultSet;
import io.dropwizard.api.tolldata;
import io.dropwizard.api.tollrecord;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class tolldataMapper implements ResultSetMapper<tolldata> {

    public tolldata map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        System.out.println("Mapper session");
        return new tolldata(resultSet.getString("code"), resultSet.getString("exceptions"));
    }
}