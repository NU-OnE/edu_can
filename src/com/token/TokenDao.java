package com.token;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.UUID;

import com.google.gson.Gson;
import com.user.User;
import com.user.UserDao;
import com.utilities.DBConnection;
import com.utilities.ResposeResult;

public class TokenDao {

	Connection con;
	Gson gson = new Gson();
	ResposeResult response = new ResposeResult(true, null);

	/**
	 * - store
	 */
	public ResposeResult store(Token token) {

		try {
			con = DBConnection.connect();
			PreparedStatement stmt = con
					.prepareStatement("insert into api_keys (user_id, token, expire_at) values (?,?,?)");
			java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(token.getExpire_at());

			stmt.setInt(1, token.getUser_id());
			stmt.setString(2, token.getToken());
			stmt.setDate(3, new java.sql.Date(utilDate.getTime()));

			if (stmt.executeUpdate() > 0) {
				response.setIs_error(false);
				response.setResult(gson.toJson(token));
			}

			con.close();

		} catch (Exception e) {
			response.setResult(e.getMessage());
		}

		return response;
	}

	/**
	 * - Get New Token
	 */
	public ResposeResult newToken(User user) {

		UserDao user_dao = new UserDao();
		User new_user = user_dao.getUserByEmail(user);

		if(new_user == null) {
			response.setResult("User not found");
			return response;
		}
		
		String uuid = UUID.randomUUID().toString();
		Token token = new Token(0, new_user.getId(), uuid.replace("-", ""), "2018-12-12", null);
		
		return store(token);
	}

}
