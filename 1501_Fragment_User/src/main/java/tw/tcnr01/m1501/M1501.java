package tw.tcnr01.m1501;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class M1501 extends AppCompatActivity implements View.OnClickListener {


    private Button b001,b002;
    private SecondFragment sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1501);
        //建立各個片段
        FirstFragment ff = new FirstFragment();

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frame,ff).commit();

        setupViewComponent();
    }

    private void setupViewComponent() {
        b001 = (Button)findViewById(R.id.button);
        b002 = (Button)findViewById(R.id.button2);

        b001.setOnClickListener(this);
        b002.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                sf = SecondFragment.newInstance("改成第二個Fragment片段");
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, sf)
                        .commit();
                break;
            case R.id.button2:
                // 刪除第2個片段
                getSupportFragmentManager().beginTransaction()
                        .remove(sf)
                        .commit();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
