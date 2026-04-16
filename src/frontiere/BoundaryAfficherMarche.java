package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			StringBuilder sb = new StringBuilder();
			sb.append(nomAcheteur);
			sb.append(", vous trouverez au marché :");
			System.out.println(sb.toString());
			
			for (int i = 0; i < infosMarche.length; i++) {
				sb = new StringBuilder();
				sb.append("- ");
				sb.append(infosMarche[i]);
				i++;
				sb.append(" qui vend ");
				sb.append(infosMarche[i]);
				i++;
				sb.append(" ");
				sb.append(infosMarche[i]);
				i++;
				System.out.println(sb.toString());
			}
		}
	}
}