package donnees;
import io.LecteurDonnees;

public class DonneesSimulation{
  Carte carte;
  Incendie incendies[];
  Robot robots[];

  public void setCarte(Carte car){
    this.carte = car;
  }

  public Carte getCarte(){
    return this.carte;
  }

  public void setIncendies(Incendie[] incend){
    this.incendies = incend;
  }

  public Incendie[] getIncendies(){
    return this.incendies;
  }

  @Override
  public String toString(){
    String strDonnees = new String();
    strDonnees += carte.toString();
    strDonnees += "Incendies : \n";
    for (Incendie incend : incendies) {
      strDonnees += incend.toString();
    }
    return strDonnees;
  }

}
