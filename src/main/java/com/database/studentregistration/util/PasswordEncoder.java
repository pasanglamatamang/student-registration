//package com.database.studentregistration.util;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class PasswordEncoder {
//
//    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
//
//    public static String encodePassword(String password) {
//        return bCryptPasswordEncoder.encode(password);
//    }
//
//    public static boolean matchPassword(String rawPassword, String encodedPassword) {
//        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
//    }
//}
