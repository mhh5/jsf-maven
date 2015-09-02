package util;

import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;
	public static final String HIBERNATE_SESSION = "hibernate_session";
	
	static {
		try {
			System.out.println("Tentando abrir uma Session Factory.");
		} catch (Exception e) {
			
		}
	}
	
}
