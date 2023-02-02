package com.simple.score.dao;

import java.util.ArrayList;

import com.simple.command.ScoreVO;

public interface ScoreDAO {
	public void regist(ScoreVO vo); //대부분 ServiceImpl과 동일
	public ArrayList<ScoreVO> getList();
	public void delete(int num);
}
