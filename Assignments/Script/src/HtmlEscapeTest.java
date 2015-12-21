
import org.apache.commons.lang.StringEscapeUtils;

/**
 * @author Deepali
 *
 */
public class HtmlEscapeTest {

	public static void main(String[] args) throws Exception {

		String results = StringEscapeUtils.escapeHtml("<script>alert('Hello');</script>");
		System.out.println(results);

	}

}