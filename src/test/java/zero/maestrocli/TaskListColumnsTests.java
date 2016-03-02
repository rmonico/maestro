package zero.maestrocli;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import zero.easymvc.EasyMVCAssert;
import zero.easymvc.EasyMVCException;

public class TaskListColumnsTests extends MaestroTest {

    @Test
    public void should_pass_columns_param_to_renderer() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls", "--columns=id,name,supertask");

        EasyMVCAssert.assertBeanList(beans, 2);

        String[] columns = EasyMVCAssert.assertAndGetBean(beans, 1, String[].class);

        assertEquals("Length", 3, columns.length);
        assertEquals("id", columns[0]);
        assertEquals("name", columns[1]);
        assertEquals("supertask", columns[2]);
    }

    @Test
    public void should_pass_columns_from_properties_when_parameter_is_not_defined() throws EasyMVCException {
        List<Object> beans = controller.run("task", "ls");

        EasyMVCAssert.assertBeanList(beans, 2);

        String[] columns = EasyMVCAssert.assertAndGetBean(beans, 1, String[].class);

        assertEquals("Length", 2, columns.length);
        assertEquals("id", columns[0]);
        assertEquals("treename", columns[1]);
    }

}
