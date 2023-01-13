package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLinearLayout, btnRelativeLayout, btnTableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLinearLayout = (Button) findViewById(R.id.btnLinearLayout);
        btnRelativeLayout = (Button) findViewById(R.id.btnRelativeLayout);
        btnTableLayout = (Button) findViewById(R.id.btnTableLayout);

        btnLinearLayout.setOnClickListener(this);
        btnRelativeLayout.setOnClickListener(this);
        btnTableLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
        Fragment fragment = null;

        switch(view.getId()){
            case R.id.btnLinearLayout:
                fragment = new LinearLayoutFragment();
                break;
            case R.id.btnRelativeLayout:
                fragment = new RelativeLayoutFragment();
                break;
            case R.id.btnTableLayout:
                fragment = new TableLayoutFragment();
                break;
        }

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainContainer, fragment);
        fragmentTransaction.commit();

    }
}