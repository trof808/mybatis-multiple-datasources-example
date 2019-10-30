## Multiple datasources MyBatis configuration with Spring Boot

### Libs

```groovy
compile group: 'org.mybatis', name: 'mybatis', version: '3.5.2'
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.1'
runtimeOnly 'org.postgresql:postgresql'
testImplementation('org.springframework.boot:spring-boot-starter-test') {
    exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
}
compile group: 'ru.yandex.clickhouse', name: 'clickhouse-jdbc', version: '0.1.54'
```

### Folder structure

```
src
└── com.mybatisexample.demo
    │   └── config
    │       ├── MyBatisConfigClickhouse - clickhouse datasource configuration
    │       └── MyBatisConfigPostgres - postgres datasource configuration
    │   └── domain - models for database table mappers
    │   └── mapper
    │       ├── clickhouse - mappers for clickhouse datasource
    │       └── postgres - mappers for postgres datasource
```

### Datasource configuration class

```java
@Configuration
@MapperScan(value = "com.mybatisexample.demo.mapper.postgres", sqlSessionFactoryRef="sqlSessionPostgres")
public class MyBatisConfigPostgres {

    @Bean(name = "dataSourcePostgres")
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/postgres");
        dataSourceBuilder.username("username");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }

    @Bean(name = "sqlSessionPostgres")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }
}
``` 

@MapperScan annotation will check mappers folder for current datasource and create beans automatically