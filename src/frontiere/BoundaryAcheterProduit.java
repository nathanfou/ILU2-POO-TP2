package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}

		String produit = Clavier
				.entrerChaine("Quel produit voulez-vous acheter ?");

		String[] vendeurs = controlAcheterProduit.trouverVendeursProduit(produit);

		if (vendeurs == null || vendeurs.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
			return;
		}

		System.out.println(
				"Chez quel commerçant voulez-vous acheter des " + produit + " ?");

		for (int i = 0; i < vendeurs.length; i++) {
			System.out.println((i + 1) + " - " + vendeurs[i]);
		}

		int choix = Clavier.entrerEntier("") - 1;
		String nomVendeur = vendeurs[choix];

		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur "
				+ nomVendeur);
		System.out.println("Bonjour " + nomAcheteur);

		int quantiteVoulu = Clavier.entrerEntier(
				"Combien de " + produit + " voulez-vous acheter ?");

		int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur,
				quantiteVoulu);

		if (quantiteAchetee == 0) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVoulu + " "
					+ produit + ", malheureusement il n'y en a plus !");
		} else if (quantiteAchetee < quantiteVoulu) {
			System.out.println(nomAcheteur + " veut acheter " + quantiteVoulu + " "
					+ produit + ", malheureusement " + nomVendeur + " n'en a plus que "
					+ quantiteAchetee + ". " + nomAcheteur
					+ " achète tout le stock de " + nomVendeur + ".");
		} else {
			System.out.println(nomAcheteur + " achète " + quantiteAchetee + " "
					+ produit + " à " + nomVendeur + ".");
		}
	}
}