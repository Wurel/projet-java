package donnees;

public class Case{
  private int ligne;
  private int colonne;
  private NatureTerrain nature;

  public Case(int ligne, int colonne, NatureTerrain nature){
    this.ligne = ligne;
    this.colonne = colonne;
    this.nature = nature;
  }

  public int getLigne(){
    return this.ligne;
  }

  public int getColonne(){
    return this.colonne;
  }

  public NatureTerrain getNature(){
    return this.nature;
  }

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

  public Direction getDirectionVoisin(Case nvCase){
    int dirSud = (nvCase.getLigne() - this.ligne == 1)?1:0;
    int dirEst = (nvCase.getColonne() - this.colonne == 1)?2:0;
    int dirOuest = (nvCase.getColonne() - this.colonne == -1)?3:0;
    return Direction.values()[dirSud + dirEst + dirOuest];
  }

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

  @Override
  public String toString(){
    return "Case : [" + this.ligne + ", " + this.colonne + "]" + " " + this.nature;
  }
}
