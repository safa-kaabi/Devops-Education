package com.esprit.examen.services;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;
import com.esprit.examen.services.IStockService;
import com.esprit.examen.services.StockServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class TestStock {
    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl iStockService;
    @Autowired
    IStockService stockService;

    Stock stock1 = new Stock("stock test",10,100);

    //JUNIT

    @Test
    public void testAddStock() {
        List<Stock> stocks = stockService.retrieveAllStocks();
        int expected=stocks.size();
        Stock s = new Stock();
        s.setLibelleStock("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock savedStock= stockService.addStock(s);
        assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());
    }
     	
 	@Test
 	public void testUpdateStock()
 	{
 	Stock s = new Stock();
 		s.setIdStock(1L);
 		s.setLibelleStock("stock test");
 		s.setQte(700);
 		s.setQteMin(7000);
 		Stock updatedStock=iStockService.updateStock(s);
 		assertEquals(s.getLibelleStock(),updatedStock.getLibelleStock());
 	}

    @Test
	public void testDeleteStock()
	{
 		iStockService.deleteStock(4L);
 		assertNull(iStockService.retrieveStock(4L));
	}
      
     // MOCKITO

     @Test
     public void addStockTestMockito() {
         when(stockRepository.save(stock1)).thenReturn(stock1);
         assertNotNull(stock1);
         assertEquals(stock1, stockService.addStock(stock1));
     }

     @Test
     public void DeleteStockTestMockito() {
         stockRepository.save(stock1);
         stockService.deleteStock(stock1.getIdStock());
         verify(stockRepository, times(1)).deleteById(stock1.getIdStock());
     }
     @Test
     public void UpdateStockTestMockito() {
         when(stockRepository.save(stock1)).thenReturn(stock1);
         assertNotNull(stock1);
         assertEquals(stock1, stockService.updateStock(stock1));
     }
}


