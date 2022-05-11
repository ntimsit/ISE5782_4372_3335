package unittests;

import org.junit.Test;
import renderer.Camera;
import primitives.*;
import geometries.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class IntegrationTests {
	Point p5=new Point(0,0,0);

    /**
     * Integration between constructRayThroughPixel of camera & findIntsersections of a plane
     * {@link Camera#constructRayThroughPixel(int, int, int, int)}
     * {@link Plane#findIntersections(Ray)}
     */
    @Test
    public void integrationTestForPlane(){
    	
        Camera camera = new Camera(p5, new Vector(0, 0, -1), new Vector(0, 1, 0)).setVPDistance(4).setVPSize(6, 6);

        // TC05: (9 points)
        // Plane is in parallel to XY plane, so all of the rays will intersect the plane.
        runTestOnVP(camera, new Plane(new Point(0, 0, -6), new Vector(0, 0, 1)), 9);

        // TC06: (0 points)
        // Plane is in parallel to XZ plane and at same axle with the center of the camera, so all of the rays will not intersect the plane.
        runTestOnVP(camera, new Plane(new Point(0, 0, -6), new Vector(0, 1, 0)), 0);

        // TC07: (0 points)
        // Plane is in parallel to YZ plane and at same axle with the center of the camera , so all of the rays will intersect the plane.
        runTestOnVP(camera, new Plane(new Point(0, 0, -6), new Vector(1, 0, 0)), 0);

        // TC08: (6 points)
        // Plane is placed in way so the rays going through the bottom of the camera's plane are in parallel to the Plane. Hence only 6 intersections.
        runTestOnVP(camera, new Plane(new Point(0, 0, -6), new Vector(0, -4, 1)), 6);

        // TC09: (9 points)
        // Plane has some curve but in way so all of the rays can intersect it. Hence 9 intersections.
        runTestOnVP(camera, new Plane(new Point(0, 0, -6), new Vector(0, 1, -1)), 9);

        // TC10: (3 points)
        // Plane is in parallel to XZ Plane but placed in way so only the rays going through the top of the camera's plane will intersect it. Hence only 3 intersections.
        runTestOnVP(camera, new Plane(new Point(0, 8, -16), new Vector(0, 1, 0)), 3);

        // TC11: (3 points)
        // Plane is in parallel to YZ Plane but placed in way so only the rays going through the left side of the camera's plane will intersect it. Hence only 3 intersections.
        runTestOnVP(camera, new Plane(new Point(-8, 0, -16), new Vector(1, 0, 0)), 3);
    }

    /**
     * Integration between constructRayThroughPixel of camera & findIntsersections of a triangle
     * {@link Camera#constructRayThroughPixel(int, int, int, int)}
     * {@link Triangle#findIntersections(Ray)}
     */
    @Test
    public void integrationTestForTriangle(){
        Camera camera = new Camera(p5, new Vector(0, 0, -1), new Vector(0, 1, 0)).setVPDistance(1).setVPSize(3, 3);
        //Polygon polygon;

        // TC01:
        // Triangle is facing to the camera. Triangle is small so only one ray will intersect the triangle.
        runTestOnVP(camera, new Triangle(new Point(0, 1, -2), new Point(1, -1, -2), new Point(-1, -1, -2)), 1);

        // TC02:
        // Triangle is facing to the camera. Triangle is above the rays going through the bottom of the camera's plane.
        // So only the rays going through the middle and the top of the camera's plane will intersect.
        runTestOnVP(camera, new Triangle(new Point(0, 20, -2), new Point(1, -1, -2), new Point(-1, -1, -2)), 2);

        // TC03:
        // Triangle is facing to the camera. Triangle is big enough and covers the camera's plane so there are 9 intersections.
        runTestOnVP(camera, new Triangle(new Point(0, 100, -5), new Point(50, -50, -5), new Point(-50, -50, -5)), 9);
    }

    /**
     * Integration between constructRayThroughPixel of camera & findIntsersections of a sphere
     * {@link Camera#constructRayThroughPixel(int, int, int, int)}
     * {@link Sphere#findIntersections(Ray)}
     */
    @Test
    public void integrationTestForSphere(){
        Camera camera;

        // TC01:
        camera = new Camera(p5, new Vector(0, 0, -1), new Vector(0, 1, 0)).setVPDistance(1).setVPSize(3, 3);
        //runTestOnVP(camera, new Sphere(new Point(0, 0, -3), 1), 2);

        // TC02:
        camera = new Camera(new Point(0, 0, 0.5), new Vector(0, 0, -0.5), new Vector(0, 1, 0)).setVPDistance(1).setVPSize(3, 3);
        //runTestOnVP(camera, new Sphere(new Point(0, 0, -2.5), 2.5), 18);

        // TC03:
        //runTestOnVP(camera, new Sphere(new Point(0, 0, -2), 2), 10);

        // TC04:
        //runTestOnVP(camera, new Sphere(new Point(0, 0, -1), 4), 9);

        // TC05:
        //runTestOnVP(camera, new Sphere(new Point(0, 0, 1), 0.5), 0);
    }

    /**
     * get camera, intersectable and number of intersections and test
     * @param camera - camera
     * @param intersectable - intersectable object
     * @param numberOfIntersections - number of intersections needed for passing the test
     */
    public void runTestOnVP(Camera camera, Intersectable intersectable, int numberOfIntersections){
        List<Point> allIntsersections = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                List<Point> intsersections = intersectable.findIntsersections(camera.constructRay(3, 3, i, j));
                if(intsersections != null)
                    allIntsersections.addAll(intsersections);
            }
        }
        assertEquals("Wrong number of intersection points", numberOfIntersections, allIntsersections.size());
    }
}