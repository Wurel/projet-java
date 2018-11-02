package creer_date;
import donnees.*;

public class CreerDateDeplacement {
  long date;
  Robot robot;
  Direction dir;

  public CreerDateDeplacement(Robot robot, long date,  Direction dir){
    this.robot = robot;
    this.date = date;
    this.dir = dir;

  }

  public long retourneDate(){
    return this.date +
    this.robot.getCarte().getTailleCases() /
    (int)this.robot.getVitesse(this.robot.getPosition().getNature());
  }

}
