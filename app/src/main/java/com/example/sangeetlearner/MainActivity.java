package com.example.sangeetlearner;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    View menu_image;
    DrawerLayout drawer_layout;
    BottomNavigationView bottom_navigation;
    ActionBarDrawerToggle drawertoggle;
    NavigationView nav_view;
    TextView nameOfUser,textView2;
    FirebaseAuth mauth;
    FirebaseUser user;
    DatabaseReference reference;
    String UserName;



    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawertoggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_layout=findViewById(R.id.drawer_layout);
        menu_image=findViewById(R.id.menu_image);
        bottom_navigation=findViewById(R.id.bottom_navigation);
        nav_view=findViewById(R.id.nav_view);
        mauth=FirebaseAuth.getInstance();
        textView2=findViewById(R.id.textView2);


//        if(mauth.getCurrentUser()==null){
//            Intent intent=new Intent(getApplicationContext(),Login_Page.class);
//            startActivity(intent);
//            finish();
//        }
//        else {
//            nameOfUser.setText(user.getEmail());
//        }

//        Experiment
        reference= FirebaseDatabase.getInstance().getReference().child("db_name");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    UserName=snapshot.getValue().toString();
                    textView2.setText(UserName);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~MenuBar Image(Three Line)~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        menu_image.setOnClickListener(v -> drawer_layout.open());


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~For Drawer~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        nav_view.bringToFront();
        drawertoggle=new ActionBarDrawerToggle(this,drawer_layout,R.string.open,R.string.close);
        drawer_layout.addDrawerListener(drawertoggle);
        drawertoggle.syncState();
        getSupportActionBar();

        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Drawer Navigation~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId=item.getItemId();

                if(itemId==R.id.guide) {
                    Intent intent=new Intent(MainActivity.this,Guide_Activity.class);
                    startActivity(intent);

                }
                else if (itemId==R.id.about) {
                    Intent intent=new Intent(MainActivity.this,About_Activity.class);
                    startActivity(intent);

                }
                else if (itemId==R.id.rating) {
                    Intent intent=new Intent(MainActivity.this,RattingBar_Activity.class);
                    startActivity(intent);

                }
                else if (itemId==R.id.logout) {
                    Toast.makeText(MainActivity.this, "Comming Soon", Toast.LENGTH_SHORT).show();
//                    FirebaseAuth.getInstance().signOut();
//                    Intent intent=new Intent(getApplicationContext(),Login_Page.class);
//                    startActivity(intent);
//                    finish();
                }

                drawer_layout.close();

                return true;
            }
        });


        //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Bottom Navigation~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               int itemId=item.getItemId();

                if(itemId==R.id.guitar_theory) {
                            FragmentManager fragmentManager=getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, Guitar_fragment.class,null)
                                .setReorderingAllowed(true)
                                .addToBackStack("name")
                                .commit();

                        }

                else if(itemId==R.id.harmonium_theory) {
                            FragmentManager fragmentManager=getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, Riyaz_Fragment.class,null)
                                .setReorderingAllowed(true)
                                .addToBackStack("name")
                                .commit();

                        }

                        else if(itemId==R.id.piano_theory) {
                            FragmentManager fragmentManager=getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                .replace(R.id.fragmentContainerView, Piano_Fragment.class,null)
                                .setReorderingAllowed(true)
                                .addToBackStack("name")
                                .commit();

                        }

               return true;
           }
       });

    }

}
//tus will always to you this program is so defacault to learn and yhe adopt the game of the wild.
// we wiuh dome the clienet the coppper the solid the  game is the same of the clients of the supper light of th fastes of the client aand superr model of the e
// this we kake time and the time goes on goes on the found the sound of the client and the dum of the corn and the flower
//this we take a few stape to work hard and the duration is that to build a narrow client bright the focus on tge goal
