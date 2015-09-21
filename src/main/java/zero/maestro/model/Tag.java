package zero.maestro.model;

import zero.maestro.app.dao.TagDao;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(daoClass = TagDao.class)
public class Tag {

    public static final String ID_FIELD_NAME = "id";
    public static final String NAME_FIELD_NAME = "name";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
