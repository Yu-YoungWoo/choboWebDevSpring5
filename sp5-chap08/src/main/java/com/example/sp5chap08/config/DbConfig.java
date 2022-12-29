//package com.example.sp5chap08.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.apache.tomcat.jdbc.pool.DataSource;
//
//@Configuration
//public class DbConfig {
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        DataSource ds = new DataSource();
//        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        ds.setUrl("jdbc:mysql://localhost:3306/spring5fs?characterEncoding=utf8");
//        ds.setName("root");
//        ds.setPassword("vbn752014&");
//        ds.setInitialSize(2);
//        ds.setMaxActive(10);
//        ds.setTestWhileIdle(true);  // 유휴 커넥션 검사
//        ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3); // 최소 유휴 시간 3분
//        ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 10초 주기로 검사
//
//        return ds;
//    }
//}
