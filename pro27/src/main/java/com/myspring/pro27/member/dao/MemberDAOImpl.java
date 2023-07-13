package com.myspring.pro27.member.dao;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List selectAllMembers() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.insertMember", memberVO);
		return result;
	}

	public int delMember(String id) throws DataAccessException {
		int result = sqlSession.delete("mapper.member.deleteMember", id);
		return result;
	}

	@Override
	public int updateMember(MemberVO memberVO) throws DataAccessException {
		int result = sqlSession.insert("mapper.member.updateMember", memberVO);
		return 0;
	}

	@Override
	public MemberVO searchMemberbyID(String id) throws DataAccessException {
		MemberVO memberVO = (MemberVO) sqlSession.selectOne("mapper.member.searchMemberbyID", id);
		return memberVO;
	}

	@Override
	public List searchMemberbyName(String memberName) throws DataAccessException {
		List membersList = sqlSession.selectList("mapper.member.searchMemberbyName", memberName);
		return membersList;
	}

	@Override
	public List selectMemberByNameOrEmail(String nameOrEmail) throws DataAccessException {
		List membersList = sqlSession.selectList("mapper.member.selectMemberByNameOrEmail", nameOrEmail);
		return membersList;
	}

}