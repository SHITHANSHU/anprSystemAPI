package io.dropwizard.jdbi;

import io.dropwizard.api.login;
import io.dropwizard.api.numberplate;
import io.dropwizard.api.session;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class sessionMapper implements ResultSetMapper<session> {

    public session map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        System.out.println("Mapper session");
        return new session(resultSet.getString("username"),resultSet.getString("acessToken"),Integer.parseInt(resultSet.getString("type")));
    }
}