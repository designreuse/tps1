package igc.tech.com.mapper;

import igc.tech.com.model.BedTypeAccessModel;
import igc.tech.com.model.BedTypeModel;
import igc.tech.com.model.RoomFacilityAccessModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BedTypeAccessMapper {

	@SuppressWarnings("rawtypes")
	public List<BedTypeAccessModel> mapList(List<Map> list) {

		List<BedTypeAccessModel> resultList = new ArrayList<>();

		BedTypeAccessModel bedTypeAccessModel;

		for (Map m : list) {
			bedTypeAccessModel = mapRow(m);
			resultList.add(bedTypeAccessModel);
		}

		return resultList;
	}

	@SuppressWarnings("rawtypes")
	public BedTypeAccessModel mapRow(Map map) {

		BedTypeAccessModel bedTypeAccessModel = new BedTypeAccessModel();

		if(map.get("BED_TYPE_ACCESS_ID")!=null){
			bedTypeAccessModel.setBedTypeAccessId(map.get("BED_TYPE_ACCESS_ID").toString());

		}

		if(map.get("ROOM_TYPE_ID")!=null){
			bedTypeAccessModel.setRoomTypeId(map.get("ROOM_TYPE_ID").toString());

		}
		if(map.get("ROOM_TYPE_DESC")!=null){
			bedTypeAccessModel.setRoomTypeDesc(map.get("ROOM_TYPE_DESC").toString());

		}
		if(map.get("BED_TYPE_ID")!=null){
			bedTypeAccessModel.setBedTypeId(map.get("BED_TYPE_ID").toString());

		}
		if(map.get("BED_TYPE_DESC")!=null){
			bedTypeAccessModel.setBedTypeDesc(map.get("BED_TYPE_DESC").toString());

		}
		if(map.get("HOTEL_NAME")!=null){
			bedTypeAccessModel.setHotelName(map.get("HOTEL_NAME").toString());

		}

		if(map.get("AREA_NAME")!=null){
			bedTypeAccessModel.setAreaName(map.get("AREA_NAME").toString());

		}

		if(map.get("REGION_NAME")!=null){
			bedTypeAccessModel.setRegionName(map.get("REGION_NAME").toString());

		}
		if(map.get("COUNTRY_NAME")!=null){
			bedTypeAccessModel.setCountryName(map.get("COUNTRY_NAME").toString());

		}

		return bedTypeAccessModel;
	}

	public BedTypeAccessModel mapRowSetNull(boolean bedTypeAccessId,
											boolean roomTypeId,
											boolean roomTypeDesc,
											boolean bedTypeId,
											boolean bedTypeDesc,
											boolean hotelName,
											boolean areaName,
											boolean regionName,
											boolean countryName,
											BedTypeAccessModel bedTypeAccessModel) {

		if(bedTypeAccessId == true){
			bedTypeAccessModel.setBedTypeAccessId(null);

		}

		if(roomTypeId == true){
			bedTypeAccessModel.setRoomTypeId(null);

		}
		if(roomTypeDesc== true){
			bedTypeAccessModel.setRoomTypeDesc(null);

		}
		if(bedTypeId== true){
			bedTypeAccessModel.setBedTypeId(null);

		}
		if(bedTypeDesc== true){
			bedTypeAccessModel.setBedTypeDesc(null);

		}
		if(hotelName== true){
			bedTypeAccessModel.setHotelName(null);

		}

		if(areaName== true){
			bedTypeAccessModel.setAreaName(null);

		}

		if(regionName== true){
			bedTypeAccessModel.setRegionName(null);

		}
		if(countryName== true){
			bedTypeAccessModel.setCountryName(null);

		}


		return bedTypeAccessModel;
	}

	public List<BedTypeAccessModel> mapListSetNull(boolean bedTypeAccessId,
												   boolean roomTypeId,
												   boolean roomTypeDesc,
												   boolean bedTypeId,
												   boolean bedTypeDesc,
												   boolean hotelName,
												   boolean areaName,
												   boolean regionName,
												   boolean countryName,
												   List<BedTypeAccessModel> bedTypeAccessModels) {

		for (BedTypeAccessModel bedTypeAccessModel: bedTypeAccessModels) {

			bedTypeAccessModel = mapRowSetNull(bedTypeAccessId,roomTypeId,roomTypeDesc,bedTypeId,bedTypeDesc,hotelName,areaName,regionName,countryName, bedTypeAccessModel);

		}

		return bedTypeAccessModels;
	}

}
