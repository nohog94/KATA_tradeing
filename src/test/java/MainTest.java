package test.java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
