package creer_date;
import donnees.*;

/**
  * Classe abstraite modelisant la prochaine date pour un robot
  */
public abstract class CreerDate {
  private long date;
  private Robot robot;

  /**
    * Initialise la date a celle du robot
    * @param robot Robot concerne par la date
    */
  public CreerDate(Robot robot){
    this.robot = robot;
    this.date = this.robot.getDate();
  }

  /**
    * @param date est la nouvelle date
    */
  public void setDate(long date){
    this.date = date;
  }

  /**
    * @return Renvoie la date
    */
  public long getDate(){
    return this.date;
  }

  /**
    * @param robot est le robot concerne par la modelisation des dates
    */
  public void setRobot(Robot robot){
    this.robot = robot;
  }

  /**
    * @return Renvoie le robot concerne par la modelisation des dates
    */
  public Robot getRobot(){
    return this.robot;
  }

  /**
    * @return Renvoie la date de fin d'evenement
    */
  public abstract long retourneDate();

}
