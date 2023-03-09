package com.iamviet.template_crud_java4.utils;

import com.iamviet.template_crud_java4.entities.DongVat;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {

    private static final SessionFactory SESSION_FACTORY;

    static {

        /*Cài đặt cấu hình cho hibernate*/
        Configuration conf = new Configuration();

        Properties props = new Properties();

        /*Cài đặt môi trường cho hibernate*/
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/template_crud_java4");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "28102003");
        props.put(Environment.SHOW_SQL, "true");
        props.put(Environment.FORMAT_SQL, "true");
        props.put(Environment.HBM2DDL_AUTO, "update");


        conf.addProperties(props);

        conf.addAnnotatedClass(DongVat.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();

        SESSION_FACTORY = conf.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getSessionFactory().toString());
    }
}
