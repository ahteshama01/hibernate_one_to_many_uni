package merge;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity_classes.Author;
import Entity_classes.Book;

public class Merge {
	public static void main(String[] args) {
		
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_one_to_many_uni");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	
	Book book1=new Book();
	Book book2=new Book();
	
	
	Author a=em.find(Author.class,1);
	
	a.getBooks().add(book1);
	a.getBooks().add(book2);
	
	
	et.begin();
	
	em.persist(book1);
	em.persist(book2);

	em.merge(a);
	et.commit();
	}
	
}
