package com.esprit.examen.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplTest {
    @Mock
    ProduitRepository Repo;

    @InjectMocks
    
    ProduitServiceImpl Service;
    Produit produit = Produit.builder().codeProduit("nom").libelleProduit("ba").build();
    List<Produit> listproduits = new ArrayList<Produit>() {
        {
            add(Produit.builder().codeProduit("nom").libelleProduit("ba").build());
            add(Produit.builder().codeProduit("nom222").libelleProduit("ba222").build());
        }
    };

    @Test
    void testRetrieveProduit() {
        Mockito.when(Repo.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        @SuppressWarnings("removal")
        Produit s1 = Service.retrieveProduit(new Long(2));
        Assertions.assertNotNull(s1);
    }

    @Test
    void testAllRetrieveProduit() {
        Mockito.when(Repo.findAll()).thenReturn(listproduits);
        List<Produit> IProduit = Service.retrieveAllProduits();
        Assertions.assertNotNull(IProduit);
    }

    @Test
    void testAddProduit() {
        Mockito.when(Repo.save(produit)).thenReturn(produit);
        Produit s1 = Service.addProduit(produit);
        Assertions.assertNotNull(s1);

    }

    @Test
    void testUpdateProduit() {
    	produit.setCodeProduit("ranim");
    	produit.setLibelleProduit("test_ranim");
        Mockito.when(Repo.save(produit)).thenReturn(produit);
        Produit s1 = Service.updateProduit(produit);
        Assertions.assertEquals(produit, s1);

    }

    @Test
    void testDeleteProduit() {
        Service.deleteProduit(produit.getIdProduit());
        Mockito.verify(Repo, Mockito.times(1)).deleteById(produit.getIdProduit());
    }


}