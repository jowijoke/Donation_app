package app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import app.activity.Login;
import app.activity.Signup;
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
        startActivity (new Intent(this, Login.class));
    }

    public void signUpPressed (View view)
    {
        startActivity (new Intent(this, Signup.class));
    }
}

