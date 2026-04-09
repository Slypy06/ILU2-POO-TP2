package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			Gaulois[] vendeurs = controlAcheterProduit.chercherVendeurs(produit);
			if (vendeurs == null) {
				System.out.println("Désolé, personne ne vend de ce produit au marché");
			}
			else {
				System.out.println("Chez quel commerçant voulez-vous acheter des " + produit + " ?");
				for (int i=0;i<vendeurs.length;i++) {
					System.out.println((i+1) + " - " + vendeurs[i].getNom());
				}
				int indexVendeur = Clavier.entrerEntier("");
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal de " + vendeurs[indexVendeur-1].getNom());
				System.out.println("Bonjour " + nomAcheteur);
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteAchete = controlAcheterProduit.acheterProduit(vendeurs[indexVendeur-1].getNom(), quantite);
				if (quantiteAchete == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
				}
				else if (quantiteAchete < quantite) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " + vendeurs[indexVendeur-1].getNom() + " n'en a plus que " + quantiteAchete + ". " + nomAcheteur + " achète tout le stock de " + vendeurs[indexVendeur-1].getNom());
				}
				else {
					System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + vendeurs[indexVendeur-1].getNom());
				}
			}
		}
	}
}
