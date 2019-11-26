package com.devin.bullshitgenerator.generator;

import com.devin.bullshitgenerator.util.JSONUtils;

import java.util.List;

public class BullshitGenerator {

    public static String generate(String title, Integer length) {
        if (length == null) {
            length = 800; // 默认生成 800 字文章
        }

        List<String> famousList = JSONUtils.getList("famous");
        List<String> boshList = JSONUtils.getList("bosh");
        List<String> beforeList = JSONUtils.getList("before");
        List<String> afterList = JSONUtils.getList("after");

        StringBuilder content = new StringBuilder();
        while (content.length() < length) {
            int num = (int) ((Math.random()) * 100);
            if (num < 10) {
                content.append("<br>");
            } else if (num < 20) {
                content.append(randomSentence(famousList)
                        .replace("a", randomSentence(beforeList))
                        .replace("b", randomSentence(afterList)));
            } else {
                content.append(randomSentence(boshList));
            }
        }
        return content.toString().replace("x", title);
    }

    private static String randomSentence(List<String> list) {
        return list.get((int) Math.floor(Math.random() * list.size()));
    }
}
