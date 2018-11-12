package donnees;
import java.util.*;
import java.lang.IndexOutOfBoundsException;
import java.lang.IllegalArgumentException;

/**
  * Classe representant la carte contenant toutes les cases.
  */

public class Carte{
  private int tailleCases;
  private int nbLignes;
  private int nbColonnes;
  private Case tableauCases[][];

  /**
    * @param nbLignes Nombre de lignes de la Carte
    * @param nbColonnes Nombre de colonne de la Carte
    */
  public Carte(int nbLignes, int nbColonnes){
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
    this.tableauCases = new Case[nbLignes][nbColonnes];
  }

  /**
    * @param nbLignes Nombre de lignes de la Carte
    * @param nbColonnes Nombre de colonne de la Carte
    * @param tailleCases Taille des cases de la Carte
    */
  public Carte(int nbLignes, int nbColonnes, int tailleCases){
    this.nbLignes = nbLignes;
    this.nbColonnes = nbColonnes;
    this.tailleCases = tailleCases;
    this.tableauCases = new Case[nbLignes][nbColonnes];
  }

  /**
    * @param cas Case qu'on set dans le tableau de cases
    * @param lig Ligne ou se situe la case
    * @param col colonne ou se situe la case
    */
  public void setCase(Case cas, int lig, int col){
    this.tableauCases[lig][col] = cas;
  }

  /**
    * @return Renvoie le nombre de lignes
    */
  public int getNbLignes(){
    return this.nbLignes;
  }

  /**
    * @return Renvoie le nombre de colonnes
    */
  public int getNbColonnes(){
    return this.nbColonnes;
  }

  /**
    * @return Renvoie la taille des cases
    */
public int getTailleCases(){
    return this.tailleCases;
  }

  /**
    * @param lig Ligne a laquelle on veut recuperer la case
    * @param col Colonne a laquelle on veut recuperer la case
    * @return Renvoie la case situe a [lig, col]
    */
  public Case getCase(int lig, int col){
    try {
      return this.tableauCases[lig][col];
    } catch (IndexOutOfBoundsException e){
      System.out.println("Cela dépasse les dimensions de la carte.");
    }
    return null;
  }

  /**
    * @param src Case dont on veut savoir si elle a un voisin
    * @param dir Direction dans laquelle on regarde si il y a un voisin
    * @return Renvoie
    */
  public boolean voisinExiste(Case src, Direction dir){
    switch (dir) {
      case EST:
        if (src.getColonne() < this.nbColonnes-1) {
          return true;
        }
        return false;
      case OUEST:
        if (0 < src.getColonne()) {
          return true;
        }
        return false;
      case NORD:
        if (0 < src.getLigne()) {
          return true;
        }
        return false;
      case SUD:
        if (src.getLigne() < this.nbLignes-1) {
          return true;
        }
        return false;
    }
    return false;

  }

  /**
    * @param src Case dont on veut la voisine
    * @param dir Direction dans laquelle on veut la voisine
    * @return Renvoie la case voisine
    */
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
    return null;
  }

  /**
    * @return Renvoie un tableau de case contenant de l'eau
    */
  public ArrayList<Case> getCasesEau(){
    ArrayList<Case> casesEau = new ArrayList<Case>();
    for (int i = 0; i < this.nbLignes; i++) {
      for (int j = 0; j < this.nbColonnes; j++) {
        if (tableauCases[i][j].getNature() == NatureTerrain.values()[0]){
          casesEau.add(tableauCases[i][j]);
        }
      }
    }
    return casesEau;
  }

  /**
    * @return Renvoie les donnees essentielles de chaque case de la carte
    */
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
