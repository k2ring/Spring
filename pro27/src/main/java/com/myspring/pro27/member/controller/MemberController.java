package com.myspring.pro27.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.pro27.member.vo.MemberVO;

public interface MemberController {

	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView addMember(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView delMember(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView modMemberForm(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	public ModelAndView updateMember(HttpServletRequest request, HttpServletResponse response) throws Exception;

	public ModelAndView search(@ModelAttribute("member") MemberVO member, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

}