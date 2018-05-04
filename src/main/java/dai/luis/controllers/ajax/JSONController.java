package dai.luis.controllers.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dai.luis.beans.JsonBean;

@Controller
public class JSONController {
	
	
	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public @ResponseBody JsonBean getJSON(Integer edad) {
		JsonBean jsonBean = new JsonBean();
		jsonBean.setEdad(3);
		
		return jsonBean;
	}
	
	//
	//	 @RequestMapping(value = "/customers/obtainProvinces/{idCountry}", method = RequestMethod.GET) 
	//	 public @ResponseBody List<ProvinceModel> getProvinces(@PathVariable String idCountry) { 
	//	 	List<ProvinceModel> provincesModel = locationsService.getProvinces(new Long(idCountry)); 
	//		return provincesModel; 
	//	 }
	//	 
}
