package creer_date;
import donnees.*;

public abstract class CreerDate {
  private long date;
  private Robot robot;

  public CreerDate(Robot robot){
    this.robot = robot;
    this.date = this.robot.getDate();
  }

  public void setDate(long date){
    this.date = date;
  }

  public long getDate(){
    return this.date;
  }

  public void setRobot(Robot robot){
    this.robot = robot;
  }

  public Robot getRobot(){
    return this.robot;
  }

  public abstract long retourneDate();

}
