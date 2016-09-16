package app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import app.donation.R;

/**
 * Created by User on 16/09/2016.
 */
public class Welcome extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void loginPressed (View view)
    {
        startActivity (new Intent(this, Donate.class));
    }
}
