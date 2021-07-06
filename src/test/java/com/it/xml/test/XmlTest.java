package com.it.xml.test;

import com.alibaba.fastjson.JSONObject;
import com.it.entity.User;
import com.it.entity.XmlEntity;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;
import sun.font.AttributeMap;

import javax.xml.transform.Source;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author LY
 * @PackageName:com.it.xml.test
 * @ClassName:XmlTest
 * @date 2021/6/18 15:27
 * 类说明: <br>
 */
@SpringBootTest
public class XmlTest {

    @Test
    public void test01() throws IOException {
        User user = new User();
        user.setName("111");
        user.setPassword("23r4234");
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        // 创建一个根节点
        Element root = document.addElement("ufinterface");
        // 给根节点添加相关属性
        root.addAttribute("account", "0517")
                .addAttribute("billtype", "vouchergl")
                .addAttribute("businessunitcode", "0001")
                .addAttribute("filename", "xbftglf2bff2b597a411eb8ddc")
                .addAttribute("groupcode", "000")
                .addAttribute("isexchange", "Y")
                .addAttribute("orgcode", "306")
                .addAttribute("receiver", "306")
                .addAttribute("replace", "Y")
                .addAttribute("roottag", "Y")
                .addAttribute("sender", "rent");
        // 创建跟结点的第一级子结点
        // 创建第二级子节点
        Element secondElement = root.addElement("voucher").addAttribute("id", "f2bff2b597a411eb8ddc").addElement("voucher_head");
        // 创建第三级结点
        // 凭证自生成id
        secondElement.addElement("pk_voucher").addText("f2bff2b597a411eb8ddc");
        // 默认值
        secondElement.addElement("year").addText("2021");
        secondElement.addElement("pk_accountingbook").addText("306-0001");
        secondElement.addElement("prepareddate").addText("2021-02-28");
        secondElement.addElement("pk_vouchertype").addText("01");// -
        secondElement.addElement("pk_system").addText("GL");//-
        secondElement.addElement("voucherkind").addText("0");//-
        secondElement.addElement("discardflag").addText("N");//-
        secondElement.addElement("period").addText("2021-02");
        secondElement.addElement("no");
        secondElement.addElement("attachment").addText("0");//-
        secondElement.addElement("pk_prepared").addText("RENT");//-
        secondElement.addElement("pk_casher");
        secondElement.addElement("signflag").addText("Y");//-
        secondElement.addElement("pk_checked");
        secondElement.addElement("tallydate");
        secondElement.addElement("pk_manager");
        secondElement.addElement("memo1");
        secondElement.addElement("memo2");
        secondElement.addElement("reserve1");
        secondElement.addElement("reserve2").addText("N");//-
        secondElement.addElement("siscardflag");
        secondElement.addElement("pk_group").addText("000");//-
        // 创建第三层结点用于引出第四层结点
        secondElement.addElement("pk_org").addText("306");
        secondElement.addElement("pk_org_v").addText("306");
        Element details = secondElement.addElement("details");
        // 创建第四层结点
        Element item = details.addElement("item");
        item.addElement("creditquantity");
        item.addElement("creditamount").addText("0.00");
        item.addElement("localcreditamount").addText("0.00");
        item.addElement("groupcreditamount");
        item.addElement("globalcreditamount");
        item.addElement("debitquantity");
        item.addElement("debitamount").addText("7989.84");
        item.addElement("localdebitamount").addText("7989.84");
        item.addElement("groupdebitamount");
        item.addElement("globaldebitamount");
        item.addElement("detailindex").addText("1");
        item.addElement("explanation").addText("杭州凯德来福士店分摊贾国慧分部02月支部人员费用");
        item.addElement("verifydate");
        item.addElement("price");
        item.addElement("excrate2").addText("1");
        item.addElement("pk_currtype").addText("CNY");
        item.addElement("pk_accasoa").addText("660258");
        item.addElement("pk_unit");
        item.addElement("pk_unit_v");
        // 创建第五层结点
        Element ass = item.addElement("ass");
        Element item1 = ass.addElement("item");
        item1.addElement("pk_Checktype").addText("0001");
        item1.addElement("pk_Checkvalue").addText("20119");
        Element item2 = ass.addElement("item");
        item2.addElement("pk_Checktype").addText("0002");
        item2.addElement("pk_Checkvalue").addText("34001");

        // 自定义xml样式
        OutputFormat outputFormat = new OutputFormat();
        // 一个结点为一行
        outputFormat.setNewlines(true);
        outputFormat.setTrimText(true);
        // 去重空格
        outputFormat.setPadText(true);
        // 放置xml文件中第二行为空白行
        outputFormat.setNewLineAfterDeclaration(false);
        XmlTest xmlTest = new XmlTest();
        String s = document.asXML();
        System.out.println(s);
        // 输出xml文件

       /* XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File("E:\\dom4j.xml")), outputFormat);
        xmlWriter.write(document);
        System.out.println("success");*/

    }

    @Test
    public void test02() {
        String s = getString();
        System.out.println(s);
    }

    public String getString() {
        XmlEntity root = new XmlEntity();
        root.setName("ufinterface");
        Map<String, Object> attributeMap = new HashMap<>();
        attributeMap.put("account", "0517");
        attributeMap.put("billtype", "vouchergl");
        attributeMap.put("businessunitcode", "0001");
        attributeMap.put("filename", "xbftglf2bff2b597a411eb8ddc");
        attributeMap.put("groupcode", "000");
        attributeMap.put("isexchange", "Y");
        attributeMap.put("orgcode", "306");
        attributeMap.put("receiver", "306");
        attributeMap.put("replace", "Y");
        attributeMap.put("roottag", "Y");
        attributeMap.put("sender", "rent");
        root.setAttribute(attributeMap);


        // map 对象 list
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> rootMap = new HashMap<>();

        Map<String, Object> elememtMap = new HashMap<>();
        Map<String, Object> firstElementMap = new HashMap<>();
        Map<String, Object> firstAttributeMap = new HashMap<>();
        firstAttributeMap.put("id", "f2bff2b597a411eb8ddc");
        // --------------------------------------------------
        // 构建子节点
        Map<String, Object> secodeElementMap = new HashMap<>();
        // 存储secodeElementMap的子节点信息
        Map<String, Object> voucherHeadMap = new HashMap<>();
        Map<String, Object> aElementMap = new HashMap<>();
        voucherHeadMap.put("element", aElementMap);
        aElementMap.put("pk_voucher", getMap("f2bff2b597a411eb8ddc"));
        aElementMap.put("pk_vouchertype", getMap("01"));
        aElementMap.put("year", getMap("2021"));
        aElementMap.put("pk_system", getMap("GL"));
        aElementMap.put("voucherkind", getMap("0"));
        aElementMap.put("pk_accountingbook", getMap("306-0001"));
        aElementMap.put("discardflag", getMap("N"));
        aElementMap.put("period", getMap("2021-02"));
        aElementMap.put("no", getMap(""));
        aElementMap.put("attachment", getMap("0"));
        aElementMap.put("prepareddate", getMap("2021-02-28"));
        aElementMap.put("pk_prepared", getMap("RENT"));
        aElementMap.put("pk_casher", getMap(""));
        aElementMap.put("signflag", getMap("Y"));
        aElementMap.put("pk_checked", getMap(""));
        aElementMap.put("tallydate", getMap(""));
        aElementMap.put("pk_manager", getMap(""));
        aElementMap.put("memo1", getMap(""));
        aElementMap.put("memo2", getMap(""));
        aElementMap.put("reserve1", getMap(""));
        aElementMap.put("reserve2", getMap("N"));
        aElementMap.put("siscardflag", getMap(""));
        aElementMap.put("pk_org", getMap("306"));
        aElementMap.put("pk_org_v", getMap("306"));
        aElementMap.put("pk_group", getMap("000"));
        Map<String, Object> detailsMap = new HashMap<>();
        Map<String, Object> itemElmentMap = new HashMap<>();
        Map<String, Object> itmeMap = new HashMap<>();
        Map<String, Object> itemElmentMap1 = new HashMap<>();
        itemElmentMap1.put("creditquantity", getMap(""));
        itemElmentMap1.put("creditamount", getMap("0.00"));
        itemElmentMap1.put("localcreditamount", getMap("0.00"));
        itemElmentMap1.put("groupcreditamount", getMap(""));
        itemElmentMap1.put("globalcreditamount", getMap(""));
        itemElmentMap1.put("debitquantity", getMap(""));
        itemElmentMap1.put("debitamount", getMap("7989.84"));
        itemElmentMap1.put("localdebitamount", getMap("7989.84"));
        itemElmentMap1.put("groupdebitamount", getMap(""));
        itemElmentMap1.put("globaldebitamount", getMap(""));
        itemElmentMap1.put("detailindex", getMap("1"));
        itemElmentMap1.put("explanation", getMap("杭州凯德来福士店分摊贾国慧分部02月支部人员费用"));
        itemElmentMap1.put("verifydate", getMap(""));
        itemElmentMap1.put("price", getMap(""));
        itemElmentMap1.put("excrate2", getMap("1"));
        itemElmentMap1.put("pk_currtype", getMap("CNY"));
        itemElmentMap1.put("pk_accasoa", getMap("660258"));
        itemElmentMap1.put("pk_unit", getMap(""));
        itemElmentMap1.put("pk_unit_v", getMap(""));
        Map<String, Object> assMap = new HashMap<>();
        List<Map<String, Object>> items = new ArrayList<>();
        Map<String, Object> item1Map = new HashMap<>();
        Map<String, Object> item2Map = new HashMap<>();
        Map<String, Object> item2Map2 = new HashMap<>();
        Map<String, Object> item2MapElement = new HashMap<>();
        Map<String, Object> item2MapElement1 = new HashMap<>();
        item2MapElement.put("pk_Checktype", getMap("0001"));
        item2MapElement.put("pk_Checkvalue", getMap("20119"));
        item2MapElement1.put("pk_Checktype", getMap("0001"));
        item2MapElement1.put("pk_Checkvalue", getMap("20119"));
        item2Map.put("element", item2MapElement);
        item2Map2.put("element", item2MapElement1);
        items.add(item2Map);
        items.add(item2Map2);
        item1Map.put("item_list", items);
        assMap.put("element", item1Map);
        itemElmentMap1.put("ass", assMap);
        itmeMap.put("element", itemElmentMap1);
        itemElmentMap.put("item", itmeMap);
        detailsMap.put("element", itemElmentMap);
        aElementMap.put("details", detailsMap);
        secodeElementMap.put("voucher_head", voucherHeadMap);
        // ----------------------------------------------------
        // 根结点的第一个结点的element属性
        firstElementMap.put("element", secodeElementMap);
        // 根结点的第一个结点的attribute属性
        firstElementMap.put("attribute", firstAttributeMap);
        // 根结点的第一个结点
        elememtMap.put("voucher", firstElementMap);
        // 根结点
        rootMap.put("element", elememtMap);
        rootMap.put("attribute", attributeMap);
        map.put("ufinterface", rootMap);
        Document mapToXml = getMapToXml(map);
        String s = mapToXml.asXML();
        return s;
    }

    private Document getMapToXml(Map<String, Object> map) {
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("UTF-8");
        Set<String> strings = map.keySet();
        for (String s : strings) {
            Element root = document.addElement(s);
            Map<String, Object> map1 = (Map<String, Object>) map.get(s);
            setXml(root, map1);
        }
        return document;
    }

    private static void setXml(Element root, Map<String, Object> map) {
        // 判断map是否为null
        if (CollectionUtils.isEmpty(map)) {
            return;
        }
        // 判断是否为属性参数
        if (map.get("attribute") != null) {
            Map<String, Object> attributeMap = (Map<String, Object>) map.get("attribute");
            Set<String> strings = attributeMap.keySet();
            for (String s : strings) {
                root.addAttribute(s, (String) attributeMap.get(s));
            }
        }
        // 判断是否为值参数
        if (map.get("text") != null) {
            root.addText((String) map.get("text"));
        }
        // 判断是否为子结点
        if (map.get("element") != null) {
            Map<String, Object> elementMap = (Map<String, Object>) map.get("element");
            Set<String> strings = elementMap.keySet();
            for (String s : strings) {
                // 判断是否为重复子结点 否走上路，是走下路
                if (!s.contains("_list")) {
                    Element element = root.addElement(s);
                    Map<String, Object> elementMap1 = (Map<String, Object>) elementMap.get(s);
                    setXml(element, elementMap1);
                } else {
                    List<Map<String, Object>> mapList = (List<Map<String, Object>>) elementMap.get(s);
                    mapList.forEach(map1 -> {
                        Element element = root.addElement(s.replaceAll("_list", ""));
                        // 通过递归调用自身
                        setXml(element, map1);
                    });
                }
            }
        }
    }

    private Map<String, Object> getMap(String b) {
        Map<String, Object> map = new HashMap<>();
        map.put("text", b);
        return map;
    }


    @Test
    public void test03() {
       /* List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int a = 0;
            try {
                a = 10 / i;
                if (i % 2 == 0) {
                    list.add(null);
                } else {
                    list.add(a+"");
                }
            } catch (Exception e) {
                System.out.println("出现异常" + i);
                continue;
            }
            System.out.println(a);
        }
        System.out.println(JSONObject.toJSONString(list));
        goEmpty(list);
        System.out.println(JSONObject.toJSONString(list));
        list = (List<String>) DeDuplication(list);
        System.out.println(JSONObject.toJSONString(list));*/
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < 10){
            int a = 0;
            try {
                a = 10 / i;
            } catch (Exception e) {
                System.out.println("出现异常" + i);
                continue;
            }finally {
                i++;
            }
            System.out.println(i);
        }
//        System.out.println(JSONObject.toJSONString(list));
    }

    public static List<?> DeDuplication(List<?> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    public static void goEmpty(List<?> list) {
        list.removeAll(Collections.singleton(null));
    }
}
