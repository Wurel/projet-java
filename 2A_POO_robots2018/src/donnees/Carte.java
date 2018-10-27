package donnees;

public class Carte{
  private int tailleCases;
  private int nbLignes;
  private int nbColonnes;
  private Case tableauCases[][];

  public Carte(int nbLignes, int nbColonnes){
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
  }

  public Carte(int nbLignes, int nbColonnes, int tailleCases){
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
    this.tailleCases = tailleCases;
  }

  public void setCase(Case casette, int ligne, int colonne){
    this.tableauCases[ligne][colonne] = casette;
  }

  public int getNbLignes(){
    return this.nbLignes;
  }

  public int getNbColonnes(){
    return this.nbColonnes;
  }

  public int getTailleCases(){
    return this.tailleCases;
  }

  public Case getCase(int lig, int col){
    if (lig <= this.nbLignes && col <= this.nbColonnes) {
      return this.tableauCases[lig][col];
    }
  }


  public int voisinExiste(Case src, Direction dir){
    switch (dir) {
      case EST:
        if (src.getCollone() < this.nbColonnes) {
          return 1;
        }
        else return 0;
      case OUEST:
        if (0 < src.getCollone()) {
          return 1;
        }
        else return 0;
      case NORD:
        if (0 < src.getLigne()) {
          return 1;
        }
        else return 0;
      case SUD:
        if (src.getLigne() < this.nbLignes) {
          return 1;
        }
        else return 0;
    }
  }

  public Case getVoisin(Case src, Direction dir){
    if (voisinExiste(src, dir) == 1) {
      switch (dir) {
        case EST:
        return this.tableauCases[src.getLigne()][src.getCollone() + 1];
        case OUEST:
        return this.tableauCases[src.getLigne()][src.getCollone() - 1];
        case NORD:
        return this.tableauCases[src.getLigne() - 1][src.getCollone()];
        case SUD:
          return this.tableauCases[src.getLigne() + 1][src.getCollone()];
      }
    }
    else{
      System.out.println("Pas de voisin go niquer ta mere et verifier avant");
      System.exit(0);
    }
  }

}
