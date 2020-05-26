package pl.jazapp.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import liquibase.integration.cdi.CDILiquibaseConfig;
import liquibase.integration.cdi.annotations.LiquibaseType;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class LiquibaseConfig {

    @Produces
    @LiquibaseType
    public CDILiquibaseConfig createConfig()
    {
        CDILiquibaseConfig config = new CDILiquibaseConfig();
        config.setChangeLog("db.changelog/db.changelog.yaml");

        return config;
    }

    @Produces
    @LiquibaseType
    public DataSource createDataSource()
    {
        Dotenv dotenv = Dotenv.configure().directory("./").load();

        var config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl(dotenv.get("JDBC_URL"));
        config.setUsername(dotenv.get("DB_USERNAME"));
        config.setPassword(dotenv.get("DB_PASSWORD"));

        return new HikariDataSource(config);
    }

    @Produces
    @LiquibaseType
    public ResourceAccessor create() {return new ClassLoaderResourceAccessor(getClass().getClassLoader());
    }
}
