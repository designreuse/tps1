package igc.tech.com.mapper;

import igc.tech.com.model.TokenModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IGC TECHNOLOGY on 3/17/2016.
 */
public class TokenMapper {


    public List<TokenModel> mapList(List<Map> list) {

        List<TokenModel> resultList = new ArrayList<>();

        TokenModel tokenModel;

        for (Map m : list) {
            tokenModel = mapRow(m);
            resultList.add(tokenModel);
        }



        return resultList;
    }

    public TokenModel mapRow(Map map) {

        TokenModel tokenModel = new TokenModel();


        tokenModel.setTokenId(map.get("token_id").toString());

        tokenModel.setStatus(map.get("status").toString());
        tokenModel.setToken(map.get("token").toString());
        tokenModel.setUserDetailId(map.get("user_detail_id").toString());
        tokenModel.setStep(map.get("step")==null?null:map.get("step").toString());


        return tokenModel;


    }
}
