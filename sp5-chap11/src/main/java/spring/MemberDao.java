package spring;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

public class MemberDao {

    private JdbcTemplate jdbcTemplate;

    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Member selectByEmail(String email) {
//        List<Member> results = jdbcTemplate.query(
//                "select * from MEMBER where EMAIL = ?",
//                (rs, rowNum) -> {
//                    Member member = new Member(
//                            rs.getString("EMAIL"),
//                            rs.getString("PASSWORD"),
//                            rs.getString("NAME"),
//                            rs.getTimestamp("REGDATE").toLocalDateTime());
//                    member.setId(rs.getLong("ID"));
//                    return member;
//                }, email
//
//        );
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER WHERE EMAIL = ?",
                new MemberRowMapper(),
                email
        );
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(Member member) {
        // KeyHolder를 통한 auto_increment ID 값 가져오기
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
            // 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
            PreparedStatement pstmt = con.prepareStatement(" insert into MEMBER(EMAIL, PASSWORD, NAME, REGDATE) values (?,?,?,?)", new String[] {"ID"});
            pstmt.setString(1, member.getEmail());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));

            // 생성한 PreparedStatement 객체 리턴
            return pstmt;
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }

    public void update(Member member) {
        jdbcTemplate.update("update MEMBER set NAME = ?, PASSWORD = ? WHERE EMAIL = ?", member.getName(), member.getPassword(), member.getEmail());
    }

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query(
                "select * from MEMBER",
                new MemberRowMapper());
        return results;
    }

    // 가져올 row가 하나 밖에 없을 경우 queryForObject로 가져오면 List형식이 아닌 값으로 가져올 수 있음
    public int count() {
        Integer count = jdbcTemplate.queryForObject(
                "select count(*) from MEMBER", Integer.class
        );
        return count;
    }

}
