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
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.IOperateurService;
import tn.esprit.rh.achat.services.OperateurServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OperateurTest{
    @Mock
    OperateurRepository operateurRepository;
    @InjectMocks
    OperateurServiceImpl operateurServiceImp  ;
    @Autowired
    IOperateurService operateurService;

    Operateur op = new Operateur("mmmm", "erere", "zezeze");

    @Test
    public void testAddOperateur() {
        List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
        int expected=operateurs.size();
        Operateur o = new Operateur();
        o.setNom("test");
        o.setPrenom("test2");
        o.setPassword("test3");
        Operateur savedOperateur= operateurService.addOperateur(o);
        assertEquals(expected+1, operateurService.retrieveAllOperateurs().size());
        assertNotNull(savedOperateur.getNom());
        //operateurService.deleteOperateur(savedOperateur.getIdOperateur());
    }


    @Test
    public void MockAddOperateur() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
        Operateur operateur = operateurServiceImp.retrieveOperateur((long) 1);
        assertNotNull(operateur);
        log.info("get operateur"+operateur.toString());
    }
}*/
