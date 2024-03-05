/*
 * title : roomEntity.java
 * 설명 : 룸 배치 내역 저장 Entity
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
public class roomEntity {
    int id;
    String F;
    String E;
    String B;
    String A;
    String CD;
    String BACKUP;
}
