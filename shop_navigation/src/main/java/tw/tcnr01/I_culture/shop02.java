package tw.tcnr01.I_culture;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class shop02 extends AppCompatActivity implements View.OnClickListener ,NavigationView.OnNavigationItemSelectedListener {

    private ImageView img01;
    private TextView txt01;
    private Button btn01,btn02,btn03;
    private Intent intent=new Intent();
    private Dialog mapDlg;

    private Integer[] shop={
            R.drawable.shop001,R.drawable.shop002,R.drawable.shop003
    };
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop02_layout);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        setupViewComponent();
    }

    private void setupViewComponent() {
        img01=(ImageView)findViewById(R.id.shop02_img01);
        txt01=(TextView)findViewById(R.id.shop02_txt01);
        btn01=(Button)findViewById(R.id.shop02_btn01);
        btn02=(Button)findViewById(R.id.shop02_btn02);
        btn03=(Button)findViewById(R.id.shop02_btn03);
        btn = (Button)findViewById(R.id.btn);

        img01.setOnClickListener(this);
        txt01.setOnClickListener(this);
        btn01.setOnClickListener(shopdialog);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(favoritetoast);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.shop02_img01:
                intent.putExtra("class_title", getString(R.string.app_name));
                intent.setClass(shop02.this, shop03.class);
                break;
            case R.id.shop02_txt01:
                intent.putExtra("class_title", getString(R.string.app_name));
                intent.setClass(shop02.this, shop03.class);
                break;
//            case R.id.shop02_btn01:
//                break;

               case R.id.shop02_btn02:
                   intent.putExtra("class_title", getString(R.string.app_name));
                   intent.setClass(shop02.this, product.class);
                   break;

            case R.id.btn:
                Intent it = new Intent(this,shop01.class);
                startActivity(it);
                finish();
                break;

//            case R.id.shop02_btn03:
//                    mapDlg = new Dialog(shop02.this);
//                    mapDlg .setTitle(getString(R.string.shop01_img01));
//                    mapDlg .setCancelable(true);
//                    mapDlg .setContentView(R.layout.shop_map_dialog);
//                    mapDlg .show();
//                    break;
        }
       // startActivity(intent);
    }

    private Button.OnClickListener shopdialog= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            mapDlg = new Dialog(shop02.this);
            mapDlg .setCancelable(false);
            mapDlg .setContentView(R.layout.shop_map_dialog);
            ImageButton btncancel=(ImageButton)mapDlg.findViewById(R.id.shop_map_dialog_btncancel);
            btncancel.setOnClickListener(productbtncancel);
            mapDlg .show();
        }
        private Button.OnClickListener productbtncancel= new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapDlg.cancel();
            }
        };
    };

    private Button.OnClickListener favoritetoast= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),R.string.shop02_m001,
                    Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
            Intent it = new Intent(this,shop01.class);
            startActivity(it);
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.shop, menu);
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
