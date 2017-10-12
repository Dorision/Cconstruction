package com.example.codetribe.cconstruction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewFlipper viewFlipper;
    private float lastX;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set view flipper
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    //handles the view flipper screen

    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN:
                lastX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = touchevent.getX();

                // Handling left to right screen swap.
                if (lastX < currentX) {
                    // If there aren't any other children, just break.
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;
                    // Next screen comes in from left.
                    viewFlipper.setInAnimation(this, R.anim.in_left);
                    // Current screen goes out from right.
                    //  viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

                    // Display next screen.
                    viewFlipper.showNext();
                }
                // Handling right to left screen swap.
                if (lastX > currentX) {

                    // If there is a child (to the left), kust break.
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;
                    // Next screen comes in from right.
                    // viewFlipper.setInAnimation(this, R.anim.in_right);
                    // Current screen goes out from left.
                    // viewFlipper.setOutAnimation(this, R.anim.slide_out_to_left);
                    // Display previous screen.
                    viewFlipper.showPrevious();
                }
                break;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.nav_slideshow) {
             Intent i = new Intent(MainActivity.this, ContactActivity.class);
             startActivity(i);

        } else if (id == R.id.nav_manage) {
             Intent i = new Intent(MainActivity.this, ProfileActivity.class);
             startActivity(i);
         } else if (id == R.id.nav_gallery) {
             Intent i = new Intent(MainActivity.this, Enquire.class);
             startActivity(i);
         } else if (id == R.id.nav_camera) {

             try {
                 Intent i = new Intent(Intent.ACTION_SEND);
                 i.setType("text/plain");
                 i.putExtra(Intent.EXTRA_SUBJECT, "C-Water Construction");
                 String sAux = "\nHi i just tried this amazing application called C Water Construction.Download it also on this link\n\n";
                 sAux = sAux + "https://play.google.com/store/apps/details?id=Consructin company app \n\n";
                 i.putExtra(Intent.EXTRA_TEXT, sAux);
                 startActivity(Intent.createChooser(i, "choose one"));
             } catch(Exception e) {
                 //e.toString();
             }

         } else if (id == R.id.nav_share) {


             String strUri = "http://maps.google.com/maps?q=loc:" +  "-23.910401" + "," + "29.463713" + " (" + "C-Water Construction" + ")";
             Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));

             intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");

             startActivity(intent);

        }
        else if (id == R.id.nav_send) {
             Intent i = new Intent(MainActivity.this, AboutActivity.class);
             startActivity(i);

        }
         else if (id == R.id.nav_exit) {

          signOut();
             startActivity(new Intent(getApplicationContext(),LoginActivity.class));

         }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void Plans(View view){
        Intent i = new Intent (MainActivity.this,PlanGallery.class);
        startActivity(i);

    }

    public void Designs(View view){
        Intent i = new Intent (MainActivity.this, DesignGallery.class);
        startActivity(i);

    }

    public void Material(View view){
        Intent i = new Intent (MainActivity.this, BuildingGallery.class);
        startActivity(i);

    }


    public void signOut(){
        FirebaseAuth.getInstance().signOut();
    }








}
