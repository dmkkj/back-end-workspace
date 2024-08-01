package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.mybatis.model.dto.SearchDTO;
import com.kh.mybatis.model.vo.Member;

// member.xml이랑 연결됨. 1:1 매핑
@Mapper
public interface MemberMapper {
	void register(Member member); // 1:1 Mapping. (Member member의 member) -> member.xml > parameterType="com.kh.mybatis.model.vo.Member에 담김
	List<Member> allMember();
	Member login(Member member); // MemberMapper.java -> MemberService.java로 이동
	void update(Member member);
//	void updatePwd(Member member);
	List<Member> search(SearchDTO dto);
	void delete(List<String> idList);	// void delete(String id);
}

