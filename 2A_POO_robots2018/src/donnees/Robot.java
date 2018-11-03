package donnees;
import java.util.*;
import simulation.Simulateur;

public abstract class Robot{
  private Carte carte;
  private Case position;
  private double vitesse;
  private int reservoirEau;
  private Simulateur simul;
  private long date;

  public Robot(Carte carte, int ligne, int colonne){
    this.carte = carte;
    this.position = carte.getCase(ligne, colonne);
  }

  public Carte getCarte(){
    return this.carte;
  }

  public long getDate(){
    return this.date;
  }

  public void setDate(long date){
    this.date = date;
  }

  public Case getPosition(){
    return this.position;
  }

  public void setPosition(Case nvCase){
    this.position = nvCase;
  }

  public Simulateur getSimulateur(){
    return this.simul;
  }

  public void setSimulateur(Simulateur simul){
    this.simul = simul;
  }

  public void setVitesse(double vitesse){
    this.vitesse = vitesse;
  }

  public double getVitesse(NatureTerrain naturePosition){
    return this.vitesse;
  }

  public void setReservoirEau(int reservoirEau){
    this.reservoirEau = reservoirEau;
  }

  public int getReservoirEau(){
    return this.reservoirEau;
  }

  public ArrayList goTo(Case nvCase){
    int nbLignes = this.carte.getNbLignes();
    int nbColonnes = this.carte.getNbColonnes();
    double inf = Double.POSITIVE_INFINITY;
    int current = this.position.getLigne() * nbColonnes + this.position.getColonne();
    ArrayList <Dijkstra> tableauDijkstra = new ArrayList <Dijkstra>();
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
    }
    /** On retourne le chemin, sans la première case où on est **/
    ArrayList <Case> chemin = new ArrayList <Case>();
    while (tableauDijkstra.get(current).getPosition().equals(this.position) != true){
      chemin.add(tableauDijkstra.get(current).getPosition());
      current = tableauDijkstra.get(current).getPrecedent().getLigne() * nbColonnes + tableauDijkstra.get(current).getPrecedent().getColonne();
    }
    Collections.reverse(chemin);
    return chemin;
  }


  public abstract void deverserEau(int vol);

  public abstract void remplirReservoir();

  public abstract  String getType();

  public abstract boolean peutSeDeplacer(Case nvCase);

  @Override
  public abstract String toString();
}
