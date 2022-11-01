package tn.esprit.rh.achat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;
import tn.esprit.rh.achat.services.IReglementService;
import tn.esprit.rh.achat.services.ReglementServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestReglement {
    @Mock
    ReglementRepository reglementRepository;
    @InjectMocks
    ReglementServiceImpl reglementServiceImpl;
    @Autowired
    IReglementService iReglementService;

    Reglement r = new Reglement();

    @Test
    public void testAddReglement() {
        List<tn.esprit.rh.achat.entities.Reglement> Reglements = iReglementService.retrieveAllReglements();
        int expected=Reglements.size();
        Reglement r = new Reglement();
        r.setMontantPaye((float) 14.5);
        r.setMontantRestant((float) 5.5);
        Reglement savedReglement= iReglementService.addReglement(r);
        assertEquals(expected+1, iReglementService.retrieveAllReglements().size());
        assertNotNull(savedReglement.getMontantPaye());
        iReglementService.deleteReglement(savedReglement.getIdReglement());
    }

    @Test
    public void MockAddReglement() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(r));
        Reglement reglement = reglementServiceImpl.retrieveReglement((long)2);
        assertNotNull(reglement);
        log.info("get reglement"+reglement.toString());
    }
}
