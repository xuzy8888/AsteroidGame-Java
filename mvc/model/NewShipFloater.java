package edu.uchicago.gerber._08final.mvc.model;

import edu.uchicago.gerber._08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewShipFloater extends Sprite {


	public NewShipFloater() {

		setTeam(Team.FLOATER);

		setExpiry(401);
		setRadius(50);
		setColor(Color.BLUE);

		setCenter(new Point(Game.R.nextInt(Game.DIM.width),0));
		//setCenter(new Point(500,500));


		//set random DeltaX
		setDeltaX(somePosNegValue(10));
		setDeltaY(Math.max(Game.R.nextInt(15),5));
		//setDeltaX(0);
		//setDeltaY(-20);

		//set rnadom DeltaY
		//setDeltaY(somePosNegValue(10));
		
		//set random spin
		setSpin(somePosNegValue(10));

		//cartesian points which define the shape of the polygon
		List<Point> pntCs = new ArrayList<>();
		pntCs.add(new Point(5, 5));
		pntCs.add(new Point(4,0));
		pntCs.add(new Point(5, -5));
		pntCs.add(new Point(0,-4));
		pntCs.add(new Point(-5, -5));
		pntCs.add(new Point(-4,0));
		pntCs.add(new Point(-5, 5));
		pntCs.add(new Point(0,4));

		setCartesians(pntCs);
	}

	@Override
	public void move() {
		super.move();
		//a newShipFloater spins
		setOrientation(getOrientation() + getSpin());

	}


}
