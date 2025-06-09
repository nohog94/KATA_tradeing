public class KiwerStockBroker implements StockBroker {
    private KiwerAPI kiwerAPI;

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

        return kiwerAPI.currentPrice(stockCode);
    }

    @Override
    public boolean buyNiceTiming(String stockCode, int amount) {
        return false;
    }

    @Override
    public boolean sellNiceTiming(String stockCode, int quantity) {
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
