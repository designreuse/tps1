package igc.tech.com.utility;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utility {


    public String getTimeForSNo() {
        Date d = new Date();
        String format = "yyyyMMddHHmmSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(d);
    }


    public BufferedImage scaleImage(final BufferedImage bufferedImage,
                                    final int size) {
        final double boundSize = size;

        final int origWidth = bufferedImage.getWidth();
        final int origHeight = bufferedImage.getHeight();

        double scale;

        if (origHeight > origWidth)
            scale = boundSize / origHeight;
        else
            scale = boundSize / origWidth;

        /*
         * Don't scale up small images.
         */
        if (scale > 1.0)
            return (null);

        final int scaledWidth = (int) (scale * origWidth);
        final int scaledHeight = (int) (scale * origHeight);

        final Image scaledImage =
                bufferedImage.getScaledInstance(scaledWidth, scaledHeight,
                        Image.SCALE_SMOOTH);

        // new ImageIcon(image); // load image
        // scaledWidth = scaledImage.getWidth(null);
        // scaledHeight = scaledImage.getHeight(null);

        final BufferedImage scaledBI =
                new BufferedImage(scaledWidth, scaledHeight,
                        BufferedImage.TYPE_INT_RGB);

        final Graphics2D g = scaledBI.createGraphics();

        g.drawImage(scaledImage, 0, 0, null);

        g.dispose();

        return (scaledBI);
    }


    public String md5(String input) throws NoSuchAlgorithmException {
        String result = input;
        if (input != null) {
            MessageDigest md = MessageDigest.getInstance("MD5"); //or "SHA-1"
            md.update(input.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            result = hash.toString(16);
            while (result.length() < 32) { //40 for SHA-1
                result = "0" + result;
            }
        }
        return result;
    }

    public String generateFileName(MultipartFile mpf, String tempFileName) {

        String contentType = mpf.getContentType();
        contentType = "." + contentType.substring(contentType.lastIndexOf("/") + 1);
        return tempFileName + contentType;
    }

    public String getContentType(MultipartFile mpf) {
        String contentType = mpf.getContentType();
        contentType = contentType.substring(contentType.lastIndexOf("/") + 1);
        return contentType;
    }


    public boolean checkSession(HttpSession session, String sessionName) {

        if (session.getAttribute(sessionName) != null || session.getAttribute(sessionName) != "") {

            return true;

        } else {
            return false;
        }


    }


/*	public String getDateTime() {
        String format = "HH:mm:ss";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return getTodaysDateNepali() + " " + sdf.format(cal.getTime());
	}

	public String getTime() {
		String format = "HH:mm";
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
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

	public String getDateAndTime() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(d);
	}

	public String getDateAndTime200() {
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
}
