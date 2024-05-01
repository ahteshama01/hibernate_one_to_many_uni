package fetch;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entity_classes.Author;
import Entity_classes.Book;

public class fetch {
public static void main(String[] args) {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_one_to_many_uni");
	EntityManager em=emf.createEntityManager();
	
	
	Author a=em.find(Author.class,1);
	System.out.println(a);
	
	List<Book> books=a.getBooks();
	
	for(Book b:books) {
		System.out.println(b);
	}
	
}
}
