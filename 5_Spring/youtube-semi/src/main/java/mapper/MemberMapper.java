package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.semi.youtube.model.vo.Member;

@Mapper
public interface MemberMapper {
	Member check(String id); // member.xml <select id="check" parameterType="String" resultType="Member">
	Member login(Member vo);
	void signup(Member vo);
}
