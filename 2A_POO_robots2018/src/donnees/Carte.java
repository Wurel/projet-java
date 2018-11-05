package donnees;

public class Carte{
  private int tailleCases;
  private int nbLignes;
  private int nbColonnes;
  private Case tableauCases[][];

  public Carte(int nbLignes, int nbColonnes){
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
    this.tableauCases = new Case[nbLignes][nbColonnes];
  }

  public Carte(int nbLignes, int nbColonnes, int tailleCases){
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
    this.tailleCases = tailleCases;
    this.tableauCases = new Case[nbLignes][nbColonnes];
  }

  public void setCase(Case cas, int lig, int col){
    this.tableauCases[lig][col] = cas;
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
    if (lig < this.nbLignes && col < this.nbColonnes) {
      return this.tableauCases[lig][col];
    }
    System.out.println("Cela dépasse les dimensions de la carte.");
    return this.tableauCases[lig][col];
  }

// A SURVEILLER
  public boolean voisinExiste(Case src, Direction dir){
    switch (dir) {
      case EST:
        if (src.getColonne() < this.nbColonnes-1) {
          return true;
        }
        else return false;
      case OUEST:
        if (0 < src.getColonne()) {
          return true;
        }
        else return false;
      case NORD:
        if (0 < src.getLigne()) {
          return true;
        }
        else return false;
      case SUD:
        if (src.getLigne() < this.nbLignes-1) {
          return true;
        }
        else return false;
    }
    return false;

  }

  public Case getVoisin(Case src, Direction dir){
    if (voisinExiste(src, dir)) {
      switch (dir) {
        case EST:
        return this.tableauCases[src.getLigne()][src.getColonne() + 1];
        case OUEST:
        return this.tableauCases[src.getLigne()][src.getColonne() - 1];
        case NORD:
        return this.tableauCases[src.getLigne() - 1][src.getColonne()];
        case SUD:
          return this.tableauCases[src.getLigne() + 1][src.getColonne()];
      }
    }
    System.out.println("Il n'y a pas de voisin dans cette direction.");
    return this.tableauCases[0][0];
  }

  @Override
  public String toString(){
    String strCarte = "Carte : \n"  ;
    for (int i = 0; i < this.nbLignes; i++) {
      for (int j = 0; j < this.nbColonnes; j++) {
        strCarte += tableauCases[i][j].toString() + "\n";
      }
    }
    return strCarte;
  }
}
