package com.luke.service;

import java.util.Map;

import com.luke.model.User;

public interface ILoginService {

	Map<String,Object> userLogin(String encryptedData, String iv, String code, User user);

}
