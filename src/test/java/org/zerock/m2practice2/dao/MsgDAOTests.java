package org.zerock.m2practice2.dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.m2practice2.dto.MsgDTO;
@Log4j2
public class MsgDAOTests {

    @Test
    public void testInsert(){

        MsgDTO test = MsgDTO.builder().who("user1").whom("user1").content("test insert").build();

        MsgDAO.INSTANCE.insert(test);

    }

}
