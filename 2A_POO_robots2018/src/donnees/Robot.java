package donnees;

public abstract class Robot{
  private Carte carte;
  private Case position;
  private double vitesse;
  private int reservoirEau;

  public Robot(int ligne, int colonne){
    this.carte = donnees.getCarte();
    this.position = donnees.getCarte().getCase(ligne, colonne);
  }

  public Carte getCarte(){
    return this.carte;
  }

  public Case getPosition(){
    return this.position;
  }

  public abstract void setPosition(Case nvCase);

  public double setVitesse(double vitesse){
    this.vitesse = vitesse;
  }

  public double getVitesse(NatureTerrain naturePosition){
    return this.vitesse;
  }

  public int setReservoirEau(int reservoirEau){
    this.reservoirEau = reservoirEau;
  }

  public int getReservoirEau(){
    return this.reservoirEau;
  }

  public abstract void deverserEau(int vol);

  public abstract void remplirReservoir();

  @Override
  public abstract String toString();
}
