package app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import app.donation.R;
import app.main.DonationApp;
import app.model.Candidate;
import app.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by User on 16/09/2016.
 */
public class Welcome extends AppCompatActivity implements Callback<List<User>> {

    private DonationApp app;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        app = (DonationApp) getApplication();
    }

    @Override
    public void onResume() {
        super.onResume();
        app.currentUser = null;
        Call<List<User>> call1 = app.donationService.getAllUsers();
        call1.enqueue(this);

        Call<List<Candidate>> call2 = app.donationService.getAllCandidates();
        call2.enqueue(new Callback<List<Candidate>>() {
            @Override
            public void onResponse(Call<List<Candidate>> call, Response<List<Candidate>> response) {
                app.candidates = response.body();
            }

            @Override
            public void onFailure(Call<List<Candidate>> call, Throwable t) {
                app.donationServiceAvailable = false;
                serviceUnavailableMessage();
            }
        });

    }

    @Override
    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
        serviceAvailableMessage();
        app.users = response.body();
        app.donationServiceAvailable = true;
    }

    @Override
    public void onFailure(Call<List<User>> call, Throwable t) {
        app.donationServiceAvailable = false;
        serviceUnavailableMessage();
    }

    public void loginPressed (View view) {
        if (app.donationServiceAvailable) {
            startActivity(new Intent(this, Login.class));
        } else {
            serviceUnavailableMessage();
        }
    }

    public void signupPressed(View view)
    {
        if (app.donationServiceAvailable) {
            startActivity(new Intent(this, Signup.class));
        } else {
            serviceUnavailableMessage();
        }
    }

    void serviceUnavailableMessage() {
        Toast toast = Toast.makeText(this, "Donation Service Unavailable. Try again later", Toast.LENGTH_LONG);
        toast.show();
    }

    void serviceAvailableMessage()
    {
        Toast toast = Toast.makeText(this, "Donation Contacted Successfully", Toast.LENGTH_LONG);
        toast.show();
    }

}

