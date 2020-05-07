package io.dropwizard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class numberplateConfiguration extends Configuration{
    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database= new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {

        System.out.println("Get configuration");
        return database;
    }

}
