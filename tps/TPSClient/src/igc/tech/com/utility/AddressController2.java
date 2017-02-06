package igc.tech.com.utility;

import com.google.appengine.repackaged.com.google.gson.Gson;
import igc.tech.com.model.AddressModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AddressController2 {
	
	public List<AddressModel> createList(){
		String[] addressId = {"2","3","4","5","6","7","8","9","10","11"};
		String[] addressName={"Region1", "Region2", "Region3", "Region4", "zone1",
				"zone2", "zone3", "zone4","district1","district2"};
		String[] parent ={"1", "1", "1", "1","2","2","3","3","6","7"};
		
		List<AddressModel> addressModelList = new ArrayList<AddressModel>();
		AddressModel addressModel = new AddressModel();
		addressModel.setAddressId("1");
		addressModel.setAddressName("country");
		addressModelList.add(addressModel);
		
		for(int i=0;i<addressId.length;i++){
			AddressModel addressModel1 = new AddressModel();
			addressModel1.setAddressId(addressId[i]);
			addressModel1.setAddressName(addressName[i]);
			addressModel1.setParentAddressId(parent[i]);
			addressModelList.add(addressModel1);
		}
		
		return addressModelList;
	}
	
	public static void main(String args[]){ 
		AddressController2 addressController = new AddressController2();
		List<AddressModel> addressModelList = addressController.createList();
		System.out.println("initial addressList: "+ addressModelList);
		
		AddressModel root = new AddressModel();
		Map<String,List<AddressModel>> nodes = new HashMap<>();
		
		for(AddressModel addressModel: addressModelList){
			if(addressModel.getParentAddressId()==null){
				root=addressModel;
			}else{
				if(!nodes.containsKey(addressModel.getParentAddressId())){
					nodes.put(addressModel.getParentAddressId(), new ArrayList<AddressModel>());
					
				}
				addressModel.setAddressModels(new ArrayList<AddressModel>());
				nodes.get(addressModel.getParentAddressId()).add(addressModel);
				
			}
		}






		System.out.println("final node"+nodes);
		
	}

}
