package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;
import personnages.Chef;
import personnages.*;
import histoire.*;
import frontiere.*;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;

	@BeforeEach
	public void initialisation() {
		System.out.println("Initialisation...\n");
		village = new Village("Le village des irréductibles",10,5);
		chef = new Chef("Abraracourcix",10,village);
		village.setChef(chef);
	}
	
	

}
