package org.encord.Handler;

import org.encord.Bean.Shape;
import org.encord.Interface.ShapeAndOrientation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class ShapeHandler implements ShapeAndOrientation {

    private final static Logger log = Logger.getLogger(ShapeHandler.class.getName());

    @Override
    public void shapeAndSize(Character shape,int index,Shape figure) {

        switch(shape){
            case 'T':
                figure.setColumnCoordinates(new ArrayList<>(Arrays.asList(index,index+1,index+1,index+2)));
                figure.setBlockShape("T");
                figure.setShapeHeight(2);
                break;
            case 'Q':
                figure.setColumnCoordinates(new ArrayList<>(Arrays.asList(index,index,index+1,index+1)));
                figure.setBlockShape("Q");
                figure.setShapeHeight(2);
                break;
            case 'Z':
                figure.setColumnCoordinates(new ArrayList<>(Arrays.asList(index,index+1,index+1,index+2)));
                figure.setBlockShape("Z");
                figure.setShapeHeight(2);
                break;
            case 'S':
                figure.setColumnCoordinates(new ArrayList<>(Arrays.asList(index,index+1,index+1,index+2)));
                figure.setBlockShape("S");
                figure.setShapeHeight(2);
                break;
            case 'I':
                figure.setColumnCoordinates(new ArrayList<>(Arrays.asList(index,index+1,index+2,index+3)));
                figure.setBlockShape("I");
                figure.setShapeHeight(1);
                break;
            case 'L':
                figure.setColumnCoordinates(new ArrayList<>(Arrays.asList(index,index,index,index+1)));
                figure.setBlockShape("L");
                figure.setShapeHeight(3);
                break;
            case 'J':
                figure.setColumnCoordinates(new ArrayList<>(Arrays.asList(index,index+1,index+1,index+1)));
                figure.setBlockShape("J");
                figure.setShapeHeight(3);
                break;


        }

    }

    @Override
    public int gameGridSize() {
        return 10;    //TODO: We can change the floorSize here in future...
    }

    @Override
    public void increasePace() {

    }

    @Override
    public void Orientation(int angle) {

    }

}
