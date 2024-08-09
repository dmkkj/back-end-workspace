package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.ajax.model.vo.Member;

@Mapper // 어노테이션을 지정해야 spring이 읽음
public interface MemberMapper {
	
	Member idCheck(String id);	// MemberService.java로 이동
	void register(Member vo);
}
