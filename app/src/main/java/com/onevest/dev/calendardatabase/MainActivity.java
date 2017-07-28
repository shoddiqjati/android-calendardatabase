package com.onevest.dev.calendardatabase;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.onevest.dev.calendardatabase.adapters.EventsAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView noEventTV;
    private EventsAdapter adapter;

    protected String[] PERMISSIONS = {Manifest.permission.READ_CALENDAR};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!hasPermissions(this, PERMISSIONS)) {
            requestPermissions();
        }

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        noEventTV = (TextView) findViewById(R.id.noEventTV);
        adapter = new EventsAdapter(this);

        try {
            recyclerView.setAdapter(adapter);
            recyclerView.setVisibility(View.VISIBLE);
            noEventTV.setVisibility(View.GONE);
        } catch (NullPointerException e) {
            noEventTV.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }
    }

    private boolean hasPermissions(Context context, String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length <= 0) {
                requestPermissions();
            }
        }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, 1);
    }
}
