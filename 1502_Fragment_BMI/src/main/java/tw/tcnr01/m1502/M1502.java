package tw.tcnr01.m1502;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class M1502 extends AppCompatActivity implements BMIFragment.BMIListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m1502);
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

    //實作BMIListener的方法
    @Override
    public void onButtonClick(double bmi) {
        FragmentManager fm = getSupportFragmentManager();
        TextFragment tf = (TextFragment) fm.findFragmentById(R.id.fragment2);
        //  呼叫TextFragment物件的方法
        tf.changeBMIValue(bmi);

    }
}
