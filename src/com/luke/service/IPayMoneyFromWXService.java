package com.luke.service;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IPayMoneyFromWXService {

	Map pay(String openid, BigDecimal total_fee,String body,String spbill_create_ip);

}
