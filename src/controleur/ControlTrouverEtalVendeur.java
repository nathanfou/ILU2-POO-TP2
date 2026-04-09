package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Etal etal = null;
		Gaulois G = village.trouverHabitant(nomVendeur);
		if(G != null) {
			etal = village.rechercherEtal(G);
		}
		return etal;
	}
}
