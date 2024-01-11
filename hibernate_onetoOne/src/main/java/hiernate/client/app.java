package hiernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import hibernate.entity.student;
import jakarta.transaction.Transaction;

public class app {

	public static void main(String[] args) {

student stu = new student();
stu.setId(0);
stu.setName("tinku");
stu.setRollNo(3);
stu.setGender("male");

StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
SessionFactory sf = meta.getSessionFactoryBuilder().build();
Session session = sf.openSession();
org.hibernate.Transaction tx = session.beginTransaction();

session.save(stu);
tx.commit();

	}

}
