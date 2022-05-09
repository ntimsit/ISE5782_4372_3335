/**
 * 
 */
package geometries;

/**
 * @author noale
 *
 */
import primitives.Point;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Geometries implements Intersectable{
	private List<Intersectable> geometries;
	
	//default constructor
    public Geometries(){
        geometries = new ArrayList<>();
    }
    /**
     * creating Geometries with given list
     * @param geometries - list of geometries
     */
    public Geometries(Intersectable... geometries){
        this.geometries = new ArrayList<>();
        this.add(geometries);
    }
    
    /**
     * add given geometries to this object geometries
     * @param geometries to add
     */
    public void add(Intersectable... geometries){
        this.geometries.addAll(Arrays.asList(geometries));
    }

    
    @Override
    public List<Point> findIntsersections(Ray ray) {
        List<Point> intersectionsPoints = new ArrayList<>();
        for (Intersectable geometry : geometries) {
            List<Point> intsersections = geometry.findIntsersections(ray);
            if(intsersections != null)
                intersectionsPoints.addAll(intsersections);
        }
        if(intersectionsPoints.size() == 0)
            return null;
        return intersectionsPoints;
    }
}





   
