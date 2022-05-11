package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {
    private Color intensity;

    /**
     * A constructor that receives IA and kA values and calculates the final intensity of fill lighting
     * @param IA the color
     * @param kA the intensity
     */
    public AmbientLight(Color IA, Double3 kA) {
        this.intensity = IA.scale(kA);
    }
    
    /**
     * A default constractor which sets the color to black
     */
    
    public AmbientLight()
	{
		this.intensity=Color.BLACK;
	}

    /**
     * @return the intensity of the Ambient Light
     */
    public Color getIntensity() {
        return intensity;
    }
}