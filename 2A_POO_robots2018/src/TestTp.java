import io.LecteurDonnees;
import donnees.Carte;
import donnees.Case;
import donnees.Incendie;
import donnees.Robot;
import donnees.Direction;
import donnees.NatureTerrain;
import donnees.DonneesSimulation;

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




public class TestTp{
  public static void main(String[] args) {
      // crée la fenêtre graphique dans laquelle dessiner
      // GUISimulator gui = new GUISimulator(800, 600, Color.BLACK);
      // crée l'invader, en l'associant à la fenêtre graphique précédente
      Jeu jeu = new Jeu(args[0]);
  }
}

class Jeu implements Simulable{

  /** L'interface graphique associée */
  private GUISimulator gui;
  private DonneesSimulation donnees;
  private int nombrePixels;

  public Jeu(String fichier){
    this.nombrePixels = 50;
  try {

    this.donnees = new DonneesSimulation();
    this.donnees = LecteurDonnees.creeDonnees(fichier);
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

  @Override
  public void next() {
      // if (this.xIterator.hasNext())
      //     this.x = this.xIterator.next();
      // if (this.yIterator.hasNext())
      //     this.y = this.yIterator.next();
      // draw();
  }


  @Override
  public void restart() {
      // planCoordinates();
      draw();
  }


  private void draw(){
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
      gui.addGraphicalElement(new Rectangle(60+incend.getCollone()*this.nombrePixels,
       40+incend.getLigne()*this.nombrePixels,
        Color.decode("#FE1B00"),
        Color.decode("#FE1B00"),
         this.nombrePixels/2));
      gui.addGraphicalElement(new Text(60+incend.getCollone()*this.nombrePixels,
       40+incend.getLigne()*this.nombrePixels, Color.decode("#A89874"),
       new Integer(incend.getEauNecessaire()).toString()));
       gui.addGraphicalElement(new Text( this.donnees.getCarte().getNbLignes()*this.nombrePixels+200,
       compteur*20 + 40,
        Color.decode("#FFFFFF"),
        incend.toString()));
      compteur ++;

    }



  }
}
