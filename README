# ⚡ Koog + LM Studio Integration Demo 🚀

This repository demonstrates how to **connect the [Koog AI framework](https://github.com/JetBrains/koog/)** with a locally running models via **[LM Studio](https://lmstudio.ai/)**

> 🧠 You’ll learn how to configure and run Koog agents with **custom models** served by LM Studio – fast, local, and private.

---

## 📦 What's in this Repo?

- ✅ **Minimal working example**
- ✅ **Direct LM Studio integration** using `OpenAIClientSettings`
- ✅ **Custom model selection** via `MyModels.kt`
- ✅ **Runnable main entry point**: `App.kt`
- ⚠️ Everything else (e.g. `CalculatorTools.kt`) is just placeholder example code – ignore it.

---

## 🔧 Requirements

- Java 17+
- Gradle 8.14+
- LM Studio running somewhere (assuming localhost), apiserver mode enabled. ⚠️ Adjust URL in `App.kt`!
- `Phi-4-Mini-Instruct` loaded in lmstudio, or you need to add your model to `MyModels.kt` and change `model` in `App.kt`

---

## 🚀 How to Run

```bash
# 1. Clone
git clone https://github.com/grayfallstown/kooglmstudio.git
cd kooglmstudio

# 2. Run the agent
./gradlew :app:run
````

> ✅ The agent connects to your LM Studio instance and sends a prompt using the selected model from `MyModels.kt`.

---

## 📂 File Overview

| File                | Purpose                                                |
| ------------------- | ------------------------------------------------------ |
| `App.kt`            | 🎯 Main entrypoint. Executes Koog agent with LM Studio |
| `MyModels.kt`       | 📦 Declares models you want to use via LM Studio       |

---

## 🔥 Customizing Your Models

Edit `MyModels.kt` to define the models you’ve loaded in LM Studio:

```kotlin
public val Phi4MiniInstruct: LLModel = LLModel(
    provider = LLMProvider.OpenAI,
    id = "phi-4-mini-instruct",
    capabilities = listOf(
        LLMCapability.Schema.JSON.Simple,
        LLMCapability.Completion,
        // not every model can actually use tools!
        LLMCapability.Tools,
        LLMCapability.ToolChoice
    )
)
```

You can add/remove entries here based on what you run in LM Studio.

## Using the models

```kotlin
    val apiKey = "<lmstudio ignores apikeys>"
    val lmStudioUrl = "http://localhost:1234"
    val openaiConfig = OpenAIClientSettings(lmStudioUrl, ConnectionTimeoutConfig())
    val executor: PromptExecutor = SingleLLMPromptExecutor(OpenAILLMClient(apiKey, openaiConfig))
    val model = MyModels.Phi4MiniInstruct
    
    
    // Create agent config with proper prompt
    val agentConfig = AIAgentConfig(
        prompt = prompt("test") {
            system("You are a calculator.")
        },
        model = model,
        maxAgentIterations = 50
    )

    // Create the runner
    val agent = AIAgent(
        promptExecutor = executor,
        strategy = strategy,
        agentConfig = agentConfig,
        toolRegistry = toolRegistry
    ) {
    // ...
```


---

## 🧠 LM Studio Setup (assumed)

> This project assumes **you’ve already installed and run LM Studio**, and it's exposing an OpenAI-compatible API on port `1234`.

You can test it with:

```bash
# when lmstudio runs on localhost:
curl http://127.0.0.1:1234/v1/models
# or remotely: curl http://192.168.2.64:1234/v1/models
```

If that doesn’t return a model list – fix that first. This repo only speaks OpenAI JSON.

---

## 🧪 Sample Output

When running `./gradlew :app:run`, you should see:

```text
> .\gradlew.bat run
Reusing configuration cache.

> Task :app:run
[main] INFO ai.koog.agents.local.features.eventHandler.feature.EventHandler - Start installing feature: EventHandler
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing subgraph test [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node __start__ [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node __start__ [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeCallLLM [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeCallLLM [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.AIAgent - Executing tools: [plus] [test, 6edad4bc-c260-412f-b19b-56797f2b1052]
Tool called: tool plus, args VarArgs(args={parameter #1 a of fun kooglmstudio.CalculatorTools.plus(kotlin.Float, kotlin.Float): kotlin.String=10.0, parameter #2 b of fun kooglmstudio.CalculatorTools.plus(kotlin.Float, kotlin.Float): kotlin.String=20.0})
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.AIAgent - Executing tools: [minus] [test, 6edad4bc-c260-412f-b19b-56797f2b1052]
Tool called: tool minus, args VarArgs(args={parameter #1 a of fun kooglmstudio.CalculatorTools.minus(kotlin.Float, kotlin.Float): kotlin.String=11.0, parameter #2 b of fun kooglmstudio.CalculatorTools.minus(kotlin.Float, kotlin.Float): kotlin.String=2.0})
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.AIAgent - Executing tools: [multiply] [test, 6edad4bc-c260-412f-b19b-56797f2b1052]
Tool called: tool multiply, args VarArgs(args={parameter #1 a of fun kooglmstudio.CalculatorTools.multiply(kotlin.Float, kotlin.Float): kotlin.String=30.0, parameter #2 b of fun kooglmstudio.CalculatorTools.multiply(kotlin.Float, kotlin.Float): kotlin.String=10.0})
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.AIAgent - Executing tools: [divide] [test, 6edad4bc-c260-412f-b19b-56797f2b1052]
Tool called: tool divide, args VarArgs(args={parameter #1 a of fun kooglmstudio.CalculatorTools.divide(kotlin.Float, kotlin.Float): kotlin.String=300.0, parameter #2 b of fun kooglmstudio.CalculatorTools.divide(kotlin.Float, kotlin.Float): kotlin.String=9.0})
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeExecuteToolMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Executing node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed node nodeSendToolResultMultiple [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.entity.AIAgentSubgraph - Completed subgraph test [test, test, 6edad4bc-c260-412f-b19b-56797f2b1052]
[main] INFO ai.koog.agents.core.agent.AIAgent - Sending final result [test, 6edad4bc-c260-412f-b19b-56797f2b1052]
Result: I have calculated the result of (10 + 20) * (5 + 5) / (2 - 11), which is approximately 33.3333 when rounded to four decimal places.

If you need further assistance with another calculation or any other task, please let me know!
```

Yeah. It's a test and [https://www.wolframalpha.com/input?i=(10%20%2B%2020)%20*%20(5%20%2B%205)%20%2F%20(2%20-%2011)](Phi4MiniInstruct got the wrong result), sometimes it gets it correct by accident.

⚠️ Replace with stronger models, real use cases and agents.

---

## ⚠️ Things to Ignore

* `CalculatorTools.kt` = Example stuff, ignore it
* Any arithmetic operations = not part of this demo

---

## 📜 License

Apache 2.0 — free to use, hack, break, and improve.

---
