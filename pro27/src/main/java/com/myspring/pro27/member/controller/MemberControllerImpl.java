package com.myspring.pro27.member.controller;

import java.util.List;
import com.myspring.pro27.member.vo.MemberVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.myspring.pro27.member.dao.MemberDAO;
import com.myspring.pro27.member.dao.MemberDAOImpl;
import com.myspring.pro27.member.service.MemberService;

@Controller(value = "memberController")
public class MemberControllerImpl implements MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberControllerImpl.class);
	

	@Autowired
	private MemberService memberService;

	@Autowired
	MemberVO memberVO;

	@Override
	@RequestMapping(value = "/member/listMembers.do", method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List<MemberVO> membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		System.out.println(viewName);
		logger.info("로그", viewName);
		return mav;
	}

	@RequestMapping(value = "/member/memberForm.do", method = RequestMethod.GET)
	public ModelAndView memberForm(MemberVO member, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberForm");
		return mav;
	}

	@RequestMapping(value = "/member/addMember.do", method = RequestMethod.POST)
	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("회원 추가 코드 동작");
		MemberVO memberVO = new MemberVO();
		int result = 0;
		result = memberService.addMember(member);
		return new ModelAndView("redirect:/member/listMembers.do");

	}

	@Override
	@RequestMapping(value = "/member/delMember.do", method = RequestMethod.GET)
	public ModelAndView delMember(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MemberVO memberVO = new MemberVO();
		int result = 0;
		result = memberService.delMember(id);
		return new ModelAndView("redirect:/member/listMembers.do");
	}

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}

	@Override
	@RequestMapping(value = "/member/modMemberForm.do", method = RequestMethod.GET)
	public ModelAndView modMemberForm(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String viewName = getViewName(request);
		System.out.println(viewName);
		ModelAndView mav = new ModelAndView(viewName);

		return mav;
	}

	@Override
	@RequestMapping(value = "/member/modMember.do", method = RequestMethod.POST)
	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		MemberVO memberVO = new MemberVO(id, pwd, name, email);
		memberService.updateMember(memberVO);
		ModelAndView mav = new ModelAndView();
		List<MemberVO> memberList = memberService.listMembers();
		mav.addObject("memberLsit", memberList);
		mav.setViewName("redirect:/member/listMembers.do");
		return mav;
	}
	
	
	@RequestMapping(value="/member/member.do", method = RequestMethod.GET)
	public ModelAndView search(MemberVO member, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action = request.getParameter("action");
		System.out.println("액션 값" + action);

		ModelAndView mav = new ModelAndView();
		if (action.equals("searchMember")) {
			List<MemberVO> membersList = searchMember(request, response);
			mav.addObject("membersList", membersList);
			System.out.println("회원 이름 조회");
			mav.setViewName("/listMembers");

		} else if (action.equals("listMembers")) {
			List<MemberVO> membersList = memberService.listMembers();
			mav.addObject("membersList", membersList);
			System.out.println("전체 조회");
			mav.setViewName("/listMembers");

		} else if (action.equals("selectMemberById")) {
			MemberVO member1 = searchMemberID(request, response);
			mav.addObject("member", member1);
			System.out.println("회원 아이디 조회");
			mav.setViewName("/listMembers");

		} else if (action.equals("selectMemberByNameOrEmail")) {
			List<MemberVO> membersList = selectMemberByNameOrEmail(request, response);
			mav.addObject("membersList", membersList);
			System.out.println("4");
			mav.setViewName("/listMembers");
		}

		return mav;
	}

	private List<MemberVO> searchMember(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("회원 이름 검색 코드 작성");
		String memberName = request.getParameter("value");
		System.out.println(memberName);
		ModelAndView mav = new ModelAndView();
		List<MemberVO> membersList = memberService.searchMember(memberName);
		return membersList;
	}

	private MemberVO searchMemberID(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("회원 이름 검색 코드 작성");
		String memberName = request.getParameter("value");
		System.out.println(memberName);
		ModelAndView mav = new ModelAndView();
		MemberVO memberVO = memberService.searchMemberID(memberName);
		return memberVO;
	}

	private List selectMemberByNameOrEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("회원 이름 및 이메일 검색 코드 작성");
		String nameOrEmail = request.getParameter("value");
		System.out.println(nameOrEmail);
		List membersList = memberService.selectMemberByNameOrEmail(nameOrEmail);
		return membersList;
	}

	
	
}