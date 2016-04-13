import java.util.Comparator;

public class Point {
	float x;
	float y;
	float z;
	float q;
	String label = null;
	float distanceToPoint;
	
	public Point(float x, float y, float z, float q, String label){
		this.x = x;
		this.y = y;
		this.z = z;
		this.q = q;
		this.label = label;
	}
	
	public Point(float x, float y, float z, float q){
		this.x = x;
		this.y = y;
		this.z = z;
		this.q = q;

	}

	static Comparator<Point> pointOrderer = new Comparator<Point>() {

        public int compare(Point o1, Point o2) {
            return compareTo(o1.distanceToPoint, o2.distanceToPoint);
        }

		private int compareTo(float distanceToPoint, float distanceToPoint2) {
			if(distanceToPoint > distanceToPoint2){
				return 1;
			}
			if(distanceToPoint < distanceToPoint2){
				return -1;
			}else{
				return 0;
			}
			
		}
    };
    
	public float getDistanceToPoint() {
		return distanceToPoint;
	}

	public void setDistanceToPoint(float distanceToPoint) {
		this.distanceToPoint = distanceToPoint;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getQ() {
		return q;
	}

	public void setQ(float q) {
		this.q = q;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", z=" + z + ", q=" + q + ", label=" + label + "]";
	}

}

