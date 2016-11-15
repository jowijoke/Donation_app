package app.main;

import java.util.List;

import app.model.Candidate;
import app.model.Donation;
import app.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by User on 15/11/2016.
 */

public interface DonationService {
    @GET("/api/users")
    Call<List<User>> getAllUsers();

    @GET("/api/users/{id}")
    Call<User> getUser(@Path("id") String id);

    @POST("/api/users")
    Call<User> createUser(@Body User User);

    @GET("/api/donations")
    Call<List<Donation>> getAllDonations();

    @GET("/api/candidates")
    Call<List<Candidate>> getAllCandidates();

    @POST("/api/candidates/{id}/donations")
    Call<Donation> createDonation(@Path("id") String id, @Body Donation donation);
}
