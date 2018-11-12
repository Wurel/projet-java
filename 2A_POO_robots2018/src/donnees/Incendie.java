package donnees;

/**
  * Classe representant les incendies
  */

public class Incendie{
  private Carte carte;
  private Case position;
  private int eauNecessaire;
  private boolean affecte;

  /**
    * @param carte Set la carte de l'Incendie
    * @param ligne Ligne sur laquelle se trouve l'Incendie
    * @param colonne Ligne sur laquelle se trouve l'Incendie
    * @param eauNecessaire Eau necessaire pour eteindre l'Incendie
    */

  public Incendie(Carte carte, int ligne, int colonne, int eauNecessaire){
    this.eauNecessaire = eauNecessaire;
    this.carte = carte;
    this.position = carte.getCase(ligne, colonne);
    this.affecte = false;
  }

  /**
    * @param position Initialise un incendie avec sa position
    * @param eauNecessaire Eau necessaire pour eteindre l'Incendie
    */

  public Incendie(Case position, int eauNecessaire){
    this.position = position;
    this.eauNecessaire = eauNecessaire;
  }

  /**
    * @return Renvoie la case sur laquelle se trouve l'Incendie
    */
  public Case getPosition(){
    return this.position;
  }

  /**
    * @param nvCase Set la position de l'incendie a nvCase
    */
  public void setPosition(Case nvCase){
    this.position = nvCase;
  }

  /**
    * @return Renvoie l'eau necessaire pour eteindre l'incendie
    */
  public int getEauNecessaire(){
    return this.eauNecessaire;
  }

  /**
    * @param eauNecessaire Modifie l'eau necessaire pour eteindre l'incendie à la valeur eauNecessaire
    */
  public void setEauNecessaire(int eauNecessaire){
    this.eauNecessaire = eauNecessaire;
  }

  /**
    * @return Renvoie la ligne sur laquelle se trouve le robot
    */
  public int getLigne(){
    return this.position.getLigne();
  }

  /**
    * @return Renvoie la colonnee sur laquelle se trouve le robot
    */
  public int getColonne(){
    return this.position.getColonne();
  }

  /**
    * @return Renvoie un booleen indiquant l'affectation de l'incendie
    */
  public boolean getAffecte(){
    return this.affecte;
  }

  /**
    * @param affecte Set l'affectation de l'incendie
    */
  public void setAffecte(boolean affecte){
    this.affecte = affecte;
  }

  /**
    * @return Renvoie les informations essentielles sur l'incendie
    */
  @Override
  public String toString(){
    return "Incendie : [" + this.getLigne() + ", " + this.getColonne() + "]" + " eau necessaire : " + this.eauNecessaire + "\n";
  }
}
