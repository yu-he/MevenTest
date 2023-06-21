package common;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

public class ParseXmlTest {
    public static void main(String[] args) throws Exception {
        Document document = DocumentHelper.parseText(getXml());
        Element root = document.getRootElement();
        Element list = root.element("list");
        List<Element> message = list.elements("message");
        //System.out.println(message.get(1).element("123").getText());
        System.out.println(message.get(1).elementText("123"));
        System.out.println(message.get(1).elementText("123").replaceAll("123",""));
    }

    private static String getXml() {
        return "<HKGoodsReleaseReceiptMessage>\n" +
                "            <head>\n" +
                "                <attachmentNo>1</attachmentNo>\n" +
                "                <masterCuscd>4712</masterCuscd>\n" +
                "                <messageDate>2022-06-19 16:19:42</messageDate>\n" +
                "                <messageNo>HKFX01R202206191619421687</messageNo>\n" +
                "                <messageNo1></messageNo1>\n" +
                "                <messageType>HKFX01R</messageType>\n" +
                "                <receiptNote>调拨单放行</receiptNote>\n" +
                "                <receiptStatus>C10</receiptStatus>\n" +
                "                <regionCode>471200</regionCode>\n" +
                "                <tradeCode></tradeCode>\n" +
                "            </head>\n" +
                "            <list>\n" +
                "                <message>\n" +
                "                    <iEFlag>E</iEFlag>\n" +
                "                    <goodsStatus>1</goodsStatus>\n" +
                "                    <docNumber>DB202206191606548447</docNumber>\n" +
                "                    <docType>D</docType>\n" +
                "                    <billNo>41651451164</billNo>\n" +
                "                    <masterCuscd>4712</masterCuscd>\n" +
                "                    <relTime>2022-06-19 16:19:42</relTime>\n" +
                "                </message>\n" +
                "                <message>\n" +
                "                    <iEFlag>E</iEFlag>\n" +
                "                    <goodsStatus>1</goodsStatus>\n" +
                "                    <docNumber>DB202206191606548447</docNumber>\n" +
                "                    <docType>D</docType>\n" +
                "                    <billNo>123</billNo>\n" +
                "                    <masterCuscd>4712</masterCuscd>\n" +
                "                    <relTime>2022-06-19 16:19:42</relTime>\n" +
                "                </message>\n" +
                "            </list>\n" +
                "        </HKGoodsReleaseReceiptMessage>";
    }
}
