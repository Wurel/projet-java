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

  public int getCollone(){
    return this.colonne;
  }

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


  @Override
  public String toString(){
    return "Case : [" + this.ligne + ", " + this.colonne + "]" + " " + this.nature;
  }
}
