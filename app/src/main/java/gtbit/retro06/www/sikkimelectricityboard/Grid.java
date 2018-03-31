package gtbit.retro06.www.sikkimelectricityboard;

import com.google.maps.model.LatLng;

public class Grid {
	String gridNumber;
	Person[] customers;
	LatLng[] polygonPoints;
	LatLng center;
	float totalCapacity;
	float usedCapacity;
	ServiceCenter controlCenter;
}
