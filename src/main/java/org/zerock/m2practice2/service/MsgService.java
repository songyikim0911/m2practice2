package org.zerock.m2practice2.service;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.zerock.m2practice2.dao.MsgDAO;
import org.zerock.m2practice2.dto.MsgDTO;

import java.util.List;
import java.util.Map;

@Log4j2
public enum MsgService {
    INSTANCE;

    public void register(MsgDTO msgDTO) throws RuntimeException{
        log.info("service register..." +msgDTO);
        MsgDAO.INSTANCE.insert(msgDTO);

    }

    public Map<String, List<MsgDTO>> getList(String user) throws RuntimeException{

        long start= System.currentTimeMillis();

        Map<String, List<MsgDTO>> result = MsgDAO.INSTANCE.selectList(user);

        long end = System.currentTimeMillis();

        log.info("TIME:" + (end - start));

        return result;

    }

    public MsgDTO read(Long mno) throws RuntimeException{
        return MsgDAO.INSTANCE.select(mno);
    }

}
