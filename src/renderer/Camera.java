/**
 * 
 */
package renderer;
import primitives.*;

/**
 * @author noale
 *
 */
public class Camera {
	private Point p0;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;
    private double width;
    private double height;
    private double distance;


/**
 * constructor
 * @param p0 point p0
 * @param vTo vTo
 * @param vUp vUp
 * @throws IllegalArgumentException if vTo and vUp are not vertical to each other
 */
public Camera(Point p0, Vector vTo, Vector vUp) throws IllegalArgumentException{
    if(Util.alignZero(vTo.dotProduct(vUp)) != 0 )
        throw new IllegalArgumentException(vTo + " and " + vUp + " are not vertical to each other");
    this.p0 = p0;
    this.vTo = vTo.normalize();
    this.vUp = vUp.normalize();
    vRight = vTo.crossProduct(vUp).normalize();
    width = 0;
    height = 0;
}
/**
 * @return p0
 */
public Point getP0() {
    return p0;
}

/**
 * @return vTo
 */
public Vector getVTo() {
    return vTo;
}

/**
 * @return vUp
 */
public Vector getVUp() {
    return vUp;
}

/**
 * @return vRight
 */
public Vector getVRight() {
    return vRight;
}

/**
 * @return width of the view plane
 */
public double getWidth() {
    return width;
}

/**
 * @return height of the view plane
 */
public double getHeight() {
    return height;
}

/**
 * @return distance of the view plane
 */
public double getDistance() {
    return distance;
}

/**
 * Update the view plane
 * @param width - new width
 * @param height - new height
 * @return this camera
 */
public Camera setVPSize(double width, double height){
    this.width = width;
    this.height = height;
    return this;
}

/**
 * Update the distance of the view plane
 * @param distance - new distance
 * @return this camera
 */
public Camera setVPDistance(double distance){
    this.distance = distance;
    return this;
}

/**
 * Construct a ray which go through pixel (i, j)
 * @param nX number of pixels in a row (width)
 * @param nY number of pixels in a column (height)
 * @param j column index of a pixel
 * @param i row index of a pixel
 * @return ray through pixel (i,j)
 */
/*
public Ray constructRay(int nX, int nY, int j, int i) 
{
	return null;
}
*/
public Ray constructRay(int nX, int nY, int j, int i){
    //Image center:
    Point center = p0.add(vTo.scale(distance));
    //Ratio: (pixel width & height)
    double rY = Util.alignZero(height / nY);
    double rX = Util.alignZero(width / nX);
    //Pixel[i,j] center
    double yI = Util.alignZero(-1 * (i - (nY - 1.0) / 2.0) * rY);
    double xJ = Util.alignZero((j - (nX - 1.0) / 2.0) * rX);
    //Pi,j:
    Point pIJ = center;
    if(xJ != 0)
        pIJ = pIJ.add(vRight.scale(xJ));
    if(yI != 0)
        pIJ = pIJ.add(vUp.scale(yI));
    //vi,j = Pi,j − P0
    Vector vIJ = pIJ.subtract(p0);
    //Ray: {p0 = P0, direction = vi,j}
    return new Ray(vIJ, p0);
}
public Object setImageWriter(ImageWriter imageWriter) {
	// TODO Auto-generated method stub
	return null;
}
public void renderImage() {
	// TODO Auto-generated method stub
	
}
public void writeToImage() {
	// TODO Auto-generated method stub
	
}
public void printGrid(int i, Color color) {
	// TODO Auto-generated method stub
	
}


}
