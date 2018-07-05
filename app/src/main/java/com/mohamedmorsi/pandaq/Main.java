package com.mohamedmorsi.pandaq;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.mohamedmorsi.pandaq.Adapters.FragmentAdapter;
import com.mohamedmorsi.pandaq.Fragments.MyOrdersFragment;
import com.mohamedmorsi.pandaq.Fragments.ProductsFragment;
import com.mohamedmorsi.pandaq.Fragments.WishListFragment;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager viewPager;
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentAdapter fragmentAdapter;
    TabLayout tabLayout;
    AppBarLayout appBarLayout;
    TabLayout tabOne,tabTwo,tabThree;
    TextView textViewOne,textViewTwo,textViewThree;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPager = findViewById(R.id.pager);
        fragmentManager = this.getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager);
        tabLayout =  findViewById(R.id.tabs);
        appBarLayout = findViewById(R.id.appBar);

        makeView();
    }

    @SuppressLint("SetTextI18n")
    private void makeView(){
        fragmentAdapter.addFragment(new ProductsFragment());
        fragmentAdapter.addFragment(new MyOrdersFragment());
        fragmentAdapter.addFragment(new WishListFragment());

        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOffscreenPageLimit(3);

        tabLayout.setupWithViewPager(viewPager);

        tabOne = (TabLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        textViewOne = tabOne.findViewById(R.id.text_tab);
        textViewOne.setText(R.string.first_page);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        tabTwo = (TabLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        textViewTwo = tabTwo.findViewById(R.id.text_tab);
        textViewTwo.setText(R.string.second_page);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        tabThree = (TabLayout) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        textViewThree = tabThree.findViewById(R.id.text_tab);
        textViewThree.setText(R.string.Third_page);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
