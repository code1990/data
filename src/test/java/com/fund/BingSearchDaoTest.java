package com.fund;

import com.util.BingSearchDao;
import com.util.TxtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @program: data
 * @Date: 2019-12-29 9:42
 * @Author: code1990
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BingSearchDaoTest {
    @Autowired
    private BingSearchDao dao;
    private String userName = System.getProperty("user.name");
    private String kwPath = "C:\\Users\\" + userName + "\\Desktop\\bing\\keyword.txt";
    private List<String> kwList = TxtUtil.readTxt(kwPath);

    @Test
    public void testInfo(){
        for (int i = 0; i <kwList.size() ; i++) {
            System.out.println(kwList.get(i));
        }
    }

    @Test
    public void getInfo(){
       /* String type ="drop";*/
        String type ="create";
        List<String> list = dao.getAllPageInfoByType(kwList,type);
        System.out.println(list.size());
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void insertTest(){
//        Long count = dao.checkKwInfo();
//        System.out.println(count);
        if ( kwList.size()!=0){
            List<Map<String, String>> list = dao.getKwMapInfo(kwList);
            List<List<Map<String, String>>> mapList = getListMapGroup(list,3);
//            List<Map<String, String>> list = dao.getKwMapInfo(kwList);
            for (int i = 0; i <mapList.size() ; i++) {
                List<Map<String, String>> list2 = mapList.get(i);
                dao.insertKwInfo(list2,i+1);
//                Map<String, String> map = list.get(i);
//                System.out.println(Arrays.toString(list2.toArray()));
            }
//            dao.insertKwInfo(list);
        }else{
//            String min = dao.getMinKwInfo();
//            if(min==null){
//                assert 0!=0;
//            }else{
//                System.out.println(kwList.get(new Integer(min)-1));
//            }
        }
    }


    public List<List<Map<String, String>>> getListMapGroup(List<Map<String, String>> taskList,int threadNum){
        List<List<Map<String, String>>> list = new ArrayList<>();
        int total = taskList.size();
        int remaider = total % threadNum; // 计算出余数
        int number = total / threadNum; // 计算出商
        int offset = 0;// 偏移量
        for (int i = 0; i < threadNum; i++) {
            if (remaider > 0) {
                List<Map<String, String>> subList = taskList.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
                list.add(subList);
            } else {
                List<Map<String, String>> subList = taskList.subList(i * number + offset, (i + 1) * number + offset);
                list.add(subList);
            }
        }
        return list;
    }

    /*public List<List<String>> getListGroup(List<String> taskList,int threadNum){
        List<List<String>> list = new ArrayList<>();
        int total = taskList.size();
        int remaider = total % threadNum; // 计算出余数
        int number = total / threadNum; // 计算出商
        int offset = 0;// 偏移量
        for (int i = 0; i < threadNum; i++) {
            if (remaider > 0) {
                List<String> subList = taskList.subList(i * number + offset, (i + 1) * number + offset + 1);
                remaider--;
                offset++;
                list.add(subList);
            } else {
                List<String> subList = taskList.subList(i * number + offset, (i + 1) * number + offset);
                list.add(subList);
            }
        }
        return list;
    }*/

    @Test
    public void testInfo1111(){
        List<String> list = dao.getAllKwList(1);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

    }
}
