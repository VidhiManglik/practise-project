package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServiceCenter extends AppCompatActivity {
	String address;
	Person[] staff;
	Grid[] grid;
	String[] services;

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person[] getStaff() {
		return staff;
	}

	public void setStaff(Person[] staff) {
		this.staff = staff;
	}

	public Grid[] getGrid() {
		return grid;
	}

	public void setGrid(Grid[] grid) {
		this.grid = grid;
	}

	public String[] getServices() {
		return services;
	}

	public void setServices(String[] services) {
		this.services = services;
	}

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_center);
    }
}
