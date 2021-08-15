package org.zerock.m2practice2.dao;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.m2practice2.dto.MsgDTO;

@Log4j2
public enum MsgDAO {


    INSTANCE;


    public static final String SQL_INSERT = "insert into tbl_msg (who,whom,content) values (?,?,?)";


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


}
