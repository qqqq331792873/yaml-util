import com.mabingbing.YamlUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		System.out.println(YamlUtil.get("project"));
		System.out.println(YamlUtil.get("project.name"));
		System.out.println(YamlUtil.get("project.version"));
		System.out.println(YamlUtil.get("project.description"));
		System.out.println(YamlUtil.get("project.description.en"));
		System.out.println(YamlUtil.get("project.description.ch"));
		System.out.println(YamlUtil.get("author"));
		System.out.println(YamlUtil.get("think"));
		YamlUtil.use("else.yaml");
		System.out.println(YamlUtil.get("author"));
	}
}
