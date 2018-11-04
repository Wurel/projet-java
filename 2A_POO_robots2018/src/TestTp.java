import io.LecteurDonnees;
import donnees.*;
import simulation.*;
import creer_date.*;
// import simulation.Simulateur;

import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;
import java.awt.image.ImageObserver;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.ImageElement;
import gui.Simulable;
import gui.Text;



import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gui.GUISimulator;
import gui.Rectangle;
import gui.ImageElement;

public class TestTp{
  public static void main(String[] args) {
      // crée la fenêtre graphique dans laquelle dessiner
      // GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
      // crée l'invader, en l'associant à la fenêtre graphique précédente
      Jeu jeu = new Jeu(args[0]);
      Simulateur simul = new Simulateur();
      jeu.setSimulateur(simul);

      ChefPompierElementaire totoLepompeur = new ChefPompierElementaire(simul, jeu.getDonnees());
      totoLepompeur.ordres();




      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[0])).retourneDate()
      //   , Direction.values()[0], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[3])).retourneDate()
      //   , Direction.values()[3], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[3])).retourneDate()
      //   , Direction.values()[3], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementRemplir(new CreerDateRemplir(jeu.getDonnees().getRobots()[1]).retourneDate(), jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[2])).retourneDate()
      //   , Direction.values()[2], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[2])).retourneDate()
      //   , Direction.values()[2], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // // simul.ajouteEvenement(new EvenementIntervention((new CreerDateIntervention(jeu.getDonnees().getRobots()[1])).retourneDate(), jeu.getDonnees().getIncendies(), jeu.getDonnees().getRobots()[1], simul));
      //
      // // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(this.getDonnees().getRobots()[1],  Direction.values()[3])).retourneDate()
      // //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1],  Direction.values()[3]).retourneDate()
      // //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      //
      //
      // for(int i = 0; i < 50; i++){
      //   simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(jeu.getDonnees().getRobots()[1]
      //   ).retourneDate(), jeu.getDonnees().getIncendies(), jeu.getDonnees().getRobots()[1]));
      // }
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[3])).retourneDate()
      //   , Direction.values()[3], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[3])).retourneDate()
      //   , Direction.values()[3], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementRemplir(new CreerDateRemplir(jeu.getDonnees().getRobots()[1]).retourneDate(), jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[2])).retourneDate()
      //   , Direction.values()[2], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[2])).retourneDate()
      //   , Direction.values()[2], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
      //   for(int i = 0; i < 30; i++){
      //     simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(jeu.getDonnees().getRobots()[1]
      //     ).retourneDate(), jeu.getDonnees().getIncendies(), jeu.getDonnees().getRobots()[1]));
      //   }
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(jeu.getDonnees().getRobots()[1], Direction.values()[1])).retourneDate()
      //   , Direction.values()[1], jeu.getDonnees().getCarte(), jeu.getDonnees().getRobots()[1]));
        //
      // simul.ajouteEvenement(new EvenementIntervention(new CreerDateIntervention(this.getDonnees().getRobots()[1]
      // ).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1], simul));


      //simul.ajouteEvenement(new EvenementIntervention(new CreerDateIntervention(this.getDonnees().getRobots()[1], simul.getEvenements().get(5).getDate()).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1], simul));


      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1],  Direction.values()[1]).retourneDate()
      //   , Direction.values()[1], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1],  Direction.values()[0]).retourneDate()
      // , Direction.values()[0], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(57).getDate(),  Direction.values()[3]).retourneDate()
      //   , Direction.values()[3], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(58).getDate(),  Direction.values()[3]).retourneDate()
      //   , Direction.values()[3], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementRemplir(new CreerDateRemplir(this.getDonnees().getRobots()[1], simul.getEvenements().get(59).getDate()).retourneDate(), this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(60).getDate(),  Direction.values()[2]).retourneDate()
      //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(61).getDate(),  Direction.values()[2]).retourneDate()
      //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // // simul.ajouteEvenement(new EvenementIntervention(new CreerDateIntervention(this.getDonnees().getRobots()[1], simul.getEvenements().get(5).getDate())).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1]));
      // for(int i = 0; i < 30; i++){
      //   simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(this.getDonnees().getRobots()[1]
      //   , simul.getEvenements().get(62+i).getDate()).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1]));
      // }
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(92).getDate(),  Direction.values()[1]).retourneDate()
      //   , Direction.values()[1], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));

      jeu.setChefPompierElementaire(totoLepompeur);
      jeu.setSimulateur(simul);
      for ( Robot robot : jeu.getDonnees().getRobots()){
        robot.setSimulateur(simul);
      }

  }
}

class Jeu implements Simulable{

  /** L'interface graphique associée */
  private GUISimulator gui;
  private DonneesSimulation donnees;
  private String fichier;
  private int nombrePixels;
  private Simulateur simul;
  private ChefPompierElementaire totoLepompeur;

  public Jeu(String fichier){
    this.nombrePixels = 50;
  try {

    this.donnees = new DonneesSimulation();
    this.donnees = LecteurDonnees.creeDonnees(fichier);
    this.fichier = fichier;
    this.gui = new GUISimulator( this.donnees.getCarte().getNbLignes()*this.nombrePixels+60 + 800,
    this.donnees.getCarte().getNbColonnes()*this.nombrePixels+40, Color.BLACK);
    gui.setSimulable(this);				// association a la gui!



    draw();


  } catch (FileNotFoundException e) {
      System.out.println("fichier " + fichier + " inconnu ou illisible");
  } catch (DataFormatException e) {
      System.out.println("\n\t**format du fichier " + fichier + " invalide: " + e.getMessage());
  }


  }

  public DonneesSimulation getDonnees(){
    return this.donnees;
  }

  public void setSimulateur(Simulateur simul){
    this.simul = simul;
  }

  public Simulateur getSimulateur(){
    return this.simul;
  }

  public void setChefPompierElementaire(ChefPompierElementaire totoLepompeur){
    this.totoLepompeur = totoLepompeur;
  }

  @Override
  public void next() {
    if (this.simul.getDate()%200 == 0) {
      this.totoLepompeur.ordres();
    }
      if (!this.simul.simulationTerminee()){
        for (Evenement event : this.simul.getEvenements()) {
          if (event.getDate() == this.simul.getDate()) {
            event.execute();
            draw();
          }
        }
        this.simul.incrementeDate();
        System.out.println(this.simul.getDate());
      }
      else{
        this.simul.incrementeDate();

      }
  }


  @Override
  public void restart() {
    try {
      this.donnees = new DonneesSimulation();
      this.donnees = LecteurDonnees.creeDonnees(this.fichier);
      Simulateur simul = new Simulateur();
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(this.getDonnees().getRobots()[1], 0,  Direction.values()[0])).retourneDate()
      //   , Direction.values()[0], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(this.getDonnees().getRobots()[1], this.getDonnees().getRobots()[1].getDate(),  Direction.values()[3])).retourneDate()
      //   , Direction.values()[3], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], this.getDonnees().getRobots()[1].getDate(),  Direction.values()[3]).retourneDate()
      //   , Direction.values()[3], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementRemplir(new CreerDateRemplir(this.getDonnees().getRobots()[1]).retourneDate(), this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement((new CreerDateDeplacement(this.getDonnees().getRobots()[1], this.getDonnees().getRobots()[1].getDate(),  Direction.values()[3])).retourneDate()
      //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], this.getDonnees().getRobots()[1].getDate(),  Direction.values()[3]).retourneDate()
      //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // // for(int i = 0; i < 50; i++){
      // //   simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(this.getDonnees().getRobots()[1]
      // //   , this.getDonnees().getRobots()[1].getDate()).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1]));
      // // }
      // simul.ajouteEvenement(new EvenementIntervention(new CreerDateIntervention(this.getDonnees().getRobots()[1]
      // , this.getDonnees().getRobots()[1].getDate()).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1], simul));
      //
      //
      // //simul.ajouteEvenement(new EvenementIntervention(new CreerDateIntervention(this.getDonnees().getRobots()[1], simul.getEvenements().get(5).getDate()).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1], simul));
      //
      //
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(55).getDate(),  Direction.values()[1]).retourneDate()
      //   , Direction.values()[1], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(56).getDate(),  Direction.values()[0]).retourneDate()
      // , Direction.values()[0], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(57).getDate(),  Direction.values()[3]).retourneDate()
      //   , Direction.values()[3], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(58).getDate(),  Direction.values()[3]).retourneDate()
      //   , Direction.values()[3], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementRemplir(new CreerDateRemplir(this.getDonnees().getRobots()[1], simul.getEvenements().get(59).getDate()).retourneDate(), this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(60).getDate(),  Direction.values()[2]).retourneDate()
      //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(61).getDate(),  Direction.values()[2]).retourneDate()
      //   , Direction.values()[2], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));
      // // simul.ajouteEvenement(new EvenementIntervention(new CreerDateIntervention(this.getDonnees().getRobots()[1], simul.getEvenements().get(5).getDate())).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1]));
      // for(int i = 0; i < 30; i++){
      //   simul.ajouteEvenement(new EvenementInterventionUnitaire(new CreerDateIntervention(this.getDonnees().getRobots()[1]
      //   , simul.getEvenements().get(62+i).getDate()).retourneDate(), this.getDonnees().getIncendies(), this.getDonnees().getRobots()[1]));
      // }
      // simul.ajouteEvenement(new EvenementDeplacement(new CreerDateDeplacement(this.getDonnees().getRobots()[1], simul.getEvenements().get(92).getDate(),  Direction.values()[1]).retourneDate()
      //   , Direction.values()[1], this.getDonnees().getCarte(), this.getDonnees().getRobots()[1]));






      // simul.ajouteEvenement(new EvenementDeplacement(1, Direction.values()[0], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementIntervention(2, this.donnees.getIncendies(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(3, Direction.values()[3], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(4, Direction.values()[3], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementRemplir(5, this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(6, Direction.values()[2], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(7, Direction.values()[2], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementIntervention(8, this.donnees.getIncendies(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(9, Direction.values()[1], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      //
      // simul.ajouteEvenement(new EvenementDeplacement(10, Direction.values()[0], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(11, Direction.values()[3], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(12, Direction.values()[3], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementRemplir(13, this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(14, Direction.values()[2], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(15, Direction.values()[2], this.donnees.getCarte(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementIntervention(16, this.donnees.getIncendies(), this.donnees.getRobots()[1]));
      // simul.ajouteEvenement(new EvenementDeplacement(17, Direction.values()[1], this.donnees.getCarte(), this.donnees.getRobots()[1]));

      this.simul = simul;
      for ( Robot robot : this.donnees.getRobots()){
        robot.setSimulateur(this.simul);
      }
    } catch (FileNotFoundException e) {
        System.out.println("fichier " + fichier + " inconnu ou illisible");
    } catch (DataFormatException e) {
        System.out.println("\n\t**format du fichier " + fichier + " invalide: " + e.getMessage());
    }
    draw();
  }


  void draw(){
    gui.reset();	// clear the window

    for (int i = 0; i < this.donnees.getCarte().getNbLignes(); i++) {
      for (int j = 0; j < this.donnees.getCarte().getNbColonnes(); j++) {
        gui.addGraphicalElement(new Rectangle(60+j*this.nombrePixels, 40+i*this.nombrePixels,
          Color.decode(this.donnees.getCarte().getCase(i,j).getCouleur()),
          Color.decode(this.donnees.getCarte().getCase(i,j).getCouleur()),
           this.nombrePixels));
        // System.out.println(this.donnees.getCarte().getCase(i,j).getCouleur);

        // switch (this.donnees.getCarte().getCase(i,j).getNature()) {
        //   case EAU:
        //     gui.addGraphicalElement(new ImageElement(j*this.nombrePixels, i*this.nombrePixels, "image.Eau.png", -1, -1, obs));
        //   case FORET:
        //     gui.addGraphicalElement(new ImageElement(j*this.nombrePixels, i*this.nombrePixels, "image.Foret.png", "eog") );
        //   case ROCHE:
        //     gui.addGraphicalElement(new ImageElement(j*this.nombrePixels, i*this.nombrePixels, "image.Roche.png", "eog"));
        //   case TERRAIN_LIBRE:
        //     gui.addGraphicalElement(new ImageElement(j*this.nombrePixels, i*this.nombrePixels, "image.Terrain_libre.png", "eog"));
        //   case HABITAT:
        //     gui.addGraphicalElement(new ImageElement(j*this.nombrePixels, i*this.nombrePixels, "image.Maison.png", "eog"));
        // }

      }

    }

    int compteur = 0;
    for (Incendie incend : this.donnees.getIncendies() ) {
      if (incend.getEauNecessaire() != 0){
        gui.addGraphicalElement(new Rectangle(60+incend.getColonne()*this.nombrePixels,
         40+incend.getLigne()*this.nombrePixels,
          Color.decode("#FE1B00"),
          Color.decode("#FE1B00"),
           this.nombrePixels/2));
        gui.addGraphicalElement(new Text(60+incend.getColonne()*this.nombrePixels,
         40+incend.getLigne()*this.nombrePixels, Color.decode("#A89874"),
         new Integer(incend.getEauNecessaire()).toString()));
         gui.addGraphicalElement(new Text( this.donnees.getCarte().getNbLignes()*this.nombrePixels+200,
         compteur*20 + 40,
          Color.decode("#FFFFFF"),
          incend.toString()));
        compteur ++;
      }

    }

    int compteur_robot = compteur;
    for (Robot robot : this.donnees.getRobots() ) {
      gui.addGraphicalElement(new Rectangle(60+robot.getPosition().getColonne()*this.nombrePixels,
       40+robot.getPosition().getLigne()*this.nombrePixels,
        Color.decode("#A22C29"),
        Color.decode("#A22C29"),
         this.nombrePixels/2));
      gui.addGraphicalElement(new Text(60+robot.getPosition().getColonne()*this.nombrePixels,
       40+robot.getPosition().getLigne()*this.nombrePixels, Color.decode("#A89874"),
       robot.getType()));
     gui.addGraphicalElement(new Text(60+robot.getPosition().getColonne()*this.nombrePixels,
      60+robot.getPosition().getLigne()*this.nombrePixels, Color.decode("#A89874"),
      new Integer(robot.getReservoirEau()).toString()));
      gui.addGraphicalElement(new Text( this.donnees.getCarte().getNbLignes()*this.nombrePixels+240,
       compteur_robot*20 + 40,
        Color.decode("#FFFFFF"),
        robot.toString()));
      compteur_robot ++;

    }



  }
}
