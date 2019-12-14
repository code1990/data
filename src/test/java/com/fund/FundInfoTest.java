package com.fund;

import com.DataApplication;
import com.dao.fund.FundInfoRepository;
import com.entity.fund.FundInfo;
import com.util.TxtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: data
 * @Date: 2019-12-14 12:26
 * @Author: code1990
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataApplication.class)
public class FundInfoTest {
    @Autowired
    private FundInfoRepository fundInfoRepository;

    String path = "F:\\github\\data\\data\\fund_type\\";

    @Test
    public void getInfo(){
        List<String> list = new ArrayList<>();
        for(File file:new File(path).listFiles()){
            list.add(file.getAbsolutePath());
        }
        path = list.get(5);
        System.out.println(path);
        String topic ="指数型";
        for (String str:TxtUtil.readTxt(path)){

            String[] strArray = str.split("\t");
            FundInfo fundInfo = new FundInfo();
            fundInfo.setFundCode(strArray[1]);
            fundInfo.setFundName(strArray[2]);
            fundInfo.setFundTypeEm(topic);
            fundInfoRepository.save(fundInfo);
            System.out.println(strArray[0]+"\t"+fundInfo.toString());
        }
    }

    @Test
    public void testInsert(){

    }
}
