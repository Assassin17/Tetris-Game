package org.encord.Service;

import org.encord.Bean.Shape;
import org.encord.Handler.ShapeHandler;

import java.util.*;
import java.util.logging.Logger;

public class GameLogic {

    private final static Logger log = Logger.getLogger(GameLogic.class.getName());

    private ShapeHandler shapeHandler = new ShapeHandler();

    private Shape figure;

    private void checkEmptySpaces(List<List<Integer>> positionMatrix,Character letter,int index,ArrayList<Integer> columnsMaxHeight){



            /** Column check for falling pieces to avoid collision. */
            figure = new Shape();
            shapeHandler.shapeAndSize(letter, index, figure);

            //TODO: generate the row or predict the height coordinates and update the heightMap..
            ArrayList<Integer> columnCoordinates = figure.getColumnCoordinates();
            //log.info(columnCoordinates.toString());
            ArrayList<Integer> rowCoordinates = getPredictedHeight(positionMatrix,columnsMaxHeight, index, letter, figure);
            //log.info(rowCoordinates.toString());
            //log.info(columnsMaxHeight.toString());

            //TODO: Update positionMatrix....
            updatePositionMatrix(positionMatrix,columnCoordinates,rowCoordinates);
            //log.info(positionMatrix.toString());

    }

    private ArrayList<Integer> getPredictedHeight(List<List<Integer>> positionMatrix,ArrayList<Integer> columnsMaxHeight,int index,Character letter,Shape figure){
        int shapeHeight = figure.getShapeHeight();
        if(letter.equals('T')){
            int maxCurrentHeight = Math.max(columnsMaxHeight.get(index),Math.max(columnsMaxHeight.get(index+1),columnsMaxHeight.get(index+2)));
            int element = (maxCurrentHeight) == 0 ? shapeHeight - 1 : maxCurrentHeight + shapeHeight;
            columnsMaxHeight.set(index, element);
            columnsMaxHeight.set(index+1, element);
            columnsMaxHeight.set(index+2, element);
            /**updating the MaxHeight map for T shape. */
            if(maxCurrentHeight>0){
                if(positionMatrix.get(maxCurrentHeight).get(index+1)==0){
                    element-=1;
                    columnsMaxHeight.set(index, element);
                    columnsMaxHeight.set(index+1, element);
                    columnsMaxHeight.set(index+2, element);
                }
                return new ArrayList<>(Arrays.asList(element,element,maxCurrentHeight,element));
            }
            if(maxCurrentHeight==0){
                return new ArrayList<>(Arrays.asList(element,element,maxCurrentHeight,element));
            }
            else{
                return new ArrayList<>(Arrays.asList(element,element,maxCurrentHeight+1,element));
            }
        }
        else if(letter.equals('Q')){
            int maxCurrentHeight = Math.max(columnsMaxHeight.get(index),columnsMaxHeight.get(index+1));
            int element = (maxCurrentHeight) == 0 ? shapeHeight - 1 : maxCurrentHeight + shapeHeight;
            columnsMaxHeight.set(index,element);
            columnsMaxHeight.set(index+1,element);
            if(element==1 && (positionMatrix.get(element-1).get(index)==1 || positionMatrix.get(element-1).get(index+1)==1)){
                element+=1;
                columnsMaxHeight.set(index,element);
                columnsMaxHeight.set(index+1,element);
                return new ArrayList<>(Arrays.asList(element,maxCurrentHeight+1,element,maxCurrentHeight+1));
            }
            if(maxCurrentHeight==0){
                return new ArrayList<>(Arrays.asList(element,maxCurrentHeight,element,maxCurrentHeight));
            }
            else{
                return new ArrayList<>(Arrays.asList(element,maxCurrentHeight+1,element,maxCurrentHeight+1));
            }
        }
        else if(letter.equals('Z')){
            int maxCurrentHeight = Math.max(columnsMaxHeight.get(index),Math.max(columnsMaxHeight.get(index+1),columnsMaxHeight.get(index+2)));
            int element = (maxCurrentHeight) == 0 ? shapeHeight - 1 : maxCurrentHeight + shapeHeight;
            columnsMaxHeight.set(index, element);
            columnsMaxHeight.set(index+1, element);
            columnsMaxHeight.set(index+2, element-1);
            if(maxCurrentHeight>0){
                if(positionMatrix.get(maxCurrentHeight).get(index+1)==0 && positionMatrix.get(maxCurrentHeight).get(index+2)==0){
                    element-=1;
                    columnsMaxHeight.set(index, element);
                    columnsMaxHeight.set(index+1, element);
                    columnsMaxHeight.set(index+2, element-1);
                }
                return new ArrayList<>(Arrays.asList(element,element,maxCurrentHeight,maxCurrentHeight));
            }
            if(maxCurrentHeight==0){
                return new ArrayList<>(Arrays.asList(element,element,maxCurrentHeight,maxCurrentHeight));
            }
            else{
                return new ArrayList<>(Arrays.asList(element,element,maxCurrentHeight+1,maxCurrentHeight+1));
            }
        }
        else if(letter.equals('S')) {
            int maxCurrentHeight = Math.max(columnsMaxHeight.get(index),Math.max(columnsMaxHeight.get(index+1),columnsMaxHeight.get(index+2)));
            int element = (maxCurrentHeight) == 0 ? shapeHeight - 1 : maxCurrentHeight + shapeHeight;
            columnsMaxHeight.set(index, element-1);
            columnsMaxHeight.set(index+1, element);
            columnsMaxHeight.set(index+2, element);
            if(maxCurrentHeight>0){
                if(positionMatrix.get(maxCurrentHeight).get(index+1)==0 && positionMatrix.get(maxCurrentHeight).get(index)==0){
                    element-=1;
                    columnsMaxHeight.set(index, element-1);
                    columnsMaxHeight.set(index+1, element);
                    columnsMaxHeight.set(index+2, element);
                }
                return new ArrayList<>(Arrays.asList(maxCurrentHeight, maxCurrentHeight, element, element));
            }
            if (maxCurrentHeight == 0) {
                return new ArrayList<>(Arrays.asList(maxCurrentHeight, maxCurrentHeight, element, element));
            } else {
                return new ArrayList<>(Arrays.asList(maxCurrentHeight + 1, maxCurrentHeight + 1, element, element));
            }
        }
        else if(letter.equals('I')){
            int maxCurrentHeight = Math.max(Math.max(columnsMaxHeight.get(index),columnsMaxHeight.get(index+3)),Math.max(columnsMaxHeight.get(index+1),columnsMaxHeight.get(index+2)));
            int element = (maxCurrentHeight) == 0 ? shapeHeight - 1 : maxCurrentHeight + shapeHeight;
            columnsMaxHeight.set(index, element);
            columnsMaxHeight.set(index+1, element);
            columnsMaxHeight.set(index+2, element);
            columnsMaxHeight.set(index+3,element);
            /** special case for handling 'I' for 0 height index and 1 height length. */
            if(element==0 && positionMatrix.get(element).get(index)==1){
                element+=1;
                columnsMaxHeight.set(index, element);
                columnsMaxHeight.set(index+1, element);
                columnsMaxHeight.set(index+2, element);
                columnsMaxHeight.set(index+3,element);
            }
            return new ArrayList<>(Arrays.asList(element,element,element,element));

        }
        else if(letter.equals('L')){
            int maxCurrentHeight = Math.max(columnsMaxHeight.get(index),columnsMaxHeight.get(index+1));
            int element = (maxCurrentHeight) == 0 ? shapeHeight - 1 : maxCurrentHeight + shapeHeight;
            columnsMaxHeight.set(index, element);
            columnsMaxHeight.set(index+1, element-2);
            if(maxCurrentHeight==0){
                return new ArrayList<>(Arrays.asList(element,element-1,maxCurrentHeight,maxCurrentHeight));
            }
            else{
                return new ArrayList<>(Arrays.asList(element,element-1,maxCurrentHeight+1,maxCurrentHeight+1));
            }
        }
        else{
            int maxCurrentHeight = Math.max(columnsMaxHeight.get(index),columnsMaxHeight.get(index+1));
            int element = (maxCurrentHeight) == 0 ? shapeHeight - 1 : maxCurrentHeight + shapeHeight;
            columnsMaxHeight.set(index, element-2);
            columnsMaxHeight.set(index+1, element);
            if(maxCurrentHeight==0){
                return new ArrayList<>(Arrays.asList(maxCurrentHeight,maxCurrentHeight,element-1,element));
            }
            else{
                return new ArrayList<>(Arrays.asList(maxCurrentHeight+1,maxCurrentHeight+1,element-1,element));
            }

        }

    }

    private void updatePositionMatrix(List<List<Integer>> positionMatrix,ArrayList<Integer> colArray, ArrayList<Integer> rowArray){

        for(int i=0;i<rowArray.size();i++){
            positionMatrix.get(rowArray.get(i)).set(colArray.get((i)),1);
        }
    }

    public void maxHeight(String shape){

        String[] values = shape.split(",");
        int expectedRowSize = 3*values.length;
        List<List<Integer>> positionMatrix = new ArrayList<List<Integer>>();
        int baseIndex=0;
        for(int i=0;i<expectedRowSize;i++){
            try {
                positionMatrix.add(new ArrayList<>(Collections.nCopies(shapeHandler.gameGridSize(), 0)));
            }
            catch (OutOfMemoryError e){
                e.printStackTrace();
                throw e;
            }
        }

        ArrayList<Integer> columnsMaxHeight = new ArrayList<>(Collections.nCopies(shapeHandler.gameGridSize(), 0));

        for(String i:values) {
            Character letter = i.charAt(0);
            int index = Character.getNumericValue(i.charAt(1));
            checkEmptySpaces(positionMatrix,letter, index, columnsMaxHeight);
        }

        /**check for completely filled rows in the matrix and find final height value... */
        for(int i=0;i<positionMatrix.size();i++){
            int sum=0;
            for(int j=0;j<positionMatrix.get(i).size();j++){
                sum+=positionMatrix.get(i).get(j);
            }
            if(sum==10){
                baseIndex++;
            }

        }
        final int height = Collections.max(columnsMaxHeight)-baseIndex+1;
        System.out.println(height);


    }
}
