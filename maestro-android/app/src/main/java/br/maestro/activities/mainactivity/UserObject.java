package br.maestro.activities.mainactivity;

import java.util.ArrayList;
import java.util.List;

public class UserObject {
    boolean isTag;
    String text;

    public static List<UserObject> createItemList(UserObject... objects) {
        List<UserObject> items = new ArrayList<UserObject>();

        for (UserObject object : objects) {
            items.add(object);
        }

        return items;
    }

    public static UserObject createTag(String text) {
        return createUO(true, text);
    }

    public static UserObject createTask(String text) {
        return createUO(false, text);
    }

    private static UserObject createUO(boolean isTag, String text) {
        final UserObject uo = new UserObject();

        uo.isTag = isTag;
        uo.text = text;

        return uo;
    }

}
