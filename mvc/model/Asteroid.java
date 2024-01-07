package edu.uchicago.gerber._08final.mvc.model;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.awt.*;

import edu.uchicago.gerber._08final.mvc.controller.Game;


public class Asteroid extends Sprite {

	//radius of a large asteroid
	private final int LARGE_RADIUS = 50;

	private boolean inWindow;

	//size determines if the Asteroid is Large (0), Medium (1), or Small (2)
	//when you explode a Large asteroid, you should spawn 2 or 3 medium asteroids
	//same for medium asteroid, you should spawn small asteroids
	//small asteroids get blasted into debris, but do not spawn anything
	public Asteroid(int size, Point center){

		//Asteroid is FOE
		setTeam(Team.FOE);
		setCenter(center);


		//the spin will be either plus or minus 0-9
		//setSpin(5);
		//random delta-x
		/**
		setDeltaX(somePosNegValue(10));
		 setDeltaX(somePosNegValue(10));
		 **/
		//random delta-y
		setDeltaX(-10);
		setDeltaY(0);

		//a size of zero is a big asteroid
		//a size of 1 or 2 is med or small asteroid respectively. See getSize() method.
		if (size == 0)
			setRadius(LARGE_RADIUS);
		else
			setRadius(LARGE_RADIUS/(size * 2));


		//setCartesians(genRandomPoints());
		List<Point> pntCs = new ArrayList<>();
		// Robert Alef's awesome falcon design
		/**
		pntCs.add(new Point(0,9));
		pntCs.add(new Point(-1, 6));
		pntCs.add(new Point(-1,3));
		pntCs.add(new Point(-4, 1));
		pntCs.add(new Point(4,1));
		pntCs.add(new Point(-4,1));
		pntCs.add(new Point(-4, -2));
		pntCs.add(new Point(-1, -2));
		pntCs.add(new Point(-1, -9));
		pntCs.add(new Point(-1, -2));
		pntCs.add(new Point(-4, -2));
		pntCs.add(new Point(-10, -8));
		pntCs.add(new Point(-5, -9));
		pntCs.add(new Point(-7, -11));
		pntCs.add(new Point(-4, -11));
		pntCs.add(new Point(-2, -9));
		pntCs.add(new Point(-2, -10));
		pntCs.add(new Point(-1, -10));
		pntCs.add(new Point(-1, -9));
		pntCs.add(new Point(1, -9));
		pntCs.add(new Point(1, -10));
		pntCs.add(new Point(2, -10));
		pntCs.add(new Point(2, -9));
		pntCs.add(new Point(4, -11));
		pntCs.add(new Point(7, -11));
		pntCs.add(new Point(5, -9));
		pntCs.add(new Point(10, -8));
		pntCs.add(new Point(4, -2));
		pntCs.add(new Point(1, -2));
		pntCs.add(new Point(1, -9));
		pntCs.add(new Point(1, -2));
		pntCs.add(new Point(4,-2));
		pntCs.add(new Point(4, 1));
		pntCs.add(new Point(1, 3));
		pntCs.add(new Point(1,6));
		pntCs.add(new Point(0,9));
		 **/

		pntCs.add(new Point(1,4));
		pntCs.add(new Point(1, 7));
		pntCs.add(new Point(3,7));
		pntCs.add(new Point(3, 4));
		pntCs.add(new Point(5,4));
		pntCs.add(new Point(5,2));
		pntCs.add(new Point(7, 2));
		pntCs.add(new Point(7, 1));
		pntCs.add(new Point(9, 1));
		pntCs.add(new Point(9, -2));
		pntCs.add(new Point(10, -2));
		pntCs.add(new Point(10, -4));
		pntCs.add(new Point(8, -4));
		pntCs.add(new Point(8, -2));
		pntCs.add(new Point(7, -2));
		pntCs.add(new Point(7, -1));
		pntCs.add(new Point(5, -1));
		pntCs.add(new Point(5, -3));
		pntCs.add(new Point(3, -3));
		pntCs.add(new Point(3, -6));
		pntCs.add(new Point(4, -6));
		pntCs.add(new Point(4, -8));
		pntCs.add(new Point(1, -8));
		pntCs.add(new Point(1, -3));


		pntCs.add(new Point(-1, -3));
		pntCs.add(new Point(-1, -8));
		pntCs.add(new Point(-4, -8));
		pntCs.add(new Point(-4, -6));
		pntCs.add(new Point(-3, -6));
		pntCs.add(new Point(-3, -3));
		pntCs.add(new Point(-5, -3));
		pntCs.add(new Point(-5, -1));
		pntCs.add(new Point(-7, -1));
		pntCs.add(new Point(-7, -2));
		pntCs.add(new Point(-8, -2));
		pntCs.add(new Point(-8, -4));
		pntCs.add(new Point(-10, -4));
		pntCs.add(new Point(-10, -2));
		pntCs.add(new Point(-9, -2));
		pntCs.add(new Point(-9, 1));
		pntCs.add(new Point(-7, 1));
		pntCs.add(new Point(-7, 2));
		pntCs.add(new Point(-5,2));
		pntCs.add(new Point(-5,4));
		pntCs.add(new Point(-3, 4));
		pntCs.add(new Point(-3,7));
		pntCs.add(new Point(-1, 7));
		pntCs.add(new Point(-1,4));

		setCartesians(pntCs);
		setOrientation(270);

	}



	//overloaded so we can spawn smaller asteroids from an exploding one
	/**
	public Asteroid(Asteroid astExploded){
		//calls the other constructor: Asteroid(int size)
		this(astExploded.getSize() + 1);
		setCenter(astExploded.getCenter());
		int newSmallerSize = astExploded.getSize() + 1;
		//random delta-x : inertia + the smaller the asteroid, the faster its possible speed
		setDeltaX(astExploded.getDeltaX() / 1.5 + somePosNegValue( 5 + newSmallerSize * 2));
		//random delta-y : inertia + the smaller the asteroid, the faster its possible speed
		setDeltaY(astExploded.getDeltaY() / 1.5 + somePosNegValue( 5 + newSmallerSize * 2));

	}
	 **/

	public boolean isInWindow(){
		return inWindow;
	}

	public void setInWindow(){
		inWindow = true;
	}


	public int getSize(){
		switch (getRadius()) {
			case LARGE_RADIUS:
				return 0;
			case LARGE_RADIUS / 2:
				return 1;
			case LARGE_RADIUS / 4:
				return 2;
			default:
				return 0;
		}
	}


	@Override
	public void move(){
		if(getCenter().x<=Game.DIM.width){
			setInWindow();
		}
		if(isInWindow()){
			super.move();
		}
		else{
			Point center = getCenter();
			double newXPos = center.x + getDeltaX();
			double newYPos = center.y + getDeltaY();
			setCenter(new Point((int) newXPos, (int) newYPos));
		}
		//an asteroid spins, so you need to adjust the orientation at each move()
		setOrientation(getOrientation() + getSpin());
	}


	  private Point[] genRandomPoints(){
		  //6.283 is the max radians
		  final int MAX_RADIANS_X1000 =6283;

		  Supplier<PolarPoint> polarPointSupplier = () -> {
			  double r = (800 + Game.R.nextInt(200)) / 1000.0; //number between 0.8 and 0.999
			  double theta = Game.R.nextInt(MAX_RADIANS_X1000) / 1000.0; // number between 0 and 6.282
		  	  return new PolarPoint(r,theta);
		  };

		 //random number of vertices between 17 and 23
		 final int vertices = Game.R.nextInt( 7 ) + 17;

		 return polarToCartesian(
				Stream.generate(polarPointSupplier)
				 .limit(vertices)
				 .sorted(new Comparator<PolarPoint>() {
							@Override
							public int compare(PolarPoint pp1, PolarPoint pp2) {
								return  pp1.getTheta().compareTo(pp2.getTheta());
							}
						})
				 .collect(Collectors.toList())
			);

	  }

}
