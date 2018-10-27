package donnees;

public class Incendie{
  private Case position;
  private int ligne;
  private int colonne;
  private int eauNecessaire;

  public Incendie(int colonne, int ligne, int eauNecessaire){
    this.colonne = colonne;
    this.ligne = ligne;
    this.eauNecessaire = eauNecessaire;
  }

  public Incendie(Case position, int eauNecessaire){
    this.position = position;
    this.eauNecessaire = eauNecessaire;
  }

  public Case getPosition(){
    return this.position;
  }

  public void setPosition(Case nv_case){
    this.position = nv_case;
  }

  public int getEauNecessaire(){
    return this.eauNecessaire;
  }

  public void setEauNecessaire(int eauNecessaire){
    this.eauNecessaire = eauNecessaire;
  }

}
