package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;

@Mapper
public interface BoardMapper {

	void register(Board board);
	List<Board> allBoard(); // 게시글 목록 조회 메소드 추가
}
