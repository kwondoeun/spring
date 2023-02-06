package com.simple.score.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.simple.command.ScoreVO;
import com.simple.score.dao.ScoreDAO;
import com.simple.score.mapper.ScoreMapper;

//@Service//@Component//@Repository//@Controller //서비스영역이니 service사용
@Service("xxx") //bean의 이름 명시
public class ScoreServiceImpl implements ScoreService{
	
	//마이바티스 매퍼
	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public void regist(ScoreVO vo) {
		scoreMapper.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		return scoreMapper.getList();
	}

	@Override
	public void delete(int num) {
		scoreMapper.delete(num);
	}
	
	/*
	@Autowired
	@Qualifier("yyy")
	private ScoreDAO scoreDAO;
	
	public void regist(ScoreVO vo) {
		scoreDAO.regist(vo);
	}

	@Override
	public ArrayList<ScoreVO> getList() {
		
		//ArrayList<ScoreVO> list = scoreDAO.getList();
		
		return scoreDAO.getList();
	}

	@Override
	public void delete(int num) {
		scoreDAO.delete(num);
		
	}
	*/

}
