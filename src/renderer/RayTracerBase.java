package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * A class whose job is to trac the color for a particular ray
 */
public abstract class RayTracerBase {
    protected Scene scene;

    /**
     * Constructor
     *
     * @param scene The scene on which the tracer is based
     */
    public RayTracerBase(Scene scene) {
        this.scene = scene;
    }

    /**
     * A function that calculates the appropriate color for the ray according to the elements in the scene
     *
     * @param ray A ray coming out of the camera
     * @return The color corresponding to the given ray
     */
    public abstract Color traceRay(Ray ray);
}