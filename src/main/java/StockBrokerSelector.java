public class StockBrokerSelector {
    public StockBroker selectStockBroker(String name) {
        if(name.equals("Nemo")) return new NemoStockBroker();
        else if(name.equals("Kiwer")) return new KiwerStockBroker();
        else {
            throw new IllegalArgumentException();
        }
        //return null;
    }
}
