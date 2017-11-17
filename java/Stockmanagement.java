package McTank.StockManagement;

import McTank.StockManagement.Article;

import org.salespointframework.inventory.Inventory;
import org.salespointframework.inventory.InventoryItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public interface Stockmanagement extends Stockmanagement<Article> {
  
  static final Sort DEFAULT_SORT = new Srt(Direction.DESC, "articleID");
  
  Iterable<Article> findByType(ArticleType type, Sort sort);
  
  default Iterable<Article> findByType(ArticleType type) {
    return findByType(type, DEFAULT_SORT);
    }
  }