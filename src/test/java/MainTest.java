import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MainTest {
    
    private StockBrokerSelector selector;

    @Mock
    private StockBroker mockStockBroker;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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
    void Nemo_없는_종목_매수_시_에러_return을_테스트한다() {
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
    void Nemo_없는_종목_매도_시_에러_return을_테스트한다() {
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
    void Nemo_없는_종목_확인_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Nemo");
        String stockCode = "999999";

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.getPrice(stockCode);
        });
    }

    @Test
    void Kiwer_증권사의_로그인_기능을_테스트한다_2() {
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
    void Kiwer_없는_종목_매수_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";
        int price = 70000;
        int quantity = 5;

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
        int price = 70000;
        int quantity = 5;

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
    void Kiwer_없는_종목_확인_시_에러_return을_테스트한다() {
        // arrange
        StockBroker broker = selector.selectStockBroker("Kiwer");
        String stockCode = "999999";

        // act & assert
        assertThrows(IllegalArgumentException.class, () -> {
            broker.getPrice(stockCode);
        });
    }

    @Test
    void buyNiceTiming_3번_다_올라가면_getPrice_3번_호출되고_buy_1번_호출된다() {
        // arrange
        AutoTrading autoTrading = new AutoTrading(mockStockBroker);
        String stockCode = "005930";
        int amount = 1000000;

        // getPrice를 3번 호출할 때 상승 추세 시뮬레이션 (100 -> 110 -> 120)
        when(mockStockBroker.getPrice(stockCode))
                .thenReturn(100)
                .thenReturn(110)
                .thenReturn(120);

        when(mockStockBroker.buy(stockCode, 120, 8333)).thenReturn(true); // 1000000 / 120 = 8333

        // act
        boolean result = autoTrading.buyNiceTiming(stockCode, amount);

        // assert
        assertTrue(result);
        verify(mockStockBroker, times(3)).getPrice(stockCode); // getPrice 3번 호출 검증
        verify(mockStockBroker, times(1)).buy(stockCode, 120, 8333); // buy 1번 호출 검증
    }

    @Test
    void buyNiceTiming_3번_중_한번이라도_내려가면_getPrice_3번_호출되지만_buy는_호출되지_않는다() {
        // arrange
        AutoTrading autoTrading = new AutoTrading(mockStockBroker);
        String stockCode = "005930";
        int amount = 1000000;

        // getPrice를 3번 호출할 때 상승->하락 추세 시뮬레이션 (100 -> 110 -> 105)
        when(mockStockBroker.getPrice(stockCode))
                .thenReturn(100)
                .thenReturn(110)
                .thenReturn(105);

        // act
        boolean result = autoTrading.buyNiceTiming(stockCode, amount);

        // assert
        assertFalse(result);
        verify(mockStockBroker, times(3)).getPrice(stockCode); // getPrice 3번 호출 검증
        verify(mockStockBroker, never()).buy(anyString(), anyInt(), anyInt()); // buy 호출되지 않음 검증
    }

    @Test
    void sellNiceTiming_3번_다_내려가면_getPrice_3번_호출되고_sell_1번_호출된다() {
        // arrange
        AutoTrading autoTrading = new AutoTrading(mockStockBroker);
        String stockCode = "005930";
        int quantity = 10;

        // getPrice를 3번 호출할 때 하락 추세 시뮬레이션 (120 -> 110 -> 100)
        when(mockStockBroker.getPrice(stockCode))
                .thenReturn(120)
                .thenReturn(110)
                .thenReturn(100);

        when(mockStockBroker.sell(stockCode, 100, quantity)).thenReturn(true);

        // act
        boolean result = autoTrading.sellNiceTiming(stockCode, quantity);

        // assert
        assertTrue(result);
        verify(mockStockBroker, times(3)).getPrice(stockCode); // getPrice 3번 호출 검증
        verify(mockStockBroker, times(1)).sell(stockCode, 100, quantity); // sell 1번 호출 검증
    }

    @Test
    void sellNiceTiming_3번_중_한번이라도_올라가면_getPrice_3번_호출되지만_sell은_호출되지_않는다() {
        // arrange
        AutoTrading autoTrading = new AutoTrading(mockStockBroker);
        String stockCode = "005930";
        int quantity = 10;

        // getPrice를 3번 호출할 때 하락->상승 추세 시뮬레이션 (120 -> 110 -> 115)
        when(mockStockBroker.getPrice(stockCode))
                .thenReturn(120)
                .thenReturn(110)
                .thenReturn(115);

        // act
        boolean result = autoTrading.sellNiceTiming(stockCode, quantity);

        // assert
        assertFalse(result);
        verify(mockStockBroker, times(3)).getPrice(stockCode); // getPrice 3번 호출 검증
        verify(mockStockBroker, never()).sell(anyString(), anyInt(), anyInt()); // sell 호출되지 않음 검증
    }
}
