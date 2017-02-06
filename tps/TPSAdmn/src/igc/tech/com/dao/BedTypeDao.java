package igc.tech.com.dao;

import java.util.List;

public interface BedTypeDao {

    @SuppressWarnings("rawtypes")
    public List procBedType(String bedTypeId, String bedTypeDesc, String size, String user, String flag);

}
