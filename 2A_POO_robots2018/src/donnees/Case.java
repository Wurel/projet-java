package donnees;

/**
  * Classe representant les cases
  */
public class Case{
  private int ligne;
  private int colonne;
  private NatureTerrain nature;

  /**
    * @param ligne Ligne a laquelle se trouve la case sur la carte
    * @param colonne Colonne a laquelle se trouve la case sur la carte
    * @param nature Nature de la case
    */
  public Case(int ligne, int colonne, NatureTerrain nature){
    this.ligne = ligne;
    this.colonne = colonne;
    this.nature = nature;
  }

  /**
    * @return Renvoie la ligne sur laquelle se situe la case
    */
  public int getLigne(){
    return this.ligne;
  }

  /**
    * @return Renvoie la colonne sur laquelle se situe la case
    */
  public int getColonne(){
    return this.colonne;
  }

  /**
    * @return Renvoie la nature de la case
    */
  public NatureTerrain getNature(){
    return this.nature;
  }

  public String getCouleur(){
    switch (this.nature) {
      case EAU:
        return "#318CE7";
      case FORET:
        return "#386F48";
      case ROCHE:
        return "#798081";
      case TERRAIN_LIBRE:
        return "#F88E55";
      case HABITAT:
        return "#6C0277";
    }
    return "";
  }

  /**
    * @return Renvoie le chemin de l'image en fonction de la nature de la case
    */
public String getImage(){
    switch (this.nature) {
      case EAU:
        return "src/image/Eau.png";
      case FORET:
        return "src/image/Foret.jpeg";
      case ROCHE:
        return "src/image/rocher.jpg";
      case TERRAIN_LIBRE:
        return "src/image/Terrain_libre.png";
      case HABITAT:
        return "src/image/Maison.jpg";
    }
    return "";
  }

  /**
    * @param nvCase Case voisine de la case actuelle
    * @return Renvoie la direction dans laquelle se trouve nvCase par rapport a la case
    */
public Direction getDirectionVoisin(Case nvCase){
    int dirSud = (nvCase.getLigne() - this.ligne == 1)?1:0;
    int dirEst = (nvCase.getColonne() - this.colonne == 1)?2:0;
    int dirOuest = (nvCase.getColonne() - this.colonne == -1)?3:0;
    return Direction.values()[dirSud + dirEst + dirOuest];
  }

  /**
    * @param otherCase Case a comparer avec la case actuelle
    * @return Renvoie true si la case actuelle et otherCase ont les memes coordonees et la meme nature
    */
  public boolean equals(Case otherCase){
    if (this.ligne != otherCase.getLigne()){
      return false;
    }
    else if (this.colonne != otherCase.getColonne()){
      return false;
    }
    else if (this.nature != otherCase.getNature()){
      return false;
    }
    return true;
  }

  /**
    * @return Renvoie les donnees essentielles de la Case
    */
  @Override
  public String toString(){
    return "Case : [" + this.ligne + ", " + this.colonne + "]" + " " + this.nature;
  }
}
