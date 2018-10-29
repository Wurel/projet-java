package donnees;

public class RobotAChenilles extends Robot {

  public RobotAChenilles(int ligne, int colonne){
    super(ligne, colonne);
    this.setVitesse(60);
  }

  public RobotAChenilles(int ligne, int colonne, double vitesse){
    super(ligne, colonne);
    if (vitesse > 80){
      throw new IllegalArgumentException("La vitesse d'un robot à chenilles ne peut excéder 80 km/h.");
    }
    this.setVitesse(vitesse);
  }

  public String getType(){
    return "Chenilles";
  }

  public double getVitesse(NatureTerrain naturePosition){
    switch(naturePosition){
      case FORET :
        return super.getVitesse(naturePosition)/2;
        break;
      default :
        return super.getVitesse(naturePosition);
    }
  }

  public boolean peutSeDeplacer(Case nvCase){
    switch(nvCase.getNature()){
      case EAU :
      case ROCHE:
        return false;
        break;
      default :
        return true;
    }
  }

  public void setPosition(Case nvCase){
    boolean still = true;
    boolean notAdapt = true;
    for ( Direction dir : Direction.values()){
      if (this.getCarte().getVoisin(this.getPosition(), dir).equals(nvCase)){
        still = false;
        if (this.peutSeDeplacer(nvCase)){
          this.setPosition(nvCase);
          notAdapt = false;
        }
      }
    }
    if (still) {
      throw new IllegalArgumentException("Le robot n'est pas à côté de cette position.");
    } else if (notAdapt){
      throw new IllegalArgumentException("Le robot ne peut pas se rendre sur de l'eau ou du rocher.");
    }
  }

  public void remplirReservoir(){
    boolean empty = true;
    for(Direction dir : Direction.values()){
      switch(this.getCarte().getVoisin(this.getPosition(), dir).getNature()){
        case EAU:
        empty = false;
        this.setReservoirEau(2000);
        break;// 5 mins pour le remplissage complet
        // 2000 litres max
        // comment gère t'on le temps ?
      }
    }
    if(empty ) {
      throw new IllegalArgumentException("Le robot ne peut remplir son réservoir qu'à côté d'une case contenant de l'eau.");
    }
  }

  public void deverserEau(int vol){
    this.setReservoirEau(this.getReservoirEau() - vol); // 8 sec pour vider 100 litres
    // comment gère t'on le temps ?
  }

  @Override
  public String toString(){
    return "Robot : [" + this.getPosition().getLigne() + ", " + this.getPosition().getColonne() + "]" + " type :  Chenilles, vitesse : " + this.getVitesse(this.getPosition().getNature()) + " , reservoirEau : " + this.getReservoirEau() + "\n";
  }
}
