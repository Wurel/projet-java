package donnees;

public class RobotAPattes extends Robot {

  public RobotAPattes(Carte carte, int ligne, int colonne){
    super(carte, ligne, colonne);
    this.setVitesse(30);
  }

  @Override
  public String getType(){
    return "Pattes";
  }

  public double getVitesse(NatureTerrain naturePosition){
    switch (naturePosition){
      case ROCHE :
        return super.getVitesse(naturePosition)/3;
      default :
        return super.getVitesse(naturePosition);
    }
  }

  @Override
  public boolean peutSeDeplacer(Case nvCase){
    switch(nvCase.getNature()){
      case EAU :
        return false;
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
          super.setPosition(nvCase);
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
    // utilise de la poudre
    // ne se remplit jamais
  }

  public void deverserEau(int vol){
    this.setReservoirEau(this.getReservoirEau() - vol); // 1 sec pour vider 10 litres
    // comment gère t'on le temps ?
  }

  @Override
  public String toString(){
    return "Robot : [" + this.getPosition().getLigne() + ", " + this.getPosition().getColonne() + "]" + " type :  Pattes, vitesse : " + this.getVitesse(this.getPosition().getNature()) + " , reservoirEau : " + this.getReservoirEau() + "\n";
  }
}
