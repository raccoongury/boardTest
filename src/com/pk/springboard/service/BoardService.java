package com.pk.springboard.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pk.springboard.domain.Board;
import com.pk.springboard.domain.Criteria;

public interface BoardService {
	public void register(HttpServletRequest request);
	public List<Board> list();
	public Map<String, Object> list(Criteria criteria);


}

