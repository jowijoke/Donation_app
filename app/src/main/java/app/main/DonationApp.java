package app.main;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import app.model.Candidate;
import app.model.Donation;
import app.model.User;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DonationApp extends Application
{
    public DonationService donationService;
    public boolean donationServiceAvailable = false;
    public String service_url = "http://10.0.2.2:4000";   // Standard Emulator IP Address

    public final int       target       = 10000;
    public int             totalDonated = 0;

    public User currentUser;
    public List<Donation> donations = new ArrayList<Donation>();
    public List<User> users = new ArrayList<User>();
    public List<Candidate> candidates = new ArrayList<Candidate>();

    public boolean newDonation(Donation donation)
    {
        boolean targetAchieved = totalDonated > target;
        if (!targetAchieved)
        {
            donations.add(donation);
            totalDonated += donation.amount;
        }
        else
        {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        }
        return targetAchieved;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        super.onCreate();
        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(service_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        donationService = retrofit.create(DonationService.class);

        Log.v("Donation", "Donation App Started");
    }

    public void newUser(User user)
    {
        users.add(user);
    }

    public boolean validUser (String email, String password)
    {
        for (User user : users)
        {
            if (user.email.equals(email) && user.password.equals(password))
            {
                currentUser = user;
                return true;
            }
        }
        return false;
    }
}