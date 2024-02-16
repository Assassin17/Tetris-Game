package org.encord.Interface;

import org.encord.Bean.Shape;

/***
 * This Interface class will help us to add new features into game moving forward [Future-Scope]....
 */

public interface ShapeAndOrientation {

     void shapeAndSize(Character shape, int index, Shape figure);

     int gameGridSize(); /**  Considering infinite height.. */

     void increasePace();  /** Increase moving pieces speed... */

     void Orientation(int angle);  //TODO: considering only 90,180,270 degree scenarios.....



}
