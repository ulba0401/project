package com.example.networkdic;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.networkdic.menu.asc.Asc_main;
import com.example.networkdic.menu.bookmark.Bookmark_main;
import com.example.networkdic.menu.main.Main_main;
import com.example.networkdic.menu.notice.Notice_main;
import com.example.networkdic.menu.unit.Unit_main;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //시작하자마자 메인화면 프래그먼트 띄우기
        onFragmentChange(1);

        //setSupportActionBar : 액션바 설정
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //액션바 기본 타이틀 보여지지 않게
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);


        //메뉴 나오게 하기
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //네비게이션 메뉴 아이템 선택시
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            //메인화면
            onFragmentChange(1);
        } else if (id == R.id.nav_asc) {
            //전체보기
            onFragmentChange(2);
        } else if (id == R.id.nav_unil) {
            //단원별 보기
            onFragmentChange(3);
        } else if (id == R.id.nav_bookmark) {
            //북마크
            onFragmentChange(4);
        } else if (id == R.id.nav_notice) {
            //고객센터
            onFragmentChange(5);
        } else if (id == R.id.nav_login) {
            //로그인
            onFragmentChange(6);
        } else if (id == R.id.nav_join) {
            //회원가입
            onFragmentChange(7);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onFragmentChange(int i){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Asc_main asc = new Asc_main();
        Bookmark_main bookmark = new Bookmark_main();
        Main_main main = new Main_main();
        Notice_main notice = new Notice_main();
        Unit_main unit = new Unit_main();

        if ( i == 1 ) {
            //메인화면
            ft.addToBackStack(null);
            ft.replace(R.id.container, main).commit();
        }
        else if ( i == 2 ) {
            //전체보기
            ft.addToBackStack(null);
            ft.replace(R.id.container, asc).commit();
        }
        else if ( i == 3 ) {
            //단원보기
            ft.addToBackStack(null);
            ft.replace(R.id.container, unit).commit();
        }
        else if ( i == 4 ) {
            //북마크
            ft.addToBackStack(null);
            ft.replace(R.id.container, bookmark).commit();
        }
        else if ( i == 5 ) {
            //고객센터
            ft.addToBackStack(null);
            ft.replace(R.id.container, notice).commit();
        }
        else if ( i == 6 ) {
            //로그인
        }
        else if ( i == 7 ) {
            //회원가입
        }


    }
}
