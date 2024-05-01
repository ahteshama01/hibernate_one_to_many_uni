package insert;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity_classes.Author;
import Entity_classes.Book;

public class insert {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_one_to_many_uni");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Book b1=new Book(101,"book1",120);
		Book b2=new Book(102,"book2",160);
		Book b3=new Book(103,"book3",190);
		
		List<Book> books1=new ArrayList<Book>();
		books1.add(b1);
		books1.add(b2);
		
		List<Book> books2=new ArrayList<Book>();
		books2.add(b3);
		
		
		Author a1=new Author(1,"shubham",books1);
		Author a2=new Author(2,"parashad",books2);
		
		et.begin();
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(a1);
		em.persist(a2);
		et.commit();
	}
}
