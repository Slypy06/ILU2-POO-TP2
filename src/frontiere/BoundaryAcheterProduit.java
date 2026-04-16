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
	        afficherRefusIdentite(nomAcheteur);
	        return;
	    }

	    String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
	    Gaulois[] vendeurs = controlAcheterProduit.chercherVendeurs(produit);

	    if (vendeurs == null) {
	        System.out.println("Désolé, personne ne vend de ce produit au marché");
	        return;
	    }

	    gererAchat(nomAcheteur, produit, vendeurs);
	}

	private void afficherRefusIdentite(String nomAcheteur) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Je suis désolé ");
	    sb.append(nomAcheteur);
	    sb.append(" mais il faut être un habitant de notre village pour commercer ici.");
	    System.out.println(sb.toString());
	}

	private void gererAchat(String nomAcheteur, String produit, Gaulois[] vendeurs) {

	    StringBuilder sb = new StringBuilder();
	    sb.append("Chez quel commerçant voulez-vous acheter des ");
	    sb.append(produit);
	    sb.append(" ?");
	    System.out.println(sb.toString());

	    for (int i = 0; i < vendeurs.length; i++) {
	        sb = new StringBuilder();
	        sb.append(i + 1);
	        sb.append(" - ");
	        sb.append(vendeurs[i].getNom());
	        System.out.println(sb.toString());
	    }

	    int indexVendeur = Clavier.entrerEntier("");

	    if (indexVendeur <= 0 || indexVendeur > vendeurs.length) {
	        System.out.println("Ce n'est pas un choix valide");
	        return;
	    }

	    effectuerTransaction(nomAcheteur, produit, vendeurs[indexVendeur - 1]);
	}

	private void effectuerTransaction(String nomAcheteur, String produit, Gaulois vendeur) {

	    StringBuilder sb = new StringBuilder();
	    sb.append(nomAcheteur);
	    sb.append(" se déplace jusqu'à l'étal de ");
	    sb.append(vendeur.getNom());
	    System.out.println(sb.toString());

	    sb = new StringBuilder();
	    sb.append("Bonjour ");
	    sb.append(nomAcheteur);
	    System.out.println(sb.toString());

	    sb = new StringBuilder();
	    sb.append("Combien de ");
	    sb.append(produit);
	    sb.append(" voulez-vous acheter ?");
	    int quantite = Clavier.entrerEntier(sb.toString());

	    int quantiteAchete = controlAcheterProduit.acheterProduit(vendeur.getNom(), quantite);

	    afficherResultat(nomAcheteur, produit, vendeur.getNom(), quantite, quantiteAchete);
	}

	private void afficherResultat(String nomAcheteur, String produit, String vendeur, int quantite, int quantiteAchete) {

	    StringBuilder sb = new StringBuilder();

	    if (quantiteAchete == 0) {
	        sb.append(nomAcheteur);
	        sb.append(" veut acheter ");
	        sb.append(quantite);
	        sb.append(" ");
	        sb.append(produit);
	        sb.append(", malheureusement il n'y en a plus !");
	    } else if (quantiteAchete < quantite) {
	        sb.append(nomAcheteur);
	        sb.append(" veut acheter ");
	        sb.append(quantite);
	        sb.append(" ");
	        sb.append(produit);
	        sb.append(", malheureusement ");
	        sb.append(vendeur);
	        sb.append(" n'en a plus que ");
	        sb.append(quantiteAchete);
	        sb.append(". ");
	        sb.append(nomAcheteur);
	        sb.append(" achète tout le stock de ");
	        sb.append(vendeur);
	    } else {
	        sb.append(nomAcheteur);
	        sb.append(" achète ");
	        sb.append(quantite);
	        sb.append(" ");
	        sb.append(produit);
	        sb.append(" à ");
	        sb.append(vendeur);
	    }

	    System.out.println(sb.toString());
	    
	}

}