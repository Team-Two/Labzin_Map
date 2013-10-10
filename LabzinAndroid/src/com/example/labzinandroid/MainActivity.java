package com.example.labzinandroid;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.location.LocationClient;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.maps.*;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;



public class MainActivity extends android.support.v4.app.FragmentActivity
	implements OnMapClickListener, GooglePlayServicesClient.ConnectionCallbacks,
    GooglePlayServicesClient.OnConnectionFailedListener{
	

	private GoogleMap mMap;
	LocationClient mLocationClient;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
	               .getMap();
		
	    mMap.setOnMapClickListener(this);
	    //mMap.setMyLocationEnabled(true);
	    
	    //  Google Play services check
	    int resultCode =
	    	    GooglePlayServicesUtil.
	    	            isGooglePlayServicesAvailable(this);
	    	
	    	if (ConnectionResult.SUCCESS == resultCode) {
	    	Log.d("Location Updates",
	    	        "Google Play services is available.");
	    	}
	    	else{
	    		Log.d("Location Updates",
		    	        "Google Play services is unavailable.");
	    		}
	    	
	    	mLocationClient = new LocationClient(this, this, this);
	 }
	 protected void onStart() {
        super.onStart();
         // Connect the client.
        mLocationClient.connect();
        
        Location mCurrentLocation = mLocationClient.getLastLocation();
        
        //mMap.addMarker(new MarkerOptions().position(
        //		new LatLng(mCurrentLocation.getLatitude(),mCurrentLocation.getLongitude())).
		//		icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
     }
	 protected void onStop() {
	        // Disconnecting the client invalidates it.
	        mLocationClient.disconnect();
	        super.onStop();
	    }
	
	public void onMapClick(LatLng point) {
		mMap.addMarker(new MarkerOptions().position(point).
				icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
		}


	@Override
	public void onConnectionFailed(ConnectionResult result) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onConnected(Bundle connectionHint) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
	
		
		/*com.google.android.maps.MapView MView = (com.google.android.maps.MapView) findViewById(R.id.mapview);
		MView.setBuiltInZoomControls(true);
		MapConrol = MView.getController();
		
		LocationManager LocManager = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
		
		LocationListener LocListener = new LocationListener() {
			
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onLocationChanged(Location location) {
				MapConrol.setCenter(new GeoPoint((int)location.getLatitude(),(int)location.getLongitude()));
				
			}
		};
		LocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, LocListener);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//@Override
	//

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	*/

}
