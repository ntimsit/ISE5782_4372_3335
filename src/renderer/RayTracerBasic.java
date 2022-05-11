package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import scene.Scene;

import java.util.List;

/**
 * A class whose job is to trac the color for a particular ray
 * Extends the abstract class RayTracerBase
 */
public class RayTracerBasic extends RayTracerBase {
    /**
     * Constructor
     *
     * @param scene The scene on which the tracer is based
     */
    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    @Override
    public Color traceRay(Ray ray) {
        List<Point> intersections = scene.geometries.findIntsersections(ray);
        if (intersections == null)
            return scene.background;
        Point closestPoint = ray.findClosestPoint(intersections);
        return calcColor(closestPoint);
    }

    /**
     * A function that calculates the color for a given point
     * @param point The 3D point
     * @return The color corresponding to the point
     */
    private Color calcColor(Point point) {
        return scene.ambientLight.getIntensity();
    }
}