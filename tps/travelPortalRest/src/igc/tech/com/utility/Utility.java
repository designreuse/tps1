package igc.tech.com.utility;

import igc.tech.com.model.EsewaResponse;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utility  {
	
	
	public String getTimeForSNo() {
		Date d = new Date();
		String format = "yyyyMMddHHmmSSS";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}

	/*public static Object convertXmlToObject(String value, Class x) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(x);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(value);
		return unmarshaller.unmarshal(reader);

	}
	*/


	public Object convertXmlToObject(String value, Class x) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(x);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(value);

		//System.out.println(unmarshaller.unmarshal(reader));

		return unmarshaller.unmarshal(reader);

	}



/*	public String getDateTime() {
		String format = "HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return getTodaysDateNepali() + " " + sdf.format(cal.getTime());
	}



	public String formatToOracle(String englishDate) {
		java.sql.Date d = java.sql.Date.valueOf(englishDate);
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yy");
		return sdf.format(d);
	}

	public String getTodaysDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMM-yy");
		return sdf.format(d);
	}

	public String getMonth() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(d);
	}

	public String getNepaliYear() {
		String td = getTodaysDateNepali();
		// String ny = td.substring(0,4);
		// System.out.println(ny);
		return td.substring(0, 4);
	}

	public String getNepaliMonth() {
		String td = getTodaysDateNepali();
		return td.substring(5, 7);
	}

	public String getYear() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(d);
	}*/



	/*public String getSoDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}

	public String getTodaysDateNepali() {

		return getNepaliDate(getTodaysDate());

	}

	public String getNepaliDate(String date) {
		String sql = "SELECT cmmn1.to_bs(?) as nep FROM dual";
		List lst = this.queryForList(sql, new Object[] { date });
		Map m = (Map) lst.get(0);
		return m.get("NEP").toString();

	}

	public String getEnglishDate(String nepaliDate) {
		String sql = "SELECT trunc(cmmn1.to_ad(?)) as eng FROM dual";
		List lst = this.queryForList(sql, new Object[] { nepaliDate });
		Map m = (Map) lst.get(0);
		String englishDate = m.get("ENG").toString();
		String[] date = englishDate.split(" ");
		return date[0].trim();
	}
*/
	public String getDateAndTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhssssyyyyMMddmm");
		return sdf.format(d);
	}

/*	public String getDateAndTime200() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, 200);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(c.getTime());
	}

	@Override
	public String inWord(String amt) {
		// TODO Auto-generated method stub
		String sql = "select to_string(?) word from dual";

		List lst = this.queryForList(sql, new Object[] { amt });
		Map m = (Map) lst.get(0);
		// return Integer.parseInt(m.get("SSS").toString());
		return m.get("WORD").toString();

	}*/

	public String getTime() {
		String format = "HH:mm:a";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		System.out.println(cal.getTime());
		return sdf.format(cal.getTime());
	}

	public String formatTime(String time) {
		String format = "hh:mm:a";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);

		List<String> timeList = Arrays.asList(time.split(":"));
		cal.set(Calendar.HOUR, Integer.parseInt(timeList.get(0)) );
		cal.set(Calendar.MINUTE, Integer.parseInt(timeList.get(1)));
		cal.set(Calendar.AM_PM,0 );

		return sdf.format(cal.getTime());
	}

	public static void main(String[] args) throws JAXBException {

		String xx="<response><response_code>failure</response_code></response>";
		EsewaResponse esewaResponse1 = (EsewaResponse) new Utility().convertXmlToObject(xx, EsewaResponse.class);

		System.out.println(esewaResponse1.getResponseCode());
	}
}
