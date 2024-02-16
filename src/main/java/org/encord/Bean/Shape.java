package org.encord.Bean;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Shape {

    private String blockShape;
    private ArrayList<Integer> columnCoordinates;
    private int shapeHeight ;

    public int getShapeHeight() {
        return shapeHeight;
    }

    public void setShapeHeight(int shapeHeight) {
        this.shapeHeight = shapeHeight;
    }

    public String getBlockShape() {
        return blockShape;
    }

    public void setBlockShape(String blockShape) {
        this.blockShape = blockShape;
    }

    public ArrayList<Integer> getColumnCoordinates() {
        return columnCoordinates;
    }

    public void setColumnCoordinates(ArrayList<Integer> columnCoordinates) {
        this.columnCoordinates = columnCoordinates;
    }

}
