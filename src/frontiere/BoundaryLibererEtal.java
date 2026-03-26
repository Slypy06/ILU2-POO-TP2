package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			
			System.out.println("Mais vous n'êtes pas inscrits sur notre marché aujourd'hui !");
			
		} else {
			
			String[] doneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			boolean etalOccupe = Boolean.parseBoolean(doneesEtal[0]);

			if(etalOccupe) {
				
				String produit = doneesEtal[2];
				String quantiteInitial = doneesEtal[3];
				String quantiteVendu = doneesEtal[4];
				
				System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitial + " " + produit + ".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée.");
				
			}
			
		}
		
	}

}
