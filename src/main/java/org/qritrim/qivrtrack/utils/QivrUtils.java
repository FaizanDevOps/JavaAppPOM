package org.qritrim.qivrtrack.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.HashMap;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qritrim.connectionManagement.dbConnections;
import com.qritrim.ecryptdecrypt.EncryptDecrypt;




@Repository
public class QivrUtils {
	
	@Value("${qivr.to.agency.details.user}")
	private String user;
	@Value("${qivr.to.agency.details.password}")
	private String password;
	
//	private final String user
//	private final String password = PASSWORD;
	private final String query = "select agency_db_url, agency_db_name from public.agency_details where agency_id = ? ";
	
	@Value("${qivr.to.agency.details.db}")
	private String url;


	public static String returnStackTrace(Exception e) {
		String retString = "";
		if (e != null) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			retString = sw.toString();
		}
		return retString;
	}

	public String encrypt(String text) {
		if (text.length() > 0) {
			EncryptDecrypt encrypt = new EncryptDecrypt();
			String cipherText = encrypt.encryptData(text);
			System.out.println("cipherText ---- " + cipherText);
			return cipherText;
		} else {
			return null;
		}
	}

	public String convertByteTo64(ByteBuffer cipherText) {
		if (cipherText != null) {
			ByteBuffer bb = cipherText.asReadOnlyBuffer();
			bb.position(0);
			byte[] b = new byte[bb.limit()];
			bb.get(b, 0, b.length);
			return Base64.getEncoder().encodeToString(b);
		} else {
			return null;
		}
	}

	public String decrypt(String cipherText) {
		if (cipherText != null && cipherText.length() > 0) {
			EncryptDecrypt decrypt = new EncryptDecrypt();
			String decryptData = decrypt.decryptData(cipherText);
			return decryptData;
		} else {
			return null;
		}
	}

	public ByteBuffer convertBase64ToByte(String text) {
		byte[] decoded = Base64.getDecoder().decode(text);
		ByteBuffer buffer = ByteBuffer.wrap(decoded);
		return buffer;
	}

	public String generateAlphaNumericString(int id, int length) {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(length);

		for (int i = 0; i < length; i++) {

// generate a random number between
// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return String.valueOf(id) + "-" + sb.toString();
	}

	public JdbcTemplate getDBConnection(int agency_Id) {

	//	dbConnections mc = new dbConnections();
		
		BasicDataSource ds = connect(agency_Id);

		JdbcTemplate jt = null;
		try {
			jt = new JdbcTemplate(ds);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jt;
	}

		

		/**
		 * Connect to the PostgreSQL database
		 *
		 * @return a Connection object
		 */
		public BasicDataSource connect(int agency_id) {
			BasicDataSource dataSource = new BasicDataSource();
			
			Connection conn = null;
			try {
				System.out.println("url util----------"+url);
				System.out.println("user util-----------"+user);
				System.out.println("password util------------"+password);
				
				conn = DriverManager.getConnection(url, user, password);
				
				System.out.println("Connected to the PostgreSQL server successfully.");
				HashMap<String, String> connectionMap = new HashMap<String, String>();

				PreparedStatement pss = conn.prepareStatement(query);
				pss.setInt(1, agency_id);

				ResultSet rs = pss.executeQuery();
				while (rs.next()) {
					connectionMap.put("dburl", rs.getString("agency_db_url"));
					connectionMap.put("dbname", rs.getString("agency_db_name"));
				}
				
				EncryptDecrypt encrypt = new EncryptDecrypt();
				String dburl = encrypt.decryptData(connectionMap.get("dburl"));
				String dbname = encrypt.decryptData(connectionMap.get("dbname"));
				
				String url = "jdbc:postgresql://" + dburl + ":5432/" + dbname.replace(" ", "");;

				dataSource.setDriverClassName("org.postgresql.Driver");
				dataSource.setUrl(url);
				dataSource.setUsername("qritrim");
				dataSource.setPassword("aks-Wtt$");
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

		        return dataSource;
		}
}
