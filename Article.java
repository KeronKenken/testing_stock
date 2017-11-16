package McTank.stockmanagement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.javamoney.moneta.Money;
import org.salespointframework.catalog.Product;
import org.salespointframework.quantity.Metric;

//(?????)
// Da der Shop DVD sowie BluRay verkaufen soll ist es sinnvoll eine gemeinsame Basisklasse zu erstellen.
// Diese erbt von Product um die Catalog-Klasse aus Salespoint nutzen zu k�nnen.
// Ein Prim�rschl�ssel ist nicht notwendig, da dieser schon in Product definiert ist, alle anderen JPA-Anforderungen m�ssen aber erf�llt werden
@Entity
public class Article extends Product {
  
  private static final long serialVersionUID = 3602164805477720501L;
  
  public static enum ArticleType {
    KRAFTSTOFF, LEBENSMITTEL;
  }
  
  public static enum Metric {
    units, Liter
  }
  
  // (?????)
  // primitve Typen oder Strings m�ssen nicht extra f�r JPA annotiert werden
  private String articleID;
  private Company company;
  private ArticleType type;
  private Metric metric;
  
  // (?????)
  // Jede Disc besitzt mehrere Kommentare, eine "1 zu n"-Beziehung -> @OneToMany f�r JPA
  // cascade gibt an, was mit den Kindelementen (Comment) passieren soll wenn das Parentelement (Disc) mit der Datenbank
  // "interagiert"
  @OneToMany(cascade = CascadeType.ALL) //
  private List<Comment> comments = new ArrayList<>();
  
  @SuppressWarnings("unused")
  private Article() {}
  
  public Article(String articleID, ArticleType type, Company company, Metric metric) {
    
    super(name, price);
    
    this.articleID = articleID;
    this.company = company;
    this.type = type;
  }
  
  public String getArticleID() {
    return articleID;
  }
  
  public void addAmount() {
    
    
    
    
    
    comments.add(comment);
  }
  
  // (?????)
  // Es ist immer sinnvoll sich zu �berlegen wie speziell der R�ckgabetyp sein sollte
  // Da sowies nur �ber die Kommentare iteriert wird, ist ein Iterable<T> das sinnvollste.
  // Weil wir keine Liste zur�ck geben, verhindern wir auch, dass jemand die comments-Liste einfach durch clear() leert.
  // Deswegen geben auch so viele Salespoint Klassen nur Iterable<T> zur�ck ;)
  public Iterable<Comment> getComments() {
    return comments;
  }
  
  public String getImage() {
    return image;
  }
  
  public DiscType getType() {
    return type;
  }
}