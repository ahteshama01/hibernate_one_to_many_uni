package remove;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity_classes.Author;
import Entity_classes.Book;

public class Remove {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_one_to_many_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		
		
		Author a=em.find(Author.class, 1);
		Book b=null;
		List<Book> books=a.getBooks();
		
Iterator<Book> itr=books.iterator();
		
		while(itr.hasNext()) {
			Book temp=itr.next();
			if(temp.getId()==102) {
				b=temp;
				itr.remove();
				
			}
		}
		
		et.begin();
		em.merge(a);
		em.remove(b);
		et.commit();
	}
}
