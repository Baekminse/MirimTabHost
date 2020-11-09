package kr.hs.emirim.mirimtabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecjae = tabHost.newTabSpec("jae").setIndicator("재혁이");
        tabSpecjae.setContent(R.id.linear_jae);
        tabHost.addTab(tabSpecjae);

        TabHost.TabSpec tabSpecjae1 = tabHost.newTabSpec("jae1").setIndicator("윤재혁");
        tabSpecjae.setContent(R.id.linear_jae1);
        tabHost.addTab(tabSpecjae1);

        TabHost.TabSpec tabSpecjae2 = tabHost.newTabSpec("jae2").setIndicator("재혁");
        tabSpecjae.setContent(R.id.linear_jae2);
        tabHost.addTab(tabSpecjae2);

        tabHost.setCurrentTab(0);
    }
}