package donnees;
import java.util.*;
import simulation.Simulateur;

/**
  * Classe abstraite representant les robots.
  */

public abstract class Robot{
  private Carte carte;
  private Case position;
  private double vitesse;
  private int reservoirEau;
  private long date;
  private boolean occupe;

  /**
    * Initialise un robot avec sa position sur la carte
    * @param carte La carte ou le robot evolue
    * @param ligne La ligne ou le robot se trouve
    * @param colonne La colonne ou le robot se trouve
    */

  public Robot(Carte carte, int ligne, int colonne){
    this.carte = carte;
    this.position = carte.getCase(ligne, colonne);
  }

/**
  * @return Renvoie la carte
  */

  public Carte getCarte(){
    return this.carte;
  }

/**
  * @return Renvoie la date du prochain evenement.
  */
  public long getDate(){
    return this.date;
  }

  /**
    * @param  date  est la nouvelle date de prochain evenement
    */
  public void setDate(long date){
    this.date = date;
  }

  /**
    * @return Renvoie l'etat du robot 1 pour occupe
    */
  public boolean getOccupe(){
    return this.occupe;
  }

  /**
    * @param occupe set l'etat
    */
  public void setOccupe(boolean occupe){
    this.occupe = occupe;
  }

  /**
    * @return Renvoie la position
    */
  public Case getPosition(){
    return this.position;
  }

  /**
    * @param nvCase nouvelle position du robot
    */
  public void setPosition(Case nvCase){
    this.position = nvCase;
  }

  /**
    * @param vitesse nouvelle vitesse du robot
    */
  public void setVitesse(double vitesse){
    this.vitesse = vitesse;
  }

  /**
    * @param naturePosition Nature du terrain
    * @return Renvoie la vitesse sur le type de terrain indique
    */
  public double getVitesse(NatureTerrain naturePosition){
    return this.vitesse;
  }

  /**
    * @param reservoirEau nouvelle contenance du reservoir
    */
  public void setReservoirEau(int reservoirEau){
    this.reservoirEau = reservoirEau;
  }

  /**
    * @return Renvoie la contenance du reservoir d'eau
    */
  public int getReservoirEau(){
    return this.reservoirEau;
  }

  /**
    * @param nvCase Case sur laquelle le robot veut se rendre
    * @return Renvoie le plus court chemin a parcourir pour aller a nvCase
    */
  public ArrayList<Case> goTo(Case nvCase){
    int nbLignes = this.carte.getNbLignes();
    int nbColonnes = this.carte.getNbColonnes();
    double inf = Double.POSITIVE_INFINITY;
    int current = this.position.getLigne() * nbColonnes + this.position.getColonne();
    ArrayList<Dijkstra> tableauDijkstra = new ArrayList<Dijkstra>();
    for (int i=0; i <= nbLignes*nbColonnes; i++){
      if (i/nbColonnes < nbLignes && i%nbColonnes < nbColonnes) {

        Dijkstra dijkstraI = new Dijkstra(this.carte.getCase(i/nbColonnes, i%nbColonnes), inf, false, this.position);
        tableauDijkstra.add(dijkstraI);
      }
    }
    Dijkstra dijkstraZero = new Dijkstra(this.position, 0, true, this.position);
    tableauDijkstra.set(current, dijkstraZero);
    while (tableauDijkstra.get(current).getPosition().equals(nvCase) != true){
      for (Direction dir : Direction.values()){
        if (this.carte.voisinExiste(tableauDijkstra.get(current).getPosition(), dir)){
          Case caseSuivante = this.carte.getVoisin(tableauDijkstra.get(current).getPosition(), dir);
          if (this.peutSeDeplacer(caseSuivante)) {
            int next = caseSuivante.getLigne() * nbColonnes + caseSuivante.getColonne();
            double nouveauTemps = tableauDijkstra.get(current).getTemps() + this.carte.getTailleCases()/(2 * this.getVitesse(tableauDijkstra.get(current).getPosition().getNature())) +
              this.carte.getTailleCases()/(2 * this.getVitesse(caseSuivante.getNature()));
            if (nouveauTemps < tableauDijkstra.get(next).getTemps()) {
              Dijkstra dijkstraSuivant = new Dijkstra(caseSuivante, nouveauTemps, false, tableauDijkstra.get(current).getPosition());
              tableauDijkstra.set(next, dijkstraSuivant);
            }
          }
        }
      }
      Dijkstra dijkstraCurrent = new Dijkstra(tableauDijkstra.get(current).getPosition(), tableauDijkstra.get(current).getTemps(), true, tableauDijkstra.get(current).getPrecedent());
      tableauDijkstra.set(current, dijkstraCurrent);
      double min = Double.POSITIVE_INFINITY;
      for(Dijkstra n : tableauDijkstra){
        if (n.getDone() == false){
          if (n.getTemps() < min){
            min = n.getTemps();
            current = n.getPosition().getLigne() * nbColonnes + n.getPosition().getColonne();
          }
        }
      }
      if (min == Double.POSITIVE_INFINITY){
        ArrayList <Case> chemin = new ArrayList <Case>();
        return chemin;
      }
    }
    /** On retourne le chemin, sans la première case où on est **/
    ArrayList<Case> chemin = new ArrayList<Case>();
    while (tableauDijkstra.get(current).getPosition().equals(this.position) != true){
      chemin.add(tableauDijkstra.get(current).getPosition());
      current = tableauDijkstra.get(current).getPrecedent().getLigne() * nbColonnes + tableauDijkstra.get(current).getPrecedent().getColonne();
    }
    Collections.reverse(chemin);
    return chemin;
  }

  /**
    * @param nvCase case a tester
    * @return Booleen indiquant si le robot peut aller jusqu'a cette case
    */
  public boolean peutAller(Case nvCase){
    ArrayList<Case> chemin = new ArrayList<Case>();
    chemin = this.goTo(nvCase);
    if (chemin.size() == 0){
      if (this.getPosition().equals(nvCase)){
        return true;
      }
      return false;
    }
    return true;
  }

  /**
    * @param chemin Chemin dont on veut calculer le temps de parcours
    * @return Renvoie le temps de parcours
    */
  public long timeToDo(ArrayList<Case> chemin){
    double vitesse = this.getVitesse(this.getPosition().getNature());
    for(Case currentCase : chemin){
      vitesse += this.getVitesse(currentCase.getNature());
    }
    double dtime = (chemin.size()*this.getCarte().getTailleCases())/(vitesse/(chemin.size()+1));
    long ltime = (long) dtime;
    return ltime;
  }


  /**
    * @param vol Retire ce volume d'eau du reservoir d'eau
    */
  public void deverserEau(int vol){
    this.setReservoirEau(this.getReservoirEau() - vol);
  }

  /**
    * Remplit le reservoir entierement
    */
  public abstract void remplirReservoir();

  /**
    * @return Renvoie le type de Robot
    */
  public abstract  String getType();

  /**
    * @param nvCase Case sur laquelle on veut savoir si le robot peut aller
    * @return Indique si le robot peut aller sur cette case
    */
  public abstract boolean peutSeDeplacer(Case nvCase);

  /**
    * @return Renvoie les informations essentielles du robot
    */
  @Override
  public abstract String toString();
}
