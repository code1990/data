package com.entity.fund;

import lombok.Data;

import javax.persistence.*;

/**
 * @program: data
 * @Date: 2019-12-14 12:19
 * @Author: code1990
 * @Description:
 */
@Data
@Entity
@Table(name = "t_fund_jz")
public class FundDayValue {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "fund_code")
    private String fundCode;
    @Column(name = "d_01_01")
    private String fundName;
    @Column(name = "fund_type_cx")
    private String fundTypeCx;
    @Column(name = "fund_type_em")
    private String fundTypeEm;
    @Column(name = "fund_lever_cx")
    private String fundLeverCx;
    @Column(name = "fund_style_cx")
    private String fundStyleCx;


}
