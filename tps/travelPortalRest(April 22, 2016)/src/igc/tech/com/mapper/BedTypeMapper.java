package igc.tech.com.mapper;

import igc.tech.com.model.BedTypeModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BedTypeMapper {
	
	
	@SuppressWarnings("rawtypes")
	public List<BedTypeModel> mapList(List<Map> list) {

		List<BedTypeModel> resultList = new ArrayList<>();

		BedTypeModel bedTypeModel;

		for (Map m : list) {
			bedTypeModel = mapRow(m);
			resultList.add(bedTypeModel);
		}

		// System.out.println("ffasdf");

		return resultList;
	}

	@SuppressWarnings("rawtypes")
	public BedTypeModel mapRow(Map map) {

		BedTypeModel bedTypeModel = new BedTypeModel();

		if (map.get("BED_TYPE_ID")!=null){
			bedTypeModel.setBedTypeId(map.get("BED_TYPE_ID").toString());

		}
		if (map.get("DESCRIPTION")!=null){
			bedTypeModel.setDescription(map.get("DESCRIPTION").toString());


		}
		if (map.get("HOTEL_DETAIL_ID")!=null){
			bedTypeModel.setHotelDetailId(map.get("HOTEL_DETAIL_ID").toString());


		}
		if (map.get("HOTEL_NAME")!=null){
			bedTypeModel.setHotelName(map.get("HOTEL_NAME").toString());


		}

		if (map.get("AREA_NAME")!=null){
			bedTypeModel.setAreaName(map.get("AREA_NAME").toString());


		}


		if (map.get("REGION_NAME")!=null){
			bedTypeModel.setRegionName(map.get("REGION_NAME").toString());


		}
		if (map.get("COUNTRY_NAME")!=null){
			bedTypeModel.setCountryName(map.get("COUNTRY_NAME").toString());

		}

		return bedTypeModel;
	}

	public BedTypeModel mapRowSetNull(boolean bedTypeId,
											boolean description,
											boolean hotelDetailId,
											boolean hotelName,
											boolean areaName,
											boolean regionName,
											boolean countryName,
											BedTypeModel bedTypeModel) {

		if(bedTypeId == true){
			bedTypeModel.setBedTypeId(null);
		}


		if(description == true){
			bedTypeModel.setDescription(null);

		}


		if(hotelDetailId==true){
			bedTypeModel.setHotelDetailId(null);

		}


		if(hotelName == true){
			bedTypeModel.setHotelName(null);

		}

		if(areaName == true){
			bedTypeModel.setAreaName(null);

		}


		if(regionName == true){
			bedTypeModel.setRegionName(null);

		}


		if(countryName==true){
			bedTypeModel.setCountryName(null);

		}

		return bedTypeModel;
	}

	public List<BedTypeModel> mapListSetNull(boolean bedTypeId,
												   boolean description,
												   boolean hotelDetailId,
												   boolean hotelName,
												   boolean areaName,
												   boolean regionName,
												   boolean countryName,
												   List<BedTypeModel> bedTypeModels) {

		for (BedTypeModel bedTypeModel: bedTypeModels) {

			bedTypeModel = mapRowSetNull(bedTypeId,description,hotelDetailId,hotelName,areaName,regionName,countryName,bedTypeModel);

		}

		return bedTypeModels;
	}

}
