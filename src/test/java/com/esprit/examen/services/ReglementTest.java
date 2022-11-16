package com.esprit.examen.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.Reglement;
import com.esprit.examen.repositories.ReglementRepository;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class ReglementTest{
    @Mock
    ReglementRepository reglementRepository;
    @InjectMocks
    ReglementServiceImpl reglementServiceImpl;
    @Autowired
    IReglementService iReglementService;

    Reglement r = new Reglement();

    @Test
    public void testAddReglement() {
        List<Reglement> Reglements = iReglementService.retrieveAllReglements();
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
