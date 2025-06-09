public interface StockBroker {
    boolean login(String id, String password);
    boolean buy(String stockCode, int price, int quantity);
    boolean sell(String stockCode, int price, int quantity);
    int getPrice(String stockCode);
}
