package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
public class OperateurTest{
    @Mock
    OperateurRepository operateurRepository;
    @InjectMocks
    OperateurServiceImpl operateurServiceImp  ;
    @Autowired
    IOperateurService operateurService;

    Operateur op = Operateur.builder().nom("aaa").prenom("bbbb").password("eeee").build();

    @Test
    public void AddOperateurTest() {
        List<Operateur> operateurs = operateurService.retrieveAllOperateurs();
        int expected=operateurs.size();
        Operateur o = new Operateur();
        o.setNom("test");
        o.setPrenom("test2");
        o.setPassword("test3");
        Operateur savedOperateur= operateurService.addOperateur(o);
        assertEquals(expected+1, operateurService.retrieveAllOperateurs().size());
        assertNotNull(savedOperateur.getNom());
        operateurService.deleteOperateur(savedOperateur.getIdOperateur());
    }
    @Test
    public void updateOperateurTest()
    {
    Operateur op = new Operateur();
        op.setNom("test");
        op.setPrenom("test2");
        op.setPassword("test3");
    
        Operateur updatedOperateur=operateurService.updateOperateur(op);
        
    }

   @Test
   public void deleteeOperateurTest()
   {
        //operateurService.deleteOperateur();
        //assertNull(operateurService.retrieveOperateur());
   }

    @Test
    public void MockAddOperateurTest() {
        Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
        Operateur operateur = operateurServiceImp.retrieveOperateur((long) 1);
        assertNotNull(operateur);
        log.info("get operateur"+operateur);
    }

    @Test
    public void saveOperateurTest() {
		when(operateurRepository.findAll()).thenReturn(Stream
				.of(new Operateur((long)12,"mock","mocks","123000",null),new Operateur((long)15,"mock1","mocks1","123001",null)).collect(Collectors.toList()));
				
	}
    @Test
    public void UpdateOperateurTestMockito() {
        when(operateurRepository.save(op)).thenReturn(op);
        assertNotNull(op);
        assertEquals(op, operateurService.updateOperateur(op));
    }
	@Test
	public void deleteOperateurTest() {
		Operateur operateur = new Operateur((long)12,"mock","mocks","123000",null);
		//operateurService.deleteOperateur(operateur.getIdOperateur());
		//verify(operateurRepository, times(1)).delete(operateur);
	}	

}