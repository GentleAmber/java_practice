package homework;

import java.util.ArrayList;

public class Homework01_NewsList {
    public static void main(String[] args) {
        /*
        按要求实现：
            (1) 封装一个新闻类，包含标题和内容属性，提供 get、set 方法，重写 toString 方法，打印对象时可打印标题；
            (2) 只提供一个带参的构造器。实例化对象时，只初始化标题，并且实例化两个对象：
            新闻一：新冠确诊病例超过千万，数百万印度教徒赴恒河“圣浴”引民众担忧
            新闻二：男子突然想起2个月前存的某个快递，拆箱一看竟是蛇
            (3) 将新闻对象添加到 ArrayList 集合中，并且进行倒序遍历；
            (4) 在倒序集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加上“…”；
            (5) 在控制台打印遍历出来经过处理的新闻标题；
         */

        ArrayList newsList = new ArrayList();
        News news1 = new News("新冠确诊病例超过千万，数百万印度教徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("男子突然想起2个月前存的某个快递，拆箱一看竟是蛇");

        newsList.add(news1);
        newsList.add(news2);

        for (int i = newsList.size() - 1; i >= 0; i--) {
            String str = ((News) newsList.get(i)).getTitle();
            if (str.length() > 15) {
                char[] chars = new char[18];
                str.getChars(0, 15, chars, 0);
                chars[15] = '.';
                chars[16] = '.';
                chars[17] = '.';
                str = String.valueOf(chars);
            }
            System.out.println(str);

        }
    }
}
class News {
    private String title;
    private String contents;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public News(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}