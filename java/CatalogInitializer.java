package McTank.stockmanagement;

import static org.salespointframework.core.Currencies.*;

import McTank.stockmanagemen.Article.articleType;

import org.javamoney.moneta.Money;
import org.salespointframework.core.DataInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
* A {@link DataInitializer} implementation that will create dummy data for the application on application startup.
  * @see DataInitializer
 */
@Component
@Order(20)
class StockInitializer implements DataInitializer {
  
  private final StockManagement stockmanagement;
  
  StockInitializer(StockManagement stockmanagement) {
    
      Assert.notNull(stockmanagement, "Stockmanagement must not be null!");
    
      this.stockmanagement = stockmanagement;
  }
  
  /* 
   * (non-Javadoc)
   * @see org.salespointframework.core.DataInitializer#initialize()
   */
  @Override
  public void initialize() {
    
      if (stockmanagement.findAll().iterator().hasNext()) {
        return;
      }
    
      stockmanagement.save(new Article("Benzin", ArticleType.KRAFTSTOFF, BenzinGbR, Metric.Liter));
      
  }
  }
