package com.pk.springboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pk.springboard.domain.Board;
import com.pk.springboard.domain.Criteria;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	public void register(Board vo) {
		sqlSession.insert("board.register", vo);
	}
	public List<Board> list() {
		return  sqlSession.selectList("board.list");
	}
	
	public int totalCount() {
		return sqlSession.selectOne("board.totalCount");
	}

	public List<Board> list(Criteria criteria) {
		return sqlSession.selectList("board.list", criteria);
	}

}
