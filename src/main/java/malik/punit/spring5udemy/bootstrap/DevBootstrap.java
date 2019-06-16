package malik.punit.spring5udemy.bootstrap;

import malik.punit.spring5udemy.model.Author;
import malik.punit.spring5udemy.model.Book;
import malik.punit.spring5udemy.model.Publisher;
import malik.punit.spring5udemy.repositories.AuthorRepository;
import malik.punit.spring5udemy.repositories.BookRepository;
import malik.punit.spring5udemy.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Publisher hc = new Publisher("Harper Collins", "addr1");
        publisherRepository.save(hc);
        Author eric  = new Author("Eric", "Evans");

        Book ddd =  new Book("Domain Driven Design", "1234", hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Publisher unknown = new Publisher("work", "addr2");
        publisherRepository.save(unknown);
        Author rod  = new Author("Rod", "Johnson");
        Book notEJB =  new Book("J2EE Development without EJB", "234444", unknown);
        rod.getBooks().add(notEJB);
        authorRepository.save(rod);
        bookRepository.save(notEJB);

    }
}
