# yaml-util
Handle all configuration related issues


Simply switch the yaml file path and get the value you want from it

Support point call

-----------------------------------------------------------------------------

处理所有配置相关的问题

很简单的切换YAML文件路径,并从中获取你想获取的值.

支持点式调用

-----------------------------------------------------------------------------

```$xslt
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

```