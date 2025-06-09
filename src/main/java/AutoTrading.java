public class AutoTrading {
    StockBroker myBroker;

    public AutoTrading(StockBroker myBroker) {
        this.myBroker = myBroker;
    }

    public boolean buyNiceTiming(String stockCode, int amount) {
        return true;
    }

    public boolean sellNiceTiming(String stockCode, int quantity) {
        return true;
    }
}