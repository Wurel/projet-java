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

  @Override
  public String toString(){
    return "Case : [" + this.ligne + ", " + this.colonne + "]" + " " + this.nature;
  }
}
