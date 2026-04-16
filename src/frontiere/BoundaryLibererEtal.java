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
				
				StringBuilder sb = new StringBuilder();
				sb.append("Vous avez vendu ");
				sb.append(quantiteVendu);
				sb.append(" sur ");
				sb.append(quantiteInitial);
				sb.append(" ");
				sb.append(produit);
				sb.append(".");
				System.out.println(sb.toString());

				sb = new StringBuilder();
				sb.append("Au revoir ");
				sb.append(nomVendeur);
				sb.append(", passez une bonne journée.");
				System.out.println(sb.toString());
				
			}
			
		}
		
	}

}
