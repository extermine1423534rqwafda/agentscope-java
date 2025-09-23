<p align="center">
  <img
    src="https://img.alicdn.com/imgextra/i1/O1CN01nTg6w21NqT5qFKH1u_!!6000000001621-55-tps-550-550.svg"
    alt="AgentScope Logo"
    width="200"
  />
</p>

## AgentScope Implementation for Java
<font style="color:rgb(31, 35, 40);">This is the Java implementation of </font>[<font style="color:rgb(9, 105, 218);">AgentScope</font>](https://github.com/agentscope-ai/agentscope/)<font style="color:rgb(31, 35, 40);">. Please note that this project is still experimental and under active development.</font>


![](https://img.shields.io/badge/GUI-AgentScope_Studio-blue?logo=look&logoColor=green&color=dark-green)![](https://img.shields.io/badge/license-Apache--2.0-black)

## ✨ Why AgentScope?
Easy for beginners, powerful for experts.

+ **Transparent to Developers**: Transparent is our **FIRST principle**. Prompt engineering, API invocation, agent building, workflow orchestration, all are visible and controllable for developers. No deep encapsulation or implicit magic.
+ Realtime Steering: Native support for realtime interruption and customized handling.
+ **More Agentic**: Support agentic tools management, agentic long-term memory control and agentic RAG, etc.
+ **Model Agnostic**: Programming once, run with all models.
+ **LEGO-style Agent Building**: All components are **modular** and **independent**.
+ **Multi-Agent Oriented**: Designed for **multi-agent**, **explicit** message passing and workflow orchestration, NO deep encapsulation.
+ **Highly Customizable**: Tools, prompt, agent, workflow, third-party libs & visualization, customization is encouraged everywhere.

## 🚀 Quickstart
### Installation
AgentScope Java requires **jdk 17** or higher.

```bash
<dependency>
    <groupId>io.agentscope</groupId>
    <artifactId>agentscope-core</artifactId>
    <version>0.1.0</version>
</dependency>
```

### Hello AgentScope!
Start with a basic ReActAgent that replies to user queries!

```java
public static void main(String[] args) {
    Model model = DashScopeChatModel.builder()
		.apiKey(System.getenv("DASHSCOPE_API_KEY"))
		.modelName("qwen-max")
		.baseUrl("https://dashscope.aliyuncs.com/v1")
		.build();

    ReActAgent agent = ReActAgent.builder()
    .name("hello-world-agent")
    .sysPrompt("You are a helpful AI assistant. Be concise and friendly. " +
               "When thinking through problems, use <thinking>...</thinking> tags to show your reasoning.")
    .model(model)
    .memory(new InMemoryMemory())
    .formatter(new DashScopeChatFormatter())
    .build();

    Msg userMessage = Msg.builder()
        .role(MsgRole.USER)
        .textContent("Hello, please introduce yourself.")
        .build();
    Msg response = agent.stream(userMessage).blockLast();

    System.out.println("Agent Response: " + response.getTextContent());
}
```

### Equip Agent with Tools
1. Define Tool

	Define a tool `TimeFunctionalTool` for obtaining time, with the input parameter being `String` and the output parameter being of type `ToolResponse`(required).

	```java
	public class TimeFunctionTool implements Function<String, ToolResponse> {
		@Override
		public ToolResponse apply(String s) {
			try {
				// Get current time and format it as string
				LocalDateTime now = LocalDateTime.now();
				String currentTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

				TextBlock textBlock = TextBlock.builder().text(currentTime).build();
				return new ToolResponse(List.of(textBlock));
			} catch (Exception e) {
				return ToolResponse.error("Tool execution failed: " + e.getMessage());
			}
		}
	}
	```

2. Register Tool to ReActAgent

	Register the Tool through `Toolkit` and specify `toolName` and `description` (Another way of doing this is using annotations when declaring the Tool).

	```java
	public static void main(String[] args) {
		Toolkit toolkit = new Toolkit();
			toolkit.registerTool(
					"timeTool",
					"Get the current time of a specific zone in format YYYY-MM-DD HH:MM:SS",
					new TimeFunctionTool()
			);

		ReActAgent agent = ReActAgent.builder()
			.name("hello-world-agent")
			.sysPrompt("You are a helpful AI assistant.")
			.model(model)
			.toolkit(toolkit)
			.memory(new InMemoryMemory())
			.formatter(new DashScopeChatFormatter())
			.build();

		Msg userMessage = Msg.builder()
				.role(MsgRole.USER)
				.textContent("Please tell me the current time of Beijing and London.")
				.build();

		agent.stream(userMessage).doOnNext(msg -> {;
			System.out.println("Agent Response: " + msg.getTextContent());
		}).blockLast();
	}
	```


## <font style="color:rgb(31, 35, 40);">📖</font><font style="color:rgb(31, 35, 40);"> Documentation</font>
+ [Create Message](./docs/quickstart-message.md)
+ [Create ReAct Agent](./docs/quickstart-agent.md)
+ Model
+ Tool
+ Memory
+ Prompt Formatter

## <font style="color:rgb(31, 35, 40);">🏗️</font><font style="color:rgb(31, 35, 40);"> </font>Roadmap
In the upcoming versions, AgentScope Java version will focus on improving the following features.

+ Multi-modal
+ Prompt Formatter
+ State/Session Management
+ Real-time Steering
+ Multi-Agent
+ Tracing
+ AgentScope Studio

## ⚖️ License
AgentScope is released under Apache License 2.0.
