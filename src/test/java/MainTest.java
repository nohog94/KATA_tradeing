package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    
    private StockBrokerSelector selector;
    
    @BeforeEach
    void setUp() {
        selector = new StockBrokerSelector();
    }
    
    @Test
    void Nemo_증권사를_선택할_수_있다() {
        // Arrange
        String brokerName = "Nemo";
        
        // act
        StockBroker broker = selector.selectStockBroker(brokerName);
        
        // assert
        assertNotNull(broker);
        assertTrue(broker instanceof NemoStockBroker);
    }
    
    @Test
    void Kiwer_증권사를_선택할_수_있다() {
        // arrange
        String brokerName = "Kiwer";
        
        // act
        StockBroker broker = selector.selectStockBroker(brokerName);
        
        // assert
        assertNotNull(broker);
        assertTrue(broker instanceof KiwerStockBroker);
    }
    
    @Test
    void 지원하지_않는_증권사_선택시_예외가_발생한다() {
        // arrange
        String brokerName = "InvalidBroker";
        
        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            selector.selectStockBroker(brokerName);
        });
    }
    
    @Test
    void Nemo_증권사의_로그인_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String id = "testId";
        String password = "testPass";
        
        // act
        boolean result = broker.login(id, password);
        
        // assert
        assertTrue(result);
    }
    
    @Test
    void Kiwer_증권사의_로그인_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String id = "testId";
        String password = "testPass";
        
        // act
        boolean result = broker.login(id, password);
        
        // assert
        assertTrue(result);
    }

    @Test
    void Nemo_매수_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int price = 70000;
        int quantity = 10;

        // act
        boolean result = broker.buy(stockCode, price, quantity);

        // assert
        assertTrue(result);
    }

    @Test
    void Nemo_없는 종목_매수_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";
        int price = 70000;
        int quantity = 10;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.buy(stockCode, price, quantity);
        });
    }
    
    @Test
    void Nemo_매도_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int price = 70000;
        int quantity = 5;
        
        // act
        boolean result = broker.sell(stockCode, price, quantity);
        
        // assert
        assertTrue(result);
    }

    @Test
    void Nemo_없는 종목_매도_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";
        int price = 70000;
        int quantity = 10;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.sell(stockCode, price, quantity);
        });
    }
    
    @Test
    void Nemo_현재가_확인_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        
        // act
        int currentPrice = broker.getPrice(stockCode);
        
        // assert
        assertTrue(currentPrice > 0);
    }

    @Test
    void Nemo_없는 종목_확인_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.getPrice(stockCode);
        });
    }

    @Test
    void Kiwer_증권사의_로그인_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String id = "testId";
        String password = "testPass";

        // act
        boolean result = broker.login(id, password);

        // assert
        assertTrue(result);
    }

    @Test
    void Kiwer_매수_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int price = 70000;
        int quantity = 10;

        // act
        boolean result = broker.buy(stockCode, price, quantity);

        // assert
        assertTrue(result);
    }

    @Test
    void Kiwer_없는 종목_매수_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.buy(stockCode, price, quantity);
        });
    }

    @Test
    void Kiwer_매도_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int price = 70000;
        int quantity = 5;

        // act
        boolean result = broker.sell(stockCode, price, quantity);

        // assert
        assertTrue(result);
    }

    @Test
    void Kiwer_없는_종목_매도_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.sell(stockCode, price, quantity);
        });
    }

    @Test
    void Kiwer_현재가_확인_기능을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";

        // act
        int currentPrice = broker.getPrice(stockCode);

        // assert
        assertTrue(currentPrice > 0);
    }

    @Test
    void Kiwer_없는 종목_확인_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.getPrice(stockCode);
        });
    }


    @Test
    void Nemo_가격이_올라가는_추세일때_buyNiceTiming으로_최대수량_매수한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertTrue(result);
    }

    @Test
    void Nemo_가격이_내려가는_추세일때_buyNiceTiming으로_매수하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertFalse(result);
    }

    @Test
    void Nemo_buyNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";
        int amount = 1000000;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.buyNiceTiming(stockCode, amount);
        });
    }

    @Test
    void Kiwer_가격이_올라가는_추세일때_buyNiceTiming으로_최대수량_매수한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertTrue(result);
    }

    @Test
    void Kiwer_가격이_내려가는_추세일때_buyNiceTiming으로_매수하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertFalse(result);
    }

    @Test
    void Kiwer_buyNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";
        int amount = 1000000;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.buyNiceTiming(stockCode, amount);
        });
    }

    @Test
    void Nemo_가격이_내려가는_추세일때_sellNiceTiming으로_설정수량_매도한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertTrue(result);
    }

    @Test
    void Nemo_가격이_올라가는_추세일때_sellNiceTiming으로_매도하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertFalse(result);
    }

    @Test
    void Nemo_sellNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";
        int quantity = 10;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.sellNiceTiming(stockCode, quantity);
        });
    }

    @Test
    void Kiwer_가격이_내려가는_추세일때_sellNiceTiming으로_설정수량_매도한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertTrue(result);
    }

    @Test
    void Kiwer_가격이_올라가는_추세일때_sellNiceTiming으로_매도하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertFalse(result);
    }

    @Test
    void Kiwer_sellNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";
        int quantity = 10;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.sellNiceTiming(stockCode, quantity);
        });
    }

    @Test
    void Nemo_가격이_올라가는_추세일때_buyNiceTiming으로_최대수량_매수한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertTrue(result);
    }

    @Test
    void Nemo_가격이_내려가는_추세일때_buyNiceTiming으로_매수하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertFalse(result);
    }

    @Test
    void Nemo_buyNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";
        int amount = 1000000;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.buyNiceTiming(stockCode, amount);
        });
    }

    @Test
    void Kiwer_가격이_올라가는_추세일때_buyNiceTiming으로_최대수량_매수한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertTrue(result);
    }

    @Test
    void Kiwer_가격이_내려가는_추세일때_buyNiceTiming으로_매수하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int amount = 1000000;

        // act
        boolean result = broker.buyNiceTiming(stockCode, amount);

        // assert
        assertFalse(result);
    }

    @Test
    void Kiwer_buyNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";
        int amount = 1000000;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.buyNiceTiming(stockCode, amount);
        });
    }

    @Test
    void Nemo_가격이_내려가는_추세일때_sellNiceTiming으로_설정수량_매도한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertTrue(result);
    }

    @Test
    void Nemo_가격이_올라가는_추세일때_sellNiceTiming으로_매도하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertFalse(result);
    }

    @Test
    void Nemo_sellNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";
        int quantity = 10;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.sellNiceTiming(stockCode, quantity);
        });
    }

    @Test
    void Kiwer_가격이_내려가는_추세일때_sellNiceTiming으로_설정수량_매도한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertTrue(result);
    }

    @Test
    void Kiwer_가격이_올라가는_추세일때_sellNiceTiming으로_매도하지_않는다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "005930";
        int quantity = 10;

        // act
        boolean result = broker.sellNiceTiming(stockCode, quantity);

        // assert
        assertFalse(result);
    }

    @Test
    void Kiwer_sellNiceTiming_없는_종목_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";
        int quantity = 10;

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.sellNiceTiming(stockCode, quantity);
        });
    }
}
