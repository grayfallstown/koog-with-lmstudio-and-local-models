package kooglmstudio

import ai.koog.prompt.llm.LLMCapability
import ai.koog.prompt.llm.LLMProvider
import ai.koog.prompt.llm.LLModel

/**
 * ✅ This part is relevant to lmstudio usage.
 * 
 * Basically you need one entry per model you want to use over lmstudio
 * Always use LLMProvider.OpenAI, since lmstudio uses the same api schema as openai
 * 
 * ⚠️ IMPORTANT ⚠️:
 * There is absolutely no garantee the LLMCapabilies are set correctly, it's just what ChatGPT o3 told me
 */
public object MyModels {

    // 1️⃣  Phi-4-Mini-Instruct
    public val Phi4MiniInstruct: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "phi-4-mini-instruct",
        capabilities = listOf(
            LLMCapability.Schema.JSON.Simple,
            LLMCapability.Completion,
            LLMCapability.Tools,
            LLMCapability.ToolChoice
        )
    )

    // 2️⃣  Phi-3.1-Mini-128k-Instruct
    public val Phi31Mini128kInstruct: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "phi-3.1-mini-128k-instruct",
        capabilities = listOf(
            LLMCapability.Schema.JSON.Simple,
            LLMCapability.Completion
        )
    )

    // 3️⃣  OpenHermes-2.5-Mistral-7B
    public val OpenHermes25Mistral7B: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "openhermes-2.5-mistral-7b",
        capabilities = listOf(
            LLMCapability.Speculation,
            LLMCapability.Schema.JSON.Full,
            LLMCapability.Completion
        )
    )

    // 4️⃣  Nous-Hermes-2-Mistral-7B-DPO
    public val NousHermes2Mistral7B: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "nous-hermes-2-mistral-7b-dpo",
        capabilities = listOf(
            LLMCapability.Speculation,
            LLMCapability.Schema.JSON.Full,
            LLMCapability.Completion
        )
    )

    // 5️⃣  Mythomax-L2-13B
    public val MythomaxL213B: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "mythomax-l2-13b",
        capabilities = listOf(
            LLMCapability.Schema.JSON.Simple,
            LLMCapability.Completion
        )
    )

    // 6️⃣  Gemma-3-4B-IT-QAT
    public val Gemma34BITQat: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "gemma-3-4b-it-qat",
        capabilities = listOf(
            LLMCapability.Schema.JSON.Simple,
            LLMCapability.Completion
        )
    )

    // 7️⃣  DeepSeek-R1-Distill-Qwen-7B
    public val DeepSeekR1Qwen7B: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "deepseek-r1-distill-qwen-7b",
        capabilities = listOf(
            LLMCapability.Speculation,
            LLMCapability.Schema.JSON.Full,
            LLMCapability.Completion
        )
    )

    // 8️⃣  DeepSeek-Coder-6.7B-Instruct
    public val DeepSeekCoder67B: LLModel = LLModel(
        provider = LLMProvider.OpenAI,
        id = "deepseek-coder-6.7b-instruct",
        capabilities = listOf(
            LLMCapability.Schema.JSON.Simple,
            LLMCapability.Completion
        )
    )

}
