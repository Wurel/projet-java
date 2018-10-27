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

  public void setCase(Case case, int ligne, int colonne){
    this.tableauCases[ligne][colonne] = case;
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

  public Case getCase(int ligne, int colonne){
    if (ligne =< this.nbLignes && colonne =< this.nbColonnes) {
      return this.tableauCases[ligne][colonne];
    }
  }


  public Boolean voisinExiste(Case src, Direction dir){
    switch (dir) {
      case EST:
        if (src.getCollone() < this.nbColonnes) {
          return TRUE;
        }
        else return FALSE;
      case OUEST:
        if (0 < src.getCollone()) {
          return TRUE;
        }
        else return FALSE;
      case NORD:
        if (0 < src.getLigne()) {
          return TRUE;
        }
        else return FALSE;
      case SUD:
        if (src.getLigne() < this.nbLignes) {
          return TRUE;
        }
        else return FALSE;
    }
  }

  public Case getVoisin(Case src, Direction dir){
    if (voisinExiste(src, dir)) {
      switch (dir) {
        case EST:
        case OUEST:
          return this.tableauCases[src.getLigne()][src.getCollone() + dir];
        case NORD:
        case SUD:
          return this.tableauCases[src.getLigne() + dir][src.getCollone()];
      }
    }
    else{
      System.println("Pas de voisin go niquer ta mere et verifier avant")
      return NULL
    }
  }

}
