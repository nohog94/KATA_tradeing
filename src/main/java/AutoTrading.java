public class AutoTrading {

    private final StockBroker broker;

    public AutoTrading(StockBroker broker) {
        this.broker = broker;
    }

    public boolean buyNiceTiming(String stockCode, int amount) {
        int[] prices = new int[3];
        for (int i = 0; i < 3; i++) {
            prices[i] = broker.getPrice(stockCode);
        }

        if (prices[0] < prices[1] && prices[1] < prices[2]) {
            int finalPrice = prices[2];
            int quantity = amount / finalPrice;
            return broker.buy(stockCode, finalPrice, quantity);
        }

        return false;
    }

    public boolean sellNiceTiming(String stockCode, int quantity) {
        int[] prices = new int[3];
        for (int i = 0; i < 3; i++) {
            prices[i] = broker.getPrice(stockCode);
        }

        if (prices[0] > prices[1] && prices[1] > prices[2]) {
            int finalPrice = prices[2];
            return broker.sell(stockCode, finalPrice, quantity);
        }

        return false;
    }
}