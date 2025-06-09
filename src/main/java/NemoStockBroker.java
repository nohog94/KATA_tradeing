public class NemoStockBroker implements StockBroker {
    private final NemoAPI nemoAPI = new NemoAPI();

    @Override
    public boolean login(String ID, String Pass) {
        nemoAPI.certification(ID, Pass);
        return true;
    }

    @Override
    public boolean buy(String stockCode, int price, int count) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();

        nemoAPI.purchasingStock(stockCode, price, count);
        return true;
    }

    @Override
    public boolean sell(String stockCode, int price, int count) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();

        nemoAPI.sellingStock(stockCode, price, count);
        return true;
    }

    @Override
    public int getPrice(String stockCode) {
        return getPrice(stockCode, 1000);
    }
  
    public int getPrice(String stockCode, int minute) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();

        return nemoAPI.getMarketPrice(stockCode, minute);
    }

    private static boolean isIllegalStockCode(String stockCode) {
        return stockCode.equals("999999");
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
