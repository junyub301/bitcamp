package java100.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java100.app.domain.Board;
import java100.app.util.DataSource;

public class BoardDao {

    public List<Board> selectList() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(
                    "select no,title,regdt,vwcnt from ex_board");
            rs = pstmt.executeQuery();
            ArrayList<Board> list = new ArrayList<>();
            while (rs.next()) {
                Board board = new Board();
                board.setNo(rs.getInt("no"));
                board.setTitle(rs.getString("title"));
                board.setRegDate(rs.getDate("regdt"));
                board.setViewCount(rs.getInt("vwcnt"));

                list.add(board);
            }
            return list;
        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {rs.close();} catch(Exception e) {}
            try {pstmt.close();} catch(Exception e) {}
            DataSource.returnConnection(con);
        }

    }

    public int insert(Board board) {
        Connection con = null;
        PreparedStatement pstmt = null;


        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(
                    "insert into ex_board(title,conts,regdt) values(?,?,now())");
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());

            return pstmt.executeUpdate();

        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {pstmt.close();} catch(Exception e) {}
            DataSource.returnConnection(con);
        }

    }

    public int update(Board board) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(
                    "update ex_board set title=?,conts=? where no=?");
            pstmt.setString(1, board.getTitle());
            pstmt.setString(2, board.getContent());
            pstmt.setInt(3, board.getNo());


            // executeUpdate()의 리턴값은 변경된 레코드들의 개수이다.
            // 만약 해당 번호와 일치하는 데이터를 찾지 못해 변경할게 없다면 0을 리턴한다.
            return pstmt.executeUpdate();
        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {pstmt.close();} catch(Exception e) {}
            DataSource.returnConnection(con);
        }

    }

    public int delete(int no) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DataSource.getConnection();
            pstmt = con.prepareStatement(
                    "delete from ex_board where no=?");
            pstmt.setInt(1, no);

            return pstmt.executeUpdate();

        } catch (Exception e ) {
            throw new DaoException();
        } finally {
            try {pstmt.close();} catch(Exception e) {}
            DataSource.returnConnection(con);
        }

    }

    public Board selectOne(int no) {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            try { 
                con = DataSource.getConnection();
                pstmt = con.prepareStatement(
                        "update ex_board set vwcnt=vwcnt+1 where no=?");
                pstmt.setInt(1, no);
                pstmt.executeUpdate();

            } catch(Exception e) {throw e;}

            try {
                con = DataSource.getConnection();
                pstmt = con.prepareStatement(
                        "select no,title,conts,regdt,vwcnt from ex_board where no=?");
                pstmt.setInt(1, no);

                rs = pstmt.executeQuery();
                Board board = null;
                if (rs.next()) {
                    board = new Board();
                    board.setNo(rs.getInt("no"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("conts"));
                    board.setRegDate(rs.getDate("regdt"));
                    board.setViewCount(rs.getInt("vwcnt"));
                }
                rs.close();
                return board;
            } catch(Exception e) {throw e;}
            
        } catch (Exception e ) {
            throw new DaoException();
        }finally {
            DataSource.returnConnection(con);
        }

    }

}