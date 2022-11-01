/*package tn.esprit.rh.achat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;
public class Produit {
    @Mock
    StockRepository ProduitRepository;
    @InjectMocks
    StockServiceImpl ProduitServiceImpl;
    @Autowired
    IStockService ProduitService;

    //Produit p = new Produit("Produit test",10,100);

    @Test
    public void testAddProduits() {
        List<Produit> Produits = ProduitService.retrieveAllProduits();
        int expected=Produits.size();
        Produit p = new Produit();
        p.
        p.setlibelleProduit("Produit test");
        p.setprix(10);
        p.set;
        p.dateDerniereModification;
        Stock savedStock= stockService.addStock(s);
        assertEquals(expected+1, stockService.retrieveAllStocks().size());
        assertNotNull(savedStock.getLibelleStock());
        stockService.deleteStock(savedStock.getIdStock());
    }
    @Test
    public void MockAddStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock stock = stockServiceImpl.retrieveStock((long) 2);
        assertNotNull(stock);
        log.info("get stock"+stock.toString());
    }



}*/
