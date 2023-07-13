package com.myspring.pro27.member.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.member.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMembers() throws DataAccessException;

	public int addMember(MemberVO memberVO) throws DataAccessException;

	public int delMember(String id) throws DataAccessException;

	public int updateMember(MemberVO memberVO) throws DataAccessException;

	public MemberVO searchMemberbyID(String id) throws DataAccessException;

	public List<MemberVO> searchMemberbyName(String memberName) throws DataAccessException;

	public List<MemberVO> selectMemberByNameOrEmail(String nameOrEmail) throws DataAccessException;
}