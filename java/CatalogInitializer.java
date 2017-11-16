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
class CatalogInitializer implements DataInitializer {
  
  private final VideoCatalog videoCatalog;
  
  CatalogInitializer(VideoCatalog videoCatalog) {
    
      Assert.notNull(videoCatalog, "VideoCatalog must not be null!");
    
      this.videoCatalog = videoCatalog;
  }
  
  /* 
   * (non-Javadoc)
   * @see org.salespointframework.core.DataInitializer#initialize()
   */
  @Override
  public void initialize() {
    
      if (videoCatalog.findAll().iterator().hasNext()) {
        return;
      }
    
      videoCatalog.save(new Article("Benzin", ArticleType.KRAFTSTOFF, BenzinGbR, Metric.Liter));
      
  }
  }
