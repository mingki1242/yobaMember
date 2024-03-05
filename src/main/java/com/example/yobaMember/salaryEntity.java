/*
 * title : salaryEntity.jaca
 * 설명 : 월급 정산 내역 저장 entitu
 * 작성자 : 박민기
 * 생성일 : 2024.03.06
 * 업데이트 : 2024.03.06
 */
package com.example.yobaMember;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class salaryEntity {
    int id;
    String yoba_email;
    String salary_details;
}
