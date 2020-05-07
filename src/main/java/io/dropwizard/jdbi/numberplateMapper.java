package io.dropwizard.jdbi;

import io.dropwizard.api.login;
import io.dropwizard.api.numberplate;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class numberplateMapper implements ResultSetMapper<numberplate> {

    public numberplate map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        System.out.println("Mapper numberplate");
        return new numberplate(resultSet.getString("id"),resultSet.getString("license"),Integer.parseInt(resultSet.getString("mobile")),resultSet.getString("name"),Integer.parseInt(resultSet.getString("toll")),Integer.parseInt(resultSet.getString("type")));
    }


}
