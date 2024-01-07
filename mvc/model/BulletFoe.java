package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BulletFoe extends Sprite {



    public BulletFoe(Asteroid ast) {



        setTeam(Team.FOE);

        //a bullet expires after 20 frames. set to one more than frame expiration
        setExpiry(25);
        setRadius(18);


        //everything is relative to the falcon ship that fired the bullet
        setCenter(ast.getCenter());

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(90);

        final double FIRE_POWER = 25.0;

        setDeltaX(ast.getDeltaX() +
                Math.cos(Math.toRadians(90)) * FIRE_POWER);
        setDeltaY(ast.getDeltaY() +
                Math.sin(Math.toRadians(90)) * FIRE_POWER);




        //defined the points on a cartesian grid
        List<Point> pntCs = new ArrayList<>();
        pntCs.add(new Point(0, 6)); //top point
        pntCs.add(new Point(3, 0));
        pntCs.add(new Point(0, -9));
        pntCs.add(new Point(-3, 0));

        setCartesians(pntCs);



    }



}
