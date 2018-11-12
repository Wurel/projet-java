package donnees;

/**
  * Classe  permettant de stocker les informations necessaires a l'algoritme de Dijkstra : case actuelle, temps pour y aller, appartenance au sous-graphe et case precedente pour y acceder
  */
public class Dijkstra{
  private Case position;
  private double temps;
  private boolean done;
  private Case precedent;

  /**
    * On initialise l'objet Dikstra avec uniquement la case concernee
    * @param position La case pour laquelle on stocke les informations
    */
  public Dijkstra(Case position){
    this.position = position;
  }

  /**
    * On initialise l'objet Dikstra avec la case concernee, le temps pour y aller et son appartenance au sous-graphe
    * @param position La case pour laquelle on stocke les informations
    * @param temps Le temps pour aller à cette case
    * @param done Le booleen pour savoir l'appartenance au sous-graphe de Dijkstra, c'est-a dire si le temps pour cette case ne changera plus
    */
  public Dijkstra(Case position, double temps, boolean done){
    this.position = position;
    this.temps = temps;
    this.done = done;
  }

  /**
    * On initialise l'objet Dikstra avec la case concernee, le temps pour y aller, son appartenance au sous-graphe et la case precedente pour y aller
    * @param position La case pour laquelle on stocke les informations
    * @param temps Le temps pour aller à cette case
    * @param done Le booleen pour savoir l'appartenance au sous-graphe de Dijkstra, c'est-a dire si le temps pour cette case ne changera plus, ni son precedent
    * @param precedent La case precedente dans le chemin le plus court
    */
  public Dijkstra(Case position, double temps, boolean done, Case precedent){
    this.position = position;
    this.temps = temps;
    this.done = done;
    this.precedent = precedent;
  }

  /**
    * @param temps est le nouveau temps pour acceder a cette case
    */
  public void setTemps(double temps){
    this.temps = temps;
  }

  /**
    * @param done : true si le sommet est intégré au sous-graphe de Dijkstra, false sinon (et alors son temps d'accès peut encore changer, ainsi que son precedent)
    */
  public void setDone(boolean done){
    this.done = done;
  }

  /**
    * @param precedent est la nouvelle case precedente dans le chemin optimal
    */
  public void setPrecedent(Case precedent){
    this.precedent = precedent;
  }

  /**
    * @return Renvoie la case actuelle de Dijkstra
    */
  public Case getPosition(){
    return this.position;
  }

  /**
    * @return Renvoie la case precedente dans le chemin optimal
    */
  public Case getPrecedent(){
    return this.precedent;
  }

  /**
    * @return Renvoie le temps pour atteindre la case
    */
  public double getTemps(){
    return this.temps;
  }

  /**
    * @return Renvoie le booleen d'appartenance ou non au sous-graphe de Dijkstra, c'est-a dire si le temps pour cette case ne changera plus  ni son precedent
    */
  public boolean getDone(){
    return this.done;
  }
}
