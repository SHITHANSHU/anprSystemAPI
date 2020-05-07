package io.dropwizard.jdbi;

import io.dropwizard.api.session;
import io.dropwizard.api.tollrecord;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class tollrecordMapper implements ResultSetMapper<tollrecord> {

    public tollrecord map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        System.out.println("Mapper session");
        return new tollrecord(resultSet.getString("code"),Integer.parseInt(resultSet.getString("type1")),Integer.parseInt(resultSet.getString("type2")),Integer.parseInt(resultSet.getString("type3")),Integer.parseInt(resultSet.getString("type4")),Integer.parseInt(resultSet.getString("type5")),Integer.parseInt(resultSet.getString("type6")));
    }
}