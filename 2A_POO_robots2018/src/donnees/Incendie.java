package donnees;

public class Incendie{
  private Carte carte;
  private Case position;
  private int ligne;
  private int colonne;
  private int eauNecessaire;
  private boolean affecte;

  public Incendie(Carte carte, int ligne, int colonne, int eauNecessaire){
    this.colonne = colonne;
    this.ligne = ligne;
    this.eauNecessaire = eauNecessaire;
    this.carte = carte;
    this.position = carte.getCase(ligne, colonne);
    this.affecte = false;
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

  public int getLigne(){
    return this.ligne;
  }

  public int getColonne(){
    return this.colonne;
  }

  public boolean getAffecte(){
    return this.affecte;
  }

  public void setAffecte(boolean affecte){
    this.affecte = affecte;
  }

  @Override
  public String toString(){
    return "Incendie : [" + this.ligne + ", " + this.colonne + "]" + " eau necessaire : " + this.eauNecessaire + "\n";
  }
}
