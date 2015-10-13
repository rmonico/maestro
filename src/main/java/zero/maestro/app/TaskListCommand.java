package zero.maestro.app;

import java.sql.SQLException;
import java.util.List;

import zero.easymvc.ArgumentsBean;
import zero.easymvc.Bean;
import zero.easymvc.CommandHandler;
import zero.easymvc.Dependency;
import zero.maestro.app.dao.TagDao;
import zero.maestro.app.dao.TaskDao;
import zero.maestro.app.dao.TaskTagDao;
import zero.maestro.model.Tag;
import zero.maestro.model.Task;
import zero.maestro.model.TaskTag;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;

public class TaskListCommand {

    @Dependency
    private TaskDao dao;

    @Dependency
    private TaskTagDao taskTagDao;

    @Dependency
    private TagDao tagDao;

    @ArgumentsBean
    private TaskListArguments args;

    @Bean
    private List<Task> tasks;

    private QueryBuilder<Task, Integer> taskBuilder;

    @CommandHandler(path = { "task", "ls" })
    public void execute() throws SQLException {
        taskBuilder = dao.queryBuilder();

        taskBuilder.where().isNull(Task.SUPERTASK_FIELD_NAME);

        applyTagsFilter();

        applyIDsFilter();

        taskBuilder.groupBy(Task.ID_FIELD_NAME);

        PreparedQuery<Task> query = taskBuilder.prepare();

        tasks = dao.query(query);

        applySomeOfTheseWordsFilter();

        applyAllOfTheseWordsFilter();
    }

    private void applyTagsFilter() throws SQLException {
        String[] tags = args.getTags();
        if (tags != null) {
            QueryBuilder<Tag, Integer> tagBuilder = tagDao.queryBuilder();

            Where<Tag, Integer> where = tagBuilder.where();

            where.in(Tag.NAME_FIELD_NAME, (Object[]) tags);

            QueryBuilder<TaskTag, Integer> taskTagBuilder = taskTagDao.queryBuilder();

            taskTagBuilder.join(tagBuilder);

            taskBuilder.join(taskTagBuilder);
        }
    }

    private void applyIDsFilter() throws SQLException {
        String[] strIDs = args.getIds();

        if ((strIDs == null) || (strIDs.length == 0))
            return;

        Integer[] ids = new Integer[strIDs.length];

        for (int i = 0; i < strIDs.length; i++) {
            String strID = strIDs[i];

            int id = Integer.parseInt(strID);

            ids[i] = id;
        }

        taskBuilder.where().in(Task.ID_FIELD_NAME, (Object[]) ids);
    }

    private void applySomeOfTheseWordsFilter() {
        String[] withSomeOfTheseWords = args.getWithSomeOfTheseWords();

        if ((withSomeOfTheseWords == null) || (withSomeOfTheseWords.length == 0))
            return;

        String[] someWordsLowercase = toLowercase(withSomeOfTheseWords);

        taskLoop: for (int i = 0; i < tasks.size();) {
            Task task = tasks.get(i);

            String taskName = task.getName().toLowerCase();

            for (String word : someWordsLowercase)
                if (taskName.contains(word)) {
                    i++;

                    continue taskLoop;
                }

            tasks.remove(i);

        }
    }

    private void applyAllOfTheseWordsFilter() {
        String[] withAllOfTheseWords = args.getWithAllOfTheseWords();

        if ((withAllOfTheseWords == null) || (withAllOfTheseWords.length == 0))
            return;

        String[] allWordsLowercase = toLowercase(withAllOfTheseWords);

        taskLoop: for (int i = 0; i < tasks.size();) {
            Task task = tasks.get(i);

            String taskName = task.getName().toLowerCase();

            for (String word : allWordsLowercase)
                if (!taskName.contains(word)) {
                    tasks.remove(i);

                    continue taskLoop;
                }

            i++;
        }

    }

    private String[] toLowercase(String[] stringArray) {
        String[] someWordsLowercase = new String[stringArray.length];

        for (int i = 0; i < stringArray.length; i++)
            someWordsLowercase[i] = stringArray[i].toLowerCase();
        return someWordsLowercase;
    }

}
