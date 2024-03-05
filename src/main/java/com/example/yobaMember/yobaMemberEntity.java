/*
 * title : yobaMemberEntity.java
 * 설명 : yoba 테이블 엔티티
 * 작성자 : 박민기
 * 생성일 : 2024.02.20
 * 업데이트 : 2024.02.20
 */
package com.example.yobaMember;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Getter
@Setter
@ToString
@Component
public class yobaMemberEntity {

    int id;
    String name;
    String email;
    String password;
    String money;
    String position;
    Date regdate;
    int readcnt;
    String address;
    String phone;
}
