package com.honger1234.springbootprojectseed.util;

import com.honger1234.springbootprojectseed.exception.TokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @Description: JWT工具类
 * @author: zt
 */
@Slf4j
public class JWTUtil {

    private static String SECRET="WgtqaT1HNTZPZNMDJu3k" ;

    private static long EXPIRE=15;//失效时间,60分钟

    /**
     * 生成token
     *
     * @param uid
     * @return
     */
    public static String generate(String uid,String subject) {
        Date nowDate = new Date();
        //过期时间
        Date expireDate = new Date(nowDate.getTime() + EXPIRE * 60*1000);
//        Map<String, Object> claims = new HashMap<>(1);
//        claims.put("id", uid);
        return Jwts.builder()
                .setId(uid) //jwt的唯一标识
                .setSubject(subject) //代表这个jwt的主体
//                .setClaims(claims)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    /**
     * 解析Claims
     *
     * @param token
     * @return
     */
    public static Claims getClaim(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.error("token解析错误", e);
            throw new TokenException("无效的token");
        }
        return claims;
    }

    /**
     * 获取jwt发布时间
     */
    public static Date getIssuedAt(String token) {
        return getClaim(token).getIssuedAt();
    }

    /**
     * 获取UID
     */
    public static String getUid(String token) {
        return (String) getClaim(token).get("id");
//        return TypeUtils.castToInt(getClaim(token).get(UID));
    }

    /**
     * 获取jwt失效时间
     */
    public static Date getExpiration(String token) {
        return getClaim(token).getExpiration();
    }

    /**
     * 验证token是否失效
     *
     * @param token
     * @return true:过期   false:没过期
     */
    public static boolean isExpired(String token) {
        try {
            Date expiration = getExpiration(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    public static void main(String[] args){
//        String s = generate("22", "哈哈");
//        System.out.println(s);
        String token="eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiIyMiIsInN1YiI6IuWTiOWTiCIsImlhdCI6MTU5NzM3Njg2NCwiZXhwIjoxNTk3Mzc3NzY0fQ.t9UMVGbNA1EHEzV11q9aJoS1NQKWhJrQeMOUPdQjt1s781dt_5dNa6qLxBBR0RTCflm3sgrxtxvr5Vpv-NbeNA";
        boolean expired = isExpired(token);
        System.out.println(expired);
    }

}
