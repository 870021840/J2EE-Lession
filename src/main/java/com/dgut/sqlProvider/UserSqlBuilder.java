package com.dgut.sqlProvider;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlBuilder {

    public static String buildGetUsersByName(final String name,final String address) {
        return new SQL(){{
            SELECT("*");
            FROM("user");
            if (name != null) {
                WHERE("username = #{param1}");
            }
            if (address !=null){
                WHERE("address = #{param2}");
            }
        }}.toString();
    }
}
