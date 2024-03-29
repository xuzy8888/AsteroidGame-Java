package edu.uchicago.gerber._08final.mvc.model;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bullet extends Sprite {



    public Bullet(Falcon fal) {



        setTeam(Team.FRIEND);

        //a bullet expires after 20 frames. set to one more than frame expiration
        setExpiry(20);
        setRadius(6);


        //everything is relative to the falcon ship that fired the bullet
        setCenter(fal.getCenter());

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(fal.getOrientation());

        final double FIRE_POWER = 35.0;
        setDeltaX(fal.getDeltaX() +
                Math.cos(Math.toRadians(fal.getOrientation())) * FIRE_POWER);
        setDeltaY(fal.getDeltaY() +
                Math.sin(Math.toRadians(fal.getOrientation())) * FIRE_POWER);


        //defined the points on a cartesian grid
        List<Point> pntCs = new ArrayList<>();
        pntCs.add(new Point(0, 3)); //top point
        pntCs.add(new Point(1, -1));
        pntCs.add(new Point(0, -2));
        pntCs.add(new Point(-1, -1));

        setCartesians(pntCs);



    }



}
