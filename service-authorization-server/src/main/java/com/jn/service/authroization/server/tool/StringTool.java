package com.jn.service.authroization.server.tool;

import com.google.common.collect.Sets;
import self.yang.util.tool.StringUtil;

import java.util.Set;

public class StringTool {

    public static Set<String> str2Set(String string) {
        if (StringUtil.isEmpty(string)) {
            return null;
        }

        Iterable<String> strings = StringUtil.splitString(string, ",");

        return Sets.newCopyOnWriteArraySet(strings);
    }
}
