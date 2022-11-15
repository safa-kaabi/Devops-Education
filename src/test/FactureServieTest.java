/*package tn.esprit.rh.achat.services;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.IFactureService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FactureServiceTest {

	@Autowired
	IFactureService FactureService;


	@Autowired
	FactureRepository FactureRepository;

	@Test
	@Order(0)
	public void testAddFacture() {

		List<Facture> ops = FactureService.retrieveAllFactures();
		int expected=ops.size();
		Facture o = new Facture((long)1,2,3,null);

	    Facture savedOp= FactureService.addFacture(o);

		assertEquals(expected+1, FactureService.retrieveAllFactures().size());
		assertNotNull(o.getIdFacture());

		FactureService.deleteFacture(o.getIdFacture());
		}
}*/