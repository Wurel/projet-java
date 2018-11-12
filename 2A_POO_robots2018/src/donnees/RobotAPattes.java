package donnees;
/**
  * Classe representant les robots a pattes.
  */

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

  public void remplirReservoir(){
    // utilise de la poudre
    // ne se remplit jamais
  }

  @Override
  public String toString(){
    return "Robot : [" + this.getPosition().getLigne() + ", " + this.getPosition().getColonne() + "]" + " type :  Pattes, reservoirEau : infini, date : " + this.getDate() + "\n";
  }
}
