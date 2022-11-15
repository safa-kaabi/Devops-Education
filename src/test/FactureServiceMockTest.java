/*package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class FactureServiceMockTest {


    @InjectMocks
    FactureServiceImpl FactureService;

    @Mock
    FactureRepository FactureRepository;
    Facture o1 = Facture.builder().montantRemise(2).montantFacture(3000).dateCreationFacture(null).dateDerniereModificationFacture(null).archivee(true).detailsFacture(nulll).fournisseur(nulll).reglements(nulll)build();

    @Test
    public void saveFactureTest() {

        FactureService.addFacture(o1);
        verify(FactureRepository, times(1)).save(o1);
        log.info(String.valueOf(o1));
        log.info("Facture added ");
    }

    @Test
    public void getAllSecteursTest()
    {
        List<Facture> FactureList = new ArrayList<Facture>() {

            {
                add(o1);
                add(Facture.builder().montantRemise(156320).montantFacture(980).dateCreationFacture(null).dateDerniereModificationFacture(null).archivee(true).detailsFacture(nulll).fournisseur(nulll).reglements(nulll)build() );
                add(Facture.builder().montantRemise(2000).montantFacture(45000).dateCreationFacture(null).dateDerniereModificationFacture(null).archivee(true).detailsFacture(nulll).fournisseur(nulll).reglements(nulll)build() );
            }};


        when(FactureService.retrieveAllFactures()).thenReturn(FactureList);
        test
        List<Facture> sList = FactureService.retrieveAllFactures();
        assertEquals(3, sList.size());
        log.info(" Retrieve all is working correctly...!!");

    }
}*/