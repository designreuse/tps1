package igc.tech.com.dao;

import java.util.List;

public interface DayDetailDao {

    @SuppressWarnings("rawtypes")
    public List procDayDetail(String dayDetailId,
                              String packageItineraryId, String activityDetailId, String user, String flag);
}
