/*
 * title : yobaMemberDao.java
 * 설명 : 데이터 베이스 접근 sql 쿼리
 * 작성자 : 박민기
 * 생성일 : 2024.02.20
 * 업데이트 : 2024.03.06
 */

package com.example.yobaMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class yobaMemberDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public yobaMemberEntity findByEmail(String email) {
        String sql = "SELECT * FROM yoba WHERE email = ?";
        RowMapper<yobaMemberEntity> rowMapper = new BeanPropertyRowMapper<>(yobaMemberEntity.class);
        try {
            return jdbcTemplate.queryForObject(sql, rowMapper, email);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //회원가입 디비 저장 로직
    public void registMember(yobaMemberEntity member)
    {
        String sql = "Insert into yoba (name , email , password , money , position , address ,phone,regdate) values(?,?,?,?,?,?,?,NOW())";
        jdbcTemplate.update(sql,member.getName(),member.getEmail(),member.getPassword(),member.getMoney(),member.getPosition(),member.getAddress(),member.getPhone());
    }

    //회원 탈퇴 로직
    public void deleteMember(int id)
    {
        String sql = "delete from yoba where id = ?";
        jdbcTemplate.update(sql , id);
    }

    //회원 리스트 불러오기
    public ArrayList<yobaMemberEntity> loadMembers()
    {
        String sql = "select * from yoba order by id";
        return (ArrayList<yobaMemberEntity>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(yobaMemberEntity.class));
    }

    //룸 직원 불러오기
    public roomEntity loadRoomMembers()
    {
        String sql = "select * from room where id = 1";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(roomEntity.class));
    }

    //월급 디비 저장
    public void InsertSalary(String email , String text)
    {
        String sql = "Insert into salary (yoba_email , salary_details) values(?,?)";
        jdbcTemplate.update(sql , email,text);
    }

    //월급 정보 불러오기
    public salaryEntity loadSalary(String email)
    {
        String sql = "select * from salary where yoba_email = ?";
        try{
            return jdbcTemplate.queryForObject(sql , new Object[]{email}, new BeanPropertyRowMapper<>(salaryEntity.class));
        }catch (EmptyResultDataAccessException e)
        {
            return null;
        }

    }

    //월급 정보 디비에 있는지 확인
    public boolean IsEmail(String email) {
        String sql = "SELECT COUNT(*) FROM salary WHERE yoba_email = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count > 0;
    }


    //월급 정보 수정 저장
    public void modifySalary(String email, String text) {
        String sql = "UPDATE salary SET salary_details = ? WHERE yoba_email = ?";
        jdbcTemplate.update(sql, text, email);
    }



}

