package guru.springframework.spring5webapp.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"firstName", "lastName","books"},of = {"id"})
@ToString(exclude = {"authors","publisher"})
 public class Books {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String title;
   private String isBn;
   @ManyToMany
   @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
   private Set<Author> authors = new HashSet<>();
   @ManyToOne
   @JoinColumn(name = "publisher_id")
   private Publisher publisher ;

   public Books(String title, String isBn) {
      this.title = title;
      this.isBn = isBn;
   }
}
