package removeall;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entity_classes.Author;
import Entity_classes.Book;

public class RemoveAll {
		public static void main(String[] args) {
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("hibernate_one_to_many_uni");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			
			
			//remove multiple
			
			Author a=em.find(Author.class, 1);
			
			List<Book> books=a.getBooks();
			List<Book> book2=new ArrayList<Book>();
		
		Iterator<Book> itr=books.iterator();
		
		while(itr.hasNext()) {
			Book temp=itr.next();
			if(temp.getId()==102||temp.getId()==104) {
				
			book2.add(temp);
			itr.remove();
			}
		}//end while
		
		et.begin();
		
		em.merge(a);
		for(Book b:book2) {
			em.remove(b);
		}
		et.commit();
		
		}
}
