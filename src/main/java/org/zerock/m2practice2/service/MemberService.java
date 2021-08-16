package org.zerock.m2practice2.service;

import org.zerock.m2practice2.dao.MemberDAO;
import org.zerock.m2practice2.dto.MemberDTO;

public enum MemberService {

    INSTANCE;

    public MemberDTO memberLogin(String mid, String mpw) throws RuntimeException{
        return MemberDAO.INSTANCE.selectForLogin(mid,mpw);
    }

}
