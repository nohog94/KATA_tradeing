public class KiwerStockBroker implements StockBroker {
    public static final int MAX_QUNTITY = 10000;
    private KiwerAPI kiwerAPI;
    private int currentPrice;

    public KiwerStockBroker() {
        this.kiwerAPI = new KiwerAPI();
    }

    @Override
    public boolean login(String id, String password) {
        kiwerAPI.login(id, password);
        return true;
    }

    @Override
    public boolean buy(String stockCode, int price, int quantity) {
        vaildateStockCode(stockCode);
        validatePriceAndQuantity(price, quantity);

        kiwerAPI.buy(stockCode, price, quantity);
        return true;
    }

    @Override
    public boolean sell(String stockCode, int price, int quantity) {
        vaildateStockCode(stockCode);
        validatePriceAndQuantity(price, quantity);

        kiwerAPI.sell(stockCode, price, quantity);
        return true;
    }

    @Override
    public int getPrice(String stockCode) {
        vaildateStockCode(stockCode);
        this.currentPrice = kiwerAPI.currentPrice(stockCode);
        return this.currentPrice;
    }

    @Override
    public boolean buyNiceTiming(String stockCode, int amount) {
        vaildateStockCode(stockCode);

        int kiwerCurrentPrice = kiwerAPI.currentPrice(stockCode);

        if (this.currentPrice < kiwerCurrentPrice) {
            kiwerAPI.sell(stockCode, kiwerCurrentPrice, MAX_QUNTITY);
            return true;
        }

        return false;
    }

    @Override
    public boolean sellNiceTiming(String stockCode, int quantity) {
        vaildateStockCode(stockCode);

        int kiwerCurrentPrice = kiwerAPI.currentPrice(stockCode);

        if (this.currentPrice > kiwerCurrentPrice) {
            kiwerAPI.sell(stockCode, kiwerCurrentPrice, quantity);
            return true;
        }

        return false;
    }

    private void vaildateStockCode(String stockCode) {
        if (stockCode.equals("999999")) throw new IllegalArgumentException("주식 코드가 잘못되었습니다.");
    }

    private void validatePriceAndQuantity(int price, int quantity) {
        if (price <= 0) throw new IllegalArgumentException("가격이 0원 이하 입니다.");
        if (quantity <= 0) throw new IllegalArgumentException("수량이 0 이하 입니다.");
    }
}
