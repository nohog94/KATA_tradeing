public class NemoStockBroker implements StockBroker {
    private final NemoAPI nemoAPI = new NemoAPI();

    public boolean login(String ID, String Pass) {
        nemoAPI.certification(ID, Pass);
        return true;
    }

    public boolean buy(String stockCode, int price, int count) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();

        nemoAPI.purchasingStock(stockCode, price, count);
        return true;
    }

    public boolean sell(String stockCode, int price, int count) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();

        nemoAPI.sellingStock(stockCode, price, count);
        return true;
    }

    public int getPrice(String stockCode, int minute) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();

        return nemoAPI.getMarketPrice(stockCode, minute);
    }

    private static boolean isIllegalStockCode(String stockCode) {
        return stockCode.equals("999999");
    }
}
