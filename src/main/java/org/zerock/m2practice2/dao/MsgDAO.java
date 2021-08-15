package org.zerock.m2practice2.dao;

import lombok.extern.log4j.Log4j2;
import org.zerock.m2practice2.dto.MsgDTO;

@Log4j2

public enum MsgDAO {

    INSTANCE;

    private static final String SQL_INSERT = "insert into tbl_msg (who,whom,content) values (?,?,?)";

    private static final String SQL_SELECT = "select mno, who, whom, content, regdate," +
            "opendate from tbl_msg where mno=?";

    private static final String SQL_UPDATE_OPEN = "update tbl_msg set opendate = now() where mno = ?";

    public void insert(MsgDTO msgDTO) throws RuntimeException{
        new JdbcTemplate(){
            @Override
            protected void execute() throws Exception {
                int idx = 1;
                preparedStatement = connection.prepareStatement(SQL_INSERT);
                preparedStatement.setString(idx++, msgDTO.getWho());
                preparedStatement.setString(idx++, msgDTO.getWhom());
                preparedStatement.setString(idx++, msgDTO.getContent());

                int count = preparedStatement.executeUpdate();
                log.info("count:" + count);
            }
        }.makeAll();
    }


    public MsgDTO select(Long mno) throws RuntimeException{
        MsgDTO msgDTO = MsgDTO.builder().build();
        new JdbcTemplate(){
            @Override
            protected void execute() throws Exception {
               preparedStatement = connection.prepareStatement(SQL_UPDATE_OPEN);
               preparedStatement.setLong(1,mno);

               preparedStatement.executeUpdate();

               preparedStatement.close();
               preparedStatement = null;

               preparedStatement = connection.prepareStatement(SQL_SELECT);
               preparedStatement.setLong(1, mno);
               resultSet = preparedStatement.executeQuery();

               resultSet.next();

               msgDTO.setMno(resultSet.getLong(1));
               msgDTO.setWho(resultSet.getString(2));
               msgDTO.setWhom(resultSet.getString(3));
               msgDTO.setContent(resultSet.getString(4));
               msgDTO.setRegdate(resultSet.getTimestamp(5));

               msgDTO.setOpendate(resultSet.getTimestamp(6));
            }
        }.makeAll();
        return msgDTO;
    }


}
