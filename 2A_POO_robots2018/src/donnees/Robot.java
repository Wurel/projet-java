package donnees;
import simulation.*;

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

  public Simulateur getSimulateur(){
    return this.simul;
  }

  public void setSimulateur(Simulateur simul){
    this.simul = simul;
  }


  public Case getPosition(){
    return this.position;
  }

  public void setPosition(Case nvCase){
    this.position = nvCase;
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

  public abstract void deverserEau(int vol);

  public abstract void remplirReservoir();

  public abstract  String getType();

  public abstract boolean peutSeDeplacer(Case nvCase);

  @Override
  public abstract String toString();
}
