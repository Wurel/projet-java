package creer_date;
import donnees.*;

public abstract class CreerDate {
  private long date;
  private Robot robot;

  public CreerDate(Robot robot, long date){
    this.robot = robot;
    this.date = date;
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
