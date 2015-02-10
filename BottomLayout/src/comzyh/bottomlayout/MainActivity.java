package comzyh.bottomlayout;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import comzyh.bottomlayout.BottomLayout.OnItemClickListener;

public class MainActivity extends Activity {

    private BottomLayout layout_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout_bottom = (BottomLayout) findViewById(R.id.layout_bottom);
        layout_bottom.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "µã»÷ÁË" + position, 0).show();
            }
        });

        new Handler().postDelayed(new Runnable() {
            public void run() {
                layout_bottom.showHomeCircle();
            }
        }, 5000);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                layout_bottom.showMessageCircle();
            }
        }, 8000);
    }

}
