package donnees;

public abstract class Robot{
  private Case position;
  private int ligne;
  private int colonne;
  private double vitesse;

  public Robot(int ligne, int colonne){
    this.ligne = ligne;
    this.colonne = colonne;
  }

  public Case getPosition(){
    return this.position;
  }

  public void setPosition(Case nv_case){
    this.position = nv_case;
  }

  public double getVitesse(){
    return this.vitesse;
  }

  public abstract void deverserEau(Case position);

  public abstract void remplirReservoir(Case position);
}
