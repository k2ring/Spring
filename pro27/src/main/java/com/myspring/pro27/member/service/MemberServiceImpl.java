package com.myspring.pro27.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro27.member.dao.MemberDAO;
import com.myspring.pro27.member.vo.MemberVO;

@Service(value = "memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List<MemberVO> listMembers() throws DataAccessException {
		List<MemberVO> membersList = null;
		membersList = memberDAO.selectAllMembers();
		return membersList;
	}

	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		int result = memberDAO.addMember(memberVO);
		return result;

	}

	@Override
	public int updateMember(MemberVO member) throws DataAccessException {
		return memberDAO.updateMember(member);
	}

	@Override
	public int delMember(String id) throws DataAccessException {

		return memberDAO.delMember(id);

	}

	@Override
	public List<MemberVO> searchMember(String memberName) throws DataAccessException {
		List<MemberVO> membersList = memberDAO.searchMemberbyName(memberName);
		return membersList;
	}

	@Override
	public MemberVO searchMemberID(String memberName) throws DataAccessException {
		MemberVO memberVO = memberDAO.searchMemberbyID(memberName);
		return memberVO;
	}

	@Override
	public List selectMemberByNameOrEmail(String nameOrEmail) throws DataAccessException {
		List memberList = memberDAO.selectMemberByNameOrEmail(nameOrEmail);
		return memberList;
	}

	@Override
	public MemberVO searchMemberbyID(String id) throws DataAccessException {
		MemberVO memberVO = memberDAO.searchMemberbyID(id);
		return memberVO;
	}

}