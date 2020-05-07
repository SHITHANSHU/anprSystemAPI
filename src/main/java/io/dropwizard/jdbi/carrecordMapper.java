package io.dropwizard.jdbi;
import io.dropwizard.api.carrecord;
import io.dropwizard.api.session;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class carrecordMapper implements ResultSetMapper<carrecord> {

    public carrecord map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        System.out.println("Mapper session");
        try {
            return new carrecord(Integer.parseInt(resultSet.getString("tollamount")),resultSet.getString("date"),resultSet.getString("tollcode"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new carrecord(Integer.parseInt(resultSet.getString("tollamount")),resultSet.getString("tollcode"));
    }
}
