public class NemoStockBroker implements StockBroker {
    private static final int ONE_SECOND = 1000;
    private static final String WRONG_CODE = "999999";
    private final NemoAPI nemoAPI = new NemoAPI();

    @Override
    public boolean login(String id, String password) {
        nemoAPI.certification(id, password);
        return true;
    }

    @Override
    public boolean buy(String stockCode, int price, int quantity) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();
        if (isValidNumber(price, quantity))
            throw new IllegalArgumentException();

        nemoAPI.purchasingStock(stockCode, price, quantity);
        return true;
    }

    @Override
    public boolean sell(String stockCode, int price, int quantity) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();
        if (isValidNumber(price, quantity))
            throw new IllegalArgumentException();

        nemoAPI.sellingStock(stockCode, price, quantity);
        return true;
    }

    private static boolean isValidNumber(int price, int quantity) {
        return price == 0 || quantity == 0;
    }

    @Override
    public int getPrice(String stockCode) {
        return getPrice(stockCode, ONE_SECOND);
    }

    public int getPrice(String stockCode, int minute) {
        if (isIllegalStockCode(stockCode))
            throw new IllegalArgumentException();

        return nemoAPI.getMarketPrice(stockCode, minute);
    }

    private static boolean isIllegalStockCode(String stockCode) {
        return stockCode.equals(WRONG_CODE);
    }
}

