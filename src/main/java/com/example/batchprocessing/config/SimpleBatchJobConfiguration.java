//package com.example.batchprocessing.config;
//
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.jdbc.support.JdbcTransactionManager;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableBatchProcessing(dataSourceRef = "batchDataSource", transactionManagerRef = "batchTransactionManager")
//public class SimpleBatchJobConfiguration {
//
//    @Bean
//    public DataSource batchDataSource() {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
//                .addScript("schema-all.sql")
//                .generateUniqueName(true)
//                .build();
//    }
//
//    @Bean
//    public JdbcTransactionManager batchTransactionManager(@Qualifier("batchDataSource") DataSource dataSource) {
//        return new JdbcTransactionManager(dataSource);
//    }
//}
