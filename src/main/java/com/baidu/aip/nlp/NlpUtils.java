package com.baidu.aip.nlp;

import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.nlp.ESimnetType;

public class NlpUtils {
	
	private static AipNlp aipNlp;
	
	static {
		aipNlp = new AipNlp(NlpAuth.APP_ID, NlpAuth.APP_KEY, NlpAuth.SECRET_KEY);
	}
	
	/**
     * 词法分析接口
     * 词法分析接口向用户提供分词、词性标注、专名识别三大功能；能够识别出文本串中的基本词汇（分词），对这些词汇进行重组、标注组合后词汇的词性，并进一步识别出命名实体。
     *
     * @param text - 待分析文本（目前仅支持GBK编码），长度不超过65536字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
    public static JSONObject lexer(String text, HashMap<String, Object> options) {
    	return aipNlp.lexer(text, options);
    }
    
    /**
     * 词法分析（定制版）接口
     * 词法分析接口向用户提供分词、词性标注、专名识别三大功能；能够识别出文本串中的基本词汇（分词），对这些词汇进行重组、标注组合后词汇的词性，并进一步识别出命名实体。
     *
     * @param text - 待分析文本（目前仅支持GBK编码），长度不超过65536字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
    public static JSONObject lexerCustom(String text, HashMap<String, Object> options) {
    	return aipNlp.lexerCustom(text, options);
    }
    
    /**
     * 依存句法分析接口
     * 依存句法分析接口可自动分析文本中的依存句法结构信息，利用句子中词与词之间的依存关系来表示词语的句法结构信息（如“主谓”、“动宾”、“定中”等结构关系），并用树状结构来表示整句的结构（如“主谓宾”、“定状补”等）。
     *
     * @param text - 待分析文本（目前仅支持GBK编码），长度不超过256字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   mode 模型选择。默认值为0，可选值mode=0（对应web模型）；mode=1（对应query模型）
     * @return JSONObject
     */
    public static JSONObject depParser(String text, HashMap<String, Object> options) {
    	return aipNlp.depParser(text, options);
    }
	
	 /**
     * 词向量表示接口
     * 词向量表示接口提供中文词向量的查询功能。
     *
     * @param word - 文本内容（GBK编码），最大64字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
	public static JSONObject wordEmbedding(String word, HashMap<String, Object> options) {
		return aipNlp.wordEmbedding(word, options);
	}
	
    /**
     * DNN语言模型接口
     * 中文DNN语言模型接口用于输出切词结果并给出每个词在句子中的概率值,判断一句话是否符合语言表达习惯。
     *
     * @param text - 文本内容（GBK编码），最大512字节，不需要切词
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
    public static JSONObject dnnlmCn(String text, HashMap<String, Object> options) {
    	return aipNlp.dnnlmCn(text, options);
    }
    
    /**
     * 词义相似度接口
     * 输入两个词，得到两个词的相似度结果。
     *
     * @param word1 - 词1（GBK编码），最大64字节*
     * @param word2 - 词1（GBK编码），最大64字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   mode 预留字段，可选择不同的词义相似度模型。默认值为0，目前仅支持mode=0
     * @return JSONObject
     */
    public static JSONObject wordSimEmbedding(String word1, String word2, HashMap<String, Object> options) {
    	return aipNlp.wordSimEmbedding(word1, word2, options);
    }
    
    /**
     * 短文本相似度接口
     * 短文本相似度接口用来判断两个文本的相似度得分。
     *
     * @param text1 - 待比较文本1（GBK编码），最大512字节*
     * @param text2 - 待比较文本2（GBK编码），最大512字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   model 默认为"BOW"，可选"BOW"、"CNN"与"GRNN"
     * @return JSONObject
     */
    public static JSONObject simnet(String text1, String text2, HashMap<String, Object> options) {
    	return aipNlp.simnet(text1, text2, options);
    }

    /**
     * 评论观点抽取接口
     * 评论观点抽取接口用来提取一条评论句子的关注点和评论观点，并输出评论观点标签及评论观点极性。
     *
     * @param text - 评论内容（GBK编码），最大10240字节
     * @param type - ESimnetType枚举类型，选择识别的垂类
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   type 评论行业类型，默认为4（餐饮美食）
     * @return JSONObject
     */
    public static JSONObject commentTag(String text, ESimnetType type, HashMap<String, Object> options) {
    	return aipNlp.commentTag(text, type, options);
    }
    
    /**
     * 情感倾向分析接口
     * 对包含主观观点信息的文本进行情感极性类别（积极、消极、中性）的判断，并给出相应的置信度。
     *
     * @param text - 文本内容（GBK编码），最大102400字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
    public static JSONObject sentimentClassify(String text, HashMap<String, Object> options) {
    	return aipNlp.sentimentClassify(text, options);
    }
    
    /**
     * 文章标签接口
     * 文章标签服务能够针对网络各类媒体文章进行快速的内容理解，根据输入含有标题的文章，输出多个内容标签以及对应的置信度，用于个性化推荐、相似文章聚合、文本内容分析等场景。
     *
     * @param title - 篇章的标题，最大80字节*
     * @param content - 篇章的正文，最大65535字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
    public static JSONObject keyword(String title, String content, HashMap<String, Object> options) {
    	return aipNlp.keyword(title, content, options);
    }
    
    /**
     * 文章分类接口
     * 对文章按照内容类型进行自动分类，首批支持娱乐、体育、科技等26个主流内容类型，为文章聚类、文本内容分析等应用提供基础技术支持。
     *
     * @param title - 篇章的标题，最大80字节*
     * @param content - 篇章的正文，最大65535字节
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     * @return JSONObject
     */
    public static JSONObject topic(String title, String content, HashMap<String, Object> options) {
    	return aipNlp.topic(title, content, options);
    }
	
}
