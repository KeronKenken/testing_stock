package McTank.StockManagement;

// anhand InventoryItem nachprüfen, was überhaupt nötig ist!

import McTank.StockManagement.Company;
import org.salespointframework.catalog.Product;
import org.salespointframework.inventory.InventoryItem;


@Entity

public class Article extends Product {
//       private static final long serialVersionUID
         public static enum ArticleType {
           KRAFTSTOFF, LEBENSMITTEL;
           }
         private String name; //salespoint.product
         private Int articleID; //salespoint.inventoryItem -> inventoryItemIdentifier - hierüberhaupt notwendig?
         private Company company;
         private ArticleType type;
         private Int quantity;
         
         public Article(String name, Int articleID, Money price, Company company, ArticleType type, Int quantity) {
           super(name, price)
           this.articleID = articleID;
           this.company = company;
           this.type = type;
           this.amount = amount;
           }
         public InventoryItemIdentifier getId() {
           return inventoryItemIdentifier;
           }
         public Company getCompany (){
           return company;
           }
         public ArticleType getType (){
           return type;
           }
         public Int getQuantity (){
           return quantity;
           }
         public void increaseQuantity(Quantity quantity){
           increasequan
         }
         
         