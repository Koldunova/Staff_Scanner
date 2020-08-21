package by.vitebsk.energo.reader;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.vitebsk.energo.StaticData;
import by.vitebsk.energo.dataBase.ConnectionDB;

public class MyXmlReader {
    private static final String XML_CONFIG = "./src/by/vitebsk/energo/resource/config.xml";

    public static void readXmlConfig() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        String conPathSender = "";
        String conPathResipient = "";

        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(XML_CONFIG));

            Node root = document.getDocumentElement();
            NodeList configDate = root.getChildNodes();

            for (int j = 0; j < configDate.getLength(); j++) {
                Node conf = configDate.item(j);
                if (conf.getNodeType() != Node.TEXT_NODE) {
                    if (conf.getNodeName().equals("ConnectionSender")) {
                        conPathSender = conf.getChildNodes().item(0).getTextContent();
                    }
                    if (conf.getNodeName().equals("ConnectionResipient")) {
                        conPathResipient = conf.getChildNodes().item(0).getTextContent();
                    }
                    if (conf.getNodeName().equals("PathFolderLog")) {
                        StaticData.setPATH_LOG(conf.getChildNodes().item(0).getTextContent());
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            StaticData.getLOGGER().writeLine(true, "ParserConfigurationException during reading config.xml - "
                    + e.getMessage() + " Next operation will not continue");
            e.printStackTrace();
        } catch (SAXException e) {
            StaticData.getLOGGER().writeLine(true,
                    "SAXException during reading config.xml - " + e.getMessage() + " Next operation will not continue");
            e.printStackTrace();
        } catch (IOException e) {
            StaticData.getLOGGER().writeLine(true,
                    "IOException during reading config.xml - " + e.getMessage() + " Next operation will not continue");
            e.printStackTrace();
        }

        if (!StaticData.isExceptionExist()) {
            StaticData.getLOGGER().writeLine(false, "Succesful reading config");
            StaticData.setCONNECTION_SENDER(new ConnectionDB(conPathSender));
            StaticData.setCONNECTION_RESIPIENT(new ConnectionDB(conPathResipient));
        }
    }
}
