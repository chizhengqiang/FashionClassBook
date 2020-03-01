package com.conan.fashionclassbook.utils;

import com.conan.fashionclassbook.pojo.Customer;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * Jwt 工具类
 */
@Slf4j
public class JWTUtil {

    public static final String SUBJECT = "fashion_class_book";

    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7; //过期时间 一周

    public static final String APP_SECRET = "fashion_class_book"; //密钥

    /**
     * 生成 jwt
     *
     * @param customer
     * @return
     */
    public static String geneJsonWebToken(Customer customer) {

        if (customer == null || customer.getId() == null || StringUtils.isBlank(customer.getNickname())) {
            return null;
        }

        String token = Jwts.builder().setSubject(SUBJECT).
                claim("id", customer.getId()).
                claim("nickname", customer.getNickname()).
                setIssuedAt(new Date()).
                setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
        return token;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    public static Claims checkJWt(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
            return claims;

        } catch (Exception e) {
            log.error("【JWT】校验token失败: {} ", e);
            return null;
        }
    }

}
