package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Books;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorsRepositories;
import guru.springframework.spring5webapp.repositories.BookRepositories;
import guru.springframework.spring5webapp.repositories.PublisherRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private  AuthorsRepositories authorsRepositories ;
    @Autowired
    private  BookRepositories bookRepositories ;
    @Autowired
    private PublisherRepositories publisherRepositories ;



    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher("nemmni","141 chemin du marcreux","Aubervillier","snt denis","93350");
        publisherRepositories.save(publisher);

        Author eric = new Author("eric","mamba");
        Books book = new Books("Spirng to guru","123456");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorsRepositories.save(eric);
        bookRepositories.save(book);
        publisherRepositories.save(publisher);

        Author rob = new Author("rob","bobo");
        Books jee = new Books("JEE","987456");
        rob.getBooks().add(jee);
        jee.getAuthors().add(rob);
        jee.setPublisher(publisher);
        publisher.getBooks().add(jee);

        authorsRepositories.save(rob);
        bookRepositories.save(jee);
        publisherRepositories.save(publisher);

        System.out.println("Boostrap Begin :");
        System.out.println("Book count : "+bookRepositories.count());
        System.out.println("Authors count : "+authorsRepositories.count());
        System.out.println("Publisher count : "+publisherRepositories.count());
        System.out.println("Boostrap End ");
    }
}
