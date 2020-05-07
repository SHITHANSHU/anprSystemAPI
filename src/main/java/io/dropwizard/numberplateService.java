package io.dropwizard;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.numberplateDAO;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;
import java.util.logging.Logger;

public class numberplateService extends Application<numberplateConfiguration> {


    private static Logger logger=Logger.getLogger((numberplateService.class.getName()));

    public static void main(String[] args) throws Exception {
        new numberplateService().run(args);
    }

    @Override
    public String getName()
    {
        return "Sample Service Application";
    }

    @Override
    public void initialize(Bootstrap<numberplateConfiguration> bootstrap)
    {

    }


    public void run(numberplateConfiguration numberplateConfiguration, Environment environment) throws Exception {
        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");


        final DBIFactory factory=new DBIFactory();
        final DataSourceFactory dataSourceFactory=numberplateConfiguration.getDataSourceFactory();
        final DBI jdbi=  factory.build(environment,dataSourceFactory,"postgres");

        final numberplateDAO dao=jdbi.onDemand(numberplateDAO.class);
        System.out.println("Entering env");
        environment.jersey().register(new numberResourceImpl(dao));
        System.out.println("exit env");
    }
}
