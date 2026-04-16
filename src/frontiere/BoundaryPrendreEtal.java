package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		
		StringBuilder sb;
		
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			
			sb = new StringBuilder();
			sb.append("Je suis désolé ");
			sb.append(nomVendeur);
			sb.append(" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(sb.toString());
			
		} else {
			
			sb = new StringBuilder();
			sb.append("Bonjour ");
			sb.append(nomVendeur);
			sb.append(", je vais regarder si je peux vous trouver un étal.");
			System.out.println(sb.toString());
			
			if(!controlPrendreEtal.resteEtals()) {
				
				sb = new StringBuilder();
				sb.append("Désolé ");
				sb.append(nomVendeur);
				sb.append(" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.println(sb.toString());
				
			} else {
				
				installerVendeur(nomVendeur);
				
			}
			
		}
	}

	private void installerVendeur(String nomVendeur) {
		
		StringBuilder sb;
		
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		System.out.println("Il me faudrait quelques renseignements :");
		
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");

		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		
		if(numeroEtal != -1) {
			
			sb = new StringBuilder();
			sb.append("Le vendeur ");
			sb.append(nomVendeur);
			sb.append(" s'est installé à l'étal n°");
			sb.append(numeroEtal);
			System.out.println(sb.toString());
			
		}
	}
}
