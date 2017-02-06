package igc.tech.com.utility;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;


/**
 * Created by tilak on 7/26/2016.
 */
public interface GitHubService {


    @FormUrlEncoded
    @POST("/epay/transrec")
    Call<ResponseBody> esewa(@Part("amt") String amt, @Part("scd") String scd, @Part("pid") String pid, @Part("rid") String rid);



    @FormUrlEncoded
    @POST("epay/transrec")
    Call<ResponseBody> listRepos(@Field("amt") String amt, @Field("scd") String scd, @Field("pid") String pid, @Field("rid") String rid);


    @GET
    Call<ResponseBody> serv();
}