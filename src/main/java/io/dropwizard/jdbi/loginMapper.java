package io.dropwizard.jdbi;

import io.dropwizard.api.login;
import io.dropwizard.api.numberplate;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class loginMapper implements ResultSetMapper<login> {

    public login map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        System.out.println("Mapper login");
        return new login(resultSet.getString("username"),resultSet.getString("password"),Integer.parseInt(resultSet.getString("type")));
    }
}