package kr.hs.emirim.mirimtabhost;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class ActionBarAndFragment extends AppCompatActivity {
    ActionBar.Tab tabJae, tabJae1, tabJae2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tabJae = bar.newTab();
        tabJae.setText("재혁이");
        tabJae.setTabListener(tabListener);
        bar.addTab(tabJae);

        tabJae1 = bar.newTab();
        tabJae1.setText("재혁");
        tabJae1.setTabListener(tabListener);
        bar.addTab(tabJae1);

        tabJae2 = bar.newTab();
        tabJae2.setText("윤재혁");
        tabJae2.setTabListener(tabListener);
        bar.addTab(tabJae2);
    }
    MyFragment myFrags[] = new MyFragment[3];

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            MyFragment myFrag = null;
            if(myFrags[tab.getPosition()] == null){
                myFrag = new MyFragment();
                Bundle data = new Bundle();
                data.putString("tabName", tab.getText().toString());
                myFrag.setArguments(data);
                myFrags[tab.getPosition()] = myFrag;
            }else{
                myFrag = myFrags[tab.getPosition()];
            }
            ft.replace(android.R.id.content, myFrag);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
    };
    public static class MyFragment extends Fragment{
        String tabName;

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle data = getArguments();
            tabName = data.getString("tabName");
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            LinearLayout linear = new LinearLayout(super.getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            linear.setLayoutParams(params);
            linear.setOrientation(LinearLayout.VERTICAL);
            if(tabName.equals("재혁이"))
                linear.setBackgroundColor(Color.RED);
            if(tabName.equals("재혁"))
                linear.setBackgroundColor(Color.BLUE);
            if(tabName.equals("윤재혁"))
                linear.setBackgroundColor(Color.GREEN);
            return linear;
        }
    }
}