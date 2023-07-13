package com.myspring.pro27.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro27.member.vo.MemberVO;

public interface MemberService {
	public List listMembers() throws DataAccessException;

	public int addMember(MemberVO member) throws DataAccessException;

	public int delMember(String id) throws DataAccessException;

	public int updateMember(MemberVO member) throws DataAccessException;

	public MemberVO searchMemberbyID(String id) throws DataAccessException;

	public List<MemberVO> searchMember(String memberName) throws DataAccessException;

	public MemberVO searchMemberID(String memberName) throws DataAccessException;

	public List selectMemberByNameOrEmail(String nameOrEmail) throws DataAccessException;
}