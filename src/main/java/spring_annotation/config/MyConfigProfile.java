package spring_annotation.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.EmbeddedValueResolver;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
* Profile功能：
*       切换环境
* 开发环境、测试环境、生产环境
* 数据源：
* 组件切换：
* @Profile 指定组件在哪个环境下才能被激活被注入到容器中，不指定的话，任何环境都不注入
* */
@PropertySource("classpath:/db.properties")
@Configuration
public class MyConfigProfile implements EmbeddedValueResolverAware {

    @Value("${db.username}")
    String username;

    String driverClass;

    @Profile("test")
    @Bean
    public DataSource dataSource(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:sqlserver://localhost:1435;databasename=Profile");
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:sqlserver://localhost:1435;databasename=ssm_crud");
        return comboPooledDataSource;
    }

    @Profile("prod")
    @Bean
    public DataSource dataSourceProd(@Value("${db.password}") String password) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:sqlserver://localhost:1435;databasename=GIAS36QA1Patch1");
        return comboPooledDataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        driverClass = stringValueResolver.resolveStringValue("${db.driverClass}");
    }
}
