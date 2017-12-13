package java100.app.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java100.app.dao.DaoException;
import java100.app.dao.MemberDao;
import java100.app.domain.Member;
import java100.app.util.DataSource;
@Component 
public class MemberDaoImpl implements MemberDao {

    // 스프링 IoC 컨테이너가 DataSource 객체를 주입하도록 표시
    @Autowired
    DataSource ds;

    public List<Member> selectList() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "select no,name,email,regdt from ex_memb");
            rs = pstmt.executeQuery();
            ArrayList<Member> list = new ArrayList<>();

            while (rs.next()) {
                Member member = new Member();
                member.setNo(rs.getInt("no"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setCreatedDate(rs.getDate("regdt"));

                list.add(member);
            }
            return list;
        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {rs.close();} catch(Exception e) {}
            try {pstmt.close();} catch(Exception e) {}
            ds.returnConnection(con);
        }


    }

    public int insert(Member member) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "insert into ex_memb(name,email,pwd,regdt) values(?,?,password(?),now())");
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPwd());

            return pstmt.executeUpdate();

        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {pstmt.close();} catch(Exception e) {}
            ds.returnConnection(con);
        }
    }

    public int update(Member member) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "update ex_memb set name=?,email=?,pwd=password(?) where no=?");
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPwd());
            pstmt.setInt(4, member.getNo());


            // executeUpdate()의 리턴값은 변경된 레코드들의 개수이다.
            // 만약 해당 번호와 일치하는 데이터를 찾지 못해 변경할게 없다면 0을 리턴한다.
            return pstmt.executeUpdate();

        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {pstmt.close();} catch(Exception e) {}
            ds.returnConnection(con);
        }
    }

    public int delete(int no) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "delete from ex_memb where no=?");
            pstmt.setInt(1, no);

            return pstmt.executeUpdate();
        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {pstmt.close();} catch(Exception e) {}
            ds.returnConnection(con);
        }
    }

    public Member selectOne(int no) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            con = ds.getConnection();
            pstmt = con.prepareStatement(
                    "select no,name,email,regdt from ex_memb where no=?");
            pstmt.setInt(1, no);

            rs = pstmt.executeQuery();
            Member member = null;

            if (rs.next()) {
                member = new Member();
                member.setNo(no);
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setCreatedDate(rs.getDate("regdt"));
            }
            rs.close();
            return member;
        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {rs.close();} catch(Exception e) {}
            try {pstmt.close();} catch(Exception e) {}
            ds.returnConnection(con);
        }

    }

}
