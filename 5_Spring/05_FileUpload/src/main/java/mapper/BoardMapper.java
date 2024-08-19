package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {
// 해당 Mapper에 mapping 해놓기
	void insert(Board vo);
	List<Board> selectAll(Paging paging); // 게시글 목록 조회 메소드 추가
	Board select(int no);
	void update(Board vo);
	void delete(int no);

	// 리턴타입 resultType이 있는지(없을 때는 void), id 메서드, 파라미터타입 있는가
	// <select id="select" parameterType="int" resultType="Board">
	// <update id="update" parameterType="Board">
	// <delete id="delete" parameterType="int">
}
