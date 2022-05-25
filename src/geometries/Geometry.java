package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point;
import primitives.Vector;

/**
 * An abstract class representing a three-dimensional shape
 */
public abstract class Geometry implements Intersectable {
    protected Color emission = Color.BLACK;
    protected Material material = new Material();

    public abstract Vector getNormal(Point p);

    /**
     * @return The basic color (emission) of the geometry
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * @return The material of the geometry
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param emission the basic color (emission) of the geometry
     * @return the geometry itself
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    /**
     * @param material the material of the geometry
     * @return the geometry itself
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }
}