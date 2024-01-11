package hibernateMap.client;

import Entity.Employee;
import hibernateConfiguration.hbmConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App {
    @SuppressWarnings("deprecation")
	public static void main(String[] args) {

        Employee e= new Employee();
        e.setId(1);
        e.setName("arun");
        e.setGender("male");
        e.setSalary(49811);
        SessionFactory sf = hbmConfiguration.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
//			Student e1 = session.get(Student.class, 2);
        session.save(e);
//			e= session.load(Employee.class, 1);
//			System.out.println(e);
        tx.commit();

    }
}
