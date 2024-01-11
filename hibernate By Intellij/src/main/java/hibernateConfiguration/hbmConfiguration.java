package hibernateConfiguration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.Properties;


public class hbmConfiguration {

 public static SessionFactory getSessionFactory() {

             try {
                 // Create a StandardServiceRegistryBuilder and configure Hibernate settings
                 // Specify JDBC connection properties
                 Properties properties = new Properties();
//            properties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver"); // auto load
                 // Specify dialect
                 properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                 properties.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernateannos");
                 properties.put(Environment.USER, "root");
                 properties.put(Environment.PASS, "root");
                 // Echo all executed SQL to stdout (for debugging)
                 properties.put(Environment.SHOW_SQL, "true");
                 properties.put(Environment.HBM2DDL_AUTO, "create");
                 properties.put(Environment.FORMAT_SQL, "true");
                 // Apply properties to the registry builder
                 StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings
                         (properties).build();
                 // Create a MetadataSources and add annotated entity classes
                 MetadataSources metadataSources = new MetadataSources(registry);
                 metadataSources.addAnnotatedClass(Entity.Employee.class);
                 // Create a SessionFactory
                 SessionFactory sessionFactory = metadataSources.buildMetadata().buildSessionFactory();

                 return sessionFactory;
             } catch (Exception ex) {
                 System.err.println("SessionFactory creation failed." + ex);
                 throw new ExceptionInInitializerError(ex);
             }
         }
}

