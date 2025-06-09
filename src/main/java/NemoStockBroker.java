public class NemoStockBroker implements StockBroker {
    @Override
    public boolean login(String id, String password) {
        return false;
    }

    @Override
    public boolean buy(String stockCode, int price, int quantity) {
        return false;
    }

    @Override
    public boolean sell(String stockCode, int price, int quantity) {
        return false;
    }

    @Override
    public int getPrice(String stockCode) {
        return 0;
    }

    @Override
    public boolean buyNiceTiming(String stockCode, int amount) {
        return false;
    }

    @Override
    public boolean sellNiceTiming(String stockCode, int quantity) {
        return false;
    }
}
