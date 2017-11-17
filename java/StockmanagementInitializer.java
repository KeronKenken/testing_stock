package McTank.StockManagement;

class StockmanagementInitializer {
  private final Stockmanagement stockmgmt;
  StockmanagementInitializer (Stockmanagement stockmgmt) {
    Assert.notNull(stockmgmt, "Stock must not be null!");
    this.stockmgmt = stockmgmt;
  }
  
  @Override
  public void initialize() {
    if (stockmgmt.findAll().iterator().hasNext()) {
      return;
    } // end of if
    stockmgmt.save(new Article("Benzin", "2100101", "Benzin GbR", "30000", ArticleType.KRAFTSTOFF));
    stockmgmt.save(new Article("Diesel", "2100102", "Benzin GbR", "20000", ArticleType.KRAFTSTOFF));
    stockmgmt.save(new Article("Super", "2100103", "Benzin GbR", "25000", ArticleType.KRAFTSTOFF));
    stockmgmt.save(new Article("Würstchen", "2200101", "Essen GbR", "300", ArticleType.LEBENSMITTEL));
  }
}