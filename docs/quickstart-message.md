# Create Message
Message is the core concept in AgentScope, used to support multimodal data, tools API, information storage/exchange and prompt construction.

A message consists of four fields:

+ `name`,
+ `role`,
+ `content`, and
+ `metadata`

The types and descriptions of these fields are as follows:

| Field | Type | Description |
| --- | --- | --- |
| name | `str` | The name/identity of the message sender |
| role | `Enum` | The role of the message sender, which must be one of “system”, “assistant”, or “user”. |
| content | `List<ContentBlock>` | The data of the message, which can be a string or a list of blocks. |
| metadata | `Map<String, Object>` | A map containing additional metadata about the message, usually used for structured output. |




> **<font style="background-color:rgba(0, 200, 82, 0.2);">Tip</font>**
>
> + In application with multiple identities, the `name` field is used to distinguish between different identities.
> + The `metadata` field is recommended for structured output, which won’t be included in the prompt construction.
>

## Creating Textual Message
Creating a message object by providing the `name`, `role`, and `content` fields.

```java
Msg msg = Msg.builder()
    .name("Jarvis")
    .role(MsgRole.ASSISTANT)
    .content("Hi! How can I help you?")
    .build();
```



Or, use `TextBlock`

```java
Msg msg = Msg.builder()
    .name("Jarvis")
    .role(MsgRole.ASSISTANT)
    .content(List.of(
        TextBlock.builder()
            .text("Hi! How can I help you?")
            .build())
    .build();
```

## Creating Multimodal Message
The message class supports multimodal content by providing different content blocks:

| <font style="color:rgb(0, 0, 0);">Class</font> | <font style="color:rgb(0, 0, 0);">Description</font> | <font style="color:rgb(0, 0, 0);">Example</font> |
| --- | --- | --- |
| TextBlock | Pure text data | ```java TextBlock.builder()\n .text("Hello World.")\n .build(); ```  |
| <font style="color:rgb(0, 0, 0);">ImageBlock</font> | <font style="color:rgb(0, 0, 0);">The image data</font> | coming soon ...  |
| <font style="color:rgb(0, 0, 0);">AudioBlock</font> | <font style="color:rgb(0, 0, 0);">The audio data</font> | coming soon ...  |
| <font style="color:rgb(0, 0, 0);">VideoBlock</font> | <font style="color:rgb(0, 0, 0);">The video data</font> | coming soon ...  |

## Creating Thinking Message
The `ThinkingBlock` is to support reasoning models, containing the thinking process of the model.

```java
Msg msgThinking = Msg.builder()
    .name("Jarvis")
    .role(MsgRole.ASSISTANT)
    .content(Arrays.asList(
        ThinkingBlock.builder()
        .thinking("I'm building an example for thinking block in AgentScope.")
        .build(),
        TextBlock.builder()
        .text("This is an example for thinking block.")
        .build()
    ))
    .build();

```

## Creating Tool Use/Result Message
The `ToolUseBlock` and `ToolResultBlock` are to support tools API:

```java
Msg msgToolCall = Msg.builder()
.name("Jarvis")
.role(MsgRole.ASSISTANT)
.content(Arrays.asList(
    ToolUseBlock.builder()
    .id("343")
    .name("get_weather")
    .input(Map.of("location", "Beijing"))
    .build()
))
.build();

Msg msgToolRes = Msg.builder()
.name("system")
.role(MsgRole.SYSTEM)
.content(Arrays.asList(
    ToolResultBlock.builder()
    .id("343")
    .name("get_weather")
    .output("The weather in Beijing is sunny with a temperature of 25°C.")
    .build()
))
.build();
```



> **<font style="background-color:rgba(0, 200, 82, 0.2);">Tip</font>**
>
> Refer to the <font style="color:rgb(39, 87, 221);">Tool</font>section for more information about tools API in AgentScope.
>



## <font style="color:rgb(0, 0, 0);">Property Functions</font>
<font style="color:rgb(0, 0, 0);">To ease the use of message object, AgentScope provides these functions:is  </font>

| <font style="color:rgb(0, 0, 0);">Function</font> | <font style="color:rgb(0, 0, 0);">Parameters</font> | <font style="color:rgb(0, 0, 0);">Description</font> |
| --- | --- | --- |
| getTextContent | - | Gather content from all TextBlock in to a single string (separated by ""\n"). |
| getContentBlocks | blockType | Return a list of content blocks of the specified type. If blockType not provided, return content in blocks format. |
| hasContentBlocks | blockType | Check whether the message has content blocks of the specified type. The str content is considered as a TextBlock type. |




<font style="color:rgb(0, 0, 0);">  
</font>

