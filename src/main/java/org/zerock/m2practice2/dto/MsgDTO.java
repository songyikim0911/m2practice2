package org.zerock.m2practice2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class MsgDTO {

    private Long mno;
    private String who, whom, content;
    private Timestamp regdate, opendate;
}
