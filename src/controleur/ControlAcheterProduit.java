package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public String[] trouverVendeursProduit(String produit) {
		String[] vendeurs = null;
		Gaulois[] gauloisVendeurs = village.rechercherVendeursProduit(produit);

		if (gauloisVendeurs != null) {
			vendeurs = new String[gauloisVendeurs.length];
			for (int i = 0; i < gauloisVendeurs.length; i++) {
				vendeurs[i] = gauloisVendeurs[i].getNom();
			}
		}

		return vendeurs;
	}

	public int acheterProduit(String nomVendeur, int quantiteAcheter) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantiteAcheter);
	}
}