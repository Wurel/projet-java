package donnees;

public class Dijkstra{
  private Case position;
  private double temps;
  private boolean done;
  private Case precedent;

  public Dijkstra(Case position){
    this.position = position;
  }

  public Dijkstra(Case position, double temps, boolean done){
    this.position = position;
    this.temps = temps;
    this.done = done;
  }

  public Dijkstra(Case position, double temps, boolean done, Case precedent){
    this.position = position;
    this.temps = temps;
    this.done = done;
    this.precedent = precedent;
  }

  public void setTemps(double temps){
    this.temps = temps;
  }

  /**
  Done : true si le sommet est intégré au sous-graphe de Dijkstra
         false sinon (et alors son temps d'accès peut encore changer, ainsi que son precedent)
  **/
  public void setDone(boolean done){
    this.done = done;
  }

  public void setPrecedent(Case precedent){
    this.precedent = precedent;
  }

  public Case getPosition(){
    return this.position;
  }

  public Case getPrecedent(){
    return this.precedent;
  }

  public double getTemps(){
    return this.temps;
  }

  public boolean getDone(){
    return this.done;
  }
}
