package creer_date;
import donnees.*;

public class CreerDateDeplacement extends CreerDate {
  private Direction dir;

  public CreerDateDeplacement(Robot robot, long date,  Direction dir){
    super(robot, date);
    this.dir = dir;
  }

  public void setDirection(Direction dir){
    this.dir = dir;
  }

  public Direction getDirection(){
    return this.dir;
  }

  public long retourneDate(){
    return this.getDate() +
    this.getRobot().getCarte().getTailleCases() /
    (int)((this.getRobot().getVitesse(this.getRobot().getPosition().getNature())
    + this.getRobot().getVitesse(this.getRobot().getCarte().getVoisin(this.getRobot().getPosition(),
     this.dir).getNature()))/2);
  }

}
