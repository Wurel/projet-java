package simulation;

/**
  * Classe abstraite representant un Evenement
  */
public abstract class Evenement{
  private long date;

  /**
    * @param date Date a laquelle se finit l'Evenement
    */
  public Evenement(long date){
    this.date = date;
  }

  /**
    * @return Renvoie la date a laquelle se termine l'Evenement
    */
  public long getDate(){
    return this.date;
  }

  /**
    * @param date Set la date de fin d'Evenement a cet date.
    */
  public void setDate(long date){
    this.date = date;
  }

  /**
    * Execute l'Evenement
    */
  public abstract void execute();

}
