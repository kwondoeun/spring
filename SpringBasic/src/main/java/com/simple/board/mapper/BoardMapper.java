package com.simple.board.mapper;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.simple.command.BoardVO;

@Mapper
public interface BoardMapper {
	
	public void boardRegist(BoardVO vo);
	public ArrayList<BoardVO> getList();
	public void boardDelete(int num);
	
	

}
