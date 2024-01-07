package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BulletFoeFast extends Sprite {



    public BulletFoeFast(BossFoe ast, int num) {



        setTeam(Team.FOE);

        //a bullet expires after 20 frames. set to one more than frame expiration
        setExpiry(20);
        setRadius(18);
        setColor(Color.RED);


        //everything is relative to the falcon ship that fired the bullet
        if(num==1) {
            setCenter(ast.getCenter());
        }
        else if(num==2){
            setCenter(new Point(ast.getCenter().x-20,ast.getCenter().y));
        }
        else if(num==3){
            setCenter(new Point(ast.getCenter().x+20,ast.getCenter().y));
        }

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(90);

        final double FIRE_POWER = 35.0;

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
