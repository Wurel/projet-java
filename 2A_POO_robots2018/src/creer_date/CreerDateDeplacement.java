package creer_date;
import donnees.*;

/**
  * Classe modelisant la prochaine date du robot apres deplacement
  */
public class CreerDateDeplacement extends CreerDate {
  private Direction dir;

  /**
    * Initialise le robot et la direction du deplacement
    * @param robot Robot concerne par le deplacement
    * @param dir La direction du deplacement
    */
  public CreerDateDeplacement(Robot robot,  Direction dir){
    super(robot);
    this.dir = dir;
  }

  /**
    * @param dir est la direction du deplacement
    */
  public void setDirection(Direction dir){
    this.dir = dir;
  }

  /**
    * @return Renvoie la direction
    */
  public Direction getDirection(){
    return this.dir;
  }

  /**
    * @return Renvoie la date de fin de deplacement
    */
  public long retourneDate(){
    return this.getDate() +
    this.getRobot().getCarte().getTailleCases() /
    (int)((this.getRobot().getVitesse(this.getRobot().getPosition().getNature())
    + this.getRobot().getVitesse(this.getRobot().getCarte().getVoisin(this.getRobot().getPosition(),
     this.dir).getNature()))/2);
  }

}
