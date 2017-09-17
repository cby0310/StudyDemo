package com.cyb.test.mytest.xml;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;


import com.cyb.test.mytest.MyLog;
import com.cyb.test.mytest.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class XmlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);

        List<Person> persons = parserPersons();
        MyLog.e(persons.toString());
        savePersonToXml(persons);

    }


    private List<Person> parserPersons() {
        List<Person> persons = new ArrayList<>();
        AssetManager assetManager = getResources().getAssets();
        try {
            InputStream inputStream = assetManager.open("person.xml");
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setInput(inputStream, "utf-8");
            int type = xmlPullParser.getEventType();
            Person person = null;
            while (type != XmlPullParser.END_DOCUMENT) {
                if (type == XmlPullParser.START_TAG) {//读到了开始节点
                    if ("person".equals(xmlPullParser.getName())) {
                        person = new Person();
                        person.setId(Integer.parseInt(xmlPullParser.getAttributeValue(0)));
                    } else if ("name".equals(xmlPullParser.getName())) {
                        person.setName(xmlPullParser.nextText());
                    } else if ("age".equals(xmlPullParser.getName())) {
                        person.setAge(Integer.parseInt(xmlPullParser.nextText()));
                    }
                } else if (type == XmlPullParser.END_TAG) {
                    if ("person".equals(xmlPullParser.getName())) {
                        persons.add(person);
                        person = null;
                    }
                }
                type = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return persons;
    }


    /**
     * 把persons集合里面的内容写到xml文件里面
     *
     * @param persons person的集合
     * @return
     */
    public boolean savePersonToXml(List<Person> persons) {
        try {
            XmlSerializer serializer = Xml.newSerializer();
            File file = new File(Environment.getExternalStorageDirectory(),
                    "person1.xml");
            FileOutputStream fos = new FileOutputStream(file);
            serializer.setOutput(fos, "utf-8");
            serializer.startDocument("utf-8", true);
            serializer.startTag(null, "persons");
            for (Person person : persons) {
                serializer.startTag(null, "person");

                serializer.attribute(null, "id", person.getId() + "");

                serializer.startTag(null, "name");
                serializer.text(person.getName());
                serializer.endTag(null, "name");

                serializer.startTag(null, "age");
                serializer.text(person.getAge() + "");
                serializer.endTag(null, "age");

                serializer.endTag(null, "person");
            }
            serializer.endTag(null, "persons");
            serializer.endDocument();
            fos.flush();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
