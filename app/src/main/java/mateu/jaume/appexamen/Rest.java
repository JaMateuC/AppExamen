package mateu.jaume.appexamen;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by root on 18/12/17.
 */

public interface Rest {

    @GET("login")
    Call<String> getLogin();

}
